package com.occasion.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.occasion.models.User;

public class UserDb extends DAOContext {
	public static User isValidLogin(String email, String password) throws SQLException {
		System.out.println(email + " " + password);
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "SELECT * FROM users WHERE email=? AND password=?";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				System.out.println("connexion");
				statement.setString(1, email);
				statement.setString(2, password);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						return new User(resultSet.getInt("id"), resultSet.getString("firstName"),
								resultSet.getString("lastName"), resultSet.getString("email"),
								resultSet.getString("password"), resultSet.getInt("city"),
								resultSet.getString("address"), resultSet.getString("tel"));
					} else {
						return null;
					}
				}
			}
		}
	}
	
	static public void inserUser(User u) {
		
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "insert into users (firstName,lastName,email,password,city,address,tel)"
					+ "values (?,?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				System.out.println("connexion insert");
				statement.setString(1, u.getFirstName());
				statement.setString(2, u.getLastName());
				statement.setString(3,u.getEmail());
				statement.setString(4,u.getPassword());
				statement.setInt(5,u.getCity());
				statement.setString(6,u.getAdress());
				statement.setString(7,u.getTel());
				statement.executeUpdate();
			}
					
				}
		 catch ( Exception exception ) {
	            
	            throw new RuntimeException( exception );
	            
	        }
			
	
	}
	
	static public void deleteUser(int id) {
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "DELETE from users where id=?";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {

				statement.setInt(1, id);
				statement.executeUpdate();
			}
		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}
	}
		
	static public void updateUser( User u) {
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "update users set firstName=?,lastName=?,city=?,address=?,tel=?";

			try (PreparedStatement statement = connection.prepareStatement(strSql)) {

				statement.setString(1, u.getFirstName());
				statement.setString(2, u.getLastName());
				statement.setFloat(3, u.getCity());
				statement.setString(4, u.getAdress());
				statement.setString(5, u.getTel());
				statement.executeUpdate();
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}
	}

	static public ArrayList<User> getAllUsers(){
	     ArrayList<User>	list = new ArrayList<>();
	     

			try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {

				String strSql = "SELECT * FROM users";
				try (Statement statement = connection.createStatement()) {
					try (ResultSet resultSet = statement.executeQuery(strSql)) {
						while (resultSet.next()) {
							User u = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
									resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6),
									resultSet.getString(7),resultSet.getString(8));
							list.add(u);
						}
						return list;

					}
				}

			} catch (Exception exception) {

				throw new RuntimeException(exception);

			}

	     
	    
	}




}
