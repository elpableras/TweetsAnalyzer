/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miw.websemantica.stemming;

/**
 *
 * @author Pablo
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import au.com.bytecode.opencsv.CSVReader;
import com.miw.websemantica.rest.AnalyzerFeeling;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class LeerCSV {
    
    private Stemm_es stm_es = new Stemm_es();    

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public LeerCSV() {                        
    }
    
    public double palabraVScsv(String lemaTweet) throws FileNotFoundException, UnsupportedEncodingException{
        //Le pasamos la URL del archivo CSV a leer.        
//        FacesContext context = FacesContext.getCurrentInstance();
//        ServletContext request = (ServletContext) context.getExternalContext().getContext();
//        File archivo= new File(request.getRealPath("/AnalizadorSentimiento/lexico/Spanish.csv"));
        //CSVReader reader = new CSVReader(new FileReader(archivo));        
        //CSVReader reader = new CSVReader(new FileReader("./lexico/Spanish.csv"));                      
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("C:\\Users\\Pablo\\Documents\\NetBeansProjects\\AnalizadorSentimiento\\lexico\\Spanish.csv"), "UTF-8"));
        //Si partimos de un input type File
        //CsvReader reader = new CsvReader(objetoformulario.getFichero.getInputStream(), Charset.forName("ISO-8859-1"));
        String [] nextLine;
        double valor = 0.0;
        try {
             while ((nextLine = reader.readNext()) != null)  {                
                String word = nextLine[1];
                String palabra = nextLine[2];
                String vMeanSum = nextLine[3];
                String vSDSum = nextLine[4];
                //System.out.println("Filas: " + word + "-" + palabra + "-" + vMeanSum + "-" + vSDSum);
                String lemaCSV = stm_es.stemm(palabra);
                if(lemaTweet.equalsIgnoreCase(lemaCSV)){
                    valor = Double.valueOf(vMeanSum);
                }
            }
        reader.close();
        } catch (IOException e) {
            Logger.getLogger(AnalyzerFeeling.class.getName()).log(Level.SEVERE, null, e);
        }        
        return valor;
    }                   
}
