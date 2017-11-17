package sistemasinteligentes;

import java.util.Random;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llanos, Javier Monescillo Buitrón
 **/

public class Terreno {

    private int Xt; //Poscion del tractor en X
    private int Yt; //Posicion del tractor en Y
    private int K; //Peso recomendado de cada casilla
    private int max; //Peso maximo de cada casilla
    private int Columnas; //Columnas que tendra el terreno
    private int Filas; //Filas que tendra el terreno
    private int V; //Peso total a repartir en todas las columnas
    private int[][] terreno;

    public Terreno(int Xt, int Yt, int K, int max, int Columnas, int Filas) {
        this.Xt = Xt;
        this.Yt = Yt;
        this.K = K;
        this.max = max;
        this.Columnas = Columnas;
        this.Filas = Filas;
        this.V = Columnas * Filas * K;
        this.terreno = new int[Filas][Columnas];
    }

    public int[][] getTerreno() {
        return terreno;
    }

    public void setTerreno(int[][] terreno) {
        this.terreno = terreno;
    }

    public void setXt(int Xt) {
        this.Xt = Xt;
    }

    public void setYt(int Yt) {
        this.Yt = Yt;
    }

    public void setK(int K) {
        this.K = K;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setColumnas(int Columna) {
        this.Columnas = Columna;
    }

    public void setFilas(int Filas) {
        this.Filas = Filas;
    }

    public void setV(int V) {
        this.V = V;
    }

    public int getXt() {
        return Xt;
    }

    public int getYt() {
        return Yt;
    }

    public int getK() {
        return K;
    }

    public int getMax() {
        return max;
    }

    public int getColumnas() {
        return Columnas;
    }

    public int getFilas() {
        return Filas;
    }

    public int getV() {
        return V;
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

    @Override
    public String toString() {
        return "Terreno{" + "Xt=" + Xt + ", Yt=" + Yt + ", K=" + K + ", max=" + max + ", Columnas=" + Columnas + ", Filas=" + Filas + ", V=" + V + '}';
    }
    
}
