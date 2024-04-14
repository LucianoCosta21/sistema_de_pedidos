package Banco_De_Dados;


import entities.Cliente;
import entities.Produto;
public class Select {
	
	public static void select() {
		
		String nome = "Maria da Silva";
		String query = "select * from fiscal.cliente where nome like '%" + nome + "%'";
		String query2 = "select * from fiscal.produtos";
		String query3 = "select descricao, vlr_venda from fiscal.produtos";
			
		
					
		Conexao dao = new Conexao();		
		
		for (Produto p : dao.selectTeste(query3)) {
			System.out.println(p.toString());
		}
	}
	
	
	
	
}
