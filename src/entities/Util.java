package entities;

import java.util.Scanner;

public final class Util {
	
	/**
	 * Private constructor to prevent instantiation
	 */
	private Util() {
		throw new AssertionError();
	}
	
	/**
	 * Recebe uma mensagem de input, confere se o input é numérico
	 * @param message
	 * @return
	 */
	public static String pedirInputNumerico(String message, Scanner input) {
		String inputString = "";	
		while(!inputString.matches("-?\\d+")) {
			System.out.println(message);
			inputString = input.next();
			if(!inputString.matches("-?\\d+")) {
				System.out.println("\nInput inválido!\n ");
			}
		}
		return inputString;
	}
	
	public static void limparTela() {
		// no eclipse não tem como limpar o terminal (console)
		// System.out.flush() não parece funcionar, então pra simular o efeito,
		// Um for loop com 100 novas linhas
		for (int i = 0; i < 100; ++i) System.out.println();
	}
}