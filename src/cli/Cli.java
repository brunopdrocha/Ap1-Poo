package cli;

import java.time.LocalDate;
import java.util.Scanner;

import dao.EventoDao;
import entidades.evento.Evento;
import entidades.evento.Jogo;
import entidades.evento.Show;
import entidades.ingresso.IngExposicao;
import entidades.ingresso.IngJogo;
import entidades.ingresso.IngShow;
import entidades.ingresso.Ingresso;
import entidades.ingresso.TipoIngresso;

public class Cli {
    public static int executar() {
        EventoDao Evento = new EventoDao();
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
                    atualizarEvento(leitor, Evento);
                    break;
                case 3:
                    ExibirIngressosRestantes(Evento, leitor);
                    break;
                case 4:
                    venderIngresso(Evento, leitor);
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
        System.out.println("2 - Atualiza data e local sem perder as outras informacoes;");
        System.out.println("3 - Exibir ingressos restantes;");
        System.out.println("4 - Vender um ingresso;");
        System.out.println("5 - Busca Evento Pelo nome;");
        System.out.println("6 - Remove Evento Pelo nome;");
        System.out.println("7 - Exibe todos  os Eventos;");
    }

    private static void venderIngresso(EventoDao eventoDao, Scanner leitor) {
        if (eventoDao == null) {
            System.out.println("Evento ainda não foi cadastrado!");
            return;
        }

        System.out.println("Escolha o evento que deseja comprar pelo nome: ");
        String nomeEvento = leitor.next();
        Evento eventoEscolhido = eventoDao.buscaEvento(nomeEvento);

        if (eventoEscolhido == null) {
            System.out.println("Evento não encontrado!");
            return;
        }

        TipoIngresso tipoIngresso = null;
        int quantidade = 0;
        Ingresso ingresso = null;

        System.out.print("Informe o tipo do ingresso (meia ou inteira): ");
        String tipo = leitor.next();
        if (tipo.equals("meia") || tipo.equals("inteira")) {
            if (tipo.equals("meia")) {
                tipoIngresso = TipoIngresso.MEIA;
            } else {
                tipoIngresso = TipoIngresso.INTEIRA;
            }
        } else {
            System.out.println("Tipo selecionado inválido!");
            return;
        }

        System.out.print("Informe quantos ingressos você deseja: ");
        if (leitor.hasNextInt()) {
            quantidade = leitor.nextInt();
            if (quantidade <= 0) {
                System.out.println("A quantidade deve ser maior que zero!");
                return;
            }
        } else {
            System.out.println("Quantidade inválida!");
            return;
        }

        if (eventoEscolhido.isIngressoDisponivel(tipoIngresso, quantidade)) {
            if (eventoEscolhido instanceof Jogo) {
                int percentual = 0;
                System.out.print("Informe o percentual do desconto de sócio torcedor: ");
                if (leitor.hasNextInt()) {
                    percentual = leitor.nextInt();
                } else {
                    System.out.println("Percentual inválido!");
                    return;
                }
                ingresso = new IngJogo(eventoEscolhido, tipoIngresso, percentual);
            } else if (eventoEscolhido instanceof Show) {
                String localizacao;
                System.out.print("Informe a localização do ingresso (pista ou camarote): ");
                localizacao = leitor.next();
                if (localizacao.equals("pista") || localizacao.equals("camarote")) {
                    ingresso = new IngShow(eventoEscolhido, tipoIngresso, localizacao);
                } else {
                    System.out.println("Localização inválida!");
                    return;
                }
            } else {
                String desconto;
                System.out.print("Informe se possui desconto social (s/n): ");
                desconto = leitor.next();
                if (desconto.equals("s") || desconto.equals("n")) {
                    ingresso = new IngExposicao(eventoEscolhido, tipoIngresso, desconto.equals("s"));
                } else {
                    System.out.println("Opção inválida!");
                    return;
                }
            }

            eventoEscolhido.venderIngresso(tipoIngresso, quantidade);

            System.out.println("Ingresso vendido com sucesso!");
        } else {
            System.out.println("Não há ingressos disponíveis desse tipo!");
        }
    }

    private static void atualizarEvento(Scanner leitor, EventoDao eventoDao) {
        System.out.println("Informe o nome do evento que deseja atualizar: ");
        String nome = leitor.next();

        Evento evento = eventoDao.buscaEvento(nome);

        if (evento == null) {
            System.out.println("Evento não encontrado!");
            return;
        }

        System.out.println("Informe a nova data do evento (dd mm aaaa): ");
        if (leitor.hasNextInt()) {
            int dia = leitor.nextInt();

            if (leitor.hasNextInt()) {
                int mes = leitor.nextInt();

                if (leitor.hasNextInt()) {
                    int ano = leitor.nextInt();
                    LocalDate novaData = LocalDate.of(ano, mes, dia);

                    System.out.println("Informe o novo local do evento: ");
                    String novoLocal = leitor.next();

                    eventoDao.atualizarEvento(nome, novaData, novoLocal);
                    System.out.println("Evento atualizado com sucesso!");
                }
            }
        }
    }

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

        try {
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
            } else if (tipo.equals("jogo")) {
                String esporte, casa, adversario;

                System.out.print("Informe o esporte: ");
                esporte = leitor.next();
                System.out.print("Informe a equipe da casa: ");
                casa = leitor.next();
                System.out.print("Informe a equipe adversária: ");
                adversario = leitor.next();

                eventoDao.addEvento(nome, data, local, ingMeia, ingInteira, preco, esporte, casa, adversario);
            } else if (tipo.equals("exposicao")) {
                int idadeMin, duracao;

                System.out.print("Informe a idade mínima para entrar na exposição: ");
                idadeMin = leitor.nextInt();
                System.out.print("Informe a duração em dias da exposição: ");
                duracao = leitor.nextInt();

                eventoDao.addEvento(nome, data, local, ingMeia, ingInteira, preco, idadeMin, duracao);
            } else {
                System.out.println("Tipo de evento inválido.");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de fornecer o tipo correto de dados.");
        } catch (java.time.DateTimeException e) {
            System.out.println("Erro: Data inválida. Certifique-se de fornecer uma data válida.");
        } catch (Exception e) {
            System.out.println("Erro desconhecido: " + e.getMessage());
        } finally {
            leitor.nextLine();
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

    public static void ExibirIngressosRestantes(EventoDao evDao, Scanner sc){
        if (evDao == null) {
            System.out.println("Evento ainda não foi cadastrado!");
        }

        System.out.println("Digite o nome de evento que deseja saber a qtd de ingressos restantes: ");
        String nomeEvento = sc.next();
        Evento eventoEscolhido = evDao.encontraEvento(nomeEvento);

        if (eventoEscolhido == null) {
            System.out.println("Evento não encontrado!");
        }
        eventoEscolhido.IngressosRestantes();
    }
}