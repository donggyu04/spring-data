package com.nts.springdatajdbcdemo.manytomany;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Author {
    @Id
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Set<BookAuthorReference> books;

    void addBook(Book book) {
        this.books.add(new BookAuthorReference(book.getId(), this.id));
    }

    Set<Long> getBookIds() {
        return this.books.stream()
                .map(BookAuthorReference::getBook)
                .collect(Collectors.toSet());
    }
}
