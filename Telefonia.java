import java.util.Scanner;

public class Telefonia {
    private AssinantePrePago[] prePagos;
    private int numPrePagos;
    private AssinantePosPago[] posPagos;
    private int numPosPagos;

    public Telefonia() {
        prePagos = new AssinantePrePago[100]; // tamanho inicial do vetor de assinantes pré-pagos
        numPrePagos = 0;
        posPagos = new AssinantePosPago[100]; // tamanho inicial do vetor de assinantes pós-pagos
        numPosPagos = 0;
    }

    public void cadastrarAssinante() {
        System.out.println("Digite o tipo de assinante (1 - Pré-pago, 2 - Pós-pago):");
        Scanner scanner;
        int tipoAssinante = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Digite o CPF do assinante:");
        String cpf = scanner.nextLine();

        System.out.println("Digite o nome do assinante:");
        String nome = scanner.nextLine();

        System.out.println("Digite o número do telefone do assinante:");
        String numero = scanner.nextLine();

        if (tipoAssinante == 1) {
            if (numPrePagos < MAX_PRE_PAGOS) {
                prePagos[numPrePagos] = new AssinantePrePago(cpf, nome, numero);
                numPrePagos++;
                System.out.println("Assinante pré-pago cadastrado com sucesso!");
            } else {
                System.out.println("Não é possível cadastrar mais assinantes pré-pagos. Limite máximo alcançado.");
            }
        } else if (tipoAssinante == 2) {
            if (numPosPagos < MAX_POS_PAGOS) {
                posPagos[numPosPagos] = new AssinantePosPago(cpf, nome, numero);
                numPosPagos++;
                System.out.println("Assinante pós-pago cadastrado com sucesso!");
            } else {
                System.out.println("Não é possível cadastrar mais assinantes pós-pagos. Limite máximo alcançado.");
            }
        } else {
            System.out.println("Opção inválida. Assinante não cadastrado.");
        }
    }

    public void listarAssinantes() {
        System.out.println("Assinantes Pré-pagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println(prePagos[i].toString());
        }

        System.out.println("Assinantes Pós-pagos:");
        for (int i = 0; i < numPosPagos; i++) {
            System.out.println(posPagos[i].toString());
        }
    }

    public void fazerChamada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de assinante (P - Pré-pago / O - Pós-pago):");
        String tipoAssinante = scanner.nextLine().toUpperCase();

        Assinante assinante = null;

        if (tipoAssinante.equals("P")) {
            System.out.println("Digite o CPF do assinante pré-pago:");
            String cpf = scanner.nextLine();

            for (int i = 0; i < numPrePagos; i++) {
                if (prePagos[i].getCpf().equals(cpf)) {
                    assinante = prePagos[i];
                    break;
                }
            }
        } else if (tipoAssinante.equals("O")) {
            System.out.println("Digite o CPF do assinante pós-pago:");
            String cpf = scanner.nextLine();

            for (int i = 0; i < numPosPagos; i++) {
                if (posPagos[i].getCpf().equals(cpf)) {
                    assinante = posPagos[i];
                    break;
                }
            }
        }

        if (assinante != null) {
            System.out.println("Digite a data da chamada (dd/MM/yyyy):");
            String dataStr = scanner.nextLine();
            System.out.println("Digite a duração da chamada em minutos:");
            int duracao = scanner.nextInt();

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

