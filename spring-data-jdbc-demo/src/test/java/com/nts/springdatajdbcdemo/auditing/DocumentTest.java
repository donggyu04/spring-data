package com.nts.springdatajdbcdemo.auditing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import java.util.Optional;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;

@SpringBootTest
class DocumentTest {

    @TestConfiguration
    @EnableJdbcAuditing
    static class Config {
        @Bean
        public AuditorAware<String> auditorProvider() {
            return () -> Optional.of("imb");
        }
    }

    @Autowired
    private DocumentRepository documentRepository;

    @Test
    public void auditingTest() throws Exception {
        Document saved = documentRepository.save(new Document("Hello, world!"));
        assertNotNull(saved);
        System.out.println(saved);

        SECONDS.sleep(1);
        System.out.println(documentRepository.save(saved));

        SECONDS.sleep(1);
        saved.setDescription("Hello, Spring Data JDBC!");
        System.out.println(documentRepository.save(saved));
    }
}