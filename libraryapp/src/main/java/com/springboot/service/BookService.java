package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.BookDetailModel;
import com.springboot.repository.BooksRepository;

@Service
public class BookService {
	@Autowired
	private BooksRepository repo;

	public BookDetailModel saveBook(BookDetailModel book) {
		repo.save(book);
		return book;
	}

	public String deleteBook(int code) {
		repo.deleteById(code);
		return "Product Removed";
	}

	public ArrayList<BookDetailModel> saveAll(ArrayList<BookDetailModel> list) {
		repo.saveAll(list);
		return list;
	}

	public List<BookDetailModel> findAll() {
		return (List<BookDetailModel>) repo.findAll();

	}

	public BookDetailModel findBook(int code) {
		return repo.findById(code).orElse(null);
	}
}
