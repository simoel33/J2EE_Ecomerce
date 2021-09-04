package com.occasion.controllers;

import java.io.IOException;

import com.occasion.dba.CategoriesDba;
import com.occasion.dba.DAOContext;
import com.occasion.dba.Productdba;
import com.occasion.dba.VilleDba;
import com.occasion.models.Product;
import com.occasion.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CreatePro
 */
@WebServlet("/createPro")
public class CreatePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		DAOContext.init(this.getServletContext());

	}
    /**
     * Default constructor. 
     */
    public CreatePro() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setAttribute("categories", CategoriesDba.getCategories());
	
		this.getServletContext().getRequestDispatcher("/admin/addproduit.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("connectedUser");
		
		System.out.println(u.getEmail());
		String name = request.getParameter("name"); 
		String image = request.getParameter("image");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("desciption");
		int owner=u.getIdUser();
		int category=Integer.parseInt(request.getParameter("category"));
		//Product p1= new Product("shjshj","jkjkdjd", 566.7f, "sgsghshghgshgs", 2, 1);

		System.out.println(owner);
		Product p= new Product(name, "/hjdfhjfhjfh", 6, description, owner,category);
		
		Productdba.createProduct(p);
		response.sendRedirect("productBrow");
		//this.getServletContext().getRequestDispatcher("productBrow").forward(request, response);
	}

}
