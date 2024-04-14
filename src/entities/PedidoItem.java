package entities;

import java.util.ArrayList;


public class PedidoItem {

	protected int idpedidoitem;
	protected double vlunitario;
	protected int qtproduto;
	protected double  vldesconto;
	private Produto produto;
	private int codigoPedido;
	private int codigoProduto;
/*
	public PedidoItem(int idpedidoitem, double vlunitario, int qtproduto, int vldesconto, Produto produto) {
		super();
		this.idpedidoitem = idpedidoitem;
		this.vlunitario = vlunitario;
		this.qtproduto = qtproduto;
		this.vldesconto = vldesconto;
		this.produto = produto;
	}
*/	
	public PedidoItem(int qtproduto, double vlunitario, double vldesconto,int codigoPedido,int codigoProduto, Produto produto) {	
		this.qtproduto = qtproduto;
		this.vlunitario = vlunitario;		
		this.vldesconto = vldesconto;
		this.codigoPedido = codigoPedido;
		this.codigoProduto = codigoProduto;
		this.produto = produto;
	}
	
		
	/*
	@Override
	public String toString() {
		return "PedidoItem [idpedidoitem=" + idpedidoitem + ", vlunitario=" + vlunitario + ", qtproduto=" + qtproduto
				+ ", vldesconto=" + vldesconto + ", produtos=" + produto.toString() + "]";
	}
	*/
	
	//String produtoDescricao = (produto != null) ? produto.getDescricao() : "Produto não encontrado";
	
	public String toString() {
	    return "Produto: = " + produto.getDescricao()
	    	   + " Quantidade: " + qtproduto 
	    	   + " Valor Unitário: " + vlunitario 
	    	   + " Desconto: " + vldesconto
	    	   + " Código do Produto: " + codigoProduto
	    	   + " Valor com Desconto: " + valorDesconto() ;
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
		this.vlunitario = vlunitario;
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
	
	//----------------------------------------------------------------------
	
	
	public double valorDesconto() {
		return vlunitario * (1-(vldesconto/100));
	}
	
	public double valorTotal() {	
		return  valorDesconto() * qtproduto;
	}

}
