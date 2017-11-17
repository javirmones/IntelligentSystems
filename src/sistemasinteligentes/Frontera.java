package sistemasinteligentes;

import java.util.PriorityQueue;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llanos, Javier Monescillo Buitrón
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
