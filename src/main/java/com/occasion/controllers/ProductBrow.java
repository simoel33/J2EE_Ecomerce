package com.occasion.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.occasion.dba.DAOContext;
import com.occasion.dba.Productdba;
import com.occasion.models.Product;
import com.occasion.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductBrow
 */
@WebServlet("/productBrow")
public class ProductBrow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		DAOContext.init(this.getServletContext());

	}
    /**
     * Default constructor. 
     */
    public ProductBrow() {
        // TODO Auto-generated constructor stub
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		ArrayList<Product> list=new ArrayList<>();
		HttpSession  session = request.getSession();
		 User currentUser = (User)session.getAttribute("connectedUser");
		 
		 //System.out.println(currentUser.getIdUser());
		 
		 if (currentUser.getFirstName() == "admin") {
				list=Productdba.getAllProducts();
				

		}else {
			list=Productdba.getAllProductsByUser(currentUser.getIdUser());
		}
		 
		 
		 request.setAttribute("products", list);
		//for(int i=0;i<list.size();i++)
		//System.out.println(list.get(i).getName());
		
		this.getServletContext().getRequestDispatcher("/admin/listproduits.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
