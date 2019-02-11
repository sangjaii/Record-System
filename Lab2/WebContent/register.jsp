<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/JavaScript">
function vaild()
{
	var ID = document.forms["register"]["userID"].value;
	var PW = document.forms["register"]["userPW"].value;
	var checkPW = document.forms["register"]["checkPW"].value;
	
	if(isBlank(checkPW) || isBlank(ID) || isBlank(PW))
			{
				alert("ID or password cannot be blank!")
				return false;
			}
	
	if(PW != checkPW)
		{
			alert("The re-enter password is incorrect!");
			return false;
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
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<form name = "register" onsubmit = "return vaild();" action = "registerID" method = "POST">
<h1>Register Page</h1><br>
User Id: <input type = "text" name = "userID"><br>
Password: <input type = "password" name = "userPW"><br>
Re-enter Password: <input type = "password" name = "checkPW"><br>
<input type = "submit" value = "Submit">
<a href = "SearchBook.jsp"> Back to home page </a>
</form>
</body>
</html>