package com.nts.springdatajdbcdemo.mybatis;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Manual {

    @Id
    private Long id = null;
    private String author;
    private String text;

    Manual(String text, String author) {
        this.author = author;
        this.text = text;
    }
}
