package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 **/
public class Sucesor {
    
    private String accion;
    private Estado estado;
    private int coste;
    
    public Sucesor(String accion, Estado estado, int coste){
        this.accion = accion;
        this.estado = estado;
        this.coste = coste;
    }

    public String getAccion() {
        return accion;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getCoste() {
        return coste;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }        
    
    @Override
    public String toString(){
        return "\nAccion: "+accion+" "+estado.toString()+"Coste: "+coste;
    }
}
