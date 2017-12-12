package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 **/
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
        this.profundidad = 1;
        this.padre = null;
        this.heuristica = 0;
    }
    
    public Nodo(Estado estado, int costo, String accion, int profundidad, Nodo padre, String estrategia, int heuristica) { //Constructor todas estrategias
        this.estado = estado;
        this.costo = costo;
        this.accion = accion;        
        this.profundidad = profundidad;
        this.padre = padre;
        this.heuristica = heuristica;

        switch (estrategia) { //Calculo valor segun estrategia
            case "Anchura":
                this.valor = this.profundidad;
                break;
            case "CualquierProfundidad":
                this.valor = -this.profundidad;
                break;
            case "Costo":
                this.valor = this.costo;
                break;
            case "A*":
                this.valor = this.costo + this.heuristica;
                break;
        }
    }

    
    public Nodo(Estado estado, int costo, String accion, int profundidad, Nodo padre, String estrategia) { //Constructor estrategia A*
        this.estado = estado;
        this.costo = costo;
        this.accion = accion;        
        this.profundidad = profundidad;
        this.padre = padre;
        this.heuristica = calculoHeuristica();

        switch (estrategia) { //Calculo valor segun estrategia
            case "Anchura":
                this.valor = this.profundidad;
                break;
            case "CualquierProfundidad":
                this.valor = -this.profundidad;
                break;
            case "Costo":
                this.valor = this.costo;
                break;
            case "A*":
                this.valor = this.costo + this.heuristica;
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

    private int calculoHeuristica() {
        int heuristica = 0;
        for (int i = 0; i < estado.getFilas(); i++) {
            for (int j = 0; j < estado.getColumnas(); j++) {
                if (estado.getTerreno()[i][j] != estado.getK()) {
                    heuristica++;
                }
            }
        }
        return heuristica;
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
