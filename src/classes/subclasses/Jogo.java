package classes.subclasses;

import classes.Evento;

public class Jogo extends Evento {
    protected String esporte;
    protected String equipe1;
    protected String equipe2;
    protected double percentualDescontoTorcedor;

    public Jogo(String nome, String data, String local, int ingressoInteira, int ingressoMeia
    , double precoCheio, String esporte, String equipe1, String equipe2, double percentualDescontoTorcedor){
        super(nome, data, local, ingressoInteira, ingressoMeia, precoCheio);
        this.equipe1 = equipe1;
        this.equipe2 = equipe1;
        this.esporte = esporte;
        this.percentualDescontoTorcedor = 1 - (percentualDescontoTorcedor/100);
        precoCheio = this.percentualDescontoTorcedor * precoCheio;
    }

    protected void setesporte(String esporte){
        this.esporte = esporte;
    }

    protected void setequipes(String equipe1, String equipe2){
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    protected void setpercentualDescontoTorcedor(double percentualDescontoTorcedor){
        this.percentualDescontoTorcedor = 1 - (percentualDescontoTorcedor/100);
    }

    protected double getpercentualDescontoTorcedor(){
        return  this.percentualDescontoTorcedor;
    }

    @Override
    public void setPrecoCheio(double precoCheio){
        this.precoCheio =  precoCheio * this.percentualDescontoTorcedor;
    }

    protected String getequipe1(){
        return equipe1;
    }

    protected String getequipe2(){
        return equipe2;
    }

    protected String getesporte(){
        return esporte;
    }
}