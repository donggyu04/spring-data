package com.nts.springdatajdbcdemo.manytomany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_author")
@AllArgsConstructor
@Getter
public class BookAuthorReference {
    private Long author;
    private Long book;
}
