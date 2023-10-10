package classes;

public abstract class Ing {
    private Evento evento;
    private TipoIng tipo;

    public Ing(Evento evento, TipoIng tipo) {
        this.evento = evento;
        this.tipo = tipo;
    }

    // Método para obter o preço do ingresso com base no tipo
    public double getPreco() {
        double precoCheio = evento.getPrecoCheio();
        if (tipo == TipoIng.inteira) {
            return precoCheio;
        } else {
            return precoCheio / 2;
        }
    }

    // Getters e Setters
    public Evento getEvento() {
        return this.evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public TipoIng getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoIng tipo) {
        this.tipo = tipo;
    }
}