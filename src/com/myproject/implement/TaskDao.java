package com.myproject.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myproject.connection.JDBCConnection;
import com.myproject.dao.Dao;
import com.myproject.entity.Task;
import com.myproject.entity.TaskAndUser;



public class TaskDao implements Dao {

	public List<Task> findShortDesc(String input){
		List<Task> listTask = null;
		try {
			listTask = new ArrayList<Task>();
			String query = "select * from task t inner join user u on t.user_id = u.id where short_description like '%"+input+"%'";
			Connection connection = JDBCConnection.getConnection();
			Statement statement = connection.createStatement();
			try {
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					Task task = new TaskAndUser();
					task.setId(resultSet.getInt("id"));
					task.setShort_description(resultSet.getString("short_description"));
					task.setStart_date(resultSet.getDate("start_date"));
					task.setEnd_date(resultSet.getDate("end_date"));
					task.setDescription(resultSet.getString("description"));
					task.setUser_id(resultSet.getInt("user_id"));
					task.setStatus(resultSet.getInt("status"));
					task.setTask_id(resultSet.getInt("task_id"));
					((TaskAndUser) task).setNameUser(resultSet.getString("name"));
					listTask.add(task);
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
		
		return listTask;
	}
	
	public int count(int input, int userId) {
		int count = 0;
		try {
			String query = "select count(*) from task where status=? and user_id=?";
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			try {
				statement.setInt(1, input);
				statement.setInt(2, userId);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();
			    count = resultSet.getInt(1);
			}catch (SQLException e) {
				throw e;
			}finally {
				if(connection!=null)
					connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public List<Task> getTaskByUser(int userId){
		List<Task> listTaskUser = null;
		try {
			listTaskUser = new ArrayList<Task>();
			String query = "select * from task t inner join user u on t.user_id = u.id where t.user_id=?";
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			try{
				statement.setInt(1, userId);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Task task = new Task();
					task.setId(resultSet.getInt("id"));
					task.setShort_description(resultSet.getString("short_description"));
					task.setStart_date(resultSet.getDate("start_date"));
					task.setEnd_date(resultSet.getDate("end_date"));
					task.setDescription(resultSet.getString("description"));
					task.setUser_id(resultSet.getInt("user_id"));
					task.setStatus(resultSet.getInt("status"));
					task.setTask_id(resultSet.getInt("task_id"));
					listTaskUser.add(task);
				}	
			}catch (SQLException e) {
				throw e;
			}finally {
				if(connection!=null)
					connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTaskUser;
	}
	
	
	public List<Task> getTaskByTaskID(int id) {
		List<Task> lst = null;
		try {
			lst = new ArrayList<Task>();
			String query = "select * from task t inner join user u on t.user_id = u.id where task_id = ?";
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			try{
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Task task = new TaskAndUser();
					task.setId(resultSet.getInt("id"));
					task.setShort_description(resultSet.getString("short_description"));
					task.setStart_date(resultSet.getDate("start_date"));
					task.setEnd_date(resultSet.getDate("end_date"));
					task.setDescription(resultSet.getString("description"));
					task.setUser_id(resultSet.getInt("user_id"));
					task.setStatus(resultSet.getInt("status"));
					task.setTask_id(resultSet.getInt("task_id"));
					((TaskAndUser) task).setNameUser(resultSet.getString("name"));
					lst.add(task);
				}	
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(connection!=null)
					connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			return lst;
	}	
	public void updateStatus(Task task, int userId) {
		try {
			String query = "update task set status=? where id=? and user_id=? ";
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			try {
				connection.setAutoCommit(false);
				statement.setInt(1, task.getStatus());
				statement.setInt(2, task.getId());
				statement.setInt(3, task.getUser_id());
		
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
	public List<Object> getAll() {
		List<Object> listTask = null;
		try {
			listTask = new ArrayList<Object>();
			String query = "select * from task t inner join user u on t.user_id = u.id";
			Connection connection = JDBCConnection.getConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Task task = new TaskAndUser();
					task.setId(resultSet.getInt("id"));
					task.setShort_description(resultSet.getString("short_description"));
					task.setStart_date(resultSet.getDate("start_date"));
					task.setEnd_date(resultSet.getDate("end_date"));
					task.setDescription(resultSet.getString("description"));
					task.setUser_id(resultSet.getInt("user_id"));
					task.setStatus(resultSet.getInt("status"));
					task.setTask_id(resultSet.getInt("task_id"));
					((TaskAndUser) task).setNameUser(resultSet.getString("name"));
					listTask.add(task);
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
		return listTask;
	}

	@Override
	public Object getById(int id){
		Task task = null;
		try {
			String query = "select * from task where id = ?";
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			try{
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()) {
					task = new Task();
					task.setId(resultSet.getInt("id"));
					task.setShort_description(resultSet.getString("short_description"));
					task.setStart_date(resultSet.getDate("start_date"));
					task.setEnd_date(resultSet.getDate("end_date"));
					task.setDescription(resultSet.getString("description"));
					task.setUser_id(resultSet.getInt("user_id"));
					task.setStatus(resultSet.getInt("status"));
					break;
				}
			} catch (SQLException e) {
				throw e;
			} finally {
				if(connection!=null)
					connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return task;
	}

	@Override
	public void add(Object ob) {
		try {
			String query = "insert into task (short_description, description, start_date, end_date, task_id, user_id) values (?,?,?,?,?,?)";
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			try {
				connection.setAutoCommit(false);
				statement.setString(1, ((Task) ob).getShort_description());
				statement.setString(2, ((Task) ob).getDescription());
				statement.setDate(3, ((Task) ob).getStart_date());
				statement.setDate(4, ((Task) ob).getEnd_date());
				statement.setInt(5, ((Task) ob).getTask_id());
				statement.setInt(6, ((Task) ob).getUser_id());
				
				statement.execute();
				connection.commit();
				return;
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
	public void delete(int id) {
		try {
			String query = "delete from task where id=?";
			Connection connection = JDBCConnection.getConnection();
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
	public void update(Object ob) {
		try {
			String query = "update task set short_description=?, description=?, start_date=?, end_date=?, user_id=? where id=? ";
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			try {
				connection.setAutoCommit(false);
				statement.setString(1, ((Task) ob).getShort_description());
				statement.setString(2, ((Task) ob).getDescription());
				statement.setDate(3, ((Task) ob).getStart_date());
				statement.setDate(4, ((Task) ob).getEnd_date());
				statement.setInt(5, ((Task) ob).getUser_id());
				statement.setInt(6, ((Task) ob).getId());
				
				statement.executeUpdate();
				connection.commit();
				return;
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
