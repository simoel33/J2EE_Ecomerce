package com.occasion.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.occasion.dba.CategoriesDba;
import com.occasion.dba.DAOContext;
import com.occasion.dba.Productdba;
import com.occasion.dba.VilleDba;
import com.occasion.models.Category;
import com.occasion.models.Product;
import com.occasion.models.ResSearch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		DAOContext.init(this.getServletContext());

	}
    public Index() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("cities", VilleDba.getCities());
		ArrayList<Category> category = CategoriesDba.getCategories();
		System.out.println(category.get(0).getName());
		request.setAttribute("categories", CategoriesDba.getCategories());
		
		this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  name = request.getParameter("name");
		String categorie = request.getParameter("categorie");
		String city = request.getParameter("city");
		ArrayList<ResSearch> result =  Productdba.filtrer(city,categorie,name );
		request.setAttribute("resultSearch", result);		
		this.getServletContext().getRequestDispatcher("recherche.jsp").forward(request, response);
	}

}
