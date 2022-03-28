package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.AuthorNames;

public interface AuthorNamesRepository extends CrudRepository<AuthorNames, Integer>
{

}
