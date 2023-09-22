import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        String nomeEvento = "";
        String dataEvento = "";
        String localEvento = "";


        while (true) { // Loop infinito para o menu principal
            System.out.println("1 - Ver evento");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Cadastrar evento");
            System.out.println("4 - Qtd Ingressos disponíveis");
            System.out.println("5 - Última compra");
            System.out.println("6 - Sair");

            int opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar o buffer de nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Informações do evento:");
                    System.out.println("Nome: " + nomeEvento);
                    System.out.println("Data: " + dataEvento);
                    System.out.println("Local: " + localEvento);
                    break;
                case 2:
                    System.out.println("Compra de ingresso");
                    System.out.println("1 - " + nomeEvento);
                    System.out.println("2 - " + dataEvento);
                    System.out.println("preco:");
                    System.out.println("AQUI DEVERA APARECER O TIPO DO INGRESSO");
                    // Implemente a compra de ingressos aqui
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada");
                    System.out.println("Cadastrar evento");
                    System.out.println("Nome do evento:");
                    nomeEvento = leitor.nextLine();
                    System.out.println("Data do evento:");
                    dataEvento = leitor.nextLine();
                    System.out.println("Local do evento:");
                    localEvento = leitor.nextLine();
                    System.out.println();

                    break;
                case 4:
                    System.out.println("Opção 4 selecionada");
                    // Implemente a visualização de ingressos disponíveis aqui
                    break;
                case 5:
                    System.out.println("Opção 5 selecionada");
                    // Implemente a exibição da última compra aqui
                    break;
                case 6:
                    System.out.println("Saindo do programa");
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção padrão (se nenhuma correspondência for encontrada)");
            }
        }
    }
}
