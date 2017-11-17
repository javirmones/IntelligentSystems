package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llanos, Javier Monescillo Buitrón
 **/

public class Problema {
    
    private Terreno terreno;  
    private Estado estadoInicial;
    
    public Problema(Terreno t){
        this.terreno = terreno;
        estadoInicial = new Estado(terreno.getTerreno(), terreno.getXt(), terreno.getYt());
    }
  
    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
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
