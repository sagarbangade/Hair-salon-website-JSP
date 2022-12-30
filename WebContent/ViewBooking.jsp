<%@page import="java.util.List"%>
<%@page import="model.Addbooking"%>
<%@page import="model.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Booking</title>


    <meta charset="utf-8">
    <title>DarkPan - Bootstrap 5 Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css2/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css2/style.css" rel="stylesheet">



</head>
<body>

<!-- --------------------------------------------------------------------- -->
         <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">All Bookings</h6>
                        <a class="btn btn-sm btn-primary" href="AddBookingForm.jsp">ADD Bookings</a>
                    </div>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-white">
                  
                    <th>ID</th>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Service</th>
                    <th>Date</th>
                    <th>Price</th>
                    <th>Time</th>
                    <th>Action</th>
                  </tr>
                </thead>
                
                
                
                
                
               <tbody>
                
                <%
                UserDao db = new UserDao();
               // String Username=request.getParameter("uname");

               String uname =(String)session.getAttribute("uname");
               
                List<Addbooking> ul= db.viewUserBooking(uname);
                
                for(Addbooking u:ul)
                {
                
                %>
                  <tr>
                   
                    <td>
                    <%=u.getBid() %>
                    </td>
                    <td>
                    <%=u.getUsername() %>
                    </td>
                    <td>
                    <%=u.getName() %>
                    </td>
                    <td>
                    <%=u.getService() %>
                    </td>
                    <td>
                    <%=u.getDate() %>
                    </td>
                    <td>
                    <%=u.getPrice() %>
                    </td>
                    <td>
                    <%=u.getTime() %>
                    </td>
                    <td>
                          <a class="btn btn-sm btn-primary" href="UpdateBooking.jsp?pId=<%=u.getBid()%>">Update</a>
                          <a class="btn btn-sm btn-primary" href="DeleteBooking.jsp?pId=<%=u.getBid()%>">Trash</a>
                    </td>
                  </tr>
                  
                  <%
                }
                  %>
                  
               
                </tbody>      
            </div>   
</body>
</html>