/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leepdf;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.Loader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;


/**
 *
 * @author guill
 */
public class LeePDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        try {
            boolean local=false;
            if (local){
                File f = new File("C:\\Users\\guill\\Downloads\\19159.pdf");
                PDDocument doc = Loader.loadPDF(f);
                String text = new PDFTextStripper().getText(doc);;
                System.out.println("Text in PDF\n---------------------------------");
                System.out.println(text);
                
            }
            else {
                System.out.println("opening connection");
                URL url = new URL("https://www.mapa.gob.es/agricultura/pags/fitos/registro/productos/pdf/19159.pdf");
                InputStream in = url.openStream();
                File f =new File("C:\\Users\\guill\\Downloads\\19159_URL.pd");
                //ERROR_REVISION INI
                FileOutputStream fos = new FileOutputStream(f);
                //ERROR_REVISION END
                System.out.println("reading from resource and writing to file...");
                int length = -1;
                byte[] buffer = new byte[1024];// buffer for portion of data from connection
                while ((length = in.read(buffer)) > -1) {
                    fos.write(buffer, 0, length);
                }
                fos.close();
                in.close();
                System.out.println("File downloaded");
                //READ
                
                PDDocument doc = Loader.loadPDF(f);
                String text = new PDFTextStripper().getText(doc);;
                System.out.println("Text in PDF\n---------------------------------");
                System.out.println(text);
            }
        } catch (IOException e) {
                e.printStackTrace();
                    
        }
    }
    
}
