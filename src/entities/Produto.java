package entities;

public class Produto {
	
	protected int idproduto;
	protected String descricao;
	protected double vlcusto;
	protected double vlvenda;
	protected String categoria;
	
	
	
	public Produto(int idproduto, String descricao, double vlcusto, double vlvenda, String categoria) {
		super();
		this.idproduto = idproduto;
		this.descricao = descricao;
		this.vlcusto = vlcusto;
		this.vlvenda = vlvenda;
		this.categoria = categoria;
	}
	
	public Produto() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "===== PRODUTO =====\nCód. Produto: \t" + idproduto + "\nDescricao: \t" + descricao + "\nValor custo: \t" + vlcusto + "\nValor venda: \t"
				+ vlvenda + "\nCategoria: \t" + categoria;
	}

	public int getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getVlcusto() {
		return vlcusto;
	}
	public void setVlcusto(double vlcusto) {
		this.vlcusto = vlcusto;
	}
	public double getVlvenda() {
		return vlvenda;
	}
	public void setVlvenda(double vlvenda) {
		this.vlvenda = vlvenda;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Produto get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}

