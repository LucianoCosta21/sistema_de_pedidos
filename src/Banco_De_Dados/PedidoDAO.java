package Banco_De_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import entities.Pedido;
import entities.PedidoItem;


public class PedidoDAO {
	
	/*
	public static String CriarPedido(int idCliente, String observacao) {	
		
		String sql= "insert into fiscal.pedido(id_cliente, observacao) values(" + idCliente + ", '%" + observacao + "%');";					
		System.out.println(query);
	
		return executarAll(query);	
  }
	
	public static int insertPedido(int idCliente, String observacao) {
				
		
		String sql= "insert into fiscal.pedido(data_emissao, data_entrega,vlr_total, observa,id_cliente) values(?,?,?,?,?);";					
		System.out.println(query);
	
		return insertTabela(query);	
  }
	
	*/

	
	public static String executarAll(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		ResultSet generatedKeys = null;
		

		try {			
			statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.execute();
						
			generatedKeys = preparedStatement.getGeneratedKeys();			
			// fazer verificação de generatedKey > 0
			if (generatedKeys.next()) {  
	            int generatedKey = generatedKeys.getInt(1);	            
	        }
			
		} catch (SQLException e) {
			return "Erro ao executar comando: " + e.getMessage();

		} finally {

			try {
				
				 if (generatedKeys != null) {
		             generatedKeys.close();
		            }
				
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

	public static int executarID(String query) {
		Connection connection = Conexao.conectar();
		Statement statement = null;
		ResultSet generatedKeys = null;
		int generatedKey = -1;

		try {			
			statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.execute();
						
			generatedKeys = preparedStatement.getGeneratedKeys();			
			
			if (generatedKeys.next()) {  
	            generatedKey = generatedKeys.getInt(1);
	            System.out.println("Chave gerada: " + generatedKey);
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {

			try {
				
				 if (generatedKeys != null) {
		             generatedKeys.close();
		            }
				
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
		return generatedKey;
	}
	
	public static int insertPedidoTabela(Pedido pedido) {
		
		Connection connection = Conexao.conectar();
		Statement statement = null;
		ResultSet generatedKeys = null;
		int generatedKey = -1;
		
		String sql= "insert into fiscal.pedido(vlr_total, observa, id_cliente) values(?,?,?);";					
		

		try {			
			statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			 	preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);				
		        preparedStatement.setDouble(1, pedido.getValortotal());
		        preparedStatement.setString(2, pedido.getObservacao());
		        preparedStatement.setInt(3, pedido.getCliente().getCodigo());
		        
		        
					System.out.println(pedido.getValortotal());
					System.out.println(pedido.getObservacao());
					System.out.println(pedido.getCodigoCliente());
			
				
		        	
			preparedStatement.executeUpdate();				
			generatedKeys = preparedStatement.getGeneratedKeys();			
			System.out.println(sql);	
			if (generatedKeys.next()) {  
	            generatedKey = generatedKeys.getInt(1);
	            System.out.println("Chave gerada: " + generatedKey);
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {

			try {
				
				 if (generatedKeys != null) {
		             generatedKeys.close();
		            }
				
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
		
		return generatedKey;
	}
	
}
