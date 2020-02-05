package com.nts.springdatajdbcdemo.conversion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.convert.JdbcValue;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomConversionTest {

    @TestConfiguration
    static class Config extends AbstractJdbcConfiguration {
        @Override
        public JdbcCustomConversions jdbcCustomConversions()  {
            return new JdbcCustomConversions(asList(BigDecimalToString.INSTANCE, StringToBigDecimalConverter.INSTANCE));
        }

        @WritingConverter
        enum StringToBigDecimalConverter implements Converter<String, JdbcValue> {

            INSTANCE;

            @Override
            public JdbcValue convert(String source) {

                Object value = new BigDecimal(source);
                System.out.println("String to decimal converting");
                return JdbcValue.of(value, JDBCType.DECIMAL);
            }

        }

        @ReadingConverter
        enum BigDecimalToString implements Converter<BigDecimal, String> {

            INSTANCE;

            @Override
            public String convert(BigDecimal source) {
                System.out.println("decimal to string converting");
                return source.toString();
            }
        }
    }

    @Autowired
    private EntityWithStringyBigDecimalRepository repository;

    @Test // DATAJDBC-327
    public void saveAndLoadAnEntity() {

        EntityWithStringyBigDecimal entity = new EntityWithStringyBigDecimal();
        entity.setStringyNumber("123456.78910");

        repository.save(entity);

        Optional<EntityWithStringyBigDecimal> reloaded = repository.findById(entity.getId());

        System.out.println(reloaded.get().getStringyNumber());

        // loading the number from the database might result in additional zeros at the end.
        String stringyNumber = reloaded.get().getStringyNumber();
        assertThat(stringyNumber).startsWith(entity.getStringyNumber());
        assertThat(stringyNumber.substring(entity.getStringyNumber().length())).matches("0*");
    }
}