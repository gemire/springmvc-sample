/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springobserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TownCrier implements Subject {

    private List townResidents = new ArrayList();
    private String messageText;
    private Logger log = LogManager.getLogger(TownCrier.class);

    // this message is added so I can give 
    // this class a reason to call notifyListener.
    public void setMessage(String message) {
        log.debug("I'm the Town Crier and "
                + "I've got a message: " + message);
        this.messageText = message;
        this.notifyListeners();
    }

    public void addListener(Observer o) {
        this.getTownResidents().add(o);
    }

    public void removeListener(Observer o) {
        if (this.getTownResidents().contains(o)) {
            this.getTownResidents().remove(o);
        }
    }

    // call the update method on 
    // each observer (town resident)
    public void notifyListeners() {
        for (Iterator iter = getTownResidents().iterator(); iter.hasNext();) {
            Observer listener = (Observer) iter.next();
            listener.update(messageText);
        }
    }

    /**
     * @return the townResident
     */
    public List getTownResidents() {
        return townResidents;
    }
}