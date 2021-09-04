package com.occasion.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Tableau")
public class Tableau extends HttpServlet {


	private static final long serialVersionUID = -156149823183809411L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<table border='1'>");
		for (int i = 1; i <= 10; i++) {
			out.print("<tr>");
			for (int j = 1; j <= 10; j++) {
				out.print("<td> M(" + i+","+j+")</td>");
			}
			out.print("</tr>");
		}
		
		out.print("</table>");
		
	}
}
