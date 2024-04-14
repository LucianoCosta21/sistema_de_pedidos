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
		
		Pedido pedido = new Pedido();
		//double valorTotal = pedido.getValortotal();
		
		int codigo =  retornoIdCliente();		
		Scanner input = new Scanner(System.in);	
			
		System.out.println("Informe um observação: ");
		String obs = input.next();
		
		/*
		String query = "insert into fiscal.pedido(id_cliente, observa) values(" + codigo + ", '" + obs + "')";					
		System.out.println(query);
		 */
		
		//chaveGerada = PedidoDAO.executarID(query);
				
	    pedido.setObservacao(obs);
	    pedido.setCodigoCliente(codigo);
	    
	    System.out.println(pedido.toString());
	    
	   
		
		CadastrarPedidoItem.CadastrarItem();
		System.out.println("chave "+chaveGerada);
	
		
		
		
		//CadastrarPedidoItem.CadastrarItem();
		//System.out.println("chave "+chaveGerada);
		
	}
	
	public static int retornoIdCliente() {
		
		boolean continua = false;	
		
		do {
				
		try {	
		
		Scanner input = new Scanner(System.in);		
		System.out.println("===== Menu de cadastro do pedido ===== \n");	
		System.out.println("Deseja adicionar o cliente por: \n\n1 - Código \n2 - Nome  \n3 - CPF: \n4 - Retornar ao menu principal");
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
			
			if(opcao < 1 || opcao > 4) {
				System.out.println("Opção inválida");
				continua = true;
				}else {
				
				}			
			}		
		}catch(InputMismatchException e) {
			System.out.println("Entrada inválida!");
			continua = true;
		}
	
	} while (continua);
		return chaveGerada;
}

	public static int ClienteCodigo() {
		
		boolean continua = false;
		
		do {
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o código do cliente que deseja localizar: ");
		int codigo = input.nextInt();
		Cliente cliente = ClienteDAO.SelectClienteCodigo(codigo);
		int idcliente = cliente.getCodigo();
		System.out.println(ClienteDAO.SelectClienteCodigo(codigo));
		return idcliente;	
		
	}catch(InputMismatchException | NullPointerException e) {
		System.out.println("Entrada inválida!");
		continua = true;
	}
		}while(continua);
		//Mudar return;
		return chaveGerada;

	}

	public static int ClienteNome() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o nome do cliente que deseja localizar: ");
		String nome = input.next();
		Cliente cliente = ClienteDAO.SelectClienteNome(nome);
		int idcliente = cliente.getCodigo();
		System.out.println(ClienteDAO.SelectClienteNome(nome));
		return idcliente;
	}
	
	public static int ClienteCpf() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o CPF do cliente que deseja localizar: ");
		String cpf = input.next();
		Cliente cliente = ClienteDAO.SelectClienteCpf(cpf);	
		int idcliente = cliente.getCodigo();
		System.out.println(	ClienteDAO.SelectClienteCpf(cpf));
		return idcliente;	
	}
}
