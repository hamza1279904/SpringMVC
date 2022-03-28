<%@page import="com.model.Author"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Add Book</title>
</head>
<body  class="bg-light" style="background-image:  url('https://images.pexels.com/photos/1029141/pexels-photo-1029141.jpeg?cs=srgb&dl=pexels-nitin-arya-1029141.jpg&fm=jpg'); background-size: 1200px;">


<nav class="navbar bg-dark text-center " style="padding-right: 0.5rem; padding-bottom: 0.5rem" >
    
    <div class="text-center col-2" style=" color: white; padding-left: 0.3rem; font-family:monospace; align:right"> Welcome 
    <%
        String username =request.getParameter("username") ;
                 request.setAttribute("username",username);
                    out.println("  "+username.toUpperCase());
        %>
    </div>
    
     <a href="Login.jsp">
     <button type="button" class="btn btn-outline-danger" >Logout</button>
     </a>
</nav>    


<div class="col-11" style="width: 95%;height: 95%; display: flex;align-items: center;">
<div class="p-2" style="  border-radius: 0.5rem; margin-left:auto; margin-right:auto; margin-top:  100px; ">

<form action="addBook" method="POST" >
<div class="" style="padding: 3rem; background-color:  rgba(0, 0 ,0, 0.651); border-radius: 0.5rem">
<p style="font-family: monospace; font-size: 35px; color: white; margin-left: 50px; margin-right: auto; ">Enter Book Details </p>

<%
List<Author> list = (List<Author>)session.getAttribute("authlist"); 
    System.out.println(list);
%>

<div class=" container-fluid sm px-2 input-group-sm mb-2" style="display:flex;">
  <span class="px-2" style="width: 150px; padding-right: 1rem;color: white;">Book Code</span>
  <input type="text" class="form-control px-2" name="code" style="width: 170px; margin-left: 1rem "aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
</div>
<div class=" container-fluid sm px-2 input-group-sm mb-2" style="display:flex;">
  <span class="px-2" style="width: 150px; padding-right: 1rem;color: white;">Book Name</span>
  <input type="text" class="form-control px-2" name="name" style="width: 170px;margin-left: 1rem"aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
</div>
<div class=" container-fluid sm px-2 input-group-sm mb-2" style="display:flex;">
  <span class=" px-2" style="width: 150px; padding-right: 1rem;color: white;">Author</span>
  
 <select class ="btn-sm btn-danger form-select" name="author" value ="Authors" style="margin-left: 2rem">
 <option selected>Choose Author</option>
    <% for(int i=0;i<list.size();i++)
    {%>
     <option><%=list.get(i).getName() %></option>
<%} %>
</select>
  
  </div>
<div class=" container-fluid sm px-2 input-group-sm mb-2" style="display:flex;">
  <span class="px-2" style="width: 150px; padding-right: 1rem;color: white;">Date</span>
  <span type="date" class=" px-2" name="output"style="width: 170px; margin-left: 1rem; color: white; "aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
<jsp:useBean id="date" class="java.util.Date"/> <fmt:formatDate value="${date}" type="date" pattern="dd-MMMMMMMMMMMMMMM-yyyy" /></span>
</div>
 
 <input type="hidden" value="<fmt:formatDate value="${date}" type="date" pattern="dd-MMM-yyyy" />" name="date">
 
 <input type="hidden" value="<%=username%>" name="username">
         
   <button type="submit"class="btn btn-danger" style="height:30px; font-size: 14px; margin-left: 10rem;  ; width: 100px">Submit</button>
   <button type="button" class="btn btn-danger" style="height:30px; font-size: 14px; margin-left: 1rem;  name="back" onclick="history.back()">Cancel</button>
</form>
   </div>
   
   
</div>
</body>
</html>