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

public abstract class UserDao implements Dao<User, Integer>{

	public User findByEmail(String email) {
		User user = null;
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "select * from user where email = ?";
			try{
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, email);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()) {
					user = new User();
					user.setId(resultSet.getInt("id"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					user.setName(resultSet.getString("name"));
					user.setRole(resultSet.getString("role"));
					break;
				}
				return user;
			} catch (SQLException e) {
				throw e;
			}finally {
				if(connection!=null) 
					connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public User findByName(String name){
		User user = null;
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "select * from user where name like '%"+name+"%'";
			try{
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()) {
					user = new User();
					user.setId(resultSet.getInt("id"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					user.setName(resultSet.getString("name"));
					user.setRole(resultSet.getString("role"));
					break;
				}
				
			} catch (SQLException e)  {
				throw e;
			}finally {
				if(connection!=null)
					connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<User> getAll() {
		List<User> listUsers = new ArrayList<User>();
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "select * from user where is_deleted = 0";
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
			} catch (SQLException e) {
				throw e;
			}finally {
				if(connection!=null)
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUsers;
	}

	@Override
	public User getById(Integer id) {
		User user = null;
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "select * from user where id = ?";
			try{
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setName(resultSet.getString("name"));
				user.setRole(resultSet.getString("role"));
				break;
				}
			} catch (SQLException e) {
				throw e;
			}finally {
				if(connection!=null)
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void add(User user) {
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "insert into user (email, password, name, role ) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			try {
				connection.setAutoCommit(false);
				statement.setString(1, user.getEmail());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getName());
				statement.setString(4, user.getRole());
				
				statement.execute();
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
			}finally {
				connection.close();
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	@Override
	public void delete(Integer id) {
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "update user set is_deleted = 1 where id=?";
			PreparedStatement statement = connection.prepareStatement(query);
			try{
				connection.setAutoCommit(false);
				statement.setInt(1, id);
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
			}finally {
				connection.close();
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return;
	}

	@Override
	public void update(User user) {
		try {
			Connection connection = JDBCConnection.getConnection();
			String query = "update user set email=?, password=?, name=?, role=? where id=? ";
			PreparedStatement statement = connection.prepareStatement(query);
			try {
				connection.setAutoCommit(false);
				
				statement.setString(1, user.getEmail());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getName());
				statement.setString(4, user.getRole());
				statement.setInt(5, user.getId());
				
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
			}finally {
				connection.close();
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

}
