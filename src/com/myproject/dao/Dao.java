package com.myproject.dao;

import java.util.List;

public interface Dao {
	public List<Object> getAll();
	public Object getById(int id);
	public int add(Object ob);
	public int delete(int id);
	public int update(Object ob);
}
