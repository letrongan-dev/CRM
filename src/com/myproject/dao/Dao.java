package com.myproject.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
	public List<Object> getAll() throws SQLException;
	public Object getById(int id) throws SQLException;
	public int add(Object ob) throws SQLException;
	public int delete(int id) throws SQLException;
	public int update(Object ob) throws SQLException;
}
