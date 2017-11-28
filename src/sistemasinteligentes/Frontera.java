package sistemasinteligentes;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 **/

public class Frontera {

    private PriorityQueue<Nodo> queue;

    public Frontera() {
        //Constructor vacio
    }

    public void crearFrontera() {
        queue = new PriorityQueue<Nodo>();
    }

    public void insertarNodo(Nodo n) {
        queue.add(n);
    }

    public void insertarLista(ArrayList<Nodo> lista){
        for(int i = 0 ; i<lista.size() ; i++){
            queue.add(lista.get(i));
        }
    }
    
    public Nodo eliminarNodo() {
        Nodo n = queue.remove();
        return n;
    }

    public boolean esVacia() {
        return queue.isEmpty();
    }

    public int tamanoFrontera() {
        return queue.size();
    }
}
