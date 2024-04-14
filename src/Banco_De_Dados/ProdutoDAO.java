package Banco_De_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class ProdutoDAO {
	
	public static List<Produto> selectTodosProdutos(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		List<Produto> produtos = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto(
						rs.getInt("id_produto"), 
						rs.getString("descricao"),
						rs.getDouble("vlr_custo"), 
						rs.getDouble("vlr_venda"), 
						rs.getString("categoria"));

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

	
	//na inclusão, permitir localizar o produto por código, 
	//mostrar o produto e confirmar ou não.
	
	public static Produto SelectProdutoCodigo(int codigo) {
		String query = "select * from fiscal.produtos where id_produto =" + codigo;
		return executarProduto(query);		
	}
	
	
	public static Produto executarProduto(String query) {
		Produto produto = new Produto();
		Connection connection = Conexao.conectar();
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				produto = new Produto (
						rs.getInt("id_produto"), 
						rs.getString("descricao"),
						rs.getDouble("vlr_custo"), 
						rs.getDouble("vlr_venda"), 
						rs.getString("categoria"));
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
		return produto;
	}
}
