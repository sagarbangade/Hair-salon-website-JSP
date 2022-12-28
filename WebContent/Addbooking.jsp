<%@page import="model.UserDao"%>
<%@page import="model.Addbooking"%>
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
UserDao db = new UserDao();
try{
String username = request.getParameter("username");
String name = request.getParameter("name");
String service = request.getParameter("service");
String date = request.getParameter("date");
String price = request.getParameter("price");
String time = request.getParameter("time");
Addbooking u = new Addbooking(username,name,service,date,price,time);
int a = db.addservice(u);

if(a>0)
{
	%>
	<script>
	   alert("Your registration Succesful");
	   window.location= "AddBooking.html";
	</script><%
}
}
catch(Exception e){
e.printStackTrace();
out.print("error sql");
}

%>
</body>
</html>