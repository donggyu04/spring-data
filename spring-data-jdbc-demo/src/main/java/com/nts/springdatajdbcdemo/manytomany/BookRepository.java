package com.nts.springdatajdbcdemo.manytomany;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
