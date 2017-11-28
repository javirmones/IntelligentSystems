package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
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
        this.costo=0;
        this.accion=null;
        this.profundidad=0;
        this.padre=null;        
    }
    
    public Nodo(Estado estado, int costo, String accion, int valor, int profundidad, Nodo padre){
        this.estado = estado;
        this.costo = costo;
        this.accion = accion;
        this.valor = valor;
        this.profundidad = profundidad;
        this.padre = padre;
    }
    
    public Estado getEstado(){
        return this.estado;
    }
    
    public void setEstado(Estado estado){
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

}
