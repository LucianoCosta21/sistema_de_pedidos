package requesitos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Banco_De_Dados.ClienteDAO;
import Banco_De_Dados.Conexao;
import Banco_De_Dados.PedidoDAO;
import Banco_De_Dados.ProdutoDAO;
import entities.Cliente;
import entities.Menu;
import entities.Pedido;
import entities.PedidoItem;
import entities.Produto;

public class CadastrarPedidoItem {

	public static ArrayList<PedidoItem> CadastrarItem() {
		Scanner input = new Scanner(System.in);

		ArrayList<PedidoItem> itens = new ArrayList<>();
		
		CadastrarPedido chave = new CadastrarPedido();
		
		int opcao;
		boolean continua = false;
		do {
			Produto p = LocalizaProduto();			
		
			System.out.println("\nInforme a quantidade: ");
			int quantidade = input.nextInt();
			System.out.println("\nInforme o valor do desconto: ");
			double vldesconto = input.nextDouble();			

			System.out.println("Deseja Adicionar no banco de dados esse produto? (1) SIM | (2) NÃO");
			opcao = input.nextInt();

			if (opcao == 1) {

				PedidoItem novoItem = new PedidoItem(quantidade, vldesconto, p, chave);
				itens.add(novoItem);

			
			}else if (opcao == 2){
				continua = true;
			}else {
				
			}
			
			System.out.println("Deseja adicionar mais produtos? \n(1)SIM \n(2)NÃO");
			int escolha = input.nextInt();
			if (escolha == 1){
				continua = true;
			}else {
				continua = false;
			}
			
		} while (continua);

		
		for (PedidoItem item : itens) {
		}
	
		return itens;
	}
	
	

	public static Produto LocalizaProduto() {
		Produto produto = null;	

		boolean continua = false;
		do {
		try {
				int opcao;
				Scanner input = new Scanner(System.in);
				System.out.println("\nInforme o código do produto que deseja localizar: ");
				int localizarCodigo = input.nextInt();
				produto = ProdutoDAO.SelectProdutoCodigo(localizarCodigo);
				System.out.println(ProdutoDAO.SelectProdutoCodigo(localizarCodigo));
				

				if (produto != null) {					
					System.out.println("\nDeseja Adicionar esse produto?\n(1) SIM \n(2) NÃO\n(3) RETORNAR AO MENU PRINCIPAL");
					opcao = input.nextInt();
					
					if (opcao == 1) {				
						return produto;
						
					} else if (opcao == 2) {
						continua = true;
					} else if(opcao == 3) {
						Menu.mostrarMenu();
						continua = false;
					}
				}
			
			} catch (InputMismatchException | NullPointerException e) {
				System.out.println("Entrada inválida!");
				continua = true;
			}
		} while (continua);		
		return produto;
	}


}
