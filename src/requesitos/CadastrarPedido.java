package requesitos;

import java.util.InputMismatchException;
import java.util.Scanner;

import Banco_De_Dados.ClienteDAO;
import Banco_De_Dados.Conexao;
import Banco_De_Dados.PedidoDAO;
import entities.Cliente;
import entities.Menu;
import entities.Pedido;

public class CadastrarPedido {

	public static int chaveGerada;

	public static void cadastrarPedido() {

		// double valorTotal = pedido.getValortotal();
		
		Scanner input = new Scanner(System.in);

		boolean seguir = false;
		
		do {
			Cliente cliente = retornoCliente();					
			System.out.println("""

					Cliente selecionado! Deseja continuar?

					(1) MUDAR PARA OUTRO CLIENTE
					(2) CONTINUAR PARA PEDIDO

					""");
			int opcao = input.nextInt();
			if (opcao == 1) {			
				seguir = true;
			} else {
				System.out.println("\nInforme um observação: ");
				String obs = input.next();
				Pedido pedido = new Pedido(obs, cliente);
				System.out.println(pedido.toString());
				seguir = false;				
			}
		} while (seguir);

		
		/*
		 * String query = "insert into fiscal.pedido(id_cliente, observa) values(" +
		 * codigo + ", '" + obs + "')"; System.out.println(query);
		 */

		// chaveGerada = PedidoDAO.executarID(query);

		//pedido.setObservacao(obs);
		// pedido.setCodigoCliente(codigo);

		//System.out.println(pedido.toString());

		CadastrarPedidoItem.CadastrarItem();
		System.out.println("chave " + chaveGerada);

		// CadastrarPedidoItem.CadastrarItem();
		// System.out.println("chave "+chaveGerada);

	}

	public static Cliente retornoCliente() {		
		boolean continua = false;

		do {

			try {

				Scanner input = new Scanner(System.in);
				System.out.println("===== Menu de cadastro do pedido ===== \n");
				System.out.println(
						"Deseja adicionar o cliente por: \n\n1 - Código \n2 - Nome  \n3 - CPF: \n4 - Retornar ao menu principal");
				int opcao = input.nextInt();

				switch (opcao) {
				case 1:
					return ClienteCodigo();
				case 2:
					return ClienteNome();
				case 3:
					return ClienteCpf();
				case 4:
					Menu.mostrarMenu();
				default:
					System.out.println("");

					if (opcao < 1 || opcao > 4) {
						System.out.println("Opção inválida");
						continua = true;
					} else {

					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!");
				continua = true;
			}

		} while (continua);
		return null;
	}

	public static Cliente ClienteCodigo() {
		Cliente cliente = null;
		boolean continua = false;
		Scanner input = new Scanner(System.in);

		do {
			try {
				int opcao;
				System.out.println("\nInforme o código do cliente que deseja localizar: ");
				int codigo = input.nextInt();
				cliente = ClienteDAO.SelectClienteCodigo(codigo);
				System.out.println(ClienteDAO.SelectClienteCodigo(codigo));

				if (cliente != null) {
					System.out.println(
							"\nDeseja Adicionar esse cliente?\n(1) SIM \n(2) NÃO\n(3) RETORNAR AO MENU PRINCIPAL");
					opcao = input.nextInt();

					if (opcao == 1) {
						return cliente;
					} else if (opcao == 2) {
						continua = true;
					}
				} else {
					Menu.mostrarMenu();
					continua = false;
				}

			} catch (InputMismatchException | NullPointerException e) {
				System.out.println("Cliente não encontrado! Deseja continuar pesquisando? \n(1)SIM \n(2)NÃO ");
				continua = false;
			}
			int opcao = input.nextInt();
			if (opcao == 1) {
				CadastrarPedido.ClienteCodigo();
			} else {
				Menu.mostrarMenu();
			}

		} while (continua);
		// Mudar return;
		return cliente;

	}

	public static Cliente ClienteNome() {
		Cliente cliente = null;
		boolean continua = false;
		Scanner input = new Scanner(System.in);

		do {
			try {
				int opcao;
				System.out.println("\nInforme o nome do cliente que deseja localizar: ");
				String nome = input.next();
				cliente = ClienteDAO.SelectClienteNome(nome);
				System.out.println(ClienteDAO.SelectClienteNome(nome));

				if (cliente != null) {
					System.out.println(
							"\nDeseja Adicionar esse cliente?\n(1) SIM \n(2) NÃO\n(3) RETORNAR AO MENU PRINCIPAL");
					opcao = input.nextInt();

					if (opcao == 1) {
						return cliente;
					} else if (opcao == 2) {
						continua = true;
					}
				} else {
					Menu.mostrarMenu();
					continua = false;
				}

			} catch (InputMismatchException | NullPointerException e) {
				System.out.println("Cliente não encontrado! Continuar pesquisando? \n(1)SIM \n(2)NÃO");
			}
			int opcao = input.nextInt();

			if (opcao == 1) {
				CadastrarPedido.ClienteNome();
			} else {
				Menu.mostrarMenu();
			}

		} while (continua);
		return cliente;
	}

	public static Cliente ClienteCpf() {
		Cliente cliente = null;
		boolean continua = false;
		Scanner input = new Scanner(System.in);
		do {
			try {
				int opcao;
				System.out.println("\nInforme o CPF do cliente que deseja localizar: ");
				String cpf = input.next();
				cliente = ClienteDAO.SelectClienteCpf(cpf);
				System.out.println(ClienteDAO.SelectClienteCpf(cpf));

				if (cliente != null) {
					System.out.println(
							"\nDeseja Adicionar esse cliente?\n(1) SIM \n(2) NÃO\n(3) RETORNAR AO MENU PRINCIPAL");
					opcao = input.nextInt();

					if (opcao == 1) {
						return cliente;
					} else if (opcao == 2) {
						continua = true;
					}
				} else {
					Menu.mostrarMenu();
					continua = false;
				}

			} catch (InputMismatchException | NullPointerException e) {
				System.out.println("Cliente não encontrado! Deseja continuar pesquisando? \n(1)SIM \n(2)NÃO");
			}
			int opcao = input.nextInt();
			if (opcao == 1) {
				CadastrarPedido.ClienteCpf();
			} else {
				Menu.mostrarMenu();
			}
		} while (continua);

		return cliente;
	}
}
