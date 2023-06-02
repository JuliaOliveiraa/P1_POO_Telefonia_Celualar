package main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Assinante {
	protected long cpf;
	protected String nome;
	protected String numero;
	protected int numChamadas;
	protected List<Chamada> chamadas;

	public Assinante(long cpf, String nome, String numero) {
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.numChamadas = 0;
		this.chamadas = new ArrayList<>();
	}

	public long getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
	}

	public void imprimirFatura(int mes, int ano) {

	}

	public void fazerChamada(GregorianCalendar data, int duracao) {

	}
}
