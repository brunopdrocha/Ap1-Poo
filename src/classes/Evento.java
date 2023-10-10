package classes;

public abstract class Evento {
    private String nome;
    private String data;
    private String local;
    private int ingressoInteira;
    private int ingressoMeia;
    private double precoCheio;

    public Evento(String nome, String data, String local, int ingressoInteira, int ingressoMeia, double precoCheio) {
        this.nome = nome;
        this.data = data;
        this.ingressoInteira = ingressoInteira;
        this.ingressoMeia = ingressoMeia;
        this.local = local;
        this.precoCheio = precoCheio;
    }

    // Métodos

    public boolean isIngressoDisponivel(TipoIng tipo, int quantidade) {
        if (tipo == TipoIng.inteira && quantidade >0) {
            return true;
        } else if (tipo == TipoIng.meia && quantidade >0) {
            return true;
        }
        return false; // Retorna false se o tipo de ingresso não for reconhecido
    }
    
    //Corrigir vender Ingresso pois esta acumalando mais de 1 INGRESSO
    public double venderIngresso(TipoIng tipo, int quantidade) {
        double valorTotal = 0;
        if (tipo == TipoIng.inteira) {
            ingressoInteira -= quantidade;
            valorTotal = quantidade * getPrecoCheio();
        } else if (tipo == TipoIng.meia ) {
            ingressoMeia -= quantidade;
            valorTotal = quantidade * (getPrecoCheio() / 2); // Preço da meia é metade do preço cheio
        }
        return valorTotal;
    }
    


    // Getters e setters para nome, data, ingressoInteira, ingressoMeia...
    

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

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public double getPrecoCheio() {
        return this.precoCheio;
    }

    public void setPrecoCheio(double precoCheio) {
        this.precoCheio = precoCheio;
    }
    
}