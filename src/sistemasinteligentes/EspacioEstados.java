/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

import java.util.ArrayList;

/**
 *
 * @author javi
 */
public class EspacioEstados {

    private int[][] estadoTerreno;
    private int Xt; //Parametros posicion tractor
    private int Yt; //Parametros posicion tractor
    private ArrayList accion; //N, S, E, O
    
    public EspacioEstados(int[][] state, ArrayList accion) {
        this.estadoTerreno = state;
        this.accion = accion;
    }

    public boolean fObjetivo(int[][] terrenoActual, Terreno t) {
        boolean objetivo = true;
        for(int i = 0 ; i < terrenoActual.length ; i++){
            for(int j = 0 ; j < terrenoActual[0].length ; j++){
                if(terrenoActual[i][j] != t.getK()){
                    objetivo = false;
                }
            }
        }        
        return objetivo; // En este metodo comprueba si el estado del terreno actual 
        //corresponde con el estado del terreno final,         
    }

    /*public void movimientoTractor() {
        //Se supone que se ha de mover el tractor en las direcciones indicadas, norte, sur, este y oeste, para ello 
        //hay que "moverlo" por la matriz, siendo las posiciones Xt, Yt las indicadas para ello
    }*/
    
    public void sacarSucesores(){        
        
    }
    
    public void copiaTerreno(){
        
    }
    
    public int[][] getEstadoTerreno() {
        return estadoTerreno;
    }

    public ArrayList getAccion() {
        return accion;
    }
}
