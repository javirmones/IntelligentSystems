package sistemasinteligentes;

import java.util.ArrayList;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 *
 */
public class Distribucion {

    public ArrayList inicioDistribucion(Estado e) {
        int[][] aux = e.getTerreno(); //Matriz auxiliar para sacar s
        int s = aux[e.getXt()][e.getYt()] - e.getK(); //Cantidad que se puede distribuir

        ArrayList<Vecino> vecinos = generarVecinos(e); //Array que guarda y genera las casillas adyacentes del tractor
        ArrayList<ArrayList> todasDistribuciones = new ArrayList(); //Array que guarda todas las distribuciones posibles

        distribucion(0, s, s, vecinos, todasDistribuciones); //Saca todas las distribuciones posibles en los vecinos

        ArrayList<ArrayList> todasAcciones = new ArrayList(); //Array que saca las acciones a partir de las distribuciones
        todasAcciones = accion(todasDistribuciones, vecinos, e); //Saca todas las acciones posibles (MovTractor, Distribucion, Coste)-->ACCION

        return todasAcciones;
    }

    private ArrayList generarVecinos(Estado e) {
        int[][] aux = e.getTerreno();
        ArrayList<Vecino> vecino = new ArrayList();
        if (e.getXt() - 1 >= 0) {
            Vecino vec1 = new Vecino(e.getXt() - 1, e.getYt(), e.getMax(), aux[e.getXt() - 1][e.getYt()], 0);
            vecino.add(vec1);
        }
        if (e.getXt() + 1 < e.getFilas()) {
            Vecino vec2 = new Vecino(e.getXt() + 1, e.getYt(), e.getMax(), aux[e.getXt() + 1][e.getYt()], 0);
            vecino.add(vec2);
        }
        if (e.getYt() - 1 >= 0) {
            Vecino vec3 = new Vecino(e.getXt(), e.getYt() - 1, e.getMax(), aux[e.getXt()][e.getYt() - 1], 0);
            vecino.add(vec3);
        }
        if (e.getYt() + 1 < e.getColumnas()) {
            Vecino vec4 = new Vecino(e.getXt(), e.getYt() + 1, e.getMax(), aux[e.getXt()][e.getYt() + 1], 0);
            vecino.add(vec4);
        }
        return vecino;
    }

    private void distribucion(int etapa, int k, int actual, ArrayList<Vecino> vecinos, ArrayList<ArrayList> todasDistribuciones) {
        if (etapa == vecinos.size()) {
            if (esSolucion(k, vecinos)) {
                ArrayList<Vecino> list = new ArrayList();
                for (int i = 0; i < vecinos.size(); i++) {
                    Vecino vec = (Vecino) vecinos.get(i).clone();
                    list.add(vec);
                }
                todasDistribuciones.add(list);
            }
        } else {
            for (int j = 0; j <= actual; j++) {
                if (esPosible(j, vecinos.get(etapa))) {
                    vecinos.get(etapa).setValorDistribuir(j);
                    distribucion(etapa + 1, k, actual - j, vecinos, todasDistribuciones);
                }
            }
        }
    }

    private ArrayList accion(ArrayList<ArrayList> todasDistribuciones, ArrayList<Vecino> vecinos, Estado e) {
        ArrayList todasAcciones = new ArrayList();
        for (int i = 0; i < vecinos.size(); i++) {
            ArrayList<Integer> posicionVecino = new ArrayList();
            posicionVecino.add(vecinos.get(i).getPosX());
            posicionVecino.add(vecinos.get(i).getPosY());
            for (int j = 0; j < todasDistribuciones.size(); j++) {
                ArrayList accion = new ArrayList();
                accion.add(posicionVecino.toString());
                accion.add(todasDistribuciones.get(j));
                todasAcciones.add(accion);
            }
        }
        return todasAcciones;
    }

    //Metodos complementarios para la distribucion
    private boolean esSolucion(int k, ArrayList<Vecino> vecinos) {
        int suma = 0;
        for (int i = 0; i < vecinos.size(); i++) {
            suma += vecinos.get(i).getValorDistribuir();
        }
        return (suma == k);
    }

    private boolean esPosible(int pesoAñadir, Vecino veci) {
        return (pesoAñadir + veci.getValor() <= veci.getMax());
    }
}
