import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Telefonia telefonia = new Telefonia();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Cadastrar assinante");
            System.out.println("2. Listar assinantes");
            System.out.println("3. Fazer chamada");
            System.out.println("4. Fazer recarga");
            System.out.println("5. Imprimir faturas");
            System.out.println("6. Sair");
            System.out.println("Digite a opção desejada:");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

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