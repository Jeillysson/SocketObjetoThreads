package br.com.ufal.socket;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CadastrarPessoa implements Serializable {

	private ArrayList<Pessoa> pessoasCadastradas = new ArrayList<Pessoa> ();

	private Pessoa pessoa;
	

	//construtor
	public CadastrarPessoa(){
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public ArrayList<Pessoa> getPessoasCadastradas() {
		return pessoasCadastradas;
	}

	public void setPessoasCadastradas(ArrayList<Pessoa> pessoasCadastradas) {
		this.pessoasCadastradas = pessoasCadastradas;
	}

	public void cadastrarPessoa(Pessoa pessoa){
		pessoasCadastradas.add(pessoa);
	}
	
	public void imprimirLista(){
		for (int i = 0; i < pessoasCadastradas.size(); i++) {
			System.out.println(pessoasCadastradas.get(i).getNome());
			System.out.println(pessoasCadastradas.get(i).getCpf());
			System.out.println(pessoasCadastradas.get(i).getProfissao());
			System.out.println(pessoasCadastradas.get(i).getIdade());
		}
	}
}
