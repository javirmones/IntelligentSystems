package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llanos, Javier Monescillo Buitrón
 **/

public class Nodo {

    private Estado estado;
    private int costo;
    private String accion;
    private int valor;
    private int profundidad;
    private Nodo padre;

    public Nodo(Estado ep) { //Construccion del nodo raiz
        this.estado=ep;
        costo=0;
        accion=null;
        profundidad=0;
        padre=null;        
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

}
