/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapping;

/**
 *
 * @author Mateo Valencia
 */
public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }

    Nodo resultado = null;

    public Nodo BusquedaRecursiva(String padre) {
        resultado = null;
        return BusquedaRecursiva(raiz, padre);
    }

    public Nodo BusquedaRecursiva(Nodo nodo, String padre) {
        if (nodo == null) {
            resultado = null;
            System.out.println("Buscando, nodo actual " + nodo.getNombre() + " nodo padre: " + padre);
        }
        if (padre == nodo.getNombre()) {
            resultado = nodo;
        }

        for (Nodo hijo : nodo.getHijos()) {
            if (resultado != null) {
                break;
            } else {
                BusquedaRecursiva(hijo, padre);
            }
        }

        return resultado;
    }

    public void insertNodo(String nombre, String padre) {
        if (getRaiz() == null) {
            System.out.println("Insertando nodo raiz" + "  --->  " + nombre);
            this.raiz = new Nodo(nombre);
        } else {
            Nodo nodoPadre = BusquedaRecursiva(padre);
//            System.out.println("Nodo Padre " + nodoPadre.getNombre());
            if (nodoPadre != null) {
                nodoPadre.addHijo(new Nodo(nombre));
            } else {
                raiz.getHijos().add(new Nodo(nombre));
            }
            System.out.println("Nodo insertado: " + nombre + "  ---> " + " Nodo Padre " + nodoPadre.getNombre());
        }
    }

    public void PreOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.getNombre() + ", ");
        nodo.getHijos().forEach((temp) -> {
            PreOrden(temp);
        });

    }

    public void PostOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        for (Nodo temp : nodo.getHijos()) {
            PostOrden(temp);
        }
        System.out.print(nodo.getNombre() + ", ");
    }

    public void InOrden(Nodo nodo) {
        if (!nodo.isLeaf(nodo)) {
            InOrden(nodo.getHijos().get(0));
            System.out.print(nodo.getNombre() + ", ");
            for (int i = 1; i < nodo.getHijos().size(); i++) {
                InOrden(nodo.getHijos().get(i));
            }
        } else {
            System.out.print(nodo.getNombre() + ", ");
        }
    }
}
