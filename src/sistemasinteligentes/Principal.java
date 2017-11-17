package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llanos, Javier Monescillo Buitrón
 **/

import utilidades.*;
import java.util.*;
import ficheros.Ficheros;
import ficheros.Teclado;

public class Principal {

    public void principal() throws Exception {
        Teclado o = new Teclado();
        Ficheros f = new Ficheros();
        boolean salir = false;
        System.out.println("\n----Práctica Sistemas Inteligentes----\n");
        do {
            int condicion = leer.entero("Seleccione de que modo quiere generar el terreno: \n"
                    + "1.\t Generacion mediante teclado\n"
                    + "2.\t Generacion mediante fichero\n"
                    + "3.\t Salir\n");
            switch (condicion) {
                case 1:
                    Terreno t = o.cargarDatosTeclado();
                    Estado e = new Estado(t.getTerreno(), t.getXt(), t.getYt());
                    MatricesOperaciones.mostrar(t.getTerreno());
                    f.escrituraFichero(t);
                    e.sucesores(e, t);
                    break;
                case 2:
                    Terreno a = f.cargarDatosFichero();
                    Estado es = new Estado(a.getTerreno(), a.getXt(), a.getYt());
                    MatricesOperaciones.mostrar(a.getTerreno());
                    es.sucesores(es, a);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("El numero no es correcto");
                    break;
            }
        } while (salir == false);
    }

}
