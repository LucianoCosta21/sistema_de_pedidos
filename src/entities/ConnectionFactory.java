package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String url = "jdbc:postgresql://localhost:5432/sistema_pedido";
	String usuario = "postgres";
	String senha = "123456";

	Connection connection;

	public Connection getConnection() {
		System.out.println("Conectando ao banco");
		try {
			connection = DriverManager.getConnection(url,usuario, senha);
			if(connection != null) {
			   System.out.println("Conectado!");
			}else {
				   System.out.println("Não foi possílvel");
			}
		}catch(SQLException err) {
			   System.out.println("Driver não encontrado");
			   return null;
		}
		return connection;
	}
}