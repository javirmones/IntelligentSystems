/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

/**
 *
 * @author absit
 */
public class Problema {
    
    private Terreno terreno;
    private EspacioEstados espacioEstados;
    private Estado estadoInicial;
    
    public Problema(Terreno t, EspacioEstados espacioEstados){
        this.terreno = terreno;
        this.espacioEstados = espacioEstados;
        estadoInicial = new Estado(terreno.getTerreno(), terreno.getXt(), terreno.getYt());
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public EspacioEstados getEspacioEstados() {
        return espacioEstados;
    }

    public void setEspacioEstados(EspacioEstados espacioEstados) {
        this.espacioEstados = espacioEstados;
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
