package Banco_De_Dados;

import java.util.Scanner;

public class Excluir {

	public static void exluirDados() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Insira o id para excluir o cliente");
		int x = input.nextInt();
		
		String query = "delete from fiscal.cliente where id_cliente = " + x;		
		String retorno = Conexao.executarAll(query);
	}

}
