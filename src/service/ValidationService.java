package service;

import model.VideoCategory;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

	public static void validateCategory(String category) {
		String categories = Arrays.stream(
						VideoCategory.values()
				)
				                    .map(Enum::name)
				                    .collect(
						                    Collectors.joining(", ")
				                    ).toLowerCase();
		boolean validCategory = false;
		String userCategory = category;

		do {

			for (VideoCategory videoCategory : VideoCategory.values()) {
				System.out.println("Usuário: " + userCategory + ", sistema: " + videoCategory.name());
				if (userCategory.equalsIgnoreCase(videoCategory.name())) {
					validCategory = true;
					break;
				}

			}

			if (!validCategory) {
				System.out.println("Categoria inválida. as opções são " + categories + ".");
				System.out.println("Por favor, escolha uma opção válida");
				userCategory = new Scanner(System.in).nextLine();
			}

		} while (!validCategory);

	}

	public static String validDate(String date) {
String  formattedDate = "";
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("ddMMuuuu")
				                                   .withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date1 = LocalDate.parse(date, inputFormatter);

			if (!date1.isAfter(LocalDate.now())) {
				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				formattedDate = date1.format(outputFormatter);
			}

			return formattedDate;
		} catch (DateTimeException exception) {
			System.out.println("Essa data não é válida. " + exception.getCause());
		}

		return "";
	}

}
