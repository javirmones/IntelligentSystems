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

import java.util.Random;
import utilidades.leer;
public class SistemasInteligentes {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        Terreno t = datosTeclado();
        System.out.println(t.toString());
        mostrarTerreno(t);
        rellenarTerreno(t);
        mostrarTerreno(t);
    }
    
    public static Terreno datosTeclado() throws Exception{
        int Columnas = leer.entero("Introduzca las columnas del terreno");
        int Filas = leer.entero("Introduzca el número de filas del terreno");
        int Yt = leer.entero("Introduzca la posición del tractor en las columnas", 0, Columnas);
        int Xt = leer.entero("Introduzca la posición del tractor en las filas", 0, Filas);
        int max = leer.entero("Introduzca el peso máximo para una casilla");
        int K = leer.entero("Introduzca el peso recomendado para una casilla", 0, max);
        
        Terreno t = new Terreno(Xt, Yt, K, max, Columnas, Filas);
        return t;
    }
    public static void mostrarTerreno(Terreno t){
	for(int i=0; i < t.getColumnas(); i++){
            for(int j=0; j < t.getFilas(); j++)
		System.out.print(" "+ t.terreno[i][j]+ " ");
            System.out.println();
	}
	System.out.println();
    }
    
    public static void rellenarTerreno(Terreno t){
        Random rnd = new Random();
        do
	for(int i=0; i < t.getColumnas(); i++){
            for(int j=0; j < t.getFilas(); j++){
                if (t.getRestante() > t.getMax()){
                    int peso = rnd.nextInt(t.getMax());
                    if(t.terreno[i][j] + peso <= t.getMax()){
                        t.terreno[i][j] += peso;
                        int nuevoRestante = t.getRestante() - peso;
                        t.setRestante(nuevoRestante);
                    }
                }
                else{
                    t.terreno[i][j] = t.getRestante();
                    t.setRestante(0);
                }
            }        
        }
        while(t.getRestante() != 0);
    }
    
}
