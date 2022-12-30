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
String uname=request.getParameter("uname");
String upass=request.getParameter("upass");
String radio = request.getParameter("radio");
if(radio.equals("1")){
	if(new UserDao().checkUser(uname, upass))
	{
	response.sendRedirect("ViewBooking.jsp");
	//request.getRequestDispatcher("ViewBooking.jsp").forward(request, response);
	session.setAttribute("uname", uname);
	}
	else
	{
	%>
	<script>
	   alert("Wrong username and password");
	   window.location= "login.html";
	</script> 
	<%
	}
	}
else if(radio.equals("2")){
	if(new UserDao().checkadminUser(uname, upass))
	{
		response.sendRedirect("AdminDashboard.jsp");
		
	}
	else
	{
	%>
		<script>
		   alert("Wrong admin username and password");
		   window.location= "login.html";
		</script>
	<%
	}
}
%>
</body>
</html>