<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<h1>Input Form</h1>
<form name = "Add" action = "addItem" method = "POST">
ISBN:			<input type = "text" name = "isbn"><br>
Title: 			<input type = "text" name = "title"><br>
Author: 		<input type = "text" name = "author"><br>
Edition Number: <input type = "text" name = "editionNo"><br>
Publisher: 		<input type = "text" name = "publisher"><br>
Copyright: 		<input type = "text" name = "copyright"><br>
Price:			<input type = "text" name = "price"><br>
<input type = "submit" value = "Submit">
</form>
</body>
</html>