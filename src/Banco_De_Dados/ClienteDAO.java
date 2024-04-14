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

public class ClienteDAO {
	
	public static List<Cliente> selectTodosClientes() {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM fiscal.cliente";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
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
		
			
	public static Cliente SelectClienteCodigo(int codigo) {
		String query = "select * from fiscal.cliente where id_cliente = " + codigo;
		return executarCliente(query);		
	}
	
	public static Cliente SelectClienteNome(String nome) {
		String query = "select * from fiscal.cliente where nome like '%" + nome + "%'";
		return executarCliente(query);		
	}
	
	public static Cliente SelectClienteCpf(String cpf) {
		String query = "select * from fiscal.cliente where cpf like '%" + cpf+ "%'";
		return executarCliente(query);		
	}
	
	
	public static Cliente executarCliente(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Cliente cliente = new Cliente(
						rs.getInt("id_cliente"), 
						rs.getString("nome"), 
						rs.getString("cpf"),
						rs.getDate("dt_nascimento"), 
						rs.getString("endereco"), 
						rs.getString("telefone"));
				return cliente;
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
		
	

