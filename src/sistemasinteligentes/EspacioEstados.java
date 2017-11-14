/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

import java.util.ArrayList;
import utilidades.MatricesOperaciones;

/**
 *
 * @author javi
 */
public class EspacioEstados {

    private Estado estadoActual;
    private ArrayList accion;
    private int coste;
    
    private int[][] estadoTerreno;
    private int originalXt;
    private int originalYt;
    
    
    public EspacioEstados(int[][] state, ArrayList accion, int originalXt, int originalYt) {
        this.estadoTerreno = state;
        this.accion = accion;
        this.originalXt = originalXt;
        this.originalYt = originalYt;
    }
    
    public EspacioEstados(Estado estado, ArrayList accion, int coste){
        this.estadoActual = estado;
        this.accion = accion;
        this.coste = coste;
                 
    }
    
    public ArrayList fSucesores(){                
        ArrayList<Estado> listaEstadosSucesores = new ArrayList();
        ArrayList aux = new ArrayList(); //ArrayList que contiene los datos de una acción
        int [][] copyTerreno = new int [estadoTerreno.length][estadoTerreno[0].length]; //estadoActual        
        int Xt = (int)(accion.get(0).toString().charAt(1) - 48); //Posicion X tractor
        int Yt = (int)(accion.get(0).toString().charAt(4) - 48); //Posicion Y tractor
                
        aux = sacarDatosAccion(aux);                      
        copyTerreno = copiarTerreno(estadoTerreno, copyTerreno);
        
        while(!aux.isEmpty()){            
            int peso = (int) aux.remove(0);
            
            copyTerreno[(int) aux.remove(0)][(int) aux.remove(0)] += peso;
            copyTerreno[originalXt][originalYt] -=peso; //estadoActual
        }
        
        Estado e = new Estado(copyTerreno, Xt, Yt);
        listaEstadosSucesores.add(e);
        /*System.out.println("\nAccion: "+accion);
        System.out.println("Coste:"+accion.get(2).toString());        
        System.out.println(e.toString());*/
        return listaEstadosSucesores;
    }   
    
    public int [][] copiarTerreno(int [][] estadoTerreno, int [][] copyTerreno){
        for(int i = 0 ; i < estadoTerreno.length ; i++){
            for(int j = 0 ; j < estadoTerreno[0].length; j++){
                copyTerreno[i][j] = estadoTerreno[i][j];
            }
        }
        return copyTerreno;
    }
    
    public ArrayList sacarDatosAccion(ArrayList aux){//En este metodo guardamos en un vector los datos que tiene cada accion                
        int contador = 1;
        for(int i = 2 ; i < accion.get(1).toString().length() ; i+=3){            
            aux.add((int)(accion.get(1).toString().charAt(i) - 48));
            if(contador == 3){
                i+=3;
                contador = 0;
            }
            contador++;
        }
        return aux;
    }       
}
