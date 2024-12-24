package service;

public class ValidationService {

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

		}

		throw new IllegalArgumentException("Esse campo não pode estar vazio nem pode ser nulo");
	}

}
