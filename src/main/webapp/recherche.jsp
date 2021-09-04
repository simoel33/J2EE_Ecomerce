<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@page import="com.occasion.models.ResSearch"%>
<%@page import="java.util.ArrayList"%>
   <% ArrayList list=(ArrayList)request.getAttribute("resultSearch"); %>
<%@ include file="navbar.jsp"%>

<body class="bg-light">
	<div class="container">

	
		<div class="row">
			<div class="col-md-12 mx-auto">
				<div>
					<p class="toptitle"
						style="margin-top: 10px; text-align: center; font-size: 32px; font-weight: normal; font-stretch: normal; font-style: normal; letter-spacing: normal; color: #434343; line-height: 1.3;">
						1er site d'annonces gratuites au Maroc</p>
					<p class="subtitle"
						style="text-align: center; font-size: 16px; font-weight: normal; font-stretch: normal; font-style: normal; line-height: normal; letter-spacing: normal; color: #666666;">
						Trouver la bonne affaire parmi 834 102 annonces</p>

				</div>

				<div class="search"
					style="background-color: white; box-shadow: 1em; border-radius: 1em;">


					<div class="container">

						<div class="row">
							<div class="col-md-3">
								
									<class="form-group">
									<form action="<%=request.getContextPath()%>/Search" method="post">
									<div class="form-group">
										<label for="quoi">Que recherchez-vous ?</label> <input
											type="text" class="form-control" id="exampleInputText"
											name="name" placeholder=" Que recherchez-vous ?">
									</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label for="exampleFormControlSelect1">Toutes les
										categories</label> <select name="categorie" class="form-control"
										id="exampleFormControlSelect1">
										<option value="Voitures">Voitures</option>
										<option value="Telephones">Telephones</option>
										<option value="l'electromenager">l'electromenager</option>
										<option value="Bricolage">Bricolage</option>
									</select>
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label for="exampleFormControlSelect1">Tout le Maroc</label> <select
										class="form-control" name="city"
										id="exampleFormControlSelect1">

										<option value="Caza">Caza</option>
										<option value="Fes">Fes</option>
										<option value="Rabat">Rabat</option>
										<option value="Mohamedia">Mohamedia</option>


									</select>
								</div>
							</div>

							<div class="col-md-3">
								<button style="margin-top: 30px" type="submit" class="btn btn-primary">
									Chercher</button>
							</div>
								</form>
						</div>

					</div>


				</div>




<!-- Start loop -->
 <%  
       for(int i=0;i<list.size();i++){
    	   ResSearch pr = (ResSearch)list.get(i); %>
<div style="margin-top: 10px">
<div class="container">
<div class="row">

<div class="col-md-4">
<img alt="" height="200px" width="200px" src="<%=pr.getImage() %>">

</div>

<div class="col-md-4">
    <p class="card-text"><%=pr.getDescription() %></p>

</div>

<div class="col-md-4">
Nom: <%=pr.getName() %><br>
prenom : <%=pr.getLastName() %><br>
Ville : <%=pr.getCity() %><br>
Tele : <%=pr.getTel()%><br>
Prix:<%=pr.getPrice()%> <br>
</div>


	
</div>
</div>
</div>

<% } %>
<!--  end loop -->

</div>
</body>
