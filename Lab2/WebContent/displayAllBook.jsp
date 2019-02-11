<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Info.</title>
</head>
<body>

	<%@page import="java.util.ArrayList" %>
	<%@page import="java.util.Date" %>
	<%@page import="bookstore.*" %>
	<%
		ArrayList<Book> books = (ArrayList<Book>)session.getAttribute("getAllBook");
		int numBooks = books.size();
		
		
		
	%>
	<center>The time now is: <%= new Date() %></center>
	
	<table align="center" border=1  >
	<tr>
		<th>ISBN</th>
		<th>Title</th>
		<th>Author</th>
		<th>Edition Number</th>
		<th>Publisher</th>
		<th>Copyright</th>
		<th></th>
	</tr>

	<% for (int i=0; i<numBooks; i++) { %>
	<tr>
		<th><%= (books.get(i)).getIsbn() %></th>
		<th><%= (books.get(i)).getTitle() %></th>
		<th><%= (books.get(i)).getAuthor() %></th>
		<th><%= (books.get(i)).getEdition() %></th>
		<th><%= (books.get(i)).getPublisher() %></th>
		<th><%= (books.get(i)).getCopyright() %></th>
		<th><a href = "deleteItem?ISBN=<%= (books.get(i)).getIsbn()%>">Delete</a></th>
		<!-- For each i, retrieve the information of the i-th book from the ArrayList. -->
		<!-- Display the information in one row per book. -->
		<!-- The last element of each row should contain a link to OrderServlet.class --> 
		<!-- with input parameter "selectedBook" and value equal to i -->
		<!-- Put your code here -->
	</tr>
	<% } %>
</table>
<center><A href="SearchBook.jsp">Home</A>      <a href = "addItemForm.jsp">Add Item</a></center>
</body>
</html>