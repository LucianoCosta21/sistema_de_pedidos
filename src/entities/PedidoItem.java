package entities;

import java.util.ArrayList;

import requesitos.CadastrarPedido;


public class PedidoItem {

	protected int idpedidoitem;
	protected double vlunitario;
	protected int qtproduto;
	protected double  vldesconto;
	private Produto produto;
	private CadastrarPedido pedido;
	
	
	public PedidoItem(int qtproduto, double vldesconto, Produto produto, CadastrarPedido chave) {	
		this.qtproduto = qtproduto;			
		this.vldesconto = vldesconto;			
		this.produto = produto;
		this.pedido = chave;
	}
	
	public String toString() {
	    return " Produto: = " + produto.getDescricao()
	    	   + "\n Quantidade: " + qtproduto 
	    	   + "\n Valor Unitário: " + produto.getVlvenda() +" R$"
	    	   + "\n Desconto: " + vldesconto + " %"
	    	   + "\n Código do Produto: " + produto.getIdproduto()
	    	   + "\n Valor com Desconto: " + valorDesconto() +" R$"
	    	   + "\n Valor total dos Itens: " +  valorTotal()+" R$";
	}


	public PedidoItem() {
		
	}	

	public int getIdpedidoitem() {
		return idpedidoitem;
	}

	public void setIdpedidoitem(int idpedidoitem) {
		this.idpedidoitem = idpedidoitem;
	}

	public double getVlunitario() {
		return vlunitario;
	}

	public void setVlunitario(double vlunitario) {
		this.vlunitario = produto.getVlvenda();
	}

	public int getQtproduto() {
		return qtproduto;
	}

	public void setQtproduto(int qtproduto) {
		this.qtproduto = qtproduto;
	}

	public double getVldesconto() {
		return vldesconto;
	}

	public void setVldesconto(int vldesconto) {
		this.vldesconto = vldesconto;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public CadastrarPedido getPedido() {
		return pedido;
	}

	public void setPedido(CadastrarPedido pedido) {
		this.pedido = pedido;
	}
		
	//----------------------------------------------------------------------
	
	

	public double valorDesconto() {
		return produto.getVlvenda() * (1-(vldesconto/100));
	}
	
	public double valorTotal() {	
		return  valorDesconto() * qtproduto;
	}

}
