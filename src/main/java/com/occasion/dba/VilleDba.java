package com.occasion.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.occasion.models.City;

public class VilleDba extends DAOContext{

	
	
static public ArrayList<City> getCities() {
	
	ArrayList<City> list=new ArrayList<>();
	try ( Connection connection = DriverManager.getConnection( urldb, userdb, "" ) ){

        String strSql = "SELECT * FROM city";
        try ( Statement statement  = connection.createStatement() ) {
            try ( ResultSet resultSet = statement.executeQuery( strSql ) ) {
            	while(resultSet.next()) {
            		City city= new City(resultSet.getInt( 1 ), resultSet.getString(2));
                    list.add(city);	
            	}
            	return list; 
                
            }
        }
        
    } catch ( Exception exception ) {
        
        throw new RuntimeException( exception );
        
    }
}
	
}
