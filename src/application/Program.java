package application;

import java.util.ArrayList;
import java.util.Scanner;

import Banco_De_Dados.ClienteDAO;
import Banco_De_Dados.Conexao;
import Banco_De_Dados.Create_Banco;
import Banco_De_Dados.PedidoDAO;
import Banco_De_Dados.PedidoItemDAO;
import Banco_De_Dados.ProdutoDAO;
import Banco_De_Dados.Select;
import entities.Cliente;
import entities.Menu;
import entities.Pedido;
import entities.PedidoItem;
import entities.Produto;
import requesitos.CadastrarPedido;
import requesitos.CadastrarPedidoItem;

public class Program {

	public static void main(String[] args) {
				
		Create_Banco.createBancoDeDados();
        Create_Banco.execucaoInsert();	

	}	
}