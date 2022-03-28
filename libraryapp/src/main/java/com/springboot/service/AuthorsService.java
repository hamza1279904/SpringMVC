package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.AuthorNames;
import com.springboot.repository.AuthorNamesRepository;

@Service
public class AuthorsService {
	@Autowired
	AuthorNamesRepository repo;

	public List<AuthorNames> authors() {
		return (List<AuthorNames>) repo.findAll();
	}
}
