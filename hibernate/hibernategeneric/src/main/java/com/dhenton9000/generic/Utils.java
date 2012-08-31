package com.dhenton9000.generic;


public class Utils {

  public static final String createErrorMessage(Exception e)
   {
       return "error class: " + e.getClass().getName() + " " + e.getMessage();
   }

}

