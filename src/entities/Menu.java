package entities;

import java.io.Reader;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco_De_Dados.ClienteDAO;
import Banco_De_Dados.Conexao;
import entities.Util;
import requesitos.CadastrarPedido;
import entities.ConnectionFactory;

public class Menu {

	static Scanner input = new Scanner(System.in);

	public static void mostrarMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean continua = false;

		do {
			System.out.println("""

					 ========= MENU =========

					1 - Cadastrar produtos
					2 - Listagem de clientes
					3 - Imprimir Pedido/Cliente
					4 - Imprimir Pedido/Cliente/Produtos

					5 - Sair

							""");
			try {

				int opcao = input.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("======= CADASTRO DE PEDIDO =======");
					CadastrarPedido.cadastrarPedido();
					break;
				case 2:
					System.out.println("======= LISTA DE CLIENTES =======");

					ClienteDAO.selectTodosClientes();
					System.out.println(ClienteDAO.selectTodosClientes().toString());

					System.out.println("Digite qualquer letra seguido de ENTER para retornar...");

					input.next();
					mostrarMenu();

					break;
				case 3:
					System.out.println("======= IMPRIMIR PEDIDO / CLIENTE =======");

					try {

						Connection connection = Conexao.conectar();
						connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema_pedido",
								"postgres", "123456");

						Statement stm = connection.createStatement();
						ResultSet rs = stm.executeQuery(

								"SELECT fc.nome, fc.telefone,  fc.cpf ,fp.id_pedido, fp.id_cliente, fp.vlr_total, fp.observa  "

										+ " FROM fiscal.pedido fp "

										+ "JOIN fiscal.cliente fc ON fp.id_cliente = fc.id_cliente ");

						while (rs.next()) {

							int id = rs.getInt("id_pedido");
							int idCliente = rs.getInt("id_cliente");
							double valorTotal = rs.getInt("vlr_total");
							String observacao = rs.getString("observa");
							String nomeCliente = rs.getString("nome");
							String cpf = rs.getString("cpf");
							String tel = rs.getString("telefone");

							System.out.println("================= PEDIDO ====================\nNome: \t\t" + nomeCliente
									+ "\nCPF: \t\t" + cpf + "\nTelefone: \t" + tel + "\nCód. Pedido: \t" + id
									+ "\nCód Cliente: \t" + idCliente + "\nValor pedido:  " + valorTotal
									+ "\nObservação: \t" + observacao + "\n\n");
						}

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
					}

					System.out.println("Insira um caracter e pressione ENTER para retornar...");
					input.next();
					Menu.mostrarMenu();

					break;
				case 4:
					System.out.println("======= IMPRIMIR PEDIDO / CLIENTE / PRODUTO =======");

					try {

						Connection connection = Conexao.conectar();
						connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema_pedido",
								"postgres", "123456");

						Statement stm = connection.createStatement();
						ResultSet rs = stm.executeQuery(

								"SELECT fc.nome, fc.telefone, fc.cpf, fp.id_pedido, fp.id_cliente, fp.vlr_total, fp.observa,"

										+ "pd_item.quantidade, pd_item.vlr_uni, pd_item.vlr_desc, prod.categoria, prod.descricao "

										+ "FROM fiscal.pedido fp JOIN fiscal.cliente fc ON fp.id_cliente = fc.id_cliente "

										+ "RIGHT JOIN fiscal.pedido_item pd_item ON fp.id_pedido = pd_item.id_pedido "

										+ "FULL JOIN fiscal.produtos prod ON prod.id_produto = pd_item.id_produto"

						);

						while (rs.next()) {
							int id = rs.getInt("id_pedido");
							int idCliente = rs.getInt("id_cliente");
							double valorTotal = rs.getInt("vlr_total");
							String observacao = rs.getString("observa");
							String nomeCliente = rs.getString("nome");
							String cpf = rs.getString("cpf");
							String tel = rs.getString("telefone");
							String nomeProd = rs.getString("descricao");
							String categoria = rs.getString("categoria");
							int valorDesc = rs.getInt("vlr_desc");
							int qtProd = rs.getInt("quantidade");

							System.out.println("================= PEDIDO ====================\nNome: \t\t" + nomeCliente
									+ "\nCPF: \t\t" + cpf + "\nTelefone: \t" + tel + "\nCód Cliente: \t" + idCliente
									+ "\n\nCód. Pedido: \t" + id + "\nProdutos: \t" + nomeProd + "\nQuantidade: \t"
									+ qtProd + "\nCategoria: \t" + categoria + "\nDesconto: \tR$" + valorDesc
									+ "\nValor pedido:  " + valorTotal + "\n\nObservação: \t" + observacao + "\n\n");

						}

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
					}

					System.out.println("Insira um caracter e pressione ENTER para retornar...");
					input.next();
					Menu.mostrarMenu();

					break;

				default:
					System.out.println("");

					if (opcao < 1 || opcao > 5) {
						System.out.println("Opção inválida, tente novamente...");
						continua = true;
					} else if (opcao == 5) {
						System.out.println("Obrigado por utilizar!");
						continua = false;
						System.exit(5);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nEntrada inválida, digite apenas números!");
				mostrarMenu();
			}
		} while (continua);
	}

}
