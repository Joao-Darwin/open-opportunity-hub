package br.com.openopportunityhub.model.dao;

import java.sql.Connection;

public class VacancyDao {
	private Connection connection;

	public VacancyDao(Connection connection) {
		this.connection = connection;
	}
}
