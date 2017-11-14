/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

import utilidades.MatricesOperaciones;

/**
 *
 * @author Angel
 */
public class Estado {
    private int terreno [][];
    private int Xt;
    private int Yt;
    
    
    public Estado(int [][] terreno, int Xt, int Yt){
        this.terreno = terreno;
        this.Xt = Xt;
        this.Yt = Yt;
    }
    
    public int [][] getTerreno(){
        return this.terreno;
    }
    
    public void setTerreno(int [][] newTerreno){
        this.terreno = newTerreno;
    }
    
    public int getXt(){
        return this.Xt;
    }
    
    public void setXt(int newXt){
        this.Xt = newXt;
    }
    
    public int getYt(){
        return Yt;
    }
    
    public void setYt(int newYt){
        this.Yt = newYt;
    }
    
    @Override
    public String toString(){
        return "Estado:\n PosXT: "+Xt+" PosYT: "+Yt+"\n Terreno:\n" + MatricesOperaciones.mostrar(terreno);
    }
}
