package com.occasion.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.occasion.models.Category;
import com.occasion.models.City;

public class CategoriesDba extends DAOContext {

	
	static public ArrayList<Category> getCategories() {
		
		ArrayList<Category> list=new ArrayList<>();
		try ( Connection connection = DriverManager.getConnection( urldb, userdb, "" ) ){

	        String strSql = "SELECT * FROM categories";
	        try ( Statement statement  = connection.createStatement() ) {
	            try ( ResultSet resultSet = statement.executeQuery( strSql ) ) {
	            	while(resultSet.next()) {
	            		Category category= new Category(resultSet.getInt(1), resultSet.getString(2));
	                    list.add(category);	
	            	}
	            	return list; 
	                
	            }
	        }
	        
	    } catch ( Exception exception ) {
	        
	        throw new RuntimeException( exception );
	        
	    }
	}
		
}
