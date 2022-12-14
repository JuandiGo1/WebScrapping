/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapping;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Nodo {
    private String nombre;
    int id;
    private List<Nodo> hijos = new ArrayList<>();
    private int nHijos;
    private int Nivel ;
    Nodo padre;
    int coorX, coorY;

    public Nodo (String nombre, int level, int hijos, int id){
        this.nombre = nombre;
        this.Nivel = level;
        this.nHijos=hijos;
        this.id=id;
        
    }
    
    
    public int darNivel (){
        return this.Nivel;
    }
    
    public int cantHijos(){
        return this.nHijos;
    }
    
    
    public String getNombre() {
        return nombre;
    }
    
    public void addHijo(Nodo p){
        this.hijos.add(p);
    }
    
    public List<Nodo> getHijos() {
        return this.hijos;
    }
    
    public boolean isLeaf(Nodo nodo){
        return nodo.getHijos().isEmpty();
    }
}
