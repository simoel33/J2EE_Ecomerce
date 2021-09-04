package com.occasion.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.occasion.models.Product;
import com.occasion.models.ResSearch;
import com.occasion.models.User;

public class Productdba extends DAOContext {

	static public Product findById(int id) {

		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "SELECT * FROM products WHERE id=?";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {

				statement.setInt(1, id);

				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						return new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
								resultSet.getFloat(4), resultSet.getString(5), resultSet.getInt(6),
								resultSet.getInt(7));
					} else {
						return null;
					}
				}
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}
	}

	static public ArrayList<Product> getAllProducts() {
		ArrayList list = new ArrayList<Product>();

		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {

			String strSql = "SELECT * FROM products";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(strSql)) {
					while (resultSet.next()) {
						Product p = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
								resultSet.getFloat(4), resultSet.getString(5), resultSet.getInt(6),
								resultSet.getInt(7));
						list.add(p);
					}
					return list;

				}
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}

	}

	static public void deleteProduct(int id) {
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "DELETE from products where id=?";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {

				statement.setInt(1, id);
				statement.executeUpdate();
			}
		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}
	}

	static public void createProduct(Product p) {
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "insert into products (name,image,price,description,owner,category)"
					+ "values (?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				System.out.println("connexion insert");
				statement.setString(1, p.getName());
				statement.setString(2, p.getImage());
				statement.setFloat(3, p.getPrice());
				statement.setString(4, p.getDescription());
				statement.setInt(5, p.getOwner());
				statement.setInt(6, p.getCategory());
				statement.executeUpdate();
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}
	}

	static public void updateProduct(Product p) {
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "update products set name=?,price=?,description=?,category=? WHERE id=?";

			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				statement.setInt(5, p.getId());
				statement.setString(1, p.getName());
				statement.setFloat(2, p.getPrice());
				statement.setString(3, p.getDescription());
				statement.setInt(4, p.getCategory());

				statement.executeUpdate();
			}

		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}
	}

	static public ArrayList<Product> getAllProductsByUser(int id) {
		ArrayList<Product> list = new ArrayList<Product>();

		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "SELECT * from products where owner=? ;";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Product p = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
								resultSet.getFloat(4), resultSet.getString(5), resultSet.getInt(6),
								resultSet.getInt(7));
						list.add(p);
					}
					return list;
				}
			}
		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}

	}

	public static ArrayList<ResSearch> filtrer(String city, String category, String product) {
		ArrayList<ResSearch> list = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(urldb, userdb, "")) {
			String strSql = "SELECT products.name,products.image,products.price,products.description,city.name,users.firstName,users.lastName,users.tel FROM (((products INNER JOIN users ON products.owner = users.id) INNER JOIN city ON users.city = city .id)INNER JOIN categories on products.category=categories.id)where city.name=? and( categories.name=? or products.name=?);";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {

				statement.setString(1, city);
				statement.setString(2, category);
				statement.setString(3, product);
				ResultSet res = statement.executeQuery();

				while (res.next()) {
					ResSearch p = new ResSearch(res.getString(1), res.getString(2), res.getFloat(3),
							res.getString(4), res.getString(5), res.getString(6),
							res.getString(7),res.getString(8));
					list.add(p);
				}

			}
		} catch (Exception exception) {

			throw new RuntimeException(exception);

		}

		return list;
	}

}
