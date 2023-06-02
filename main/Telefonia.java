package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Telefonia {
	private List<AssinantePrePago> prePagos;
	private List<AssinantePosPago> posPagos;

	public Telefonia() {
		prePagos = new ArrayList<>();
		posPagos = new ArrayList<>();
	}

	public void cadastrarAssinante() {
		System.out.print("Digite o tipo de assinante (1 - Pré-pago, 2 - Pós-pago):");
		Scanner scanner = new Scanner(System.in);
		int tipoAssinante = scanner.nextInt();

		System.out.println();

		System.out.print("Digite o CPF do assinante:");
		long cpf = scanner.nextLong();

		System.out.println();

		System.out.print("Digite o nome do assinante:");
		scanner.nextLine();
		String nome = scanner.nextLine();

		System.out.println();

		System.out.print("Digite o número do telefone do assinante:");
		String numero = scanner.next();

		System.out.println();

		if (tipoAssinante == 1) {
			prePagos.add(new AssinantePrePago(cpf, nome, numero));
			System.out.println("Assinante pré-pago cadastrado com sucesso!");
		} else if (tipoAssinante == 2) {
			System.out.print("Digite o valor da assinatura do telefone do assinante:");
			int valor = scanner.nextInt();

			System.out.println();
			
			posPagos.add(new AssinantePosPago(cpf, nome, numero, valor));
			System.out.println("Assinante pós-pago cadastrado com sucesso!");
		} else {
			System.out.println("Opção inválida. Assinante não cadastrado.");
		}
	}

	public void listarAssinantes() {
		System.out.println("Assinantes Pré-pagos:");
		for (int i = 0; i < prePagos.size(); i++) {
			System.out.println(prePagos.get(i).toString());
			System.out.println();
		}

		System.out.println("###################################");
		
		System.out.println("Assinantes Pós-pagos:");
		for (int i = 0; i < posPagos.size(); i++) {
			System.out.println(posPagos.get(i).toString());
			System.out.println();
		}
	}

	public void fazerChamada() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o tipo de assinante (P - Pré-pago / O - Pós-pago):");
		String tipoAssinante = scanner.nextLine().toUpperCase();

		System.out.println();

		Assinante assinante = null;

		if (tipoAssinante.equals("P")) {
			System.out.print("Digite o CPF do assinante pré-pago:");
			long cpf = scanner.nextLong();

			for (int i = 0; i < prePagos.size(); i++) {
				if (prePagos.get(i).getCpf() == cpf) {
					assinante = prePagos.get(i);
					break;
				}
			}
		} else if (tipoAssinante.equals("O")) {
			System.out.print("Digite o CPF do assinante pós-pago:");
			long cpf = scanner.nextLong();

			for (int i = 0; i < posPagos.size(); i++) {
				if (posPagos.get(i).getCpf() == cpf) {
					assinante = posPagos.get(i);
					break;
				}
			}
		}

		if (assinante != null) {
			System.out.print("Digite a data da chamada (dd/MM/yyyy):");
			String dataStr = scanner.nextLine();

			System.out.println();

			System.out.print("Digite a duração da chamada em minutos:");
			int duracao = scanner.nextInt();

			System.out.println();

			// Converter a data de string para o formato desejado (dd/MM/yyyy)
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date data;
			try {
				data = dateFormat.parse(dataStr);
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(data);

				assinante.fazerChamada(calendar, duracao);
			} catch (ParseException e) {
				System.out.println("Data inválida. A chamada não foi registrada.");
			}
		} else {
			System.out.println("Assinante não encontrado.");
		}

	}

	public void fazerRecarga() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o CPF do assinante pré-pago:");
		long cpf = scanner.nextLong();

		System.out.println();

		AssinantePrePago assinante = localizarPrePago(cpf);

		if (assinante != null) {
			System.out.println("Digite o valor da recarga:");
			float valor = scanner.nextFloat();

			System.out.println("Digite a data da recarga (dd/MM/yyyy):");
			String dataString = scanner.next();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date data;
			try {
				data = sdf.parse(dataString);
				Calendar dataRecarga = Calendar.getInstance();
				dataRecarga.setTime(data);

				assinante.recarregar((GregorianCalendar) dataRecarga, valor);
			} catch (ParseException e) {
				System.out.println("Data inválida. A recarga não pôde ser realizada.");
			}
		} else {
			System.out.println("Assinante pré-pago com CPF " + cpf + " não encontrado.");
		}
	}

	public AssinantePrePago localizarPrePago(long cpf) {
		for (int i = 0; i < prePagos.size(); i++) {
			if (prePagos.get(i).getCpf() == cpf) {
				return prePagos.get(i);
			}
		}
		return null;
	}

	public AssinantePosPago localizarPosPago(long cpf) {
		for (int i = 0; i < posPagos.size(); i++) {
			if (posPagos.get(i).getCpf() == cpf) {
				return posPagos.get(i);
			}
		}
		return null;
	}

	public void imprimirFaturas() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o mês para imprimir as faturas:");

		int mes = scanner.nextInt();

		System.out.println();
		
		System.out.print("Digite o ano para imprimir as faturas:");

		int ano = scanner.nextInt();

		System.out.println();

		System.out.println("Faturas dos assinantes pré-pagos:");
		for (int i = 0; i < prePagos.size(); i++) {
			prePagos.get(i).imprimirFatura(mes, ano);
			System.out.println("----------------------------------------");
		}
		System.out.println("############################################");
		System.out.println("Faturas dos assinantes pós-pagos:");
		for (int i = 0; i < posPagos.size(); i++) {
			posPagos.get(i).imprimirFatura(mes, ano);
			System.out.println("----------------------------------------");
		}
	}

	public static void main(String[] args) {
		Telefonia telefonia = new Telefonia();
		int opcao = 0;

		do {
			System.out.println();
			System.out.println("Menu de Opções:");
			System.out.println("1. Cadastrar assinante");
			System.out.println("2. Listar assinantes");
			System.out.println("3. Fazer chamada");
			System.out.println("4. Fazer recarga");
			System.out.println("5. Imprimir faturas");
			System.out.println("6. Sair");
			System.out.println("Digite a opção desejada:");

			Scanner scanner = new Scanner(System.in);
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				telefonia.cadastrarAssinante();
				break;
			case 2:
				telefonia.listarAssinantes();
				break;
			case 3:
				telefonia.fazerChamada();
				break;
			case 4:
				telefonia.fazerRecarga();
				break;
			case 5:
				telefonia.imprimirFaturas();
				break;
			case 6:
				System.out.println("Encerrando o programa.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (opcao != 6);
	}
}
