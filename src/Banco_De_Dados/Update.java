package Banco_De_Dados;

import java.util.Scanner;

public class Update {
	
	public static void atualizarDados() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Insira o id do cliente que deseja alterar");
		int x = input.nextInt();
		
		
		String query = "update fiscal.cliente set nome = 'Maria Ribeiro' where id_cliente = " + x +";";
		String retorno = Conexao.executarAll(query);
	}

}
