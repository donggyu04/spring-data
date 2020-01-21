package com.nts.springdatajdbcdemo.manytomany;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
