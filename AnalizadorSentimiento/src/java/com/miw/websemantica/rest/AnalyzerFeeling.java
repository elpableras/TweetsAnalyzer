/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miw.websemantica.rest;

import com.miw.websemantica.stemming.LeerCSV;
import com.miw.websemantica.stemming.Stemm_es;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Pablo
 */
@Stateless 
@Path("/analizartweet")
public class AnalyzerFeeling {
    
    //Clase para detectar idioma
    private LangDetector lang = new LangDetector();
    //Clase para separar palabras por stemming en español
    private Stemm_es stm_es = new Stemm_es();
    //Clase donde están el csv con el valor de las palabras
    private LeerCSV csv = new LeerCSV();
    //String con los datos a pasar en el GET
    private String cadDatos;

    public AnalyzerFeeling() {
        
    }            
    
    @GET
    public String tweet(@QueryParam("base")String base) {
        return ($tweet(base));      
    }
    
    String $tweet(String base) {
        String cad = base; 
        double valor = -1;        
        //Convierte a minuscula
        cad = cad.toLowerCase();
        //Deja solo números y letras
        cad = cad.replaceAll("[!\"#$%&'()*+,-./:;<=>?@^_`{|}~¡¿]","");
        cadDatos = cad + " -";
        String l = lang.detectLanguage(cadDatos);
        if(l.compareToIgnoreCase("@es")==0){
            try {
                //Nos devuelve el valor de la palabra
                valor = Double.valueOf(stemm(cad));
                cadDatos += " - " + valor;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AnalyzerFeeling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AnalyzerFeeling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{            
            cadDatos += " SinPalabra:0 - " + valor;
        }        
        //Detecta el idioma
        cadDatos += " - " + l;
        return cadDatos;
    }

    private double stemm(String cad) throws UnsupportedEncodingException, FileNotFoundException {
        String[] lWord;
        double valor = 0.0;        
        double aux;
        int cont = 0;
        
        lWord = cad.split(" ");
        for (int i = 0; i < lWord.length; i++) {            
            aux = csv.palabraVScsv(stm_es.stemm(lWord[i]));
            if(aux != 0.0){
                cont++;
            }
            valor += aux;
            cadDatos += " " + lWord[i] + ":" + aux;                     
        }
        if(cont > 0){                        
            return (valor/cont);
        }
        return -1;
    }
}
