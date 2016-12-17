package br.com.ufal.socket;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pessoa implements Serializable  {
	
	private String nome;
	private String cpf;
	private String profissao;
	private int idade;
	
	public Pessoa(String nome, String cpf, String profissao, int idade){
		this.nome = nome;
		this.cpf = cpf;
		this.profissao = profissao;
		this.idade = idade;
	}
	
	public Pessoa(){}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
