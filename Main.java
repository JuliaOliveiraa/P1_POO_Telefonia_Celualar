import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Assinante> assinantesPrePago = new ArrayList<>();
        ArrayList<Assinante> assinantesPosPago = new ArrayList<>();

        boolean executando = true;
        while (executando) {
            System.out.println("----------- MENU -----------");
            System.out.println("1 - Cadastrar assinante");
            System.out.println("2 - Listar assinantes");
            System.out.println("3 - Fazer chamada");
            System.out.println("4 - Fazer recarga");
            System.out.println("5 - Imprimir faturas");
            System.out.println("6 - Sair do programa");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Tipo de assinante (1 - Pré-pago / 2 - Pós-pago): ");
                    int tipoAssinante = scanner.nextInt();
                    if (tipoAssinante == 1) {
                        assinantesPrePago.add(cadastrarAssinantePrePago(scanner));
                    } else if (tipoAssinante == 2) {
                        assinantesPosPago.add(cadastrarAssinantePosPago(scanner));
                    }
                    break;
                case 2:
                    System.out.println("Assinantes pré-pagos:");
                    for (Assinante assinante : assinantesPrePago) {
                        System.out.println(assinante);
                    }
                    System.out.println("Assinantes pós-pagos:");
                    for (Assinante assinante : assinantesPosPago) {
                        System.out.println(assinante);
                    }
                    break;
                case 3:
                    fazerChamada(scanner, assinantesPrePago, assinantesPosPago);
                    break;
                case 4:
                    fazerRecarga(scanner, assinantesPrePago);
                    break;
                case 5:
                    System.out.println("Informe o mês (1 - Janeiro / 2 - Fevereiro / etc): ");
                    int mes = scanner.nextInt();
                    System.out.println("Faturas dos assinantes pré-pagos:");
                    for (Assinante assinante : assinantesPrePago) {
                        if (assinante instanceof AssinantePrePago) {
                            AssinantePrePago assinantePrePago = (AssinantePrePago) assinante;
                            System.out.println(assinantePrePago.imprimirFatura(mes));
                        }
                    }
                    System.out.println("Faturas dos assinantes pós-pagos:");
                    for (Assinante assinante : assinantesPosPago) {
                        if (assinante instanceof AssinantePosPago) {
                            AssinantePosPago assinantePosPago = (AssinantePosPago) assinante;
                            System.out.println(assinantePosPago.imprimirFatura(mes));
                        }
                    }
                    break;
                case 6:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }
}