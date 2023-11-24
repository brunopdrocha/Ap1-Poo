package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import entidades.evento.Evento;
import entidades.evento.Exposicao;
import entidades.evento.Show;
import entidades.evento.Jogo;

public class EventoDao {
    private ArrayList<Evento> eventos = new ArrayList<>();

    // Adiconar Exposicao
    public void addEvento(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira,
            double precoCheio, int faixaEtariaMinima, int duracaoDias) {
        eventos.add(new Exposicao(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, faixaEtariaMinima,
                duracaoDias));

    }

    // Adicionar Show
    public void addEvento(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira,
            double precoCheio, String artista, String genero) {
        eventos.add(new Show(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, artista, genero));
    }

    // Adicionar Jogo
    public void addEvento(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira,
            double precoCheio, String esporte, String casa, String adv) {
        eventos.add(new Jogo(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, esporte, casa, adv));
    }

    public void removeEvento(String nome) {
        eventos.removeIf(eventos -> eventos.getNome().equals(nome));

        System.out.println("Evento " + nome + " foi removido");
    }

    public void atualizarEvento(String nome, LocalDate novoData, String novoLocal) {
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nome)) {
                evento.setData(novoData);
                evento.setLocal(novoLocal);
                break;
            }
        }
    }

    // Exibir Eventos
    public void mostraEvento() {
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    public Evento encontraEvento(String nome){
        if (eventos.isEmpty()){
            System.out.println("Nenhum evento cadastrado");
            return null;
        }
        for (Evento evento : eventos){
            if (evento.getNome().equals(nome)) {
                System.out.println("Evento encontrado:");
                return evento;
            }

        }
        return null;
    }

    // Exibir Evento Expecifico
    public Evento buscaEvento(String nome) {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado");
            return null;
        }

        for (Evento evento : eventos) {
            if (evento.getNome().equals(nome)) {
                System.out.println("Evento encontrado:");
                System.out.println(evento);
                return evento; // Retorna o evento encontrado
            }
        }

        System.out.println("Evento não encontrado");
        return null; // Retorna null se o evento não for encontrado
    }

    // salvar eventos em um arquivo
    public void salvarEventosEmArquivo() {
        String nomeArquivo = "eventos.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (Evento evento : eventos) {
                writer.write(evento.toString()); 
                writer.newLine(); 
            }
            System.out.println("Eventos salvos em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar eventos no arquivo.");
            e.printStackTrace();
        }
    }

}
