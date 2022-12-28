<%@page import="model.MyUser"%>
<%@page import="model.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String email = request.getParameter("email");



UserDao db = new UserDao();
if(db.checkEmail(email))
{
	out.print("Email Id already exists");
}
else{
try{
	String username = request.getParameter("username");
	String name = request.getParameter("name");
	String psw=request.getParameter("psw");
	MyUser u = new MyUser(username,name,email,psw);
int a = db.reguser(u);
if(a>0)
{%>
	<script>
	   alert("username registration Succesful now login");
	   window.location= "login.html";
	</script><%
}
}
catch(Exception e){
e.printStackTrace();
out.print("error sql");

}
}
%>
</body>
</html>