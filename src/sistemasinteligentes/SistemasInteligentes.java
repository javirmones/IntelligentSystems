/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

/**
 *
 * @author absit
 */
import java.util.Random;
import utilidades.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SistemasInteligentes {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        principal();
        //System.out.println(t.toString());
        //mostrarTerreno(t);
        //rellenarTerreno(t);
        //mostrarTerreno(t);
    }

    public static void principal() throws Exception {
        
        boolean condicional = false;

        do {

            int condicion = leer.entero("Seleccione de que modo quiere generar el terreno\n"
                    + "1. Generacion mediante teclado\n"
                    + "2. Generacion mediante fichero\n"
                    + "3. Salir\n");
            switch (condicion) {
                case 1:
                    Terreno t = cargarDatosTeclado();
                    rellenarTerreno(t);
                    mostrarTerreno(t);
                    break;
                case 2:
                    cargarDatosFichero();
                    break;
                case 3:
                    condicional = true;
                    break;
                default:
                    System.out.println("El numero no es correcto");
                    break;
            }
        } while (condicional == false);

    }

    public static void cargarDatosFichero() throws Exception {

        try {

            int j = 0;
            Scanner lectura = new Scanner(new File("FicheroPrueba.txt"));
            lectura.useDelimiter(" ");
            String[] aux = lectura.nextLine().split(" ");
            String[] auxM;
            int[][] matrizTerreno = new int[Integer.parseInt(aux[4])][Integer.parseInt(aux[5])];

            Terreno t = new Terreno(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]),
                    Integer.parseInt(aux[3]), Integer.parseInt(aux[4]), Integer.parseInt(aux[4]));

            //4 filas
            //5 columnas
            while (lectura.hasNext()) {
                lectura.skip(" ");
                auxM = lectura.nextLine().split(" ");
                for (int i = 0; i < Integer.parseInt(aux[5]); i++) {
                    matrizTerreno[j][i] = Integer.parseInt(auxM[i]);
                }
                j++;

            }

            t.terreno = matrizTerreno;
            mostrarTerreno(t);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

    }

    public static Terreno cargarDatosTeclado() throws Exception {
        int Columnas = leer.entero("Introduzca las columnas del terreno");
        int Filas = leer.entero("Introduzca el número de filas del terreno");
        int Yt = leer.entero("Introduzca la posición del tractor en las columnas", 0, Columnas);
        int Xt = leer.entero("Introduzca la posición del tractor en las filas", 0, Filas);
        int max = leer.entero("Introduzca el peso máximo para una casilla");
        int K = leer.entero("Introduzca el peso recomendado para una casilla", 0, max);

        Terreno t = new Terreno(Xt, Yt, K, max, Columnas, Filas);

        return t;
    }

    public static void mostrarTerreno(Terreno t) {
        for (int i = 0; i < t.getColumnas(); i++) {
            for (int j = 0; j < t.getFilas(); j++) {
                System.out.print(" " + t.terreno[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rellenarTerreno(Terreno t) {
        Random rnd = new Random();
        do {
            for (int i = 0; i < t.getColumnas(); i++) {
                for (int j = 0; j < t.getFilas(); j++) {
                    if (t.getRestante() > t.getMax()) {
                        int peso = rnd.nextInt(t.getMax());
                        if (t.terreno[i][j] + peso <= t.getMax()) {
                            t.terreno[i][j] += peso;
                            int nuevoRestante = t.getRestante() - peso;
                            t.setRestante(nuevoRestante);
                        }
                    } else {
                        t.terreno[i][j] = t.getRestante();
                        t.setRestante(0);
                    }
                }
            }
        } while (t.getRestante() != 0);
    }

    public static void inicioDistribucion() {
        //TO DO
    }

    public static void escrituraFichero() {
        //TO DO
    }
}
