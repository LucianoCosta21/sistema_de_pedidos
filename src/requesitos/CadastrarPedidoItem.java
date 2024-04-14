package requesitos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Banco_De_Dados.ClienteDAO;
import Banco_De_Dados.Conexao;
import Banco_De_Dados.PedidoDAO;
import Banco_De_Dados.ProdutoDAO;
import entities.Pedido;
import entities.PedidoItem;
import entities.Produto;

public class CadastrarPedidoItem {

	public static void CadastrarItem() {
		Scanner input = new Scanner(System.in);

		ArrayList<PedidoItem> itens = new ArrayList<>();

		CadastrarPedido chave = new CadastrarPedido();
		int chaveGerada = chave.chaveGerada;

		// PedidoDAO.SelectIdUltimoPedido();
		// ClienteDAO.selectTodosClientes();

		int opcao;

		do {
			int codigo = LocalizaProduto();
			// System.out.println("Cadastro de Produtos");
			System.out.println("\nInforme a quantidade: ");
			int quantidade = input.nextInt();
			System.out.println("\nInforme o valor do desconto: ");
			double vldesconto = input.nextDouble();

			String query1 = "select * from fiscal.produtos where id_produto = " + codigo;
			Produto produto = Conexao.selectUmProduto(query1);
			double vlunitario = produto.getVlvenda();
			System.out.println("Deseja Adicionar esse produto? (1) SIM | (2) NÃO");
			opcao = input.nextInt();

			if (opcao == 1) {

				PedidoItem novoItem = new PedidoItem(quantidade, vlunitario, vldesconto, chaveGerada, codigo);
				itens.add(novoItem);

			}
			System.out.println("Deseja Adicionar esse produto? (1) SIM | (2) NÃO");

		} while (opcao != 2);

		// System.out.println(itens.toString());

		for (PedidoItem item : itens) {
			System.out.println(item.toString());
		}

		// String query = "insert into fiscal.pedido_item(quantidade, vlr_uni, vlr_desc,
		// id_pedido, id_produto) values(" + quantidade + "," + vlunitario + ","+
		// vldesconto + "," + chaveGerada + "," + codigo + ");";
		// System.out.println( query);
		// Conexao.executarAll(query);

		// String queryProduto = "select * from fiscal.produtos where id_produto = "+
		// localizarCodigo ;

		// for (Produto p : Conexao.selectProduto(queryProduto)) {
		// System.out.println(p.toString());
		// }

		/*
		 * System.out.println("Informe o o código do produto: "); int codigo =
		 * input.nextInt(); System.out.println("Informe a quantidade: "); int quantidade
		 * = input.nextInt(); System.out.println("Informe o valor do desconto: ");
		 * double vldesconto = input.nextDouble();
		 * 
		 * 
		 * 
		 * String query1 = "select * from fiscal.produtos where id_produto = " + codigo;
		 * Produto produto = Conexao.selectUmProduto(query1);
		 * 
		 * 
		 * double vlunitario = produto.getVlvenda();
		 * 
		 * 
		 * String query =
		 * "insert into fiscal.pedido_item(quantidade, vlr_uni, vlr_desc, id_produto) values("
		 * 
		 * + quantidade + "," + vlunitario + ","+ vldesconto + "," + codigo +" );";
		 * 
		 * String retorno = Conexao.executarAll(query);
		 */
	}

	public static int LocalizaProduto() {

		int idproduto = 0;

		boolean continua = false;

		do {

			try {
				int opcao;
				Scanner input = new Scanner(System.in);
				System.out.println("\nInforme o código do produto que deseja localizar: ");
				int localizarCodigo = input.nextInt();
				Produto produto = ProdutoDAO.SelectProdutoCodigo(localizarCodigo);
				idproduto = produto.getIdproduto();
				System.out.println(ProdutoDAO.SelectProdutoCodigo(localizarCodigo));
				System.out.println("\nDeseja Adicionar esse produto?\n(1) SIM \n(2) NÃO\n(3) RETORNA");
				opcao = input.nextInt();

				if (opcao == 1) {
					return idproduto;
				} else if (opcao == 2) {
					continua = true;
				} else {

				}

			} catch (InputMismatchException | NullPointerException e) {
				System.out.println("Entrada inválida!");
				continua = true;
			}
		} while (continua);

		return idproduto;
	}

}