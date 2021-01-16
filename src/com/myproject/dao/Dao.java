package com.myproject.dao;

import java.util.List;

public interface Dao {
	public List<Object> getAll();
	public Object getById(int id);
	public void add(Object ob);
	public void delete(int id);
	public void update(Object ob);
}
