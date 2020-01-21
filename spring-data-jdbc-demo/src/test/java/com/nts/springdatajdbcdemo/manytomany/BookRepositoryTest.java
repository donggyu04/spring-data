package com.nts.springdatajdbcdemo.manytomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testManyToMany() {
        Author author = new Author();
        author.setName("taeyeonKim");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("TomorrowLand");
        book.setIsbn("123123");
        book.addAuthor(author);
        bookRepository.save(book);

        for (Book book1 : bookRepository.findAll()) {
            System.out.println(authorRepository.findAllById(book1.getAuthorIds()));
        }

        for (Author author1 : authorRepository.findAll()) {
            System.out.println(bookRepository.findAllById(author1.getBookIds()));
        }
    }
}