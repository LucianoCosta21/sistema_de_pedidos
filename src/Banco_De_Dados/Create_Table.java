package Banco_De_Dados;


public class Create_Table {
	
	public static void createTable() {
		
	String query = "CREATE TABLE fiscal.persons (\r\n"
			+ "    PersonID int,\r\n"
			+ "    LastName varchar(255),\r\n"
			+ "    FirstName varchar(255),\r\n"
			+ "    Address varchar(255),\r\n"
			+ "    City varchar(255)\r\n"
			+ ");";
	
	String retorno = Conexao.executarAll(query);
	System.out.println(retorno);
	
	}
}
