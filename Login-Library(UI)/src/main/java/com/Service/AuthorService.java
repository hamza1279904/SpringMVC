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
import com.model.Author;
import com.model.BookDetailModel;

@Service
public class AuthorService 
{
	
  public List<Author> search() throws Exception
  {
	  
	  var url="http://localhost:9091/authors";
		 var req=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		 var client =HttpClient.newBuilder().build();
		 var res= client.send(req,HttpResponse.BodyHandlers.ofString());
		
		 System.out.println(res.statusCode());
		 System.out.println(res.body());
		 
		 ObjectMapper mapper=new ObjectMapper();
		  List<Author> list= mapper.readValue(res.body(),new TypeReference<List<Author>>() {});
		  
		  System.out.println(list);
		  return list; 
	 
	  
  }
}
