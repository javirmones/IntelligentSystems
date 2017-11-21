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
        Problema problema = new Problema();
        Estado ei = new Estado();
        boolean salir = false;
        System.out.println("\n----Práctica Sistemas Inteligentes----\n");
        do {
            int condicion = leer.entero("Seleccione de que modo quiere generar el terreno: \n"
                    + "1.\t Generacion mediante teclado\n"
                    + "2.\t Generacion mediante fichero\n"
                    + "3.\t Salir\n");
            switch (condicion) {
                case 1:
                    ei = o.cargarDatosTeclado();                    
                    MatricesOperaciones.mostrar(ei.getTerreno());
                    
                    f.escrituraFichero(ei);
                    
                    problema = new Problema(ei);
                    
                    primeraLLamada(problema);
                    break;
                case 2:
                    ei = f.cargarDatosFichero();                    
                    MatricesOperaciones.mostrar(ei.getTerreno());
                    
                    problema = new Problema(ei);
                    
                    primeraLLamada(problema);
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

    public void primeraLLamada(Problema p){
        Estado es = p.getEstadoInicial();
        espacioEstados ee = new espacioEstados();
        ee.sucesores(es);      
    }

}
