package com.occasion.controllers;

import java.io.IOException;
import java.sql.SQLException;

import com.occasion.dba.DAOContext;
import com.occasion.dba.UserDb;
import com.occasion.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		   	DAOContext.init(this.getServletContext());

	}

    /**
     * Default constructor. 
     */
	
	
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		request.setAttribute("email", "");
		request.setAttribute("password", "");
		request.setAttribute("error", "");
		/*session.setAttribute("login", "");
		session.setAttribute("password", "");*/
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");String password=request.getParameter("password");
		//HttpSession session = request.getSession(true);
		request.setAttribute("email", email);
		request.setAttribute("pass", password);
		User connectedUser=null;;
		try {
			connectedUser = UserDb.isValidLogin(email, password );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(connectedUser!=null) {
            HttpSession session = request.getSession();
            session.setAttribute( "connectedUser", connectedUser );
            User us = (User)session.getAttribute("connectedUser");
            System.out.println(us.getEmail());
            
            session.setAttribute("name", us.getFirstName());
            //session.setAttribute( "catalogBrowser", new CatalogBrowser() );
            
            
    		this.getServletContext().getRequestDispatcher("/").forward(request, response);

            //request.getRequestDispatcher( "/connexion.jsp" ).forward( request, response );

		}
		else {
			request.setAttribute( "error", "Bad identity" );         
            request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
		}
	}

}
