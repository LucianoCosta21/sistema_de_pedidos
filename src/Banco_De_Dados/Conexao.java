package Banco_De_Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import entities.Produto;

public class Conexao {

	public static Connection conectar() {

		String banco = "sistema_pedido";
		String usuario = "postgres";
		String senha = "123456";

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + banco, usuario, senha);

		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco: " + e.getMessage());
		}
		return connection;
	}

	public static String executarAll(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (SQLException e) {
			return "Erro ao executar comando: " + e.getMessage();

		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return "Informação executada com sucesso!";
	}
	
	public static String executarUpdate(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;

		try {
			statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			return "Erro ao executar comando: " + e.getMessage();

		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return "Informação executada com sucesso!";
	}
	
	public static List<Cliente> selectAll(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		List<Cliente> clientes = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("id_cliente"), 
						rs.getString("nome"), 
						rs.getString("cpf"),
						rs.getDate("dt_nascimento"), 
						rs.getString("endereco"), 
						rs.getString("telefone"));
				clientes.add(cliente);
			}
		} catch (SQLException err) {
			System.out.println("Erro !");
			err.printStackTrace();

		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return clientes;
	}

	public static List<Produto> selectProduto(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		List<Produto> produtos = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto(rs.getInt("id_produto"), rs.getString("descricao"),
						rs.getDouble("vlr_custo"), rs.getDouble("vlr_venda"), rs.getString("categoria"));

				produtos.add(produto);
			}
		} catch (SQLException err) {
			System.out.println("Erro !");
			err.printStackTrace();

		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return produtos;
	}

	public List<Produto> selectTeste(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		List<Produto> produtos = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setDescricao(rs.getString("descricao"));
				produto.setVlvenda(rs.getDouble("vlr_venda"));

				produtos.add(produto);
			}
		} catch (SQLException err) {
			System.out.println("Erro !");
			err.printStackTrace();

		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return produtos;
	}



	public static Produto selectUmProduto(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Produto produto = new Produto(rs.getInt("id_produto"), rs.getString("descricao"),
						rs.getDouble("vlr_custo"), rs.getDouble("vlr_venda"), rs.getString("categoria"));
				return produto;
			}
		} catch (SQLException err) {
			System.out.println("Erro !");
			err.printStackTrace();
			return null;

		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return null;
	}
}