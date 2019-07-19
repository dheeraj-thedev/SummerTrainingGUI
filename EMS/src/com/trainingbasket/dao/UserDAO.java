package com.trainingbasket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.trainingbasket.beans.User;
import com.trainingbasket.utils.ConnectionUtils;

public class UserDAO {
	Connection connection = null;

	public UserDAO() throws ClassNotFoundException, SQLException {
		connection = ConnectionUtils.getConnection();
	}

	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("Select * FROM sem1pro.users");
		while (resultSet.next()) {
			User user = new User();
			user.setPassword(resultSet.getString("password"));
			user.setPrivilage("privilege");
			user.setUssername("username");
			users.add(user);
		}
		return users;
	}

	public boolean getUserLogin(User user) throws SQLException {
		boolean existStatus = false;
		if (user != null) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("Select *  FROM sem1pro.users where username=? and password=?");
			preparedStatement.setString(1, user.getUssername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				existStatus = true;
			}
		}
		return existStatus;
	}

	public boolean saveUser(User user) throws SQLException {
		boolean existStatus = false;
		if (user != null) {

			String sql = "INSERT INTO sem1pro.users(username,password,privilege) VALUES(?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUssername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getPrivilage());

			int row = preparedStatement.executeUpdate();
			System.out.println("No of affected rows are  : " + row);
			if (row != 0) {
				existStatus = true;
			}
		}
		return existStatus;

	}

	public boolean updateUser(User user) throws SQLException {
		boolean status = false;
		String sql = "UPDATE sem1pro.users SET username = ?, password = ?, privilege = ? WHERE username = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, user.getUssername());
		stmt.setString(2, user.getPassword());
		stmt.setString(3, user.getPrivilage());
		stmt.setString(4, user.getUssername());
		int row = stmt.executeUpdate();
		if (row != 0) {
			status = true;
		}
		return status;
	}

	public boolean deleteUser(String user) throws SQLException {
		boolean status = false;
		String sql = "Delete from sem1pro.users WHERE username = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, user);
		int row = stmt.executeUpdate();
		if (row != 0) {
			status = true;
		}
		return status;
	}

	public static void main(String[] args) {

	
		try {
			System.out.println("Insert Dtatus" + new UserDAO().deleteUser("forTesting"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * User user = new User(); user.setUssername("Admin");
		 * user.setPassword("admin"); try { System.out.println("Usser Exist :" + new
		 * UserDAO().getUserLogin(user)); } catch (ClassNotFoundException | SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * Test Case to get All Users from DAO List<User> lisst; try { lisst = new
		 * UserDAO().getAllUsers(); lisst.forEach(System.out::println); } catch
		 * (ClassNotFoundException | SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */

	}
}
