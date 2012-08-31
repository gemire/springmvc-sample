/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.utils.velocityproject;

import java.util.Locale;

/**
 *
 * @author dhenton
 */
public class Utility {
    
   public static String nameify(String t)
   {
       if (t == null)
           return "";
       
       String z = t.substring(0,1).toLowerCase() +t.substring(1,t.length());
       
       return z;
   }
   
    public static String  proper(String t)
   {
       if (t == null)
           return "";
       
       String z = t.substring(0,1).toUpperCase() +t.substring(1,t.length());
       
       return z;
   }
   
}
