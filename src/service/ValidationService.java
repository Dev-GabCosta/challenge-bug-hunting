package service;

import java.util.Scanner;

public class ValidationService {

	public static boolean checkOption(int option, String message) {
		Scanner input = new Scanner(System.in);

		while (option != 1 && option != 0) {
			System.out.println(message);
			option = input.nextInt();

			if (option == 1 || option == 0) {
				break;
			}

		}

		return true;
	}

	public static void validateNumber(int number) {

		if (number <= 0) {
			throw new IllegalArgumentException("Esse campo requer um número maior que 0");
		}

	}

	public static void validateString(String text) {

		if (!text.isEmpty() && text != null) {

			for (char t : text.toCharArray()) {

				if (Character.isDigit(t)) {
					throw new IllegalArgumentException("Esse campo não pode conter número");
				}

			}

		} else {
			throw new IllegalArgumentException("Esse campo não pode estar vazio nem pode ser nulo");
		}

	}

}
