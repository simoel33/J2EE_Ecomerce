package com.occasion.controllers;

import java.io.IOException;

import com.occasion.dba.DAOContext;
import com.occasion.dba.Productdba;
import com.occasion.dba.VilleDba;
import com.occasion.models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdatePro
 */
@WebServlet("/updatePro")
public class UpdatePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		DAOContext.init(this.getServletContext());

	}

    /**
     * Default constructor. 
     */
    public UpdatePro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		request.getRequestDispatcher("/updatepro.jsp").forward(request, response);
	
		//	Product p = new Product(2,"VOl","D:espour",200000.74f,"pour vous tous de mois",1,1);
		//Productdba.updateProduct(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name"); 
		//String image = request.getParameter("image");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("desciption");
		//int owner=Integer.parseInt(request.getParameter("owner"));
		//int category=Integer.parseInt(request.getParameter("category"));
		Product p= new Product();
		p.setName(name);
		//p.setImage(image);
		p.setPrice(price);
		p.setDescription(description);
		p.setId(id);
		p.setCategory(3);
		
		Productdba.updateProduct(p);
		this.getServletContext().getRequestDispatcher("/productBrow").forward(request, response);
		
		
	}

}
