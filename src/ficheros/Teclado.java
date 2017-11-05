/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;


import sistemasinteligentes.Terreno;
import utilidades.leer;

/**
 *
 * @author absit
 */
public class Teclado {
    
    public Terreno cargarDatosTeclado() throws Exception{

        int Columnas = leer.entero("Introduzca las columnas del terreno");
        int Filas = leer.entero("Introduzca el número de filas del terreno");
        int Yt = leer.entero("Introduzca la posición del tractor en las columnas", 0, Columnas - 1);
        int Xt = leer.entero("Introduzca la posición del tractor en las filas", 0, Filas - 1);
        int max = leer.entero("Introduzca el peso máximo para una casilla");
        int K = leer.entero("Introduzca el peso recomendado para una casilla", 0, max);

        Terreno t = new Terreno(Xt, Yt, K, max, Columnas, Filas); //Se genera un pbjeto terreno con los datos introducidos
        t.rellenarTerreno();

        return t; //Retornamos el terreno
    }
}
