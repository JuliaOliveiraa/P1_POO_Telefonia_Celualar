package main;

import java.util.GregorianCalendar;

public class AssinantePosPago extends Assinante {
	private float valorAssinatura;

	public AssinantePosPago(long cpf, String nome, String numero, float valorAssinatura) {
		super(cpf, nome, numero);
		this.valorAssinatura = valorAssinatura;
	}

	@Override
	public void fazerChamada(GregorianCalendar data, int duracao) {
		Chamada chamada = new Chamada(data, duracao);
		chamadas.add(chamada);
		System.out.println("Chamada registrada com sucesso!");
	}

	@Override
	public void imprimirFatura(int mes, int ano) {
		System.out.println("CPF: " + getCpf());
		System.out.println("Nome: " + nome);
		System.out.println("Número: " + numero);

		// Imprimir chamadas do mês
		System.out.println("Chamadas do mês:");
		float custoTotalChamadas = 0.0f;
		for (int i = 0; i < chamadas.size(); i++) {
			Chamada chamada = chamadas.get(i);
			if (chamada.getData().get(GregorianCalendar.MONTH) == mes) {
				System.out.println("Data: " + chamada.getData().getTime());
				System.out.println("Duração: " + chamada.getDuracao() + " minutos");
				float custoChamada = chamada.getDuracao() * 1.04f;
				System.out.println("Custo: R$" + custoChamada);
				custoTotalChamadas += custoChamada;
			}
		}

		// Imprimir total da fatura
		float valorTotalFatura = valorAssinatura + custoTotalChamadas;
		System.out.println("Valor da assinatura: R$" + valorAssinatura);
		System.out.println("Valor total das chamadas: R$" + custoTotalChamadas);
		System.out.println("Valor total da fatura: R$" + valorTotalFatura);
	}

}
