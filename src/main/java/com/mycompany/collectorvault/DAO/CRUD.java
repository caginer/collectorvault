package com.mycompany.collectorvault.DAO;

import java.util.List;



public interface CRUD <T> {
	
	public List<T> findAll();
	
	public T findById(int theId);
	
	public void save (T t);
	
	public void deleteById (int theId);

}
