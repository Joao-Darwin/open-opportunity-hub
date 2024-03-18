package br.com.openopportunityhub.model.dao.exceptions;

public class VacancyNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public VacancyNotFoundException(String msg) {
		super(msg);
	}

}
