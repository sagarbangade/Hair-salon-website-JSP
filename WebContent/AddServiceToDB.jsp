<%@page import="model.UserDao"%>
<%@page import="model.AddServices"%>
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
try{
	UserDao db = new UserDao();
	String serviceName = request.getParameter("servicename");
	String price = request.getParameter("price"); 
	AddServices u = new AddServices(serviceName,price);
			
			int a = db.AddServices(u);
	if(a>0)
	{
	%>
		<script>
		   alert("New Service Added Sucessfully");
		   window.location= "AdminDashboard.jsp";
		</script>
	<%
	}
	}
	catch(Exception e){
	e.printStackTrace();
	out.print("error sql");
	}
	
			

%>
</body>
</html>