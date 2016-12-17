package br.com.ufal.socket;

import java.io.DataOutputStream;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {
	
	public Socket conexao;
	
	public Servidor(Socket conexao){
		this.conexao = conexao;
	}
	
	
	public void run(){
		System.out.println("ENTROU \0/ 222");
		try {
			ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
			CadastrarPessoa cadastrar = (CadastrarPessoa) entrada.readObject();
			//Pessoa cadastrar = (Pessoa) entrada.readObject();
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			
			//while (entrada.readObject() != null){
				//System.out.println("ENTROU \0/");
				cadastrar.imprimirLista();
				//System.out.println(cadastrar.getNome());
			//}
			entrada.close();
			this.conexao.close();
		}catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main (String args[]) throws IOException, ClassNotFoundException{
		
		ServerSocket server = new ServerSocket(1313);
		System.out.println("[SERVER] Servidor rodando ... ");
			
		while (true){
			Socket conexao = server.accept();
			Servidor tratamento = new Servidor(conexao);
			Thread thread = new Thread(tratamento);
		}
	}
	
	

}
