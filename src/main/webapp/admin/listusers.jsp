<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="com.occasion.models.User"%>
<%@page import="java.util.ArrayList"%>
    <%@ include file="sidebar.jsp" %>
       <% ArrayList list=(ArrayList)request.getAttribute("users"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listusers</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha512-SfTiTlX6kk+qitfevl/7LibUOeJWlt9rbyDn92a1DqWOw9vWG2MFoays0sgObmWazO5BQPiFucnnEAjpAB+/Sw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body class="bg-light">
	<div class="container">
	<div>
	<p> la liste des utilisateurs</p>
	
	
	</div>

		<div style="margin-left: 20px" class="row">
			
			
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">email</th>
       <th scope="col">Tele</th>
       <th scope="col">Modifier</th>
        <th scope="col">Supprimer</th>
       
    </tr>
  </thead>
  <tbody>
   <%  
       for(int i=0;i<list.size();i++){
       User user = (User)list.get(i); %>
       
    
    <tr>
      
      <th scope="row"><%=user.getFirstName() %></th>
      <td><%=user.getLastName() %></td>
      <td><%=user.getEmail() %></td>
      <td><%=user.getTel() %></td>
  <td> <a href="<%= request.getContextPath() %>/register?id=<%=user.getIdUser()%>"> <i style="color:blue;" class="fa fa-pencil-square" aria-hidden="true"></i></a>
</td>
 <td>
  <a  href="<%= request.getContextPath() %>/suppUser?id=<%=user.getIdUser()%>" class="button delete-confirm"> <i style="color:red;" class="fa fa-trash" aria-hidden="true"></i> </a>
</td>
 <script>
      
      
      function confirmdelete() {
    	  event.preventDefault(); // prevent form submit
    	  var form = event.target.form; // storing the form
    	  swal({
        	  title: "Are you sure?",
        	  text: "Once deleted, you will not be able to recover this imaginary file!",
        	  icon: "warning",
        	  buttons: true,
        	  dangerMode: true,
        	})
        	.then((willDelete) => {
        	  if (willDelete) {
        	    swal("Poof! Your imaginary file has been deleted!", {
        	      icon: "success",
        	      
        	    });
        	  } else {
        	    swal("Your imaginary file is safe!");
        	    
        	  }
        	});
	}
      </script> 
       
    </tr>
   <%} %>
      <script>
      
      
      function confirmdelete() {
    	  event.preventDefault(); // prevent form submit
    	  var form = event.target.form; // storing the form
    	  swal({
        	  title: "Are you sure?",
        	  text: "Once deleted, you will not be able to recover this imaginary file!",
        	  icon: "warning",
        	  buttons: true,
        	  dangerMode: true,
        	})
        	.then((willDelete) => {
        	  if (willDelete) {
        	    swal("Poof! Your imaginary file has been deleted!", {
        	      icon: "success",
        	      
        	    });
        	  } else {
        	    swal("Your imaginary file is safe!");
        	    
        	  }
        	});
	}
      </script> 
       
        

   
  </tbody>
</table>
			
			</div>
			</div>
		


</html>