/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

/**
 * @author Adrian Muñoz, Javier Monescillo, Angel Sanchez
 *
 */
import java.util.Random;
import utilidades.*;
import java.util.*;
import java.io.*;
import ficheros.Ficheros;
import ficheros.Teclado;

public class Principal {

    public void principal() throws Exception {

        boolean salir = false;
        System.out.println("\n----Práctica Sistemas Inteligentes----\n");
        do {
            int condicion = leer.entero("Seleccione de que modo quiere generar el terreno: \n"
                    + "1.\t Generacion mediante teclado\n"
                    + "2.\t Generacion mediante fichero\n"
                    + "3.\t Salir\n");
            switch (condicion) {
                case 1:
                    Teclado o = new Teclado();
                    Ficheros f = new Ficheros();
                    Terreno t = o.cargarDatosTeclado();
                    t.mostrarTerreno();
                    f.escrituraFichero(t);
                    inicioDistribucion(t);
                    break;
                case 2:
                    Ficheros fic = new Ficheros();
                    Terreno a = fic.cargarDatosFichero();
                    a.mostrarTerreno();
                    inicioDistribucion(a);
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

    public void mostrarMatriz(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.println("" + b[i][j]);
            }
        }
    }

    public ArrayList generarVecinos(Terreno t) {
        int[][] aux = t.getTerreno();
        ArrayList<Vecino> vecino = new ArrayList();
        if (t.getXt() - 1 >= 0) {
            Vecino vec1 = new Vecino(t.getXt() - 1, t.getYt(), t.getMax(), aux[t.getXt() - 1][t.getYt()], 0);
            vecino.add(vec1);
        }
        if (t.getXt() + 1 < t.getFilas()) {
            Vecino vec2 = new Vecino(t.getXt() + 1, t.getYt(), t.getMax(), aux[t.getXt() + 1][t.getYt()], 0);
            vecino.add(vec2);
        }
        if (t.getYt() - 1 >= 0) {
            Vecino vec3 = new Vecino(t.getXt(), t.getYt() - 1, t.getMax(), aux[t.getXt()][t.getYt() - 1], 0);
            vecino.add(vec3);
        }
        if (t.getYt() + 1 < t.getColumnas()) {
            Vecino vec4 = new Vecino(t.getXt(), t.getYt() + 1, t.getMax(), aux[t.getXt()][t.getYt() + 1], 0);
            vecino.add(vec4);
        }
        return vecino;
    }

    public void inicioDistribucion(Terreno t) {
        int[][] aux = t.getTerreno();
        int s = aux[t.getXt()][t.getYt()] - t.getK();
        ArrayList<Vecino> vecinos = generarVecinos(t);
        ArrayList<ArrayList> todasDistribuciones = new ArrayList(); //Array que guarda todas las distribuciones posibles
        distribucion(0, s, s, vecinos, todasDistribuciones);

        ArrayList<ArrayList> todasAcciones = new ArrayList();
        todasAcciones = accion(todasDistribuciones, vecinos);
        for (int i = 0; i < todasAcciones.size(); i++) {
            System.out.println(todasAcciones.get(i));
        }

        for (int i = 0; i < todasAcciones.size(); i++) {
            EspacioEstados c = new EspacioEstados(t.getTerreno(), todasAcciones.get(i), t.getXt(), t.getYt());
            c.fSucesores();
        }
    }

    public void distribucion(int etapa, int k, int actual, ArrayList<Vecino> vecinos, ArrayList<ArrayList> todasDistribuciones) {
        if (etapa == vecinos.size()) {
            if (esSolucion(k, vecinos)) {
                ArrayList<Vecino> list = new ArrayList();
                for (int i = 0; i < vecinos.size(); i++) {
                    Vecino vec = (Vecino) vecinos.get(i).clone();
                    list.add(vec);
                }
                if (!esRepetido(todasDistribuciones, list)) {
                    todasDistribuciones.add(list);
                }
            }
        } else {
            for (int i = 0; i < vecinos.size(); i++) {
                for (int j = 0; j <= actual; j++) {
                    if (esPosible(j, vecinos.get(i))) {
                        vecinos.get(i).setValorDistribuir(j);
                        distribucion(etapa + 1, k, actual - j, vecinos, todasDistribuciones);
                    }
                }
            }
        }
    }

    public ArrayList accion(ArrayList<ArrayList> todasDistribuciones, ArrayList<Vecino> vecinos) {
        ArrayList todasAcciones = new ArrayList();
        int coste = 1;
        for (int i = 0; i < vecinos.size(); i++) {
            ArrayList<Integer> posicionVecino = new ArrayList();
            posicionVecino.add(vecinos.get(i).getPosX());
            posicionVecino.add(vecinos.get(i).getPosY());
            for (int j = 0; j < todasDistribuciones.size(); j++) {
                ArrayList accion = new ArrayList();
                accion.add(posicionVecino.toString());
                accion.add(todasDistribuciones.get(j));
                accion.add(coste);
                todasAcciones.add(accion);
            }
        }
        return todasAcciones;
    }

    //Metodos complementarios para la distribucion
    public boolean esRepetido(ArrayList<ArrayList> todasDistribuciones, ArrayList<Vecino> list) {
        boolean repetido = false;
        for (int i = 0; i < todasDistribuciones.size(); i++) {
            if (todasDistribuciones.get(i).toString().equals(list.toString())) {
                repetido = true;
            }
        }
        return repetido;
    }

    public boolean esSolucion(int k, ArrayList<Vecino> vecinos) {
        int suma = 0;
        for (int i = 0; i < vecinos.size(); i++) {
            suma += vecinos.get(i).getValorDistribuir();
        }
        return (suma == k);
    }

    public boolean esPosible(int pesoAñadir, Vecino veci) {
        return (pesoAñadir + veci.getValor() <= veci.getMax());
    }
}
