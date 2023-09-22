package classes;

public abstract class Ingresso {
    private Evento evento;
    private double preco;
    private TipoIng tipo;

    public Ingresso(Evento evento, double preco, TipoIng tipo) {
        this.evento = evento;
        this.preco = preco;
        this.tipo = tipo;
    }

    public abstract double getPreco();
}
