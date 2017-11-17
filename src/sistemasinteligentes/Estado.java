package sistemasinteligentes;

import java.util.ArrayList;

import utilidades.MatricesOperaciones;

/**
 * @author Ángel Sánchez González, Adrián Muñoz Llanos, Javier Monescillo Buitrón
 **/

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
    
    public ArrayList sucesores(Estado e, Terreno t){
        Distribucion dist = new Distribucion(); //Creamos un objeto distribucion para sacar todas las acciones
        ArrayList<ArrayList> accion = dist.inicioDistribucion(t, e); //Guardamos las acciones en el ArrayList
        for (int i = 0; i < accion.size(); i++) System.out.println(accion.get(i)); /*Imprime todas las acciones*/       
        
        ArrayList listaSucesores = new ArrayList();        
        for(int i = 0 ; i<accion.size() ; i++){
            Estado es = fSucesores(e,accion.get(i)); //Guardamos el estado que sacamos a partir de la accion
            
            //Metemos en una lista cada sucesor (ACCION / ESTADO / COSTE)
            listaSucesores.add(accion.get(0));             
            listaSucesores.add(es);
            listaSucesores.add(costo(accion.get(i)));                                 
            
            System.out.println("\nAccion: "+listaSucesores.get(1));
            System.out.println("Coste:"+listaSucesores.get(3));        
            System.out.println((Estado)listaSucesores.get(2));
        }
        
        return listaSucesores; 
    }
    
    private Estado fSucesores(Estado e, ArrayList accion){
        int Xt, Yt;
        ArrayList<Estado> listaEstadosSucesores = new ArrayList();
        ArrayList aux = new ArrayList(); //ArrayList que contiene los datos de una acción        
        
        int [][] copyTerreno = new int [e.getTerreno().length][e.getTerreno()[0].length]; //estadoActual        
        Xt = (int)(accion.get(0).toString().charAt(1) - 48); //Posicion X tractor
        Yt = (int)(accion.get(0).toString().charAt(4) - 48); //Posicion Y tractor
                
        aux = sacarDatosAccion(aux, accion);                      
        copyTerreno = copiarTerreno(e.getTerreno(), copyTerreno);
        
        while(!aux.isEmpty()){            
            int peso = (int) aux.remove(0);
            
            copyTerreno[(int) aux.remove(0)][(int) aux.remove(0)] += peso;
            copyTerreno[e.getXt()][e.getYt()] -=peso; //estadoActual
        }
        
        Estado es = new Estado(copyTerreno, Xt, Yt); //Creamos un estado del sucesor del estado parametro
        
        return es;
    }   
    
    public int [][] copiarTerreno(int [][] estadoTerreno, int [][] copyTerreno){
        for(int i = 0 ; i < estadoTerreno.length ; i++){
            for(int j = 0 ; j < estadoTerreno[0].length; j++){
                copyTerreno[i][j] = estadoTerreno[i][j];
            }
        }
        return copyTerreno;
    }
    
    public ArrayList sacarDatosAccion(ArrayList aux, ArrayList<ArrayList> accion){//En este metodo guardamos en un vector los datos que tiene cada accion                
        int contador = 1;
        for(int i = 2 ; i < accion.get(1).toString().length() ; i+=3){            
            aux.add((int)(accion.get(1).toString().charAt(i) - 48));
            if(contador == 3){
                i+=3;
                contador = 0;
            }
            contador++;
        }
        return aux;
    }
    
    public int costo(ArrayList accion){
        int costo = 1;
        for(int i=2; i < accion.get(1).toString().length() ; i+=12){
            costo += (int) accion.get(1).toString().charAt(i)-48;
        }
        return costo;
    }
        
    @Override
    public String toString(){
        return "Estado:\n PosXT: "+Xt+" PosYT: "+Yt+"\n Terreno:\n" + MatricesOperaciones.mostrar(terreno);
    }
}
