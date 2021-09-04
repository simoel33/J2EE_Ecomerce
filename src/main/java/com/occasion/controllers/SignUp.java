package com.occasion.controllers;

import java.io.IOException;

import com.occasion.dba.DAOContext;
import com.occasion.dba.UserDb;
import com.occasion.dba.VilleDba;
import com.occasion.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		DAOContext.init(this.getServletContext());

	}

	/**
	 * Default constructor.
	 */
	public SignUp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		//System.out.println("med ya med" + VilleDba.getCities().get(0).getName());
		HttpSession session = request.getSession(true);
		request.setAttribute("cities", VilleDba.getCities());
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int city = Integer.parseInt(request.getParameter("city"));
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

		User user = new User(firstName, lastName, email, password, city, address, tel);
		UserDb.inserUser(user);
		this.getServletContext().getRequestDispatcher("/admin/index.jsp").forward(request, response);
		

	}

}
