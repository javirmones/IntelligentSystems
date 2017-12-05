package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 *
 */
public class Nodo implements Comparable<Nodo> {

    private Estado estado;
    private int costo;
    private String accion;
    private int valor;
    private int profundidad;
    private Nodo padre;
    private int heuristica;

    public Nodo(Estado ep) { //Construccion del nodo raiz
        this.estado = ep;
        this.costo = 0;
        this.accion = null;
        this.profundidad = 0;
        this.padre = null;
        this.heuristica = 0;
    }

    public Nodo(Estado estado, int costo, String accion, int valor, int profundidad, Nodo padre, String estrategia, int heuristica) { //Un nodo cualquiera
        this.estado = estado;
        this.costo = padre.getCosto() + 1; // El costo para pasar de un nodo a otro se incrementa en uno
        this.accion = accion;
        this.valor = valor;
        this.profundidad = profundidad + 1; //Al pasar de un nodo a otro se incrementa la profundidad, es decir cuando se genera un nodo nuevo por otro
        this.padre = padre;
        this.heuristica = heuristica;

        switch (estrategia) { //Segun la estrategia elegida se toman distintos valores
            case "Anchura":
                this.valor = profundidad;
                break;
            case "CualquierProfundidad":
                this.valor = -profundidad;
                break;
            case "Costo":
                this.valor = costo;
                break;
            case "A*":
                this.valor = costo + heuristica; //Sacar heurística
                break;
        }
    }

    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getAccion() {
        return this.accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getCosto() {
        return this.costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getProfundidad() {
        return this.profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public Nodo getPadre() {
        return this.padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public int compareTo(Nodo e) {
        int r = 0;
        if (e.getValor() < getValor()) {
            r = +1;
        } else if (e.getValor() > getValor()) {
            r = -1;
        }
        return r;
    }
}
