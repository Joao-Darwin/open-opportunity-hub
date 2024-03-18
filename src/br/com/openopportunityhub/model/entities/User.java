package br.com.openopportunityhub.model.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private int age;
	
	private List<Vacancy> vacancies = new ArrayList<>();
	
	public User() {
	}
	
	public User(int id, String name, String email, String phone, String gender, int age) {
		this.id = id;
		this.name = name;
		this.email = name;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Vacancy> getVacancies() {
		return vacancies;
	}
	
}
