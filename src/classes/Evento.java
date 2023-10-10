package classes;

public abstract class Evento {
    private String nome;
    private String data;
    private String local;
    private int ingressoInteira;
    private int ingressoMeia;
    private double precoCheio;
    private double precoTotal;
    private int tipoIngresso;

    public int getTipoIngresso() {
        return this.tipoIngresso;
    }

    public void setTipoIngresso(int tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public double getPrecoTotal() {
        return this.precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Evento() {
        super();
    }

    public Evento(String nome, String data, String local, int ingressoInteira, int ingressoMeia, double precoCheio) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressoInteira = ingressoInteira;
        this.ingressoMeia = ingressoMeia;
        this.precoCheio = precoCheio;
    }

    public boolean isIngressoDisponivel(TipoIng tipo, int quantidade) {
        if (tipo == TipoIng.inteira) {
            return this.ingressoInteira >= quantidade && quantidade > 0;
        } else if (tipo == TipoIng.meia) {
            return this.ingressoMeia >= quantidade && quantidade > 0;
        }
        return false; // Tipo de ingresso não reconhecido
    }

    public double venderIngresso(TipoIng tipo, int quantidade) {
        double valorTotal = 0;
        if (tipo == TipoIng.inteira && isIngressoDisponivel(TipoIng.inteira, quantidade)) {
            this.ingressoInteira -= quantidade;
            valorTotal = quantidade * this.precoCheio;
        } else if (tipo == TipoIng.meia && isIngressoDisponivel(TipoIng.meia, quantidade)) {
            this.ingressoMeia -= quantidade;
            valorTotal = quantidade * (this.precoCheio / 2);
        }
        return valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIngressoInteira() {
        return ingressoInteira;
    }

    public void setIngressoInteira(int ingressoInteira) {
        this.ingressoInteira = ingressoInteira;
    }

    public int getIngressoMeia() {
        return ingressoMeia;
    }

    public void setIngressoMeia(int ingressoMeia) {
        this.ingressoMeia = ingressoMeia;
    }

    public double getPrecoCheio() {
        return precoCheio;
    }

    public void setPrecoCheio(double precoCheio) {
        this.precoCheio = precoCheio;
    }
}
