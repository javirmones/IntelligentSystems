/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

import java.util.PriorityQueue;

/**
 *
 * @author javi
 */
public class Frontera {

    private PriorityQueue<Nodo> queue;

    public Frontera() {

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
