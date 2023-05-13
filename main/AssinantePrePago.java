package main;

import java.util.GregorianCalendar;

public class AssinantePrePago extends Assinante {
	private Recarga[] recargas;
	private int numRecargas;
	private float creditos;

	public AssinantePrePago(String cpf, String nome, String numero) {
		super(cpf, nome, numero);
		this.recargas = new Recarga[100]; // tamanho inicial do vetor de recargas
		// nao passados no construtor
		this.numRecargas = 0;
		this.creditos = 0.0f;
	}

	@Override
	public void fazerChamada(GregorianCalendar data, int duracao) {
		float custoPorMinuto = 1.45f;
		float custoChamada = duracao * custoPorMinuto;

		if (numChamadas >= chamadas.length || creditos < custoChamada) {
			System.out
					.println("Não é possível fazer a chamada. Créditos insuficientes ou limite de chamadas atingido.");
		} else {
			Chamada chamada = new Chamada(data, duracao);
			chamadas[numChamadas] = chamada;
			numChamadas++;
			creditos -= custoChamada;
			System.out.println("Chamada registrada com sucesso!");
		}
	}

	public void recarregar(GregorianCalendar data, float valor) {
		if (numRecargas >= recargas.length) {
			System.out.println("Não é possível realizar a recarga. Limite de recargas atingido.");
		} else {
			Recarga recarga = new Recarga(data, valor);
			recargas[numRecargas] = recarga;
			numRecargas++;
			creditos += valor;
			System.out.println("Recarga realizada com sucesso!");
		}
	}

	public void imprimirFatura(int mes) {
		System.out.println("CPF: " + getCpf());
		System.out.println("Nome: " + getNome());
		System.out.println("Número: " + getNumero());

		// Imprimir chamadas do mês
		System.out.println("Chamadas do mês:");
		for (int i = 0; i < numChamadas; i++) {
			Chamada chamada = chamadas[i];
			if (chamada.getData().get(GregorianCalendar.MONTH) == mes) {
				System.out.println("Data: " + chamada.getData().getTime());
				System.out.println("Duração: " + chamada.getDuracao() + " minutos");
				float custo = chamada.getDuracao() * 1.45f;
				System.out.println("Custo: R$" + custo);
			}
		}

		// Imprimir recargas do mês
		System.out.println("Recargas do mês:");
		for (int i = 0; i < numRecargas; i++) {
			Recarga recarga = recargas[i];
			if (recarga.getData().get(GregorianCalendar.MONTH) == mes) {
				System.out.println("Data: " + recarga.getData().getTime());
				System.out.println("Valor: R$" + recarga.getValor());
			}
		}

		System.out.println("Total de chamadas: " + numChamadas);
		System.out.println("Total de recargas: " + numRecargas);
		System.out.println("Créditos disponíveis: R$" + creditos);
	}
}
