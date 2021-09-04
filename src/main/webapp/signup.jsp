<%@page import="com.occasion.models.City"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="navbar.jsp" %>
    
   <% ArrayList list=(ArrayList)request.getAttribute("cities"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creer Votre Compte</title>
</head>
<body class="bg-light">
	<div class="container">

		<div class="row">
			<div class="col-md-12 mx-auto">
			<div>
					<p class="toptitle" style="
					margin-top:10px;
	text-align: center;
	    font-size: 32px;
    font-weight: normal;
    font-stretch: normal;
    font-style: normal;
    letter-spacing: normal;
    color: #434343;
    line-height: 1.3;
					">Creer Votre Compte c'est gratuit !</p>
					</p>
						
				</div>
			</div>
			</div>
			
			<div class="row">
    <div class="col-md-4  mx-auto">
    <form method="post" action="SignUp">
    <div class="form-group">
<input type='text' name='firstName'  required="required" placeholder="Nom" class="form-control" id="ema">

</div>
 <div class="form-group">
<input type='text' name="lastName" required="required" placeholder="Prenom" class="form-control">
</div>
 <div class="form-group">
<input type="email" name="email" id='log' required="required" class="form-control" placeholder="E-mail">
</div>
 <div class="form-group">
 <input type="password" name="password" required="required" id="pass" class="form-control"  placeholder="*********">
</div>
 <div class="form-group">
<select name="city" class="form-control" id="exampleFormControlSelect1">
<%

for(int i=0;i<list.size();i++)
{%>
	
<% 	City c= (City)list.get(i); %>

<option value='<%=c.getId() %>'><%= c.getName()%></option> 
<%} %>
</select>
</div>
 <div class="form-group">
<input type='text' required="required" class="form-control" placeholder="Adresse" name = 'address'>
</div>
<div class="form-group">
<input type='text' class="form-control"  required="required" placeholder="+212 XXX-XXX-XXX" name='tel'>
</div>

<button type="submit" value="enregistrer" class="btn btn-block btn-primary">S'inscrire</button>

</form>
</div>
</div>
    </div>
			
			
			
</body>
</html>