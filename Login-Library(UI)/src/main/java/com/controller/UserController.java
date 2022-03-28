package com.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Service.UserService;
import com.Service.AuthorService;
import com.Service.BookService;

import com.dao.UserDao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.BookDetailModel;

@Controller
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	BookService extract;
	@Autowired
	AuthorService authservice;

	@GetMapping("/authenticate")
	ModelAndView Authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username);
		System.out.println(password);

		boolean check = service.Search(username, password);
		System.out.println("Authentication " + check);

		ModelAndView mv = new ModelAndView();

		if (check) {
			mv.setViewName("welcome.jsp");
			mv.addObject("username", username);
			mv.addObject("table", extract.extract());
			mv.addObject("authlist", authservice.search());
		} else {
			mv.setViewName("Login.jsp");
		}
		return mv;
	}

}
