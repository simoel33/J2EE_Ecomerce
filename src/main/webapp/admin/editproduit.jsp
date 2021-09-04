<%@page import="com.occasion.models.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@page import="com.occasion.models.Product"%>
       <% Product prod=(Product)request.getAttribute("product"); %>

<%@ include file="sidebar.jsp"%>)
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listusers</title>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>
<body class="bg-light">
	<div class="container">
		<div>
			<p>la liste des Annonces</p>
		</div>

		<div style="margin-left: 20px" class="row">

			<form action="<%= request.getContextPath() %>/updatePro" method="post">

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Nom Produit</th>
							<th scope="col">prix</th>
							<th scope="col">Description</th>
							<th scope="col">Image</th>
							<th scope="col">Modifier</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">

								<div class="form-group">
								
									<input type="text" value="<%= prod.getName()%>"  name="name"
										class="form-control" id="ema">
								</div>
								
								

							</th>
							
							<td>
							
							<div class="form-group">
								
									<input type="text" value="<%= prod.getPrice() %>"  name="price"
										class="form-control" id="ema">
								</div>
							</td>
							<td>
							<input type="hidden" name="id" value="<%= prod.getId() %>">
								<div class="form-group">
									<input type="text" value="<%= prod.getDescription() %>"  name="desciption"
										class="form-control" id="ema">
								</div>
							</td>
							<td>
							
							
<input type="file" class="form-control" id="customFile" />
							</td>
							<td><button type="submit" class="btn btn-info"> Modifier </button></td>
							

						</tr>

					</tbody>
				</table>

			</form>

		</div>
	</div>
</html>