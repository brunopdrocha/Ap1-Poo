package classes.subclasses;

import classes.Evento;

public class Show extends Evento {
    protected String artista;
    protected String generoMusical;

    public Show(String nome, String data , String local, int ingressoInteira , int ingressoMeia
    , double precoCheio, String artista, String generoMusical){
        super(nome, data, local, ingressoInteira, ingressoMeia, precoCheio);
        this.artista = artista;
        this.generoMusical = generoMusical;
    }

    protected void setartista(String artista){
        this.artista = artista;
    }

    protected void setgeneroMusical(String generoMusical){
        this.generoMusical = generoMusical;
    }

    protected String getartista(){
        return artista;
    }

    protected String getgeneroMusical(){
        return generoMusical;
    }

    public enum localingresso{
        pista , camarote
    }
}