
<%@page import="com.model.Author"%>
<%@page import="com.model.BookDetailModel"%>
<%@page import="com.mysql.cj.xdevapi.Table"%>

<%@page import="java.io.*"%>
<%@page import="javax.servlet.annotation.WebServlet,java.util.*"%>
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

    <title>Book Management</title>

</head>
<body class="bg-light" style="background-image:  url('https://images.pexels.com/photos/1029141/pexels-photo-1029141.jpeg?cs=srgb&dl=pexels-nitin-arya-1029141.jpg&fm=jpg'); background-size: 1200px;">

 


 
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


<div>
<div class="container-fluid" style="padding: 1rem; display: flex;">
<div class="container-fluid col-10  " style="align-items:center; display:inline-flex; height: 15px " >
  <h3 class="" style="color: white;padding-bottom: 0.5rem; font-family: monospace;font-size: 25px; margin-left: auto; margin-right: auto;" >Book Listing</h3>
    </div>

<form action="AddBook.jsp">
 <input  class="btn btn-sm btn-warning" style="color: white; margin-right:0.5rem " type="submit" value="Add Book" > 
                    <input   type="hidden"  value="<%=username%>" name="username">
</form>

 </div>    
   <br>
   
<div class="p-3  container-fluid  " style="padding: 2rem;   border-radius: 0.4rem; background-color: rgba(10, 10 ,10, 0.51); ">
<br>



<%
try{
ArrayList<BookDetailModel> table=new ArrayList();
table= (ArrayList<BookDetailModel>)request.getAttribute("table");
int c=table.size();
%>
<table class="table" style="color: white;">
  <thead class="thead-dark" style="color: white;">
    <tr>
      <th scope="col">SNo.</th>
      <th scope="col">Book Code</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Date Added</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
 
  <%
   ArrayList<Author> list=new ArrayList();
         list=( ArrayList<Author> )request.getAttribute("authlist"); 
         session.setAttribute("authlist", list);
         System.out.println(list+" jajaja");
   %>  
  
 
 
  <tbody class=" table-striped">
           
<%
      for (int i = 0; i < c; i++) {
%>
    <tr class="" style="height:2rem">
                    
                    <td><% out.println(i+1); %></td> 
                    <td><% out.println(table.get(i).getCode()); %></td>
                    <td><% out.println(table.get(i).getName()); %></td>
                    <td><% out.println(table.get(i).getAuthor()); %></td>
                    <td><% out.println(table.get(i).getDate()); %></td>
                    <td> 
                    
        
                    
                    <div class="sm " style="display:flex ; font-family:monospace; font-size: 12px; align-items: center; width: 15px;">
                    
                    <form action="Edit.jsp" method="GET">
                    <input  class="btn btn-sm btn-warning" style="color: white; margin-right:0.5rem " type="submit" value="Edit" > 
                    <input   type="hidden"  value="<%=  table.get(i).getCode()%>" name="code">
                    <input   type="hidden"  value="<%=  table.get(i).getDate()%>" name="date">
                    <input type="hidden" name="username" value="${username}"></form>
                   
                    <form action="delete" method="post">
                    <input  class="btn btn-sm btn-danger" style="color:white;" type="submit"  value="Delete" >
                    <input  type="hidden"  value="<%= table.get(i).getCode()%>" name="code"> 
                    <input type="hidden" name="username" value="${username}"></form>
                   </div>
                   
                  </td></tr>
                
           <%}}catch(Exception e){out.print("Error");} %>
                
            </tbody>
        </table>


<br>
</div>
</div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>




</body>
</html>