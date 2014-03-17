/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miw.websemantica.rest;

import org.knallgrau.utils.textcat.TextCategorizer;
import java.util.HashMap;

/**
 * Encuentra el idioma de un texto dado
 * @author Sebastian
 *
 */
public class LangDetector {

  // -------------------------------------------------------------------------------------
  // Constantes
  // -------------------------------------------------------------------------------------

  /**
   * Idioma inglés
   */
  private final String ENGLISH="english";
  
  /**
   * Idioma español
   */
  private final String SPANISH="spanish";
  
  /**
   * Idioma francés
   */
  private final String FRENCH="french";
  
  /**
   * Idioma alemán
   */
  private final String GERMAN="german";

  // -------------------------------------------------------------------------------------
  // Miembros de la clase
  // -------------------------------------------------------------------------------------
  
  /**
   * Clase que detecta los idiomas
   */
  private TextCategorizer categorizer;
  
  /**
   * Traduce los lenguajes detectados a códigos ISO 639-1
   */
  private HashMap<String, String> textToCode;
  
   {
    categorizer = new TextCategorizer();
    
    textToCode = new HashMap<String, String>();
    textToCode.put(ENGLISH, Commons.ENGLISH_LANG);
    textToCode.put(SPANISH, Commons.SPANISH_LANG);
    textToCode.put(FRENCH, Commons.FRENCH_LANG);
    textToCode.put(GERMAN, Commons.GERMAN_LANG);
  }
  
  // -------------------------------------------------------------------------------------
  // Métodos estáticos
  // -------------------------------------------------------------------------------------
  
  /**
   * Encuentra el idioma del texto dado
   * @param text
   * @return
   */
  public String detectLanguage(String text) {
    return textToCode.get(categorizer.categorize(text));
  }

}

