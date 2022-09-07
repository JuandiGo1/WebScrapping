/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapping;

/**
 *
 * @author ASUS TUF GAMING F15 tomado de:
 * http://aprenderestructuradedatos.blogspot.com/2015/11/colas-en-java.html
 */
public class Cola {

    //Declaración de atributos
    private NodoCola inicio;
    private NodoCola termino;

    //Constructor sin parametros
    public Cola() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(Nodo dato) {
        NodoCola i = new NodoCola(dato);
        i.setNext(null);
        if (inicio == null & termino == null) {
            inicio = i;
            termino = i;
        } else {
            termino.setNext(i);
            termino = termino.getNext();
        }

    }

    //Metodo extraer dato
    public Nodo extraer() {
        Nodo dato = inicio.getDato();
        inicio = inicio.getNext();
        if (inicio==null){
            termino=null;
        }
        return dato;
    }

    //Metodo para comprobar que la cola no esta vacia
    public boolean estaVacia() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;
            System.out.println("La cola esta vacia");
        } else {
            System.out.println("La cola no esta vacia");
            cola = false;
        }
        return cola;
    }

    //Metodo para contar los elementos de la cola
    public int contar() {
        int contador = 0;
        NodoCola c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        System.out.println("Numero de datos en la cola: " + contador);
        return contador;
    }

    //Metodo toString
    public String toString() {
        NodoCola c = this.inicio;
        String s = "";
        while (c != null) {
            s = s + c.toString();
            c = c.getNext();
        }
        return s;
    }

}
