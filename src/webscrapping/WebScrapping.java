/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webscrapping;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Juan Maestre
 */
public class WebScrapping {

    /**
     * @param args the command line arguments
     */
    static Arbol arbol = new Arbol();

    public static void main(String[] args) {

        try {
            String link = "https://jsoup.org/cookbook/input/parse-document-from-string";
            Connection con = Jsoup.connect(link);
            Document doc = con.get();
//            Elements el = doc.getAllElements();

            scrap(doc.getElementsByTag("html").get(0), "", null);
//Element html = scrap(doc.getElementsByTag("html").get(0));
            System.out.println("PreOrden: ");
            arbol.PreOrden(arbol.getRaiz());
        } catch (IOException ex) {
            Logger.getLogger(WebScrapping.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void scrap(Element et, String esp, String padre) {

        if (et == null) {
            esp = "";
            return;
        } else {
            //System.out.println(esp + et.nodeName() + ": " + et.childrenSize());

            arbol.insertNodo(et.nodeName(), padre);

        }
        String esp1 = esp;
        if (et.childrenSize() > 0) {
            esp1 = esp;
            esp = esp + "-";
            scrap(et.firstElementChild(), esp, et.nodeName());
        }
        scrap(et.nextElementSibling(), esp1, padre);
    }

}
