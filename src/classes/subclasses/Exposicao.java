package classes.subclasses;

import classes.Evento;
public class Exposicao extends Evento {
    protected int faixaEtariaMinima;
    protected int duracaoDias;
    protected boolean descontoSocial;

    public Exposicao(String nome, String data, String local, int ingressoInteira, int ingressoMeia, double precoCheio, int faixaEtariaMinima
    , int duracaoDias , boolean descontoSocial) {
        super(nome, data, local, ingressoInteira, ingressoMeia, precoCheio);
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.duracaoDias = duracaoDias;
        this.descontoSocial = descontoSocial;
        if (descontoSocial == true){
            precoCheio = 0;
        }
    }

    protected void setdescontoSocial(boolean descontoSocial){
        this.descontoSocial = descontoSocial;
        if (descontoSocial == true){
            this.setPrecoCheio(0);
        }
    }

    protected void setfaixaetariaminima(int faixaEtariaMinima){
        this.faixaEtariaMinima = faixaEtariaMinima;
    }

    protected void setduracaoDias(int duracaoDias){
        this.duracaoDias = duracaoDias;
    }

    protected boolean getdescontoSocial(){
        return descontoSocial;
    }

    protected int getfaixaetariaminima(){
        return faixaEtariaMinima;
    }

    protected int getduracaoDias(){
        return duracaoDias;
    }
   
}
