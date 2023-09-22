package classes;

public abstract class Evento {
    String nomeEvento, dataEvento, localEvento;
    int qtdIngresso;

    public Evento() {
    }

    public String getNomeEvento() {
        return this.nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDataEvento() {
        return this.dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLocalEvento() {
        return this.localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public int getQtdIngresso() {
        return this.qtdIngresso;
    }

    public void setQtdIngresso(int qtdIngresso) {
        this.qtdIngresso = qtdIngresso;
    }



}
