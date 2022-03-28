package com.nagarro.advancejava.libararyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.AuthorNames;
import com.springboot.service.AuthorsService;

@RestController
public class AuthorNamesController {
	@Autowired
	AuthorsService service;

	@GetMapping("authors")
	public List<AuthorNames> seach() {
		return service.authors();
	}
}
