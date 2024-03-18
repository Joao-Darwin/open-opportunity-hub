package br.com.openopportunityhub.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.openopportunityhub.db.exceptions.DbException;
import br.com.openopportunityhub.model.dao.exceptions.UserNotFoundException;
import br.com.openopportunityhub.model.entities.User;

public class UserDao {

	private Connection connection;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public void create(User user) {
		String query = "INSERT INTO \"User\" (name, email, phone, gender, age) VALUES (?, ?, ?, ?, ?)";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPhone());
			statement.setString(4, user.getGender());
			statement.setInt(5, user.getAge());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Erro ao criar user: " + e.getMessage());
		}
	}
	
	public User findById(int id) {
		String query = "SELECT * FROM \"User\" WHERE id = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return instantiateUser(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Error finding user: " + e.getMessage());
		}

		throw new UserNotFoundException("User not found. ID: " + id);
	}
	
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM \"User\"";
		
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {	
			while (resultSet.next()) {
				users.add(instantiateUser(resultSet));
			}
		} catch (SQLException e) {
			throw new DbException("Error finding all users: " + e.getMessage());
		}
			
		return users;
	}
	
	public void update(int id, User user) {
		String query = "UPDATE \"User\" SET name = ?, email = ?, phone = ?, gender = ?, age = ? WHERE id = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPhone());
			statement.setString(4, user.getGender());
			statement.setInt(5, user.getAge());
			statement.setInt(6, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Error updating user: " + e.getMessage());
		}
	}
	
	public void delete(int id) {
		String query = "DELETE FROM \"User\" WHERE id = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Error deleting user: " + e.getMessage());
		}
	}
	
	private User instantiateUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		
		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("email"));
		user.setEmail(resultSet.getString("email"));
		user.setPhone(resultSet.getString("phone"));
		user.setGender(resultSet.getString("gender"));
		user.setAge(resultSet.getInt("age"));
		
		return user;
	}
	
}
