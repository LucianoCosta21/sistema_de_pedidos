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
	public PedidoItem(int qtproduto, double vldesconto, Produto produto, CadastrarPedido chave) {	
		this.qtproduto = qtproduto;			
		this.vldesconto = vldesconto;			
		this.produto = produto;
		this.pedido = chave;
	}
	
	//int chaveGerada = chave.chaveGerada;
	//String query = "insert into fiscal.pedido_item(quantidade, vlr_uni, vlr_desc, id_pedido, id_produto) values(" + quantidade + "," + vlunitario + ","+ vldesconto + "," + chaveGerada + "," + produto.getIdproduto() + ");";
		
	/*
	@Override
	public String toString() {
		return "PedidoItem [idpedidoitem=" + idpedidoitem + ", vlunitario=" + vlunitario + ", qtproduto=" + qtproduto
				+ ", vldesconto=" + vldesconto + ", produtos=" + produto.toString() + "]";
	}
	*/
	
	//String produtoDescricao = (produto != null) ? produto.getDescricao() : "Produto não encontrado";
	
	public String toString() {
	    return " Produto: = " + produto.getDescricao()
	    	   + " Quantidade: " + qtproduto 
	    	   + " Valor Unitário: " + vlunitario 
	    	   + " Desconto: " + vldesconto
	    	   + " Código do Produto: " + produto.getIdproduto()
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
		return vlunitario * (1-(vldesconto/100));
	}
	
	public double valorTotal() {	
		return  valorDesconto() * qtproduto;
	}

}
