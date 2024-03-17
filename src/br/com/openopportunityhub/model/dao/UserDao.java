package br.com.openopportunityhub.model.dao;

import java.sql.Connection;
import java.util.List;

import br.com.openopportunityhub.model.entities.User;

public class UserDao {

	private Connection connection;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public void create(User user) {
		
	}
	
	public User findById(int id) {
		
	}
	
	public List<User> findAll() {
		
	}
	
	public void update(int id, User user) {
		
	}
	
	public void delete(int id) {
		
	}
	
}
