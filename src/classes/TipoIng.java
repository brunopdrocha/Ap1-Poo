package classes;

public class TipoIng {
    public boolean inteira;
    public boolean meia;

    public TipoIng(boolean inteira,bo meia){
        this.inteira = true;
        this.meia =false;
    }

    public boolean isInteira() {
        return this.inteira;
    }

    public boolean getInteira() {
        return this.inteira;
    }

    public void setInteira(boolean inteira) {
        this.inteira = inteira;
    }

    public boolean isMeia() {
        return this.meia;
    }

    public boolean getMeia() {
        return this.meia;
    }

    public void setMeia(boolean meia) {
        this.meia = meia;
    }

}
