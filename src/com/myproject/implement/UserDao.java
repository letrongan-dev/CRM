package com.myproject.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.connection.JDBCConnection;
import com.myproject.dao.Dao;
import com.myproject.entity.User;

public class UserDao implements Dao{

	
	public User findByEmail(String email) {
		Connection connection = JDBCConnection.getConnection();
		User user = new User();
		String query = "select * from user where email = ?";
		try{
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
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
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}
	
	
	@Override
	public List<Object> getAll() {
		Connection connection = JDBCConnection.getConnection();
		List<Object> listUsers = new ArrayList<Object>();
		String query = "select * from user";
		try {
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
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listUsers;
	}

	@Override
	public Object getById(int id) {
		Connection connection = JDBCConnection.getConnection();
		User user = new User();
		String query = "select * from user where id = ?";
		try{
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
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public int add(Object ob) {
		Connection connection = JDBCConnection.getConnection();
		String query = "insert into user (email, password, name, role ) values (?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ((User) ob).getEmail());
			statement.setString(2, ((User) ob).getPassword());
			statement.setString(3, ((User) ob).getName());
			statement.setString(4, ((User) ob).getRole());
			
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		Connection connection = JDBCConnection.getConnection();
		String query = "delete from user where id=?";
		try{
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int update(Object ob) {
		Connection connection = JDBCConnection.getConnection();
		String query = "update user set email=?, password=?, name=?, role=? where id=? ";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ((User) ob).getEmail());
			statement.setString(2, ((User) ob).getPassword());
			statement.setString(3, ((User) ob).getName());
			statement.setString(4, ((User) ob).getRole());
			statement.setInt(5, ((User) ob).getId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

}
