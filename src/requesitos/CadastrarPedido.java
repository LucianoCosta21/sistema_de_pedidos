package requesitos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Banco_De_Dados.ClienteDAO;
import Banco_De_Dados.Conexao;
import Banco_De_Dados.PedidoDAO;
import Banco_De_Dados.PedidoItemDAO;
import entities.Cliente;
import entities.Menu;
import entities.Pedido;
import entities.PedidoItem;

public class CadastrarPedido {

	public static int chaveGerada;

	public static void cadastrarPedido() {
		ArrayList<PedidoItem> itens = null;

		Scanner input = new Scanner(System.in);
		Cliente cliente = null;
		Pedido pedido = null;
		boolean seguir = false;
		
		do {
			cliente = retornoCliente();
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
				itens = CadastrarPedidoItem.CadastrarItem();
				pedido = new Pedido(obs, cliente, itens);
				seguir = false;
			}
		} while (seguir);
		
		
		
		/*
		Cliente novoCliente = alterarCliente();	
		pedido.setCliente(novoCliente);
		//----------------------Alterar cliente--------------------------------//
		System.out.println("Informe o código do novo cliente: ");		
		int codigoCliente = input.nextInt();
		
		// Verificar se o novo cliente existe
		Cliente novoCliente = ClienteDAO.SelectClienteCodigo(codigoCliente);
		if (novoCliente != null) {
		    // Atribuir o novo cliente ao pedido
		    pedido.setCliente(novoCliente);
		    System.out.println("Cliente do pedido alterado com sucesso!");
		} else {
		    System.out.println("O cliente com o código informado não existe.");
		}
		
		
	
		//----------------------Alterar Produto--------------------------------//
		System.out.println("Informe o código do produto que deseja alterar");
		int codigo = input.nextInt();
		
		int indiceProduto = -1; // Inicializa como -1 para identificar se a pessoa não foi encontrada
		for (int i = 0; i < itens.size(); i++) {
		    if (itens.get(i).getProduto().getIdproduto() == codigo) {	    	
		    	indiceProduto = i; // Armazena o índice da pessoa encontrada
		        break; // Sai do loop assim que a pessoa é encontrada
		    }
		} 
				
		// Se o produto foi encontrado, modifica o código
		if (indiceProduto != -1) {
		    System.out.println("Informe o novo código do produto");
		    int novoCodigo = input.nextInt();
		    itens.get(indiceProduto).getProduto().setIdproduto(novoCodigo);
		} else {
		    System.out.println("Produto não encontrado na lista.");
		}
		
	*/
		
		
		

		boolean produtosCadastrados = true;
		for (PedidoItem item : itens) {
			if (item.getProduto().getIdproduto() == 0) {
				produtosCadastrados = false;
				break;
			}
		}

		if (pedido.getCliente().getCodigo() == 0) {
			System.out.println("Pedido não possui cliente cadastrado");
		} else if (!produtosCadastrados) {
			System.out.println("Pedido não possui produto cadastrado");
		} else {
							
			chaveGerada = PedidoDAO.insertPedidoTabela(pedido);			
			for (PedidoItem item : itens) {
				PedidoItemDAO.insertPedidoItem(item);
				System.out.println("\n" + item.toString());
			}
			System.out.println("\nPedido cadastrado com sucesso!");
		}

		
		Menu.mostrarMenu();
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

			int opcao;
			System.out.println("\nInforme o código do cliente que deseja localizar: ");
			int codigo = input.nextInt();
			cliente = ClienteDAO.SelectClienteCodigo(codigo);

			if (cliente != null) {
				System.out.println(ClienteDAO.SelectClienteCodigo(codigo));
				System.out
						.println("\nDeseja Adicionar esse cliente?\n(1) SIM \n(2) NÃO\n(3) RETORNAR AO MENU PRINCIPAL");
				opcao = input.nextInt();

				if (opcao == 1) {
					return cliente;
				} else if (opcao == 2) {
					continua = true;
				} else if (opcao == 3) {
					Menu.mostrarMenu();
				}
			} else {
				System.out.println("Cliente não encontrado!");
				Menu.mostrarMenu();
				continua = false;
			}

		} while (continua);

		return cliente;

	}

	public static Cliente ClienteNome() {
		Cliente cliente = null;
		boolean continua = false;
		Scanner input = new Scanner(System.in);

		do {

			int opcao;
			System.out.println("\nInforme o nome do cliente que deseja localizar: ");
			String nome = input.next();
			cliente = ClienteDAO.SelectClienteNome(nome);

			if (cliente != null) {
				System.out.println(ClienteDAO.SelectClienteNome(nome));
				System.out
						.println("\nDeseja Adicionar esse cliente?\n(1) SIM \n(2) NÃO\n(3) RETORNAR AO MENU PRINCIPAL");
				opcao = input.nextInt();

				if (opcao == 1) {
					return cliente;
				} else if (opcao == 2) {
					continua = true;
				} else if (opcao == 3) {
					Menu.mostrarMenu();
				}
			} else {
				System.out.println("Cliente não encontrado!");
				Menu.mostrarMenu();
				continua = false;
			}

		} while (continua);
		return cliente;
	}

	public static Cliente ClienteCpf() {
		Cliente cliente = null;
		boolean continua = false;
		Scanner input = new Scanner(System.in);
		do {

			int opcao;
			System.out.println("\nInforme o CPF do cliente que deseja localizar: ");
			String cpf = input.next();
			cliente = ClienteDAO.SelectClienteCpf(cpf);

			if (cliente != null) {
				System.out.println(ClienteDAO.SelectClienteCpf(cpf));
				System.out
						.println("\nDeseja Adicionar esse cliente?\n(1) SIM \n(2) NÃO\n(3) RETORNAR AO MENU PRINCIPAL");
				opcao = input.nextInt();

				if (opcao == 1) {
					return cliente;
				} else if (opcao == 2) {
					continua = true;
				} else if (opcao == 3) {
					Menu.mostrarMenu();
				}
			} else {
				System.out.println("Cliente não encontrado!");
				Menu.mostrarMenu();
				continua = false;
			}

		} while (continua);

		return cliente;
	}

	/*
	public static Cliente alterarCliente() {
		
		Cliente novoCliente = null;		
		Scanner input = new Scanner(System.in);		
		System.out.println("Informe o código do novo cliente: ");		
		int codigoCliente = input.nextInt();

		novoCliente = ClienteDAO.SelectClienteCodigo(codigoCliente);
		if (novoCliente != null) {	  
		    System.out.println("Cliente do pedido alterado com sucesso!");
		} else {
		    System.out.println("O cliente com o código informado não existe.");
		}
		
		return novoCliente;
	}
	
	public static P alterarProduto() {
		
	}
	*/
}
