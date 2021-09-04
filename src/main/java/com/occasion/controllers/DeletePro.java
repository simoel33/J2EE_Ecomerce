package com.occasion.controllers;

import java.io.IOException;

import com.occasion.dba.DAOContext;
import com.occasion.dba.Productdba;
import com.occasion.models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletePro
 */
@WebServlet(name = "deletePro", urlPatterns = { "/deletePro" })
public class DeletePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		DAOContext.init(this.getServletContext());

	}
    /**
     * Default constructor. 
     */
    public DeletePro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n= Integer.parseInt(request.getParameter("id"));
			
		System.out.println(n);
		Product p =Productdba.findById(n);
		//System.out.println(p.getDescription()+"  "+ p.getName());
		Productdba.deleteProduct(n);
		response.sendRedirect("productBrow");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
