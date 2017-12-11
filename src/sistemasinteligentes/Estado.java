package sistemasinteligentes;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import utilidades.MatricesOperaciones;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llano, Javier Monescillo Buitrón
 **/
public class Estado {

    private int terreno[][];
    private int Xt;
    private int Yt;
    private int K; //Peso recomendado de cada casilla
    private int max; //Peso maximo de cada casilla
    private int Columnas; //Columnas que tendra el terreno
    private int Filas; //Filas que tendra el terreno
    private int V; //Peso total a repartir en todas las columnas

    public Estado() {
        //Constructor vacio
    }

    public Estado(int Xt, int Yt, int K, int max, int Columnas, int Filas) { //Llamada para el estado inicial
        this.Xt = Xt;
        this.Yt = Yt;
        this.K = K;
        this.max = max;
        this.Columnas = Columnas;
        this.Filas = Filas;
        this.V = Columnas * Filas * K;
        this.terreno = new int[Filas][Columnas];
    }

    public Estado(int[][] terreno, int Xt, int Yt, int K, int max, int Columnas, int Filas) {
        this.terreno = terreno;
        this.Xt = Xt;
        this.Yt = Yt;
        this.K = K;
        this.max = max;
        this.Columnas = Columnas;
        this.Filas = Filas;
        this.V = Columnas * Filas * K;
    }

    public int[][] getTerreno() {
        return this.terreno;
    }

    public void setTerreno(int[][] newTerreno) {
        this.terreno = newTerreno;
    }

    public int getXt() {
        return this.Xt;
    }

    public void setXt(int newXt) {
        this.Xt = newXt;
    }

    public int getYt() {
        return Yt;
    }

    public void setYt(int newYt) {
        this.Yt = newYt;
    }

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getColumnas() {
        return Columnas;
    }

    public void setColumnas(int Columna) {
        this.Columnas = Columna;
    }

    public int getFilas() {
        return Filas;
    }

    public void setFilas(int Filas) {
        this.Filas = Filas;
    }

    public int getV() {
        return V;
    }

    public void setV(int V) {
        this.V = V;
    }

    public void rellenarTerreno() { //Metodo para rellenar el terreno de manera aleatoria
        Random rnd = new Random();
        int restante = V;
        int[][] aux = terreno;
        do {
            for (int i = 0; i < Filas; i++) {
                for (int j = 0; j < Columnas; j++) {
                    if (restante > max) {
                        int peso = rnd.nextInt(max);
                        if (aux[i][j] + peso <= max) {
                            aux[i][j] += peso;
                            restante -= peso;
                        }
                    } else {
                        if (aux[i][j] + restante <= max) {
                            aux[i][j] += restante;
                            restante = 0;
                        }
                    }
                }
            }
        } while (restante != 0);
    }

    public String toMD5() throws NoSuchAlgorithmException {
        return Encriptacion.md5(this.toString());
    }

    @Override
    public String toString() {
        return "Estado:\n PosXT: " + Xt + " PosYT: " + Yt + "\n Terreno:\n" + MatricesOperaciones.mostrar(terreno);
    }
}
