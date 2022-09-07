/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapping;

/**
 *
 * @author ASUS TUF GAMING F15
 * tomado de: http://aprenderestructuradedatos.blogspot.com/2015/11/colas-en-java.html
 */
public class NodoCola {

    //Declaracion de atributos
    private Nodo dato;
    private NodoCola next;

    //Constructor
    public NodoCola(Nodo dato) {
        this.dato = dato;
    }

    //Metodos getter and setters
    public Nodo getDato() {
        return dato;
    }

    public void setDato(Nodo dato) {
        this.dato = dato;
    }

    public NodoCola getNext() {
        return next;
    }

    public void setNext(NodoCola next) {
        this.next = next;
    }

    //Metodo toString
    public String toString() {
        String s = " " + dato + " ";
        return s;
    }

}
