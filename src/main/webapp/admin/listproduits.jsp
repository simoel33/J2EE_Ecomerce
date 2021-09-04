<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.occasion.models.Product"%>
<%@page import="java.util.ArrayList"%>
    
       <% ArrayList list=(ArrayList)request.getAttribute("products"); %>
      
    
    <%@ include file="sidebar.jsp" %>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body class="bg-light">
	<div class="container">
	<div>
	<p> la liste des Annonces</p>
	</div>

		<div style="margin-left: 20px" class="row">
			
			
<table class="table">
  <thead class="thead-dark">
    <tr>
     <th scope="col">Image</th>
      <th scope="col">Nom Produit</th>
      <th scope="col">Description</th>
      <th scope="col">Categorie</th>
       <th scope="col">Modifier</th>
        <th scope="col">Supprimer</th>
       
    </tr>
  </thead>
  <tbody>
  
   
       <%  
       for(int i=0;i<list.size();i++){
       Product pr = (Product)list.get(i); %>
       
    
      

    <tr>
    <th scope="row"> <img alt="" height="150px" width="150px" src="<%=pr.getImage() %>"> </th>
      <th scope="row"><%=pr.getName() %></th>
      <td><%=pr.getDescription() %></td>
      <td><%=pr.getCategory() %></td>
       <td> <a href="<%= request.getContextPath() %>/detailPro?id=<%=pr.getId()%>" > <i style="color:blue;" class="fa fa-pencil-square" aria-hidden="true"></i></a>
</td>
       <td><a  href="<%= request.getContextPath() %>/deletePro?id=<%=pr.getId()%>" class="button delete-confirm"> <i style="color:red;" class="fa fa-trash" aria-hidden="true"></i> </a>
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
    
       <% } %>

   
  </tbody>
</table>
			
			<script type="text/javascript">
			$('.delete-confirm').on('click', function (event) {
			    event.preventDefault();
			    const url = $(this).attr('href');
			    swal({
			        title: 'Are you sure?',
			        text: 'This record and it`s details will be permanantly deleted!',
			        icon: 'warning',
			        buttons: ["Cancel", "Yes!"],
			    }).then(function(value) {
			        if (value) {
			            window.location.href = url;
			        }
			    });
			});
			</script>
			</div>
			</div>
		


</html>