package br.com.openopportunityhub.util;

import java.util.List;
import java.util.Scanner;

import br.com.openopportunityhub.db.exceptions.DbException;
import br.com.openopportunityhub.model.dao.DaoFactory;
import br.com.openopportunityhub.model.dao.VacancyDao;
import br.com.openopportunityhub.model.dao.exceptions.VacancyNotFoundException;
import br.com.openopportunityhub.model.entities.Vacancy;

public class VacancyMenuOptionsUtil {
	private static VacancyDao vacancyDao = DaoFactory.createVacancyDao();

	public static void createMenuOptions(Scanner scanner) {
		System.out.println("\nPor favor, insira os detalhes da nova vaga:");
		scanner.nextLine();

		System.out.print("Nome da empresa: ");
		String company = scanner.nextLine();

		System.out.print("Cargo: ");
		String role = scanner.nextLine();

		System.out.print("Descrição: ");
		String description = scanner.nextLine();

		System.out.print("Salário (Ex: '1412,00'): ");
		double salary = scanner.nextDouble();
		scanner.nextLine();

		Vacancy vacancy = new Vacancy(0, company, role, description, salary);

		try {
			vacancyDao.create(vacancy);
			System.out.println("Vaga criada com sucesso!");
		} catch (DbException e) {
			System.out.println("Erro ao criar vaga: " + e.getMessage());
		}
	}

	public static void findMenuOptions(Scanner scanner) {
		System.out.println("\nEscolha uma opção:");
		System.out.println("1) Encontrar vaga por ID");
		System.out.println("2) Listar todas as vagas");
		System.out.print("\nOpção: ");

		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
		case 1:
			findVacancyById(scanner);
			break;
		case 2:
			findAllVacancies(scanner);
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}

	public static void findVacancyById(Scanner scanner) {
		System.out.print("\nDigite o ID da vaga que deseja encontrar: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			Vacancy vacancy = vacancyDao.findById(id);
			System.out.println("Vaga encontrada:");
			System.out.println(vacancy);
		} catch (VacancyNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void findAllVacancies(Scanner scanner) {
		try {
			List<Vacancy> vacancies = vacancyDao.findAll();
			System.out.println("Listando todas as vagas:");
			for (Vacancy vacancy : vacancies) {
				System.out.println(vacancy);
			}
		} catch (DbException e) {
			System.out.println("Erro ao listar vagas: " + e.getMessage());
		}
	}

	public static void updateMenuOptions(Scanner scanner) {
		System.out.print("\nID da vaga que deseja atualizar: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nova empresa: ");
		String company = scanner.nextLine();

		System.out.print("Novo cargo: ");
		String role = scanner.nextLine();

		System.out.print("Nova descrição: ");
		String description = scanner.nextLine();

		System.out.print("Novo salário: ");
		double salary = scanner.nextDouble();
		scanner.nextLine();

		Vacancy updatedVacancy = new Vacancy(0, company, role, description, salary);

		try {
			vacancyDao.update(id, updatedVacancy);
			System.out.println("Vaga atualizada com sucesso!");
		} catch (DbException e) {
			System.out.println("Erro ao atualizar vaga: " + e.getMessage());
		}
	}

	public static void deleteMenuOptions(Scanner scanner) {
		System.out.print("\nDigite o ID da vaga que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        try {
            vacancyDao.delete(id);
            System.out.println("Vaga excluída com sucesso!");
        } catch (DbException e) {
            System.out.println("Erro ao excluir vaga: " + e.getMessage());
        }	
	}
}
