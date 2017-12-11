package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 **/
public class Vecino implements Cloneable {

    private int posX;
    private int posY;
    private int max;
    private int valor;
    private int valorDistribuir;

    public Vecino() {
        //Constructor vacio
    }

    public Vecino(int posX, int posY, int max, int valor, int valorDistribuir) {
        this.posX = posX;
        this.posY = posY;
        this.max = max;
        this.valor = valor;
        this.valorDistribuir = valorDistribuir;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getMax() {
        return max;
    }

    public int getValor() {
        return valor;
    }

    public int getValorDistribuir() {
        return valorDistribuir;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setValorDistribuir(int valorDistribuir) {
        this.valorDistribuir = valorDistribuir;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }

    @Override
    public String toString() {
        return "(" + valorDistribuir + ",(" + posX + ", " + posY + "))";
    }
}
