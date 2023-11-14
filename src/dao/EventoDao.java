package dao;

import java.util.ArrayList;

import entidades.evento.Evento;
import entidades.evento.Exposicao;
import entidades.evento.Show;
import entidades.evento.Jogo;

public class EventoDao {
    private ArrayList<Evento> eventos = new ArrayList<>();
    
    // Adiconar Exposicao
    public void addEvento(String nome, String data, String local, int ingressosMeia, int ingressosInteira, double precoCheio, int faixaEtariaMinima, int duracaoDias) {
        eventos.add(new Exposicao(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, faixaEtariaMinima, duracaoDias));
    
    }
    // Adicionar Show
    public void addEvento(String nome, String data, String local, int ingressosMeia, int ingressosInteira, double precoCheio, String artista, String genero) {
        eventos.add(new Show(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, artista, genero));
    }
    
    // Adicionar Jogo
    public void addEvento(String nome, String data, String local, int ingressosMeia, int ingressosInteira, double precoCheio, String esporte, String casa, String adv) {
        eventos.add(new Jogo(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, esporte, casa, adv));
    }

    public void removeEvento(String nome){
        eventos.removeIf(eventos -> eventos.getNome().equals(nome));
    }

    public void atualizarEvento(String nome,String novoData,String novoLocal){
        for(Evento evento : eventos){
            if(evento.getNome().equals(nome)){
                evento.setData(novoData);
                evento.setLocal(novoLocal);
                break;
            }
        }
    }
}