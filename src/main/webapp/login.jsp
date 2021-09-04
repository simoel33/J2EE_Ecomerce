<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="navbar.jsp" %>

<div class="container">
<div class="row">
    <div class="col-md-5  mx-auto">
        <form action="<%= request.getContextPath() %>/login" method="post" >
<div>
<img alt="" style="margin-left: 35%" height="100px" width="100PX" src="https://www.loasisdelexcellence.com/wp-content/uploads/2015/11/avatar-default-icon.png">
</div>
            <div class="form-group">
                <label for="email">Email</label>
                <input  type="email" name="email" class="form-control" id="ema">
            </div>

            <div class="form-group ">
                <label for="password ">Password</label>
                <input  type="password" name="password" class="form-control " id="pas ">
            </div>
            <div>
              
            </div>
            <button type="submit" class="btn btn-block btn-primary "><i class="fa fa-sign-in" aria-hidden="true"></i>
            Se connecter </button>
            <p>Pas encore inscrit? <a href="#">S'inscrire gratuitement.</a></p>
        </form>

    </div>
</div>
</div>

</body>
</html>