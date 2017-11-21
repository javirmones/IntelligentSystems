package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llanos, Javier Monescillo Buitrón
 **/

public class Problema {
    
    
    private Estado estadoInicial;
    private espacioEstados espacioEstado;
    
    public Problema(){
        //Constructor vacio
    }
    
    public Problema(Estado ei){
        this.estadoInicial = ei;
    }
  
    public Estado getTerreno() {
        return estadoInicial;
    }

    public void setTerreno(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }    
    
    public boolean fObjetivo(int[][] estadoActual, int k) {       
        boolean objetivo = true;
        for(int i = 0 ; i < estadoActual.length ; i++){
            for(int j = 0 ; j < estadoActual[0].length ; j++){
                if(estadoActual[i][j] != k) objetivo = false;
            }
        }        
        return objetivo;         
    }
}
