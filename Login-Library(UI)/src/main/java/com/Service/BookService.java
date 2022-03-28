package com.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.BookDetailModel;

@Service
public class BookService {

	public void addBook(BookDetailModel book) throws Exception {
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(book);

		String url = "http://localhost:9091/addBook";

		var req = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(json)).build();

		var client = HttpClient.newHttpClient();
		var res = client.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.body());
	}

	public void delete(String code) throws Exception {
		String url = "http://localhost:9091/deleteBook";
		url = url + "/" + code;

		var req = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").DELETE()
				.build();

		var client = HttpClient.newHttpClient();
		var res = client.send(req, HttpResponse.BodyHandlers.ofString());

		System.out.println(res.body());
	}

	public List<BookDetailModel> extract() throws Exception {
		var url = "http://localhost:9091/findBooks";
		var req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		var client = HttpClient.newBuilder().build();
		var res = client.send(req, HttpResponse.BodyHandlers.ofString());

		System.out.println(res.statusCode());
		System.out.println(res.body());

		ObjectMapper mapper = new ObjectMapper();
		List<BookDetailModel> list = mapper.readValue(res.body(), new TypeReference<List<BookDetailModel>>() {
		});

		System.out.println(list);
		return list;
	}
}
