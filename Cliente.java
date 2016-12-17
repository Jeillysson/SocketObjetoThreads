package br.com.ufal.socket;

import java.io.DataInputStream;

//import java.io.DataInputStream;

import java.io.IOException;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente implements Runnable{
	
	private Socket conexao;
	
	//adastrarPessoa cadastrar = new CadastrarPessoa();
	private ObjectOutputStream saida;
	DataInputStream entrada;

	private Socket socket;

	public Cliente (Socket conexao){
		this.conexao = conexao;
	}
	
	public void run(){
		
		CadastrarPessoa cadastrar = new CadastrarPessoa();
		boolean loop = true;
		
		while (loop){
			
			Scanner inicio = new Scanner(System.in);
			System.out.println("DIGITE - 1 para Cadastrar Usuários. \n"
					+ "2  Para Imprimir Usuários \n"
					+ "3 para Sair");
			int ent = inicio.nextInt();
			if (ent == 1){
				Scanner entrada = new Scanner(System.in);
				System.out.println("Digite o nome que deseja Cadastrar: ");
				String nome = entrada.nextLine();
				System.out.println("Agora Digite o CPF que deseja Cadastrar: ");
				String cpf = entrada.nextLine();
				System.out.println("Agora Digite sua profissão: ");
				String profissao = entrada.nextLine();
				System.out.println("Agora para encerrar, Digite sua Idade: ");
				int idade = entrada.nextInt();
				
				Pessoa pessoa = new Pessoa(nome,cpf,profissao,idade);
				cadastrar.cadastrarPessoa(pessoa);
			}
			if (ent == 2){
				cadastrar.imprimirLista();
			}
			if (ent == 3){
				loop = false;
			}
			if(ent <= 0 || ent >= 4){
				System.out.println("Digite um número válido");
			}
		
		try {
			saida = new ObjectOutputStream(conexao.getOutputStream());
			saida.writeObject(cadastrar);
			saida.reset();
			saida.flush();
			//entrada = new DataInputStream(conexao.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		}
		
	}
	
	public static void main(String args[]) throws IOException, UnknownHostException{
		
		Socket cliente = new Socket("127.0.0.1",1313);
		Pessoa pessoa = null;
		System.out.println("[CLIENTE] - CONECTADO");
		
		
		Cliente c = new Cliente(cliente);
		Thread thread = new Thread(c);
		thread.start();
		
	}
				
}
