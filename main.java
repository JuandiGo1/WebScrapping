/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1;

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
 * @author Usuario
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String link = "https://jsoup.org/cookbook/input/parse-document-from-string";
            Connection con = Jsoup.connect(link);
            Document doc = con.get();
//            Elements el = doc.getAllElements();

            scrap(doc.getElementsByTag("html").get(0), "");
            //Element html = scrap(doc.getElementsByTag("html").get(0));

        } catch (IOException ex) {
            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void scrap(Element et, String esp) {
        
        if (et == null) {
            esp="";
            return;
        } else {
            System.out.println(esp + et.nodeName() + ": " + et.childrenSize());
            String esp1=esp;
            if (et.childrenSize() > 0) {
                esp1=esp;
                esp = esp+"-";
                scrap(et.firstElementChild(), esp);
            }
            scrap(et.nextElementSibling(), esp1);
        }

    }
}
