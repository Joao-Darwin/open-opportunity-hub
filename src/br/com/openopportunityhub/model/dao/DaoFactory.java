package br.com.openopportunityhub.model.dao;

import br.com.openopportunityhub.db.ConnectionFactory;

public class DaoFactory {
	public static UserDao createUserDao() {
		return new UserDao(ConnectionFactory.getConnection());
	}
	
	public static VacancyDao createVacancyDao() {
		return new VacancyDao(ConnectionFactory.getConnection());
	}
}
