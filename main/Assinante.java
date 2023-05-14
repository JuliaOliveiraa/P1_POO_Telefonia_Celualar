package main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Assinante {
	private String cpf;
	private String nome;
	private String numero;
	protected List<Chamada> chamadas;

	public Assinante(String cpf, String nome, String numero) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.chamadas = new ArrayList<>(); // tamanho inicial do vetor de chamadas
	}

	public String getCpf() {
		return cpf;
	}

// usar toString para get 
	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
	}
	
	public void fazerChamada(GregorianCalendar data, int duracao) {
		
	}
}
