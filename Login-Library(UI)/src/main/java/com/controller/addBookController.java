package com.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Service.BookService;
import com.Service.AuthorService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.BookDetailModel;

@RestController
public class addBookController {

	@Autowired
	BookService service;
	@Autowired
	AuthorService authservice;

	@PostMapping("/addBook")
	public ModelAndView adddBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		String username = request.getParameter("username");

		System.out.println(code + " " + name + " " + author + " " + date);

		BookDetailModel book = new BookDetailModel(Integer.parseInt(code), name, author, date);

		var url = "http://localhost:9091/findBook";
		url = url + "/" + code;
		var req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		var client = HttpClient.newBuilder().build();
		var res = client.send(req, HttpResponse.BodyHandlers.ofString());

		System.out.println(res.body());

		if (res.body().isEmpty())
			service.addBook(book);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome.jsp");
		mv.addObject("table", service.extract());
		mv.addObject("username", username);
		mv.addObject("authlist", authservice.search());

		return mv;

	}

	@PostMapping("/updateBook")
	ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String date = request.getParameter("date");

		System.out.println(name + " " + date + " " + username + "  from edit");

		service.delete(code);

		BookDetailModel book = new BookDetailModel(Integer.parseInt(code), name, author, date);
		service.addBook(book);
		System.out.println("Book Updated");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome.jsp");
		mv.addObject("username", username);
		mv.addObject("table", service.extract());
		mv.addObject("authlist", authservice.search());

		return mv;
	}

	@PostMapping("/delete")
	ModelAndView deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String code = request.getParameter("code");

		service.delete(code);

		ModelAndView mv = new ModelAndView();
		mv.addObject("username", username);
		mv.setViewName("welcome.jsp");
		mv.addObject("table", service.extract());
		mv.addObject("authlist", authservice.search());
		return mv;
	}
	
	
}
