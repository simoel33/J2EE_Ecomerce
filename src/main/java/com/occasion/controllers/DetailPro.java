package com.occasion.controllers;

import java.io.IOException;

import com.mysql.cj.Session;
import com.occasion.dba.DAOContext;
import com.occasion.dba.Productdba;
import com.occasion.models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailPro
 */
@WebServlet(name = "detailPro", urlPatterns = { "/detailPro" })
public class DetailPro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		DAOContext.init(this.getServletContext());

	}
    /**
     * Default constructor. 
     */
    public DetailPro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id = Integer.parseInt( request.getParameter("id"));
		Product p= Productdba.findById(id);
		request.setAttribute("p", p);
		System.out.println(id);
		
		request.setAttribute("product", p);
		request.getRequestDispatcher("/admin/editproduit.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
