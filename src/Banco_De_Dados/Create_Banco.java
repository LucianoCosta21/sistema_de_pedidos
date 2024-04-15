package Banco_De_Dados;

import entities.Menu;

public class Create_Banco {
	public static void execucaoInsert() {
	    String query = "SELECT COUNT(*) AS id_produto FROM fiscal.produtos";
	    String retorno = Conexao.executarAll(query);
	    
	    if(retorno != null) { 
	        if (retorno.equals("Informação executada com sucesso!")) {
	            CreateInsert();
	            Menu.mostrarMenu();
	            
	        } else {
	            Menu.mostrarMenu();
	           
	        }
	    } else {
	        System.out.println("Erro ao executar consulta SQL.");
	    }
	}

	
	public static void createBancoDeDados() {

		String query = """
		
		CREATE SCHEMA fiscal;

		create table IF NOT EXISTS fiscal.cliente(
		    id_cliente serial primary key,
		    nome varchar (100)not null,
		    cpf varchar (15)not null,
		    dt_nascimento date not null,
		    endereco varchar (150) not null,
		    telefone varchar (16) not null
		);
		
		create table IF NOT EXISTS fiscal.produtos(
		    id_produto serial primary key,
		    descricao varchar(100) not null,
		    vlr_custo int not null,
		    vlr_venda int not null,
		    categoria varchar (100) not null
		);
		
		create table IF NOT EXISTS fiscal.pedido(
		    id_pedido serial primary key,
		    data_emissao date default now(),
		    data_entrega date default current_date + (floor(random() * 30) || ' days')::interval,
		    vlr_total int,
		    observa text,
		    id_cliente int references fiscal.cliente(id_cliente) not null
		
		);
		
		create table IF NOT EXISTS fiscal.pedido_item(
		    id_pedido_item serial primary key,
		    quantidade int not null,
		    vlr_uni int not null,
		    vlr_desc int  not null,
		    id_pedido int references fiscal.pedido(id_pedido) not null,
		    id_produto int references fiscal.produtos(id_produto) not null
		); 
			""";

		String retorno = Conexao.executarAll(query);
		//System.out.println(retorno);
		//System.out.println("Tabela");
	}

	public static void CreateInsert() {
		
		String query = """
				
				INSERT INTO fiscal.cliente (nome, cpf, dt_nascimento, endereco, telefone) 
				VALUES
				('Ana Souza', '664.987.321-00', '1992-02-18', 'Rua D, 321', '(11) 87654-3210'),
				('Pedro Lima', '779.123.456-00', '1980-12-30', 'Avenida E, 987', '(11) 23456-7890'),
				('Mariana Costa', '134.567.890-00', '1987-08-25', 'Rua F, 654', '(11) 67890-1234'),
				('Paulo Pereira', '801.234.567-00', '1995-04-05', 'Avenida G, 567', '(11) 89012-3456'),
				('Fernanda Santos', '245.678.901-00', '1976-11-12', 'Rua H, 890', '(11) 67890-2345'),
				('Gabriel Oliveira', '367.890.123-00', '1983-09-08', 'Avenida I, 1234', '(11) 78901-2345'),
				('Luciana Rodrigues', '578.901.234-00', '1991-03-28', 'Rua J, 5678', '(11) 89012-3456'),
				('Rafaela Lima', '689.012.345-00', '1979-06-15', 'Avenida K, 9876', '(11) 90123-4567'),
				('Marcos Fernandes', '022.345.678-00', '1988-01-22', 'Rua L, 12345', '(11) 01234-5678'),
				('Isabela Almeida', '133.456.789-00', '1994-07-10', 'Avenida M, 23456', '(11) 12345-6789'),
				('Matheus Silva', '244.567.890-00', '1982-05-20', 'Rua N, 34567', '(11) 23456-7890'),
				('Juliana Oliveira', '545.678.901-00', '1986-08-14', 'Avenida O, 45678', '(11) 34567-8901'),
				('Luiz Santos', '466.789.012-00', '1977-12-03', 'Rua P, 56789', '(11) 45678-9012'),
				('Camila Souza', '577.890.123-00', '1993-11-09', 'Avenida Q, 67890', '(11) 56789-0123'),
				('Daniel Lima', '668.901.234-00', '1981-01-31', 'Rua R, 78901', '(11) 67890-1234'),
				('Carolina Costa', '589.012.345-00', '1989-06-26', 'Avenida S, 89012', '(11) 78901-2345'),
				('Vinícius Pereira', '990.123.456-00', '1996-02-17', 'Rua T, 90123', '(11) 89012-3456');

		
				INSERT INTO fiscal.produtos (descricao, vlr_custo, vlr_venda, categoria) VALUES
						('Blusa de Moletom', 35, 70, 'Vestuário'),
						('Jaqueta de Couro', 120, 250, 'Vestuário'),
						('Saia Midi', 40, 80, 'Vestuário'),
						('Sapato Social', 90, 180, 'Calçados'),
						('Sandália Rasteira', 25, 50, 'Calçados'),
						('Botinha Cano Curto', 70, 140, 'Calçados'),
						('Relógio de Pulso', 60, 120, 'Acessórios'),
						('Bolsa de Couro', 80, 160, 'Acessórios'),
						('Óculos de Sol', 45, 90, 'Acessórios'),
						('Bermuda Jeans', 30, 60, 'Vestuário'),
						('Vestido Longo', 55, 110, 'Vestuário'),
						('Sapatênis', 75, 150, 'Calçados'),
						('Chinelo de Dedo', 20, 40, 'Calçados'),
						('Colar de Prata', 40, 80, 'Acessórios'),
						('Boné Esportivo', 25, 50, 'Acessórios'),
						('Cinto de Couro', 30, 60, 'Acessórios'),
						('Calça Legging', 40, 80, 'Vestuário');

				""";
		
	String retorno = Conexao.executarAll(query);
		//System.out.println(retorno);
		//System.out.println("INsert");
	}
}
