package br.com.openopportunityhub.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Vacancy {
	private int id;
	private String company;
	private String role;
	private String description;
	private double salary;
	
	private List<User> candidates = new ArrayList<>();
	
	public Vacancy() {
	}
	
	public Vacancy(int id, String company, String role, String description, double salary) {
		this.id = id;
		this.company = company;
		this.role = role;
		this.description = description;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public List<User> getCandidates() {
		return candidates;
	}
	
}
