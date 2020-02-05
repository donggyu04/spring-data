package com.nts.springdatajdbcdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories
//@Import(MyBatisJdbcConfiguration.class)
public class JdbcConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScripts("create-pet-schema.sql", "create-customer-schema.sql", "create-movie-schema.sql")
                .addScripts("create-book-author-schema.sql")
                .addScripts("create-stringy-big-decimal.sql")
                .addScripts("create-employee-schema.sql")
                .addScripts("create-mybatis-schema.sql")
                .build();
    }
}
