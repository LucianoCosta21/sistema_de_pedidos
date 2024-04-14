package entities;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	// SimpleDateFormat sdf = new
	// SimpleDateFormat("dd/MM/yyyy");
	private int id_pedido;
	private Date dtemissao;
	private Date dtentrega;
	private double valortotal;
	private String observacao;
	private int codigoCliente;

	private Cliente cliente;
	// ArrayList para add os ITENS
	// UM PEDIDO PODE TER VÁRIOS PEDIDO ITEM
	private ArrayList<PedidoItem> itens;

	public Pedido(String observacao, int codigoCliente, double valortotal) {
		super();
		this.valortotal = valortotal;
		this.observacao = observacao;
		this.codigoCliente = codigoCliente;

	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Pedido(int id_pedido) {
		this.id_pedido = id_pedido;
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
		return "Pedido [id_pedido=" + id_pedido + ", dtemissao=" + dtemissao + ", dtentrega=" + dtentrega
				+ ", valortotal=" + valortotal + ", observacao=" + observacao + ", codigoCliente=" + codigoCliente
				+ ", cliente=" + cliente + ", itens=" + itens + "]";
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getDtemissao() {
		return dtemissao;
	}

	public void setDtemissao(Date dtemissao) {
		this.dtemissao = dtemissao;
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

	private void calcularValorTotal() {

		valortotal = 0.0;
		for (PedidoItem item : itens) {
			valortotal += item.valorTotal();
		}

	}

	public void add(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	

}
