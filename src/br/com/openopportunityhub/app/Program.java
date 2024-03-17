package br.com.openopportunityhub.app;

import java.util.Scanner;

import br.com.openopportunityhub.util.PrintMenuOptionsUtil;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		System.out.println("<---------- Open Opportunity Hub ---------->");
		do {
			PrintMenuOptionsUtil.printMenuOptions();
			
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				PrintMenuOptionsUtil.printMenuUserOptions(scanner);
				break;
			case 2:
				PrintMenuOptionsUtil.printMenuVacanciesOptions(scanner);
				break;
			case 3:
				System.out.println("See you later... :)");
				break;
			default:
				System.out.print("Opcao invalida! Aperte enter para tentar novamente...");
				scanner.nextLine();
				scanner.nextLine();
			}
		} while (choice != 3);	
		
		scanner.close();
	}

}
