package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 *
 */
import utilidades.*;
import java.util.*;
import ficheros.Ficheros;
import ficheros.Teclado;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public void principal() throws Exception {
        Teclado o = new Teclado();
        Ficheros f = new Ficheros();
        Problema problema;
        Estado ei;
        boolean salir = false;

        System.out.println("\n----Práctica Sistemas Inteligentes----\n");
        do {
            int condicion = leer.entero("Seleccione de que modo quiere generar el terreno: \n"
                    + "1.\t Generacion mediante teclado\n"
                    + "2.\t Generacion mediante fichero\n"
                    + "3.\t Salir\n");
            switch (condicion) {
                case 1:
                    ei = o.cargarDatosTeclado(); //Carga el estado inicial mediante teclado
                    MatricesOperaciones.mostrar(ei.getTerreno());

                    f.escrituraFichero(ei);

                    problema = new Problema(ei);

                    seleccionEstrategia(problema);
                    break;
                case 2:
                    ei = f.cargarDatosFichero(); //Carga el estado inicial mediante fichero                  
                    MatricesOperaciones.mostrar(ei.getTerreno());

                    problema = new Problema(ei);

                    seleccionEstrategia(problema);
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

    public void seleccionEstrategia(Problema p) {
        int profMax = leer.entero("Elige la profundidad maxima");
        int estrategia = leer.entero("Elige la estrategia:\n1.\tAnchura\n2.\tProfundidad Iterativa\n3.\tProf.Acotada\n"
                + "4.\tProf.Simple\n5.\tCosto Uniforme\n6.\tA*");

        switch (estrategia) {
            case 1:
                busquedaAcotada("Anchura", profMax, p);
                break;
            case 2:
                int incProf = leer.entero("Introduce el incremento de profundidad");
                busqueda("CualquierProfundidad", profMax, incProf, p);
                break;
            case 3:
                busquedaAcotada("CualquierProfundidad", profMax, p);
                break;
            case 4:
                busquedaAcotada("CualquierProfundidad", profMax, p);
                break;
            case 5:
                busquedaAcotada("Costo", profMax, p);
                break;
            case 6:
                busquedaAcotada("A*", profMax, p);
                break;
            default:
                System.out.println("Introduzca una opción correcta.");
                break;
        }
    }

    public boolean busqueda(String estrategia, int profMax, int incProf, Problema p) {
        int profActual = incProf;
        boolean solucion = false;

        while (!solucion && profActual <= profMax) {
            solucion = busquedaAcotada(estrategia, profActual, p);
            profActual += incProf;
        }
        return solucion;
    }

    public boolean busquedaAcotada(String estrategia, int profMax, Problema p) {

        ArrayList<Sucesor> listaSucesores = new ArrayList();
        ArrayList<Nodo> listaNodos = new ArrayList();
        ArrayList<Nodo> nodosVisitados = new ArrayList();
        boolean solucion = false;

        Frontera frontera = new Frontera(); //Creacion de la frontera
        frontera.crearFrontera();

        Nodo raiz = new Nodo(p.getEstadoInicial());
        frontera.insertarNodo(raiz); //Inclusion de la raiz en la frontera

        Nodo nodoActual = null;

        while (!solucion && !frontera.esVacia()) {
            nodoActual = frontera.eliminarNodo();
            nodosVisitados.add(nodoActual);
            if (p.fObjetivo(nodoActual.getEstado(), p.getEstadoInicial().getK())) {
                solucion = true;
            } else {
                if (nodoActual.getProfundidad() <= profMax) {
                    listaSucesores = p.sucesores(nodoActual.getEstado());
                    listaNodos = crearNodos(listaSucesores, nodoActual, profMax, estrategia);
                    frontera.insertarLista(listaNodos);
                }
            }
        }
        if (solucion) {
            System.out.println("Se ha encontrado una solución.");
            crearSolucion(nodoActual, estrategia);
            return true;
        } else {
            System.out.println("No se ha encontrado una solución");
            return false;
        }
    }

    public ArrayList crearNodos(ArrayList<Sucesor> listaSucesores, Nodo padre, int profundidadMax, String estrategia) {
        ArrayList<Nodo> listaNodos = new ArrayList();
        for (int i = 0; i < listaSucesores.size(); i++) {
            //  if (estrategia == "A") {
            //Calculo de la heuristica es decir introducir un nodo nuevo igual, lo que discuto es la lista de nodos
            //  }
            Nodo nuevoNodo = new Nodo(listaSucesores.get(i).getEstado(), listaSucesores.get(i).getCoste(),
                    listaSucesores.get(i).getAccion(), padre.getCosto() + listaSucesores.get(i).getCoste(),
                    padre.getProfundidad(), padre, estrategia);
            listaNodos.add(nuevoNodo);
        }
        return listaNodos;
    }

    public void crearSolucion(Nodo n, String estrategia) {
        Stack<String> stack = new Stack<>();
        int profundidad = n.getProfundidad();
        int costo = n.getCosto();

        for (int i = 0; i < profundidad; i++) { // Introducimos el conjunto de acciones en la pila para darle la vuelta.
            stack.push(n.getAccion());
            n = n.getPadre();
        }
        try {
            File archivo = new File("solucion.txt"); //Creacion del archivo de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Estrategia utilizada: " + estrategia + "\nProfundidad: " + profundidad + "\nCoste: " + costo + "\n");

            for (int j = 0; j < profundidad; j++) { //Escribe todos los datos importantes y las acciones para llegar a la solucion
                bw.write(stack.pop() + "\n");
            }
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Problema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
