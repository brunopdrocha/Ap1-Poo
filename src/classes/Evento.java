package classes;

public abstract class Evento {

    private String nome;
    private String data;
    private String horario;
    private int ingressoInteira;
    private int ingressoMeia;

    Evento(String nome, String data, String horario, int ingressoInteira, int ingressoMeia ) {
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.ingressoInteira = ingressoInteira;
        this.ingressoMeia = ingressoMeia;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getIngressoInteira() {
        return this.ingressoInteira;
    }

    public void setIngressoInteira(int ingressoInteira) {
        this.ingressoInteira = ingressoInteira;
    }

    public int getIngressoMeia() {
        return this.ingressoMeia;
    }

    public void setIngressoMeia(int ingressoMeia) {
        this.ingressoMeia = ingressoMeia;
    }


    public boolean isIngressoDisponivel(TipoIng tipo, int quantidade) {
        if (tipo == TipoIng.inteira) {
            return ingressoInteira >= quantidade;
        } else {
            return ingressoMeia >= quantidade;
        }
    }


    public double venderIngresso(TipoIng tipo, int quantidade) {
        double valorTotal = 0;
        if (isIngressoDisponivel(tipo, quantidade)) {
            if (tipo == TipoIng.inteira) {
                ingressoInteira -= quantidade;
                valorTotal = quantidade * getPrecoInteira();
            } else {
                ingressoMeia -= quantidade;
                valorTotal = quantidade * getPrecoMeia();
            }
        }
        return valorTotal;
    }

    // Métodos pra puxar preço da inteira e meia
    public abstract double getPrecoInteira();
    public abstract double getPrecoMeia();
>>>>>>> a4495cf20cc1b31194c04d8f661d69bc8248fa51
}
