package com.myproject.dao;

import java.util.List;

public interface Dao {
	List<Object> getAll();
	Object getById(int id);
	void add(Object ob);
	void delete(int id);
	void update(Object ob);
}
