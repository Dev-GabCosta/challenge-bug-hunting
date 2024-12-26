package controller;

import view.View;

import java.util.Scanner;

public class Controller {
	private  final  View VIEW;
	private  static  final Scanner INPUT = new Scanner(System.in);

	public  static  void  controlActions(){
		boolean condition = false;

		do {

			View.displayMenu();
			int option = INPUT.nextInt();

			switch (option){
				case 1:
					View.listVideos();
					break;
				case  2:
					View.addVideo();
					break;
				case  3:
					View.searchVideoByTitle();
					break;
				case  4:
					condition = true;
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}

			if (!condition){
				System.out.println("Digite 1 para continuar no programa ou 0 para sair");
				option = INPUT.nextInt();
				condition= 1 == option;
			}

		}while (!condition);

	}

}
