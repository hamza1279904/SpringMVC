package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.model.BookDetailModel;

public interface BooksRepository extends CrudRepository<BookDetailModel, Integer>
{

}
