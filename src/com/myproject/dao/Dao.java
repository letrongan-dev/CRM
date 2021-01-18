package com.myproject.dao;

import java.util.List;

public interface Dao <T, K>{
	List<T> getAll();
	T getById(K id);
	void add(T ob);
	void delete(K id);
	void update(T ob);
}
