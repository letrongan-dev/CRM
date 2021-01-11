package com.myproject.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myproject.connection.JDBCConnection;
import com.myproject.dao.Dao;
import com.myproject.entity.User;

public class UserDao implements Dao{

	@Override
	public List<Object> getAll() {
		List<Object> listUsers = new ArrayList<Object>();
		String query = "select * from user";
		try (Connection connection = JDBCConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setName(resultSet.getString("name"));
				user.setRole(resultSet.getString("role"));
				listUsers.add(user);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUsers;
	}

	@Override
	public Object getById(int id) {
		User user = new User();
		String query = "select * from user where id = ?";
		try (Connection connection = JDBCConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			user.setId(resultSet.getInt("id"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setName(resultSet.getString("name"));
			user.setRole(resultSet.getString("role"));
			break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int add(Object ob) {
		String query = "insert into user (email, password, name, role ) values (?,?,?,?)";
		
		try (Connection connection = JDBCConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ((User) ob).getEmail());
			statement.setString(2, ((User) ob).getPassword());
			statement.setString(3, ((User) ob).getName());
			statement.setString(4, ((User) ob).getRole());
			
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		String query = "delete from user where id=?";
		try (Connection connection = JDBCConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Object ob) {
		String query = "update user set email=?, password=?, name=?, role=? where id=? ";
		
		try (Connection connection = JDBCConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ((User) ob).getEmail());
			statement.setString(2, ((User) ob).getPassword());
			statement.setString(3, ((User) ob).getName());
			statement.setString(4, ((User) ob).getRole());
			statement.setInt(5, ((User) ob).getId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
