package com.occasion.dba;

import jakarta.servlet.ServletContext;

public class DAOContext {

	protected static String urldb;
	protected static String userdb;
	
	public static void init( ServletContext context) {
		
		try {
			Class.forName(context.getInitParameter("driver"));
			urldb=context.getInitParameter("url");
			userdb=context.getInitParameter("user");
			System.out.println("database connection "+context.getInitParameter("driver")+urldb+" "+userdb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
