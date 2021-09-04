<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@page import="com.occasion.models.User"%>
	
	<% User u = (User) request.getSession().getAttribute("connectedUser");  %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	integrity="sha512-SfTiTlX6kk+qitfevl/7LibUOeJWlt9rbyDn92a1DqWOw9vWG2MFoays0sgObmWazO5BQPiFucnnEAjpAB+/Sw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" type="text/css" href="style/style.css" />

</head>
<body>


	<nav style="margin-top: 1px"
		class="navbar navbar-expand-sm navbar-light bg-primary">
		<a class="navbar-brand" href="index.jsp" style="margin-left: 100px">Occasion</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
						class="fa fa-home" aria-hidden="true"></i> Accueil <span
						class="sr-only">(current)</span></a></li>
						
 
 
 
   

    
      <% if(u == null){ %>
    
				<li class="nav-item active"><a class="nav-link"
					href="<%= request.getContextPath() %>/login"> <i class="fa fa-user-circle"
						aria-hidden="true"></i> Login <span class="sr-only"></span></a></li>
						
	 
				<li class="nav-item active"><a class="nav-link"
					href="<%= request.getContextPath() %>/SignUp"> <i class="fa fa-user-plus"
						aria-hidden="true"></i> S'inscrire <span class="sr-only"></span></a></li>
						
						
						
						<% } %>
						<% if(u != null){ %>
						<li class="nav-item active"><a class="nav-link"
					href="<%= request.getContextPath() %>/admin/index.jsp"> <i class="fa fa-user-plus"
						aria-hidden="true"></i> Mon Compte <span class="sr-only"></span></a></li>
<% } %>
			</ul>

		</div>
	</nav>