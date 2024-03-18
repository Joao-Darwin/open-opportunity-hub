package br.com.openopportunityhub.util;

import java.util.List;
import java.util.Scanner;

import br.com.openopportunityhub.db.exceptions.DbException;
import br.com.openopportunityhub.model.dao.DaoFactory;
import br.com.openopportunityhub.model.dao.UserDao;
import br.com.openopportunityhub.model.dao.exceptions.UserNotFoundException;
import br.com.openopportunityhub.model.entities.User;

public class UserMenuOptionsUtil {

	private static UserDao userDao = DaoFactory.createUserDao();

	public static void createMenuOptions(Scanner scanner) {
		scanner.nextLine();
		System.out.println("\nPor favor, insira os dados do usuário:");

		System.out.print("Nome: ");
		String name = scanner.nextLine();

		System.out.print("Email: ");
		String email = scanner.nextLine();

		System.out.print("Telefone: ");
		String phone = scanner.nextLine();

		System.out.print("Gênero: ");
		String gender = scanner.nextLine();

		System.out.print("Idade: ");
		int age = Integer.parseInt(scanner.nextLine());

		User newUser = new User(0, name, email, phone, gender, age);

		try {
			userDao.create(newUser);
			System.out.println("Usuário criado com sucesso!");
		} catch (DbException e) {
			System.out.println("Erro ao criar usuário: " + e.getMessage());
		}
	}

	public static void findMenuOptions(Scanner scanner) {
		System.out.println("\nEscolha uma opção:");
		System.out.println("1) Encontrar usuario por ID");
		System.out.println("2) Listar todos os usuarios");
		System.out.print("\nOpção: ");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option) {
		case 1:
			findUserById(scanner);
			break;
		case 2:
			findAllUsers(scanner);
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}

	public static void findUserById(Scanner scanner) {
		System.out.print("\nDigite o ID do usuário: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			User user = userDao.findById(id);
			System.out.println("Usuário encontrado:");
			System.out.println(user);
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void findAllUsers(Scanner scanner) {
		List<User> users = userDao.findAll();
		if (users.isEmpty()) {
			System.out.println("Nenhum usuário encontrado.");
		} else {
			System.out.println("Lista de usuários:");
			for (User user : users) {
				System.out.println(user);
			}
		}
	}

	public static void updateMenuOptions(Scanner scanner) {
		System.out.print("\nID do usuário que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
		System.out.print("Novo nome: ");
		String name = scanner.nextLine();
		System.out.print("Novo email: ");
		String email = scanner.nextLine();
		System.out.print("Novo telefone: ");
		String phone = scanner.nextLine();
		System.out.print("Novo gênero: ");
		String gender = scanner.nextLine();
		System.out.print("Nova idade: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		User user = new User(id, name, email, phone, gender, age);

		try {
			userDao.update(user.getId(), user);
			System.out.println("Usuário atualizado com sucesso!");
		} catch (DbException e) {
			System.out.println("Erro ao atualizar usuário: " + e.getMessage());
		}
	}

	public static void deleteMenuOptions(Scanner scanner) {
		System.out.print("\nID do usuário que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        try {
            userDao.delete(id);
            System.out.println("Usuário excluído com sucesso!");
        } catch (DbException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
	}
}
