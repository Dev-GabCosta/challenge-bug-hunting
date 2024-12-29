package controller;

import service.ValidationService;
import view.View;

import java.util.Scanner;

public class Controller {
	private View VIEW;
	private static final Scanner INPUT = new Scanner(System.in);

	public static void controlActions() {
		boolean condition = false;

		do {

			View.displayMenu();
			int option = INPUT.nextInt();

			switch (option) {
				case 1:
					View.listVideos();
					break;
				case 2:
					View.addVideo();
					break;
				case 3:
					View.searchVideoByTitle();
					break;
				case  4:
					View.delete();
					break;
				case  5:
					View.editVideo();
					break;
				case 6:
					condition = true;
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}

			if (!condition) {
				String message = "Digite 1 para continuar no programa ou 0 para sair";
				System.out.println(message);
				option = INPUT.nextInt();

				if (ValidationService.checkOption(option, message)) {
					condition = option == 0;
				}

			}

		} while (!condition);

		System.out.println("Saindo...");
	}

}
