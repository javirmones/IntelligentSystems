package sistemasinteligentes;

import java.util.ArrayList;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
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
    
    public ArrayList sucesores(Estado estado){
        ArrayList<Sucesor> listaSucesores = espacioEstado.sucesores(estado);
        return listaSucesores;
    }
    
    public boolean fObjetivo(Estado estado, int k) {       
        boolean objetivo = true;
        for(int i = 0 ; i < estado.getTerreno().length ; i++){
            for(int j = 0 ; j < estado.getTerreno()[0].length ; j++){
                if( estado.getTerreno()[i][j] != k) objetivo = false;
            }
        }        
        return objetivo;         
    }
}
