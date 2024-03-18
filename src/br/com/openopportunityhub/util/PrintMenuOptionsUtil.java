package br.com.openopportunityhub.util;

import java.util.Scanner;

public class PrintMenuOptionsUtil {

	public static void printMenuOptions() {
		System.out.println("\nMenus:");
		System.out.println("1) Users");
		System.out.println("2) Vacancies");
		System.out.println("3) Exit");
		System.out.print("\nOpção: ");
	}

	public static void printMenuUserOptions(Scanner scanner) {
		int choice;

		do {
			System.out.println("\nSub-Menu: Users");
			showOptionsFromSubMenu();
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				UserMenuOptionsUtil.createMenuOptions(scanner);
				scanner.nextLine();
				break;
			case 2:
				UserMenuOptionsUtil.findMenuOptions(scanner);
				scanner.nextLine();
				break;
			case 3:
				UserMenuOptionsUtil.updateMenuOptions(scanner);
				scanner.nextLine();
				break;
			case 4:
				UserMenuOptionsUtil.deleteMenuOptions(scanner);
				scanner.nextLine();
				break;
			case 5:
				break;
			default:
				System.out.print("Opção invalida! Aperte enter para tentar novamente...");
				scanner.nextLine();
			}
		} while (choice != 5);
	}

	private static void showOptionsFromSubMenu() {
		System.out.println("1) Create");
		System.out.println("2) Find");
		System.out.println("3) Update");
		System.out.println("4) Delete");
		System.out.println("5) Exit");
		System.out.print("\nOpção: ");
	}

	public static void printMenuVacanciesOptions(Scanner scanner) {
		int choice;

		do {
			System.out.println("\nSub-Menu: Vacancies");
			showOptionsFromSubMenu();
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Vacancy criado!");
				scanner.nextLine();
				break;
			case 2:
				System.out.println("Vacancy encontrado!");
				scanner.nextLine();
				break;
			case 3:
				System.out.println("Vacancy atualizado!");
				scanner.nextLine();
				break;
			case 4:
				System.out.println("Vacancy deletado!");
				scanner.nextLine();
				break;
			case 5:
				break;
			default:
				System.out.print("Opção invalida! Aperte enter para tentar novamente...");
				scanner.nextLine();
			}
		} while (choice != 5);
	}
}
