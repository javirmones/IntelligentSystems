package ficheros;


import sistemasinteligentes.Estado;
import utilidades.leer;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 **/
public class Teclado {
    
    public Estado cargarDatosTeclado() throws Exception{

        int Columnas = leer.entero("Introduzca las columnas del terreno");
        int Filas = leer.entero("Introduzca el número de filas del terreno");
        int Yt = leer.entero("Introduzca la posición del tractor en las columnas", 0, Columnas - 1);
        int Xt = leer.entero("Introduzca la posición del tractor en las filas", 0, Filas - 1);
        int max = leer.entero("Introduzca el peso máximo para una casilla");
        int K = leer.entero("Introduzca el peso recomendado para una casilla", 0, max);

        Estado ei = new Estado(Xt, Yt, K, max, Columnas, Filas); //Se genera un pbjeto terreno con los datos introducidos
        ei.rellenarTerreno();

        return ei; //Retornamos el terreno
    }
}
