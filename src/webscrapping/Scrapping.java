/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapping;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Usuario
 */
public class Scrapping {

    public static Arbol arbol = new Arbol();
    static Nodo pa;
    static int id=0;
    static public String titulo;

    public Scrapping(String link) {

        try {
            //String link = "https://jsoup.org/cookbook/input/parse-document-from-string";
            //""
            
            Connection con = Jsoup.connect(link);
            Document doc = con.get();
            titulo = doc.title();

            scrap(doc.getElementsByTag("html").get(0), "", null, 0);

            System.out.println("NODOS EN NIVEL 2: " + arbol.verNxL(arbol.getRaiz(), 2));
        } catch (IOException ex) {
            Logger.getLogger(Scrapping.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void scrap(Element et, String esp, Nodo padre, int level) {

        if (et == null) {

            return;
        } else {
            //System.out.println(esp + et.nodeName() + ": " + et.childrenSize()+" nivel: "+ level);
            System.out.println("Nodo: "+et.nodeName()+": "+id);
            arbol.insertNodo(et.nodeName(), padre, level, et.childrenSize(), id);

        }
        String esp1 = esp;
        pa = new Nodo(et.nodeName(), level, et.childrenSize(), id);
        if (et.childrenSize() > 0) {
            

            esp1 = esp;
            esp = esp + "-";
            id++;
            System.out.println("Este nodo: "+ et.firstElementChild().nodeName()+" va a buscar el id: "+pa.id);
            scrap(et.firstElementChild(), esp, pa, level + 1);
            
        }
        id++;
        scrap(et.nextElementSibling(), esp1, padre, level);
    }

}
