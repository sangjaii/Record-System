<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<style type="text/css">
.topright {
    position: absolute;
    top: 3px;
    right: 3px;
    font-size: 18px;
}
</style>
<title>Online Bookstore</title>
<script type="text/JavaScript">
function validateForm() {
	var isbn = document.forms["search"]["isbn"].value;
	var author = document.forms["search"]["author"].value;
	
	if(isBlank(isbn))
		if(isBlank(author))
		{
			alert("ISBN or Author cannot be blank!");
			return false;
		}	
	if(!isBlank(isbn))
	{
		if(isNaN(parseInt(isbn)))
			{
				alert("ISBN must be number!");
				return false;
			}
	}	
	return true;

	
		
}

function isBlank(s) {
	var i
	for (i = 0; i < s.length; i++) {
		if (s.charAt(i) != " ")
			return false
	}
	return true
}

</script>
</head>

<body>
<%@page import="javax.servlet.http.HttpSession" %>

<% 
boolean loginOrNot=false;

if(session.getAttribute("logined")!=null)
{
	loginOrNot =(boolean) session.getAttribute("logined");
}

if(loginOrNot)
	{%>
		<div class = "topright">Welcome, <%= session.getAttribute("UserID") %>!<br>
		<a href = "logout">logout</a>
		</div>
<%	}
else
	{%>
		<div class = "topright"><a href="login.html">Log in</a><br>
		<a href = "register.jsp">Register Account</a>
		</div>
<%	} %>



	<form name="search" onsubmit="return validateForm()" method="post" action="QueryServlet">

		<p>
			Student Name: Poon Yin Sang Bernie<br>
			Student ID: 17050056D<br>
			<p id= "time"></p>
			<p id= "date"></p>
			Please choose <b>either ISBN or Author</b> to search books:<br>
			
			Search
			by ISBN: <input type="text" name="isbn" size=20 value="0132404168"> <br>Search
			by Author: <input type="text" name="author" size=19 value="Paul Deitel"> <br>
			<input type="submit" value="Submit">
	</form>
<%if(loginOrNot)
	{%>
	<a href = "GetAll">Manage database</a>
<%		} %>
	
<script>
function addZero(s)
{
	if(s<10)
		{
			var Added= s.toString();
			return "0" + Added;
		}
	return s;
}
  var d = new Date();
  var Hours = d.getHours();
  var Minute= d.getMinutes();
  var date= d.getDate();
  var Month= d.getMonth();
  var Year= d.getFullYear();
  Month+=1;
  
  document.getElementById("time").innerHTML="The time now is: " + addZero(Hours) + ":" + addZero(Minute);
  document.getElementById("date").innerHTML="The date is: " + date + "/" + Month + "/" + Year;
</script>
	
</body>
</html>