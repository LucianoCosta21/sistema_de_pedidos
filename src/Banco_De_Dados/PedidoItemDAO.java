package Banco_De_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import entities.PedidoItem;
import requesitos.CadastrarPedido;

public class PedidoItemDAO {

	public static String AlterarDadosDoProduto(int quantidade, int vlunitario, int vldesconto, int codigoProd,int codigoCond) {	
	String query = "update fiscal.pedido_item set quantidade = " + quantidade + ",vlr_uni = " + vlunitario + ", vlr_desc = "+ vldesconto + ", id_produto = " + codigoProd + " where id_pedido_item = " + codigoCond;	
	
	return Conexao.executarAll(query);	
	
	}
	
public static int insertPedidoItem(PedidoItem item) {
		
		Connection connection = Conexao.conectar();
		Statement statement = null;
		ResultSet generatedKeys = null;
		int generatedKey = -1;
		
		String sql= "insert into fiscal.pedido_item(quantidade, vlr_uni,vlr_desc,id_pedido, id_produto ) values(?,?,?,?,?);";					
		

		try {			
			statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			 	preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);				
		        preparedStatement.setInt(1,item.getQtproduto());
		        preparedStatement.setDouble(2, item.getProduto().getVlvenda());
		        preparedStatement.setDouble(3, item.getVldesconto());		        
				item.getPedido();
				preparedStatement.setInt(4, CadastrarPedido.chaveGerada);
				preparedStatement.setInt(5, item.getProduto().getIdproduto());
				
				
		        
			
			int teste = preparedStatement.executeUpdate();	
			System.out.println(teste);
			generatedKeys = preparedStatement.getGeneratedKeys();			
			//System.out.println(sql);	
			if (generatedKeys.next()) {  
	            generatedKey = generatedKeys.getInt(1);
	          //  System.out.println("Chave gerada: " + generatedKey);
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
				//se.printStackTrace();
			}
		}
		
		return generatedKey;
	}


}
	
	
