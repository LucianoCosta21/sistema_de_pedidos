package application;

import java.util.ArrayList;
import java.util.Scanner;

import Banco_De_Dados.ClienteDAO;
import Banco_De_Dados.Conexao;
import Banco_De_Dados.Excluir;
import Banco_De_Dados.PedidoDAO;
import Banco_De_Dados.PedidoItemDAO;
import Banco_De_Dados.ProdutoDAO;
import Banco_De_Dados.Select;
import Banco_De_Dados.Update;
import entities.Cliente;
import entities.Menu;
import entities.Pedido;
import entities.PedidoItem;
import entities.Produto;
import requesitos.CadastrarPedido;
import requesitos.CadastrarPedidoItem;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<PedidoItem> itens = new ArrayList<>();
		
		Menu.mostrarMenu();
		//Select.select();
		//Excluir.exluirDados();
		//Update.atualizarDados();
		
		//ClienteDAO.selectTodosClientes();
		//CadastrarPedido.cadastrarPedido();
		//System.out.println(ClienteDAO.SelectClienteCodigo(22));
		//System.out.println(PedidoDAO.SelectIdUltimoPedido());
	    //Pedido pedido = PedidoDAO.SelectIdUltimoPedido();
		//System.out.println(pedido.toString());
		//String query = "select * from fiscal.cliente";
		//System.out.println(PedidoDAO.executarID("insert into fiscal.pedido(id_cliente, observa) values(25, 'QQQQQQQQQ')"));
		//CadastrarPedidoItem.CadastrarItem(); 
		
	
		
		//ClienteDAO dao = new ClienteDAO();		
		
		//for (Cliente p : ClienteDAO.selectTodosClientes()) {
			//System.out.println(p.toString());
		//}
		
		/*
		 
		PedidoItem novoItem = new PedidoItem(5, 20.0, 5.5, 2, 1);
		PedidoItem novoItem2 = new PedidoItem(10, 50.0, 5.5, 2, 1);
		itens.add(novoItem);
		itens.add(novoItem2);
		
		for (PedidoItem item : itens) {
		    System.out.println(item.toString());
		}
		-----------------------------------------------------------------
		System.out.println("Informe a quantidade");		
		int quantidade = sc.nextInt();
		System.out.println("Informe o valor");		
		int valor = sc.nextInt();
		System.out.println("Informe o valor desconto");		
		int valorDesc = sc.nextInt();
		System.out.println("Informe o codigo1");		
		int codigoProd= sc.nextInt();
		System.out.println("Informe o codigo2");		
		int codigoCond = sc.nextInt();
				
		
		PedidoItemDAO.AlterarDadosDoProduto(quantidade, valor, valorDesc, codigoProd, codigoCond);
		
		
		
		*/
		
		//System.out.println("Informe o codigo");
		//int codigo = sc.nextInt();
		//System.out.println(ClienteDAO.SelectClienteCodigo(codigo));
		
	
		//System.out.println("Informe o codigo");
		//int codigo1 = sc.nextInt();
		//System.out.println(ProdutoDAO.SelectProdutoCodigo(codigo1));		
						
		//for (Cliente c : ClienteDAO.selectTodosClientes()) {			
		//	System.out.println(c.toString());
		//}	
	}	
}