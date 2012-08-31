/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample.parties;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a generator with a switch. The list type is the 
 * switch for this generator see SimpleModule and TestSamples. In the
 * SimpleModule 
 * @author dhenton
 */
public class AffliationGenerator implements Provider<List<String>> {

    public enum LIST_TYPE {

        democratic,
        communist,
        facist
    }
    @Inject
    @Named("listType")
    private LIST_TYPE listType = null;

    public List<String> get() {

        ArrayList<String> listvar = new ArrayList<String>();

        switch (listType) {
            case democratic:
                listvar.add("Democrat");
                listvar.add("Republican");
                break;
            case communist:
                listvar.add("Bolshevek");
                listvar.add("Trotskyite");
                break;
            case facist:
                listvar.add("Hitlerian");
                listvar.add("Togoan");
                break;



        }




        return listvar;
    }
}
