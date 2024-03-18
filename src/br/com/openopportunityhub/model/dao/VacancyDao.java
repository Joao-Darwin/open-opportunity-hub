package br.com.openopportunityhub.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.openopportunityhub.db.exceptions.DbException;
import br.com.openopportunityhub.model.dao.exceptions.VacancyNotFoundException;
import br.com.openopportunityhub.model.entities.Vacancy;

public class VacancyDao {
	private Connection connection;

	public VacancyDao(Connection connection) {
		this.connection = connection;
	}

	public void create(Vacancy vacancy) {
		String sql = "INSERT INTO \"Vacancy\" (company, role, description, salary) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, vacancy.getCompany());
			statement.setString(2, vacancy.getRole());
			statement.setString(3, vacancy.getDescription());
			statement.setDouble(4, vacancy.getSalary());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Erro ao criar vacancy: " + e.getMessage());
		}
	}

	public Vacancy findById(int id) {
		String sql = "SELECT * FROM \"Vacancy\" WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return instantiateVacancy(resultSet);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Error finding vacancy: " + e.getMessage());
		}

		throw new VacancyNotFoundException("Vacancy not found. ID: " + id);
	}

	public List<Vacancy> findAll() {
		List<Vacancy> vacancies = new ArrayList<>();
		String sql = "SELECT * FROM \"Vacancy\" ORDER BY id";
		try (PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				vacancies.add(instantiateVacancy(resultSet));
			}
		} catch (SQLException e) {
			throw new DbException("Error finding all vacancies: " + e.getMessage());
		}
		return vacancies;
	}

	public void update(int id, Vacancy vacancy) {
		String sql = "UPDATE \"Vacancy\" SET company = ?, role = ?, description = ?, salary = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, vacancy.getCompany());
			statement.setString(2, vacancy.getRole());
			statement.setString(3, vacancy.getDescription());
			statement.setDouble(4, vacancy.getSalary());
			statement.setInt(5, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Error updating vacancy: " + e.getMessage());
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM \"Vacancy\" WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("Error deleting vacancy: " + e.getMessage());
		}
	}

	private Vacancy instantiateVacancy(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String company = resultSet.getString("company");
		String role = resultSet.getString("role");
		String description = resultSet.getString("description");
		double salary = resultSet.getDouble("salary");
		return new Vacancy(id, company, role, description, salary);
	}
}
