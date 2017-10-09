/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

/**
 * @author Adrian Muñoz, Javier Monescillo, Angel Sanchez
 **/
import java.util.Random;
import utilidades.*;
import java.util.*;
import java.io.*;

public class SistemasInteligentes {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     **/
    
    public static void main(String[] args) throws Exception {
        principal();
    }

    public static void principal() throws Exception {
        
        boolean salir = false; //Condicional para comprobar la finalizacion del programa

        do {
            int condicion = leer.entero("Seleccione de que modo quiere generar el terreno\n"
                    + "1. Generacion mediante teclado\n"
                    + "2. Generacion mediante fichero\n"
                    + "3. Salir\n");
            switch(condicion){
                case 1:
                    Terreno t = cargarDatosTeclado();
                    rellenarTerreno(t);
                    mostrarTerreno(t);
                    escrituraFichero(t);
                    break;
                case 2:
                    Terreno a = cargarDatosFichero();
                    mostrarTerreno(a);
                    inicioDistribucion(a);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("El numero no es correcto");
                    break;
            }
        } while(salir == false);

    }

    public static Terreno cargarDatosFichero() throws Exception {
        Terreno t = null;
        try {

            int j = 0;
            Scanner lectura = new Scanner(new File("FicheroPrueba.txt"));
            lectura.useDelimiter(" ");
            String[] aux = lectura.nextLine().split(" ");
            String[] auxM;
            int[][] matrizTerreno = new int[Integer.parseInt(aux[4])][Integer.parseInt(aux[5])];

            t = new Terreno(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]),
                    Integer.parseInt(aux[3]), Integer.parseInt(aux[4]), Integer.parseInt(aux[5]));

            while (lectura.hasNext()){
                lectura.skip(" ");
                auxM = lectura.nextLine().split(" ");
                for (int i = 0; i < Integer.parseInt(aux[4]); i++) {
                    matrizTerreno[j][i] = Integer.parseInt(auxM[i]);
                }
                j++;
            }
                     
            t.terreno = matrizTerreno;            
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        return t;
    }

    public static Terreno cargarDatosTeclado() throws Exception {
        int Columnas = leer.entero("Introduzca las columnas del terreno");
        int Filas = leer.entero("Introduzca el número de filas del terreno");
        int Yt = leer.entero("Introduzca la posición del tractor en las columnas", 0, Columnas - 1);
        int Xt = leer.entero("Introduzca la posición del tractor en las filas", 0, Filas - 1);
        int max = leer.entero("Introduzca el peso máximo para una casilla");
        int K = leer.entero("Introduzca el peso recomendado para una casilla", 0, max);

        Terreno t = new Terreno(Xt, Yt, K, max, Columnas, Filas); //Se genera un pbjeto terreno con los datos introducidos
        
        return t; //Retornamos el terreno
    }

    public static void mostrarTerreno(Terreno t){
        for(int i = 0; i < t.getFilas(); i++){
            for(int j = 0; j < t.getColumnas(); j++){
                System.out.print(" " + t.terreno[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rellenarTerreno(Terreno t){
        Random rnd = new Random();
        int restante = t.getV();
        do{
            for(int i = 0; i < t.getFilas(); i++){
                for(int j = 0; j < t.getColumnas(); j++){
                    if(restante > t.getMax()){
                        int peso = rnd.nextInt(t.getMax());
                        if(t.terreno[i][j] + peso <= t.getMax()){
                            t.terreno[i][j] += peso;
                            restante -= peso;
                        }
                    }else {
                        if(t.terreno[i][j] + restante <= t.getMax()){
                            t.terreno[i][j] += restante;
                            restante = 0;
                        }                       
                    }
                }
            }
        }while(restante != 0);
    }

    public static void escrituraFichero(Terreno t) {
        File archivo = new File("DistribucionesTerreno.txt");
	try{                    
            FileWriter fl = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fl);
            pw.print(t.getXt()+" "+t.getYt()+" "+t.getK()+" "+t.getMax()+" "+t.getColumnas()+" "+t.getFilas());
            pw.println("");
            for(int i = 0; i < t.getFilas(); i++){
                for(int j = 0; j < t.getColumnas(); j++){
                    pw.print(" " + t.terreno[i][j]);
                }
                pw.println();
            } 
        pw.close();
        }catch(IOException ex){
            System.out.println("ERROR");
        }
    }
    
    public static void inicioDistribucion(Terreno t) {
        int s = t.terreno[t.getXt()][t.getYt()] - t.getK();
        ArrayList vecinos = generarVecinos(t);
        System.out.println(vecinos);
    }
    
    public static ArrayList generarVecinos(Terreno t){
        /*for(int i = 0; i < vecinos.length; i++){
            if (t.getXt() - 1 < 0 || t.getYt() - 1  < 0 || t.getXt() + 1 >= t.getFilas() || t.getYt() + 1 >= t.getColumnas());
        }*/
        ArrayList vecinos = new ArrayList();
        if(t.getXt() - 1 >= 0){
            ArrayList vec1 = new ArrayList();
            vec1.add(t.getXt()-1);
            vec1.add(t.getYt());
            vecinos.add(vec1);
        }
        if(t.getXt() + 1 < t.getFilas()){
            ArrayList vec2 = new ArrayList();
            vec2.add(t.getXt()+1);
            vec2.add(t.getYt());
            vecinos.add(vec2);
        }
        if(t.getYt() - 1 >= 0){
            ArrayList vec3 = new ArrayList();
            vec3.add(t.getXt());
            vec3.add(t.getYt()-1);
            vecinos.add(vec3);
        }
        if(t.getYt() + 1 < t.getColumnas()){
            ArrayList vec4 = new ArrayList();
            vec4.add(t.getXt());
            vec4.add(t.getYt()+1);
            vecinos.add(vec4);
        }
        
        return vecinos;
    }
}
