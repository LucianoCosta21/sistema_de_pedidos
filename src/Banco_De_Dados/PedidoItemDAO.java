package Banco_De_Dados;

import java.util.Scanner;

import entities.PedidoItem;

public class PedidoItemDAO {
	
	/*
	public static String AlterarProdutoPedido(int codigo, int codigo2) {		
		String query = "update fiscal.pedido_item set id_produto = " + codigo2 + " where id_pedido_item = " + codigo +";";
		return Conexao.executarAll(query);		
	}
	*/
	
	public static String AlterarDadosDoProduto(int quantidade, int vlunitario, int vldesconto, int codigoProd,int codigoCond) {	
	String query = "update fiscal.pedido_item set quantidade = " + quantidade + ",vlr_uni = " + vlunitario + ", vlr_desc = "+ vldesconto + ", id_produto = " + codigoProd + " where id_pedido_item = " + codigoCond;	
	System.out.println(query);
	return Conexao.executarAll(query);	
	
	}
}
	
	
