package com.nts.springdatajdbcdemo.manytomany;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private Set<BookAuthorReference> authors = new HashSet<>();

    void addAuthor(Author author) {
        this.authors.add(new BookAuthorReference(author.getId(), this.id));
    }

    Set<Long> getAuthorIds() {
        return this.authors.stream()
                .map(BookAuthorReference::getAuthor)
                .collect(Collectors.toSet());
    }
}
