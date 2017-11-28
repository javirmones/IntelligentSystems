package sistemasinteligentes;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
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
                    ei = o.cargarDatosTeclado(); //Carga el estado inicial mediante teclado
                    MatricesOperaciones.mostrar(ei.getTerreno());
                    
                    f.escrituraFichero(ei);
                    
                    problema = new Problema(ei);
                    
                    inicializar(problema);
                    break;
                case 2:
                    ei = f.cargarDatosFichero(); //Carga el estado inicial mediante fichero                  
                    MatricesOperaciones.mostrar(ei.getTerreno());
                    
                    problema = new Problema(ei);
                    
                    inicializar(problema);
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

    public void inicializar(Problema p){
        boolean solucion;
        ArrayList<Sucesor> listaSucesores = new ArrayList();
        ArrayList<Nodo> listaNodos = new ArrayList();
        ArrayList<Nodo> nodosVisitados = new ArrayList();
        int profMax = 20;
        
        Estado estadoInicial= p.getEstadoInicial(); 
        
        Frontera frontera = new Frontera();
        frontera.crearFrontera(); //Creamos una frontera vacia
        
        Nodo nodoRaiz = new Nodo(estadoInicial); //Creamos el nodo raiz 
        
        frontera.insertarNodo(nodoRaiz); //Insertamos el nodo raiz en la frontera
        
        solucion = false; //Inicializamos solucion
        Nodo nodoActual = null; //Inicializamos el nodo nodoActual
        while(!solucion && !frontera.esVacia()){
            nodoActual = cogerNodo(frontera);
            nodosVisitados.add(nodoActual);
            if(p.fObjetivo(nodoActual.getEstado(), 5)){
                solucion = true;
            }else{
                listaSucesores = p.sucesores(nodoActual.getEstado());
                listaNodos = crearNodos(listaSucesores,nodoActual, profMax);
                frontera.insertarLista(listaNodos);
            }
        }
        
        if(solucion){
            crearSolucion(nodoActual);
        }else{
            solucion = false;
        }
    } 
    
    public ArrayList crearNodos(ArrayList<Sucesor> listaSucesores, Nodo padre, int profundidadMax){
        ArrayList<Nodo> listaNodos = new ArrayList();
        for(int i = 0 ; i<listaSucesores.size() ; i++){
            Nodo nuevoNodo = new Nodo(listaSucesores.get(i).getEstado(),listaSucesores.get(i).getCoste(),
            listaSucesores.get(i).getAccion(),padre.getCosto()+listaSucesores.get(i).getCoste(),
            padre.getProfundidad()+1,padre);
            listaNodos.add(nuevoNodo);
        }
        return listaNodos;
    }
    
    public Nodo cogerNodo(Frontera frontera){
        Nodo nodo = frontera.eliminarNodo();
        return nodo;
    }
    
    public void crearSolucion(Nodo nodo){
        
    }
    
}
