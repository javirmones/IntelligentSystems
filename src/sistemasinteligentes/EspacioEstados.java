/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

/**
 *
 * @author javi
 */
public class EspacioEstados {

    private int[][] estadoTerreno;
    private int Xt;
    private int Yt;
    private String accion; //N, S, E, O

    public EspacioEstados(int[][] state, String accion) {

    }

    public boolean fObjetivo(int[][] terrenoFinal) {
        return false; // En este metodo lo que hay que hacer, es comprobar si el estado del terreno final, 
        //correponde con el estado del terreno actual, que es la variable estadoTerreno
    }

    public void movimientoTractor() {
        //Se supone que se ha de mover el tractor en las direcciones indicadas, norte, sur, este y oeste, para ello 
        //hay que "moverlo" por la matriz, siendo las posiciones Xt, Yt las indicadas para ello
    }

    public int[][] getEstadoTerreno() {
        return estadoTerreno;
    }

    public String getAccion() {
        return accion;
    }
}
