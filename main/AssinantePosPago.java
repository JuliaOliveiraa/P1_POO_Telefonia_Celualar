package main;

import java.util.GregorianCalendar;

public class AssinantePosPago extends Assinante {
	private float assinatura;

	public AssinantePosPago(String cpf, String nome, String numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	@Override
	public void fazerChamada(GregorianCalendar data, int duracao) {

		float custoPorMinuto = 1.04f;

		if (numChamadas >= chamadas.length) {
			System.out.println("Não é possível fazer a chamada. Limite de chamadas atingido.");
		} else {
			Chamada chamada = new Chamada(data, duracao);
			chamadas[numChamadas] = chamada;
			numChamadas++;
			System.out.println("Chamada registrada com sucesso!");
		}
	}

	public void imprimirFatura(int mes) {
		System.out.println("CPF: " + getCpf());
		System.out.println("Nome: " + getNome());
		System.out.println("Número: " + getNumero());

		// Imprimir chamadas do mês
		System.out.println("Chamadas do mês:");
		float custoTotalChamadas = 0.0f;
		for (int i = 0; i < numChamadas; i++) {
			Chamada chamada = chamadas[i];
			if (chamada.getData().get(GregorianCalendar.MONTH) == mes) {
				System.out.println("Data: " + chamada.getData().getTime());
				System.out.println("Duração: " + chamada.getDuracao() + " minutos");
				float custoChamada = chamada.getDuracao() * 1.04f;
				System.out.println("Custo: R$" + custoChamada);
				custoTotalChamadas += custoChamada;
			}
		}

		// Imprimir total da fatura
		float valorTotalFatura = assinatura + custoTotalChamadas;
		System.out.println("Valor da assinatura: R$" + assinatura);
		System.out.println("Valor total das chamadas: R$" + custoTotalChamadas);
		System.out.println("Valor total da fatura: R$" + valorTotalFatura);
	}

}
