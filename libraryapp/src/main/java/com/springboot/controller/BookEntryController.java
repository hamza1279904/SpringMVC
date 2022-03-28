package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.BookDetailModel;
import com.springboot.repository.BooksRepository;
import com.springboot.service.BookService;

@RestController
public class BookEntryController {
	@Autowired
	private BookService service;
	@Autowired
	private BooksRepository repo;

	@PostMapping("addBook")
	public BookDetailModel addBook(@RequestBody BookDetailModel book) {
		return service.saveBook(book);
	}

	@PostMapping("addBooks")
	public ArrayList<BookDetailModel> addBooks(@RequestBody ArrayList<BookDetailModel> list) {
		return service.saveAll(list);
	}

	@GetMapping("findBooks")
	public List<BookDetailModel> findBooks() {
		List<BookDetailModel> list = (ArrayList<BookDetailModel>) repo.findAll();

		return list;
	}

	@GetMapping("/findBook/{code}")
	public BookDetailModel findBook(@PathVariable int code) {
		return repo.findById(code).orElse(null);
	}

	@DeleteMapping("/deleteBook/{code}")
	public String deleteBook(@PathVariable int code) {
		repo.findById(code).toString();
		repo.deleteById(code);
		return "Book Deleted";
	}

	@PutMapping("/updateBook")
	public String updateBook(@RequestBody BookDetailModel book) {
		repo.deleteById(book.getCode());
		repo.save(book);

		return "Updated";
	}
}
