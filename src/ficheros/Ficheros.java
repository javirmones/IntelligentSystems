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

import sistemasinteligentes.Estado;
import utilidades.leer;

/**
 *
 * @author absit
 */
public class Ficheros {

    public Estado cargarDatosFichero() throws Exception {

        Estado ei = null;
        try {

            int j = 0;
            Scanner lectura = new Scanner(new File("FicheroPrueba.txt"));
            lectura.useDelimiter(" ");
            String[] aux = lectura.nextLine().split(" ");
            String[] auxM;
            int[][] matrizTerreno = new int[Integer.parseInt(aux[4])][Integer.parseInt(aux[5])];

            ei = new Estado(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]),
                    Integer.parseInt(aux[3]), Integer.parseInt(aux[4]), Integer.parseInt(aux[5]));

            matrizTerreno = ei.getTerreno();

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
        return ei;
    }

    public void escrituraFichero(Estado ei) {
        File archivo = new File("DistribucionesTerreno.txt");
        try {
            int[][] m = ei.getTerreno();
            FileWriter fl = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fl);
            pw.print(ei.getXt() + " " + ei.getYt() + " " + ei.getK() + " " + ei.getMax() + " " + ei.getColumnas() + " " + ei.getFilas());
            pw.println("");
            for (int i = 0; i < ei.getFilas(); i++) {
                for (int j = 0; j < ei.getColumnas(); j++) {
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
