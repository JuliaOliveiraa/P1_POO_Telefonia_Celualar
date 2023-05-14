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
		try (Scanner scanner = new Scanner(System.in)) {
			int tipoAssinante = scanner.nextInt();
			
			System.out.println();

			System.out.print("Digite o CPF do assinante:");
			String cpf = scanner.nextLine();
			
			System.out.println();
			
			System.out.print("Digite o nome do assinante:");
			String nome = scanner.nextLine();
			
			System.out.println();

			System.out.print("Digite o número do telefone do assinante:");
			String numero = scanner.nextLine();
			
			System.out.println();

			if (tipoAssinante == 1) {
				prePagos.add(new AssinantePrePago(cpf, nome, numero));
				System.out.println("Assinante pré-pago cadastrado com sucesso!");
			} else if (tipoAssinante == 2) {
				posPagos.add(new AssinantePosPago(cpf, nome, numero, 30));
				System.out.println("Assinante pós-pago cadastrado com sucesso!");
			} else {
				System.out.println("Opção inválida. Assinante não cadastrado.");
			}
		} catch (Exception e) {
			System.out.println("Erro durante a execução: " + e.getMessage());
		}
	}

	public void listarAssinantes() {
		System.out.println("Assinantes Pré-pagos:");
		for (int i = 0; i < prePagos.size(); i++) {
			System.out.println(prePagos.get(i).toString());
		}

		System.out.println("Assinantes Pós-pagos:");
		for (int i = 0; i < posPagos.size(); i++) {
			System.out.println(posPagos.get(i).toString());
		}
	}

	public void fazerChamada() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o tipo de assinante (P - Pré-pago / O - Pós-pago):");
			String tipoAssinante = scanner.nextLine().toUpperCase();

			System.out.println();
			
			Assinante assinante = null;

			if (tipoAssinante.equals("P")) {
				System.out.print("Digite o CPF do assinante pré-pago:");
				String cpf = scanner.nextLine();

				for (int i = 0; i < prePagos.size(); i++) {
					if (prePagos.get(i).getCpf().equals(cpf)) {
						assinante = prePagos.get(i);
						break;
					}
				}
			} else if (tipoAssinante.equals("O")) {
				System.out.print("Digite o CPF do assinante pós-pago:");
				String cpf = scanner.nextLine();

				for (int i = 0; i < posPagos.size(); i++) {
					if (posPagos.get(i).getCpf().equals(cpf)) {
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
					System.out.println("Chamada registrada com sucesso!");
				} catch (ParseException e) {
					System.out.println("Data inválida. A chamada não foi registrada.");
				}
			} else {
				System.out.println("Assinante não encontrado.");
			}
		}
	}

	public void fazerRecarga() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o CPF do assinante pré-pago:");
			String cpf = String.valueOf(scanner.nextLong());

			System.out.println();
			
			AssinantePrePago assinante = localizarPrePago(cpf);

			if (assinante != null) {
				System.out.println("Digite o valor da recarga:");
				float valor = scanner.nextFloat();

				System.out.println("Digite a data da recarga (dd/MM/yyyy):");
				String dataString = scanner.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date data;
				try {
					data = sdf.parse(dataString);
					Calendar dataRecarga = Calendar.getInstance();
					dataRecarga.setTime(data);

					assinante.recarregar((GregorianCalendar) dataRecarga, valor);
					System.out.println("Recarga realizada com sucesso para o assinante CPF: " + cpf);
				} catch (ParseException e) {
					System.out.println("Data inválida. A recarga não pôde ser realizada.");
				}
			} else {
				System.out.println("Assinante pré-pago com CPF " + cpf + " não encontrado.");
			}
		}
	}

	public AssinantePrePago localizarPrePago(String cpf) {
		for (int i = 0; i < prePagos.size(); i++) {
			if (prePagos.get(i).getCpf().equals(cpf)) {
				return prePagos.get(i);
			}
		}
		return null;
	}

	public AssinantePosPago localizarPosPago(String cpf) {
		for (int i = 0; i < posPagos.size(); i++) {
			if (posPagos.get(i).getCpf().equals(cpf)) {
				return posPagos.get(i);
			}
		}
		return null;
	}

	public void imprimirFaturas() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o mês para imprimir as faturas:");
			
			int mes = scanner.nextInt();
			
			System.out.println();

			System.out.println("Faturas dos assinantes pré-pagos:");
			for (int i = 0; i < prePagos.size(); i++) {
				prePagos.get(i).imprimirFatura(mes);
				System.out.println("----------------------------------------");
			}
			System.out.println("Faturas dos assinantes pós-pagos:");
			for (int i = 0; i < posPagos.size(); i++) {
				posPagos.get(i).imprimirFatura(mes);
				System.out.println("----------------------------------------");
			}
		}
	}

}
