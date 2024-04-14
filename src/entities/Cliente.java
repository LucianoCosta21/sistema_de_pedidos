package entities;

import java.util.Date;

public class Cliente extends Pessoa {
	
	private int codigo;
	private String endereco;
	private String telefone;
		
	
	public Cliente(int codigo, String nome, String cpf, Date dtnascimento,  String endereco, String telefone) {
		super(nome, cpf, dtnascimento);
		this.codigo = codigo;
		this.endereco = endereco;
		this.telefone = telefone;

	}	
	
    @Override
    public String toString() {
        return "===== Cliente ===== \n\n" +
                "Código: \t" + codigo +"\n"+
                "Nome: \t\t" + getNome() + "\n" +
                "CPF: \t\t" + getCpf() + "\n" +
                "Nascimento: \t" + getDtnascimento() + "\n" +
                "Endereço: \t" + endereco + "\n" +
                "Telefone: \t" + telefone + "\n" ;
                
    }
	
	public Cliente() {
		super();	
	}
	
	

	public Cliente(int int1, Object integer, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public int getCodigo() {
		return codigo;
	}
	

}
