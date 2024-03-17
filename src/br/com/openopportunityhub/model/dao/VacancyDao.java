package br.com.openopportunityhub.model.dao;

import java.sql.Connection;
import java.util.List;

import br.com.openopportunityhub.model.entities.Vacancy;

public class VacancyDao {
	private Connection connection;

	public VacancyDao(Connection connection) {
		this.connection = connection;
	}

	public void create(Vacancy user) {

	}

	public Vacancy findById(int id) {

	}

	public List<Vacancy> findAll() {

	}

	public void update(int id, Vacancy vacancy) {

	}

	public void delete(int id) {

	}
}
