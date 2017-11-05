/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import sistemasinteligentes.Terreno;
import utilidades.leer;

/**
 *
 * @author absit
 */
public class Ficheros {

    public Terreno cargarDatosFichero() throws Exception {

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

            matrizTerreno = t.getTerreno();

            while (lectura.hasNext()) {
                lectura.skip(" ");
                auxM = lectura.nextLine().split(" ");
                for (int i = 0; i < Integer.parseInt(aux[4]); i++) {
                    matrizTerreno[j][i] = Integer.parseInt(auxM[i]);
                }
                j++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        return t;
    }

    public void escrituraFichero(Terreno t) {
        File archivo = new File("DistribucionesTerreno.txt");
        try {
            int[][] m = t.getTerreno();
            FileWriter fl = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fl);
            pw.print(t.getXt() + " " + t.getYt() + " " + t.getK() + " " + t.getMax() + " " + t.getColumnas() + " " + t.getFilas());
            pw.println("");
            for (int i = 0; i < t.getFilas(); i++) {
                for (int j = 0; j < t.getColumnas(); j++) {
                    pw.print(" " + m[i][j]);
                }
                pw.println();
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
}
