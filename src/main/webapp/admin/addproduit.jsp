<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.occasion.models.Category"%>
<%@page import="java.util.ArrayList"%>
    
    <%@ include file="sidebar.jsp" %>
    
     <% ArrayList list=(ArrayList)request.getAttribute("categories"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Annonce</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha512-SfTiTlX6kk+qitfevl/7LibUOeJWlt9rbyDn92a1DqWOw9vWG2MFoays0sgObmWazO5BQPiFucnnEAjpAB+/Sw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


</head>

<body class="bg-light">
	<div class="container">

		<div class="row">
			<div class="col-md-12 mx-auto">
			<div>
					<p style="text-align: center;" class="toptitle">Ajouter une Annonce</p>
					</p>
						
				</div>
			</div>
			</div>
			
			
			
			
			
<div class="row">
    <div class="col-md-4  mx-auto">
        <form action="<%= request.getContextPath() %>/createPro" method="post" >
  			<div class="form-group">
                <input  type="text" placeholder="Nom Produit" name="name" class="form-control" id="ema">
            </div>
            <div class="form-group">
                <input  type="text" placeholder="Description" name="desciption" class="form-control" id="ema">
            </div>
             <div class="form-group">
                <input  type="number" placeholder="Prix DH" name="price" class="form-control" id="ema">
            </div>
            
           
            <div class="form-group">
									 <select
										class="form-control" id="exampleFormControlSelect1" name="category">
										
										<%

for(int i=0;i<list.size();i++)
{%>
	
<% 	Category c= (Category)list.get(i); %>

<option value='<%=c.getId() %>'><%= c.getName()%></option> 


<%} %>
										
										
									</select>
								</div>
								<label class="form-label"  for="customFile">Ajouter la photo du produit</label>
<input type="file" name="image" class="form-control" id="customFile" />
<br>
								 
            <button type="submit" class="btn btn-block btn-primary ">
            <i style="margin-top: 8px;height: 20px"  class="fa fa-plus-circle" aria-hidden="true"></i>

            Ajouter une Annonce </button>
        </form>

    </div>
</div>
			</div>
			
			
			

</body>
</html>