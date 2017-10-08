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
import utilidades.leer;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SistemasInteligentes {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Terreno t = principal();
        //System.out.println(t.toString());
        // mostrarTerreno(t);
        //rellenarTerreno(t);
        //mostrarTerreno(t);
    }

    public static Terreno principal() throws Exception {

        boolean condicional = false;
        Terreno t = null;
        System.out.println("Practica 1- Sistemas Inteligentes\n");
        System.out.println("1.\t Generacion mediante teclado");
        System.out.println("2.\t Generacion mediante fichero");
        System.out.println("3.\t Salir");

        do {

            int condicion = leer.entero("Seleccione de que modo quiere generar el terreno\n");
            switch (condicion) {
                case 1:
                    return t = cargarDatosTeclado();

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
        return t;

    }

    public static void cargarDatosFichero() throws Exception {
        //TO DO   
        try {

            Scanner lectura = new Scanner(new File("FicheroPrueba.txt"));
            lectura.useDelimiter(" ");
            String linea;
            String[]aux;
            String[]auxf;
            int i=0;
            
            while(lectura.hasNext()){
                
                int prueba=lectura.nextInt();
                System.out.println(prueba);

                //linea=lectura.nextLine();
               
                //System.out.println(linea);
                //System.out.println(aux.toString());
                
               // int prueba=Integer.parseInt(aux[4]);
                //System.out.println(prueba);
                //int Yt=Integer.pareInt(aux[2]);
                //int K=Integer.parseInt(aux[4]);
                //int max=Integer.parseInt(aux[5]);
                //int C= Integer.parseInt(aux[8]);
                //int F= Integer.parseInt(aux[10]);
               // System.out.println(linea);
                //Terreno t=new Terreno(Xt,Yt,K,max,C,F);
                //t.toString();
            
            }
        } catch (FileNotFoundException e) {
            System.out.println("A");
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

}
