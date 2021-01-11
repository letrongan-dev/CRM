package com.myproject.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myproject.connection.JDBCConnection;
import com.myproject.dao.Dao;
import com.myproject.entity.Task;
import com.myproject.entity.User;

public class TaskDao implements Dao {

	@Override
	public List<Object> getAll() {
		List<Object> listTask = new ArrayList<Object>();
		String query = "select * from task";
		try (Connection connection = JDBCConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
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
				listTask.add(task);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTask;
	}

	@Override
	public Object getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Object ob) {
		String query = "insert into task (short_description, description, start_date, end_date, user_id, status) values (?,?,?,?,?,?)";
		
		try (Connection connection = JDBCConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ((Task) ob).getShort_description());
			statement.setString(2, ((Task) ob).getDescription());
			statement.setDate(3, (Date) ((Task) ob).getStart_date());
			statement.setDate(4, (Date) ((Task) ob).getEnd_date());
			statement.setInt(5, ((Task) ob).getUser_id());
			statement.setInt(6, ((Task) ob).getStatus());
			
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

}
