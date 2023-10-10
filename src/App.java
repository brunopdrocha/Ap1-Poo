import java.util.Scanner;
import classes.Evento;
import classes.MeuEvento;
import classes.TipoIng;

public class App {
    public static void main(String[] args) throws Exception {
        Evento evento = null; // Inicializa o objeto Evento como nulo
        TipoIng tipo = TipoIng.meia; // Inicializa o tipo de ingresso como Meia
        int qtd = 0; // Inicializa a quantidade como 0


        Scanner leitor = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Ver evento");
            System.out.println("2 - Compra ingresso");
            System.out.println("3 - Cadastrar evento");
            System.out.println("4 - Qtd Ingressos disponíveis");
            System.out.println("5 - Última compra");
            System.out.println("6 - Sair");

            int opcao = leitor.nextInt();
            leitor.nextLine(); // Limpa o caractere de nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Informações do evento:"); {
                    System.out.println("Nome: " + evento.getNome());
                    System.out.println("Data: " + evento.getData());
                    System.out.println("Local: " + evento.getLocal());
                    System.out.println("Quantidade de Ingressos Inteira: " + evento.getIngressoInteira());
                    System.out.println("Quantidade de Ingressos Meia: " + evento.getIngressoMeia());
                }
                    break;
                case 2:
                    System.out.println("Compra de ingresso"); {
                    System.out.println("1 - " + evento.getNome());
                    System.out.println("2 - " + evento.getData());

                    System.out.println("Escolha o tipo do ingresso:\n1 - Inteira\n2 - Meia");
                    int tipoIngresso = leitor.nextInt();
                    leitor.nextLine();

                    if (tipoIngresso == 1) {
                        tipo = TipoIng.inteira;
                    } else {
                        tipo = TipoIng.meia;
                    }

                    System.out.println("Informe a quantidade de ingressos:");
                    qtd = leitor.nextInt();
                    leitor.nextLine();

                    if (evento.isIngressoDisponivel(tipo, qtd)) {
                        double precoTotal = evento.venderIngresso(tipo, qtd);
                        System.out.println("informacoes do ingresso: ");
                        System.out.println("Preço total: " + evento.getPrecoTotal());
                        System.out.println("nome " + evento.getNome());
                        System.out.println("data " + evento.getData());
                        System.out.println("local " + evento.getLocal());
                        System.out.println("quantidade de ingresso(s) " + qtd);
                        System.out.println(evento.getTipoIngresso());
                    } else {
                        System.out.println("Ingressos não disponíveis em quantidade suficiente.");
                    }

                    break;
                }

                case 3:
                    System.out.println("Opção 3 selecionada");
                    System.out.println("Cadastrar evento");
                    System.out.println("Nome do evento:");
                    String nome = leitor.nextLine();
                    System.out.println("Data do evento:");
                    String data = leitor.nextLine();
                    System.out.println("Local do evento:");
                    String local = leitor.nextLine();
                    System.out.println("Quantidade de ingressos Inteira:");
                    int ingressoInteira = leitor.nextInt();
                    leitor.nextLine();
                    System.out.println("Quantidade de ingressos Meia:");
                    int ingressoMeia = leitor.nextInt();
                    leitor.nextLine();
                    System.out.println("Preço do ingresso cheio:");
                    double precoCheio = leitor.nextDouble();

                    evento = new MeuEvento(nome, data, local, ingressoInteira, ingressoMeia, precoCheio);
                    break;
                case 4:
                    System.out.println("Quantidade de ingressos disponiveis ");

                        System.out.println("Ingressos disponíveis:");
                        System.out.println("Inteira: " + evento.getIngressoInteira());
                        System.out.println("Meia: " + evento.getIngressoMeia());
                    break;
                case 5:
                    System.out.println("Informacao da ultima compra ");
                    System.out.println("informacoes do ingresso:");
                    System.out.println("Preço total: " + evento.getPrecoTotal());
                    System.out.println("nome " + evento.getNome());
                    System.out.println("data " + evento.getData());
                    System.out.println("local " + evento.getLocal());
                    System.out.println("quantidade de ingresso(s) " + qtd);

                    if (evento.getTipoIngresso() == 1) {
                        System.out.println("Inteira");

                    } else {
                        System.out.println("Meia");
                    }

                    break;

                default:
                    System.out.println("Saindo do programa");
                    System.exit(0); // Sai do programa
                    break;

            }
        }
    }
}
