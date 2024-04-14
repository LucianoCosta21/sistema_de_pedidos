package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	// SimpleDateFormat sdf = new
	// SimpleDateFormat("dd/MM/yyyy");
	private int id_pedido;
	private LocalDate dtemissao = LocalDate.now();
	private Date dtentrega;
	private double valortotal;
	private String observacao;
	private int codigoCliente;


	private Cliente cliente;
	private ArrayList<PedidoItem> itens;

	public Pedido(String observacao, int codigoCliente, double valortotal, Cliente cliente) {
		super();
		this.valortotal = valortotal;
		this.observacao = observacao;
		this.codigoCliente = codigoCliente;
		this.cliente = cliente;

	}
	
	
	
	public Pedido(int id_pedido, LocalDate dtemissao, Date dtentrega, double valortotal, String observacao,
			int codigoCliente, Cliente cliente, ArrayList<PedidoItem> itens) {
		super();
		this.id_pedido = id_pedido;
		this.dtemissao = dtemissao;
		this.dtentrega = dtentrega;
		this.valortotal = valortotal;
		this.observacao = observacao;
		this.codigoCliente = codigoCliente;
		this.cliente = cliente;
		this.itens = itens;
	}



	public Pedido(String obs, Cliente cliente) {
		this.observacao = obs;
		this.cliente = cliente;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	

	public void imprimirItens() {
		for (PedidoItem p : itens) {
			System.out.println(p.toString());
		}
	}

	private String pegarStringItens() {
		String resultado = " ";
		for (PedidoItem p : itens) {
			resultado += p.toString() + " ";
		}
		return resultado;
	}

	private String pegarStringItens2() {
		String resultado = "";

		for (int i = 0; i < itens.size(); i++) {
			resultado += itens.get(i).toString();
		}
		return resultado;
	}

	public Pedido() {

	}
	/*
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + "]";
	}
*/
	
	
	
	public int getId_pedido() {
		return id_pedido;
	}

	@Override
	public String toString() {
		return "============================\nPedido: \t" + id_pedido + "\nData emissão: \t" + dtemissao +
				"\nData entrega: \t" + dtentrega+ "\nValor total: \t" + valortotal + "\nObservação: \t" + observacao + 
				"\nCód. Cliente: \t" + cliente.getCodigo() + "\nCliente: \t" + cliente.getNome() + "\nItens: \t\t" + itens;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}


	public Date getDtentrega() {
		return dtentrega;
	}

	public void setDtentrega(Date dtentrega) {
		this.dtentrega = dtentrega;
	}

	public double getValortotal() {
		calcularValorTotal();
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(ArrayList<PedidoItem> itens) {
		this.itens = itens;
	}
	
	public LocalDate getDtemissao() {
		return dtemissao;
	}



	public void setDtemissao(LocalDate dtemissao) {
		this.dtemissao = dtemissao;
	}
	

	//-------------------------------------------------------------------------
	
	public void calcularValorTotal() {
		valortotal = 0.0;
	    if (itens != null) { // Verifica se a lista de itens não é nula
	        for (PedidoItem item : itens) {
	            valortotal += item.valorTotal();
	        }
	    }
	}
}
