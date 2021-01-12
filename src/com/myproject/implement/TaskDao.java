package com.myproject.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.connection.JDBCConnection;
import com.myproject.dao.Dao;
import com.myproject.entity.Task;
import com.myproject.entity.TaskAndUser;



public class TaskDao implements Dao {

	@Override
	public List<Object> getAll() {
		List<Object> listTask = new ArrayList<Object>();
		String query = "select * from task t inner join user u where t.user_id = u.id";
		Connection connection = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				TaskAndUser task = new TaskAndUser();
				task.setId(resultSet.getInt("id"));
				task.setShort_description(resultSet.getString("short_description"));
				task.setStart_date(resultSet.getDate("start_date"));
				task.setEnd_date(resultSet.getDate("end_date"));
				task.setDescription(resultSet.getString("description"));
				task.setUser_id(resultSet.getInt("user_id"));
				task.setStatus(resultSet.getInt("status"));
				task.setNameUser(resultSet.getString("name"));
				listTask.add(task);
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
		return listTask;
	}

	@Override
	public Object getById(int id) {
		Task task = new Task();
		String query = "select * from task where id = ?";
		Connection connection = JDBCConnection.getConnection();
		try{
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			task.setId(resultSet.getInt("id"));
			task.setShort_description(resultSet.getString("short_description"));
			task.setStart_date(resultSet.getDate("start_date"));
			task.setEnd_date(resultSet.getDate("end_date"));
			task.setDescription(resultSet.getString("description"));
			task.setUser_id(resultSet.getInt("user_id"));
			task.setStatus(resultSet.getInt("status"));
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
		return task;
	}

	@Override
	public int add(Object ob) {
		String query = "insert into task (short_description, description, start_date, end_date, user_id, status) values (?,?,?,?,?,?)";
		Connection connection = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ((Task) ob).getShort_description());
			statement.setString(2, ((Task) ob).getDescription());
			statement.setDate(3, ((Task) ob).getStart_date());
			statement.setDate(4, ((Task) ob).getEnd_date());
			statement.setInt(5, ((Task) ob).getUser_id());
			statement.setInt(6, ((Task) ob).getStatus());
			
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
		String query = "delete from task where id=?";
		Connection connection = JDBCConnection.getConnection();
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
		String query = "update task set short_description=?, description=?, start_date=?, end_date=? where id=? ";
		Connection connection = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ((Task) ob).getShort_description());
			statement.setString(2, ((Task) ob).getDescription());
			statement.setDate(3, ((Task) ob).getStart_date());
			statement.setDate(4, ((Task) ob).getEnd_date());
			statement.setInt(5, ((Task) ob).getId());
			
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
