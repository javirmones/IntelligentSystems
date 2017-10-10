/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

/**
 *
 * @author 05937379
 */
public class Terreno {
    private int Xt; //Poscion del tractor en X
    private int Yt; //Posicion del tractor en Y
    private int K; //Peso recomendado de cada casilla
    private int max; //Peso maximo de cada casilla
    private int Columnas; //Columnas que tendra el terreno
    private int Filas; //Filas que tendra el terreno
    private int V; //Peso total a repartir en todas las columnas
    int[][] terreno; 

    
    public Terreno (){
        
    }
    
    public Terreno (int Xt, int Yt, int K, int max, int Columnas, int Filas){
        this.Xt = Xt;
        this.Yt = Yt;
        this.K = K;
        this.max = max;
        this.Columnas = Columnas;
        this.Filas = Filas;
        V = Columnas * Filas * K;
        terreno = new int [Filas][Columnas];
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

    @Override
    public String toString() {
        return "Terreno{" + "Xt=" + Xt + ", Yt=" + Yt + ", K=" + K + ", max=" + max + ", Columnas=" + Columnas + ", Filas=" + Filas + ", V=" + V + '}';
    }
    
}