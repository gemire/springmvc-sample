package com.dhenton9000.classic;


public class Utils {

  public static final String createErrorMessage(Exception e)
   {
       return "error class: " + e.getClass().getName() + " " + e.getMessage();
   }

}

