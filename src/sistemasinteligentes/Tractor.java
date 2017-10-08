/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasinteligentes;

/**
 *
 * @author javi
 */
public class Tractor {
    
    private int xt;
    private int yt;
    private int mov;

    public Tractor(int xt, int yt, int mov) {
        this.xt = xt;
        this.yt = yt;
        this.mov = mov;
    }

    public int getXt() {
        return xt;
    }

    public void setXt(int xt) {
        this.xt = xt;
    }

    public int getYt() {
        return yt;
    }

    public void setYt(int yt) {
        this.yt = yt;
    }

    public int getMov() {
        return mov;
    }

    public void setMov(int mov) {
        this.mov = mov;
    }
    
    
    
}
