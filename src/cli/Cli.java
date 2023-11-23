package cli;

import java.time.LocalDate;
import java.util.Scanner;

import dao.EventoDao;

public class Cli {
    public static int executar() {
        EventoDao Evento = new EventoDao();
        // Evento novoEvento = null;
        // Ingresso ingresso = null;
        Scanner leitor = new Scanner(System.in);
        int opcao;

        System.out.println("Seja bem-vindo ao programa de venda de ingressos de eventos!");

        while (true) {
            menu();
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarEvento(leitor, Evento);
                    System.out.println("Evento cadastrado com sucesso!");
                    break;
                case 2:
                    // exibirEvento(eventoDao);
                    break;
                case 3:
                    // exibirIngressosRestantes(evento);
                    break;
                case 4:
                    // ingresso = venderIngresso(evento, leitor);
                    break;
                case 5:
                    exibirEvento(leitor, Evento);

                    break;
                case 6:
                    removeEvento(leitor, Evento);

                    break;
                case 7:
                    exibeEvento(Evento);

                    break;
                default:
                    leitor.close();
                    Evento.salvarEventosEmArquivo();
                    System.out.println("Volte sempre!");
                    return 0;
            }
        }
    }

    private static void menu() {
        System.out.println("\nDigite a opção desejada ou qualquer outro valor para sair:");
        System.out.println("1 - Cadastrar um novo evento;");
        System.out.println("2 - Exibir evento cadastrado;");
        System.out.println("3 - Exibir ingressos restantes;");
        System.out.println("4 - Vender um ingresso;");
        System.out.println("5 - Busca Evento Pelo nome;");
        System.out.println("6 - Remove Evento Pelo nome;");
        System.out.println("7 - Exibe todos  os Eventos;");
    }
    /*
     * ----------1-------------------
     * private static void exibirIngresso(Ingresso ingresso) {
     * if (ingresso == null) {
     * System.out.println("Nenhum ingresso foi vendido!");
     * } else {
     * System.out.println(ingresso);
     * }
     * }
     * ----------------------1----------------------
     */

    /*
     * -----------------2---------------------
     * private static Ingresso venderIngresso(Evento evento, Scanner leitor) {
     * if (evento == null) {
     * System.out.println("Evento ainda não foi cadastrado!");
     * return null;
     * }
     *
     * String tipo;
     * TipoIngresso tipoIngresso;
     * int quantidade;
     * Ingresso ingresso;
     *
     * System.out.print("Informe o tipo do ingresso (meia ou inteira): ");
     * tipo = leitor.next();
     * if (!(tipo.equals("meia") || tipo.equals("inteira"))) {
     * System.out.println("Tipo selecionado inválido!");
     * return null;
     * }
     *
     * tipoIngresso = tipo.equals("meia") ? TipoIngresso.MEIA :
     * TipoIngresso.INTEIRA;
     *
     * System.out.print("Informe quantos ingressos você deseja: ");
     * quantidade = leitor.nextInt();
     *
     * if (!evento.isIngressoDisponivel(tipoIngresso, quantidade)) {
     * System.out.println("Não há ingressos disponíveis desse tipo!");
     * return null;
     * }
     *
     * if (evento instanceof Jogo) {
     * int percentual;
     *
     * System.out.print("Informe o percentual do desconto de sócio torcedor: ");
     * percentual = leitor.nextInt();
     * ingresso = new IngJogo(evento, tipoIngresso, percentual);
     * } else if (evento instanceof Show) {
     * String localizacao;
     *
     * System.out.print("Informe a localização do ingresso (pista ou camarote): ");
     * localizacao = leitor.next();
     *
     * if (!(localizacao.equals("pista") || localizacao.equals("camarote"))) {
     * System.out.println("Localização inválida!");
     * return null;
     * }
     * ingresso = new IngShow(evento, tipoIngresso, localizacao);
     * } else {
     * String desconto;
     *
     * System.out.print("Informe se possui desconto social (s/n): ");
     * desconto = leitor.next();
     *
     * ingresso = new IngExposicao(evento, tipoIngresso, desconto.equals("s"));
     * }
     *
     * evento.venderIngresso(tipoIngresso, quantidade);
     * System.out.println("Ingresso vendido com sucesso!");
     * return ingresso;
     * }
     *
     * -------------------------2------------------------------------
     */

    /*
     * --------------------------------------11--------------------------
     * private static void exibirIngressosRestantes(Evento evento) {
     * if (evento == null) {
     * System.out.println("Evento ainda não foi cadastrado!");
     * } else {
     * System.out.println("Ingressos restantes: " + evento.getIngressos());
     * }
     * }
     * --------------------------------------11--------------------------
     */
    private static void exibirEvento(Scanner leitor, EventoDao eventoDao) {
        String nome;
        System.out.println("Informe o nome do evento que deseja encontrar: ");
        nome = leitor.next();

        eventoDao.buscaEvento(nome);

    }

    private static void cadastrarEvento(Scanner leitor, EventoDao eventoDao) {
        String nome, local, tipo;
        LocalDate data;
        int ingMeia, ingInteira;
        double preco;

        System.out.print("Informe o nome do evento: ");
        nome = leitor.next();

        System.out.print("Informe o dia do evento: ");
        int dia = leitor.nextInt();
        System.out.print("Informe o mês do evento: ");
        int mes = leitor.nextInt();
        System.out.print("Informe o ano do evento: ");
        int ano = leitor.nextInt();
        data = LocalDate.of(ano, mes, dia);

        
        System.out.print("Informe o local do evento: ");
        local = leitor.next();
        System.out.print("Informe o número de entradas tipo meia: ");
        ingMeia = leitor.nextInt();
        System.out.print("Informe o número de entradas tipo inteira: ");
        ingInteira = leitor.nextInt();
        System.out.print("Informe o preço cheio do evento: ");
        preco = leitor.nextDouble();
        System.out.print("Informe o tipo do evento (show, jogo ou exposição): ");
        tipo = leitor.next();

        if (tipo.equals("show")) {
            String artista, genero;

            System.out.print("Informe o nome do artista: ");
            artista = leitor.next();
            System.out.print("Informe o gênero do show: ");
            genero = leitor.next();

            eventoDao.addEvento(nome, data, local, ingMeia, ingInteira, preco, artista, genero);
        }

        if (tipo.equals("jogo")) {
            String esporte, casa, adversario;

            System.out.print("Informe o esporte: ");
            esporte = leitor.next();
            System.out.print("Informe a equipe da casa: ");
            casa = leitor.next();
            System.out.print("Informe a equipe adversária: ");
            adversario = leitor.next();

            eventoDao.addEvento(nome, data, local, ingMeia, ingInteira, preco, esporte, casa, adversario);
        }
        if (tipo.equals("exposicao")) {
            int idadeMin, duracao;

            System.out.print("Informe a idade mínima para entrar na exposição: ");
            idadeMin = leitor.nextInt();
            System.out.print("Informe a duração em dias da exposição: ");
            duracao = leitor.nextInt();

            eventoDao.addEvento(nome, data, local, ingMeia, ingInteira, preco, idadeMin, duracao);
        }
    }

    private static void removeEvento(Scanner leitor, EventoDao eventoDao) {
        String nome;
        System.out.println("Informe o nome do evento que deseja remover: ");
        nome = leitor.next();

        eventoDao.removeEvento(nome);

    }

    private static void exibeEvento(EventoDao eventoDao) {

        eventoDao.mostraEvento();

    }
}