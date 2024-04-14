package entities;

import java.util.Date;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private Date dtnascimento;
	
		
	
	public Pessoa(String nome, String cpf, Date dtnascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dtnascimento = dtnascimento;
	}
	
	
	
	public Pessoa() {
		super();
	}


	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public Date getDtnascimento() {
		return dtnascimento;
	}
	
	
}
