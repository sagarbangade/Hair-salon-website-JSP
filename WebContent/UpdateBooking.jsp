<%@page import="model.UserDao"%>
<%@page import="model.Addbooking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
   <style>

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #ff2e46;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #573b8a;
}


.main{

	
	width: 1350px;
	height: 570px;
	background: red;
	overflow: hidden;
	background: url("https://doc-08-2c-docs.googleusercontent.com/docs/securesc/68c90smiglihng9534mvqmq1946dmis5/fo0picsp1nhiucmc0l25s29respgpr4j/1631524275000/03522360960922298374/03522360960922298374/1Sx0jhdpEpnNIydS4rnN4kHSJtU1EyWka?e=view&authuser=0&nonce=gcrocepgbb17m&user=03522360960922298374&hash=tfhgbs86ka6divo3llbvp93mg4csvb38") no-repeat center/ cover;
	border-radius: 10px;
	box-shadow: 5px 20px 50px #000;
}

#chk{
	display: none;
}
.signup{
	position: relative;
	width:100%;
	height: 100%;
}
label{
	color: #fff;
	font-size: 2.3em;
	justify-content: center;
	display: flex;
	margin: 60px;
	font-weight: bold;
	cursor: pointer;
	transition: .5s ease-in-out;
}
input{
	width: 60%;
	height: 20px;
	background: #e0dede;
	justify-content: center;
	display: flex;
	margin: 20px auto;
	padding: 10px;
	border: none;
	outline: none;
	border-radius: 5px;
}
button{
	width: 60%;
	height: 40px;
	margin: 10px auto;
	justify-content: center;
	display: block;
	color: #fff;
	background: #ff2e46;
	font-size: 1em;
	font-weight: bold;
	margin-top: 20px;
	outline: none;
	border: none;
	border-radius: 5px;
	transition: .2s ease-in;
	cursor: pointer;
}
button:hover{
	background: #6d44b8;
}
.login{
	height: 460px;
	background: #eee;
	border-radius: 60% / 10%;
	transform: translateY(-180px);
	transition: .8s ease-in-out;
}
.login label{
	color: #573b8a;
	transform: scale(.6);
}

#chk:checked ~ .login{
	transform: translateY(-500px);
}
#chk:checked ~ .login label{
	transform: scale(1);	
}
#chk:checked ~ .signup label{
	transform: scale(.6);
}




  </style>
</head>
<body>
  <%
      	int pId=Integer.parseInt(request.getParameter("pId"));

try
{
	
	  Addbooking p = new UserDao().updateBooking(pId);
      	
%>
<div class="navbar">
<ul>
  <li><a href="index.html">Home</a></li>
  <li><a href="#about">About Us</a></li>
  <li><a href="service.html">Services</a></li>
  <li><a href="feedback.html">Feedback</a></li>
  <li><a class="active" href="login.html">Login</a></li>
</ul>
</div>
	<div class="main"> 
	
		<input type="checkbox" id="chk" aria-hidden="true">
			
			<div class="signup">
				<form action="UpdateBookingData.jsp" method="post">
					<label for="chk" aria-hidden="true">Update Booking</label>
					<input type="text" name="username" placeholder="user name" value="<%=p.getUsername() %>"required/>
					<input type="text" name="name" placeholder="name"value="<%=p.getName() %>" required/>
					<input type="text" name="service" placeholder="service"value="<%=p.getService() %>" required/>
					<input type="text" name="date" placeholder="date" value="<%=p.getDate() %>"required/>
					<input type="text" name="price" placeholder="price"value=<%= p.getPrice()%> required/>
					<input type="text" name="time" placeholder="time"value=<%=p.getTime()%> required/>
					<input type ="hidden" name="bid" value=<%=p.getBid() %> required/>
					
					<button>Submit</button>
				</form>
			</div>
<%
     }
    catch(Exception e)
    {
    	out.print("error : "+e);
    }
    %>
	</div>
</body>
</html>