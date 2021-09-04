package com.occasion.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.occasion.dba.Productdba;
import com.occasion.models.Product;
import com.occasion.models.ResSearch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Search() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//this.getServletContext().getRequestDispatcher("recherche.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  name = request.getParameter("name");
		String categorie = request.getParameter("categorie");
		String city = request.getParameter("city");
		
		System.out.println(name + " " + categorie + " " + city);
		ArrayList<ResSearch> result =  Productdba.filtrer(city,categorie,name);
		System.out.println(result.get(0).getImage());
		request.setAttribute("resultSearch", result);		
		this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(request, response);

		
		
		//doGet(request, response);
	}

}
