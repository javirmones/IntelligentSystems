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
    private int originalXt;
    private int originalYt;
    private ArrayList accion;
    
    public EspacioEstados(int[][] state, ArrayList accion, int originalXt, int originalYt) {
        this.estadoTerreno = state;
        this.accion = accion;
        this.originalXt = originalXt;
        this.originalYt = originalYt;
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
    
    public void fSucesores(){        
        //Sacamos posicion tractor
        Xt = (int)(accion.get(0).toString().charAt(1) - 48);
        Yt = (int)(accion.get(0).toString().charAt(4) - 48);
        ArrayList aux = new ArrayList();
        int contador = 1;
        for(int i = 2 ; i < accion.get(1).toString().length() ; i+=3){            
            aux.add((int)(accion.get(1).toString().charAt(i) - 48));
            if(contador == 3){
                i+=3;
                contador = 0;
            }
            contador++;
        }
        int peso, posx, posy;
        int i = 0;
        boolean salir = false;
        int[][] copyTerreno = new int [estadoTerreno.length][estadoTerreno[0].length];
        copyTerreno = copiarTerreno(estadoTerreno, copyTerreno);
        
        while(salir == false){            
            peso = (int) aux.remove(i);
            posx = (int) aux.remove(i);
            posy = (int) aux.remove(i);
            
            copyTerreno[posx][posy] += peso;
            copyTerreno[originalXt][originalYt] -=peso;
            i = 0;
            if(aux.isEmpty()){
                
                salir = true;
            }
        }                    
        
        System.out.println("\nAccion: "+accion+"\nEstado: \n PosXT: "+Xt+" PosYT: "+Yt+"\n Terreno:");
        mostrarTerreno(copyTerreno);
        System.out.println("Coste:"+accion.get(2).toString());
    }
    
    public static void mostrarTerreno(int [][] t){
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t.length; j++){
                System.out.print(" " + t[i][j] + " ");
            }
            System.out.println();
        }        
    }
    
    public int [][] copiarTerreno(int [][] estadoTerreno, int [][] copyTerreno){
        for(int i = 0 ; i < estadoTerreno.length ; i++){
            for(int j = 0 ; j < estadoTerreno[0].length; j++){
                copyTerreno[i][j] = estadoTerreno[i][j];
            }
        }
        return copyTerreno;
    }
    
    public int[][] getEstadoTerreno() {
        return estadoTerreno;
    }

    public ArrayList getAccion() {
        return accion;
    }
}
