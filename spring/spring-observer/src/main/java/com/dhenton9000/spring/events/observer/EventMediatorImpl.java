/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.events.observer;

import com.dhenton9000.spring.events.MessageEvent;
import java.util.List;

/**
 *
 * @author dhenton
 */
public class EventMediatorImpl implements EventMediator {

    private List<MessageEventPublisher> registeredPublishers = null;
    private List<MessageEventListener> registeredListeners = null;

    /**
     * @return the registeredObservers
     */
    public List<MessageEventPublisher> getRegisteredPublishers() {
        return registeredPublishers;
    }

    /**
     * @param registeredPublishers the registeredPublishers to set
     */
    public void setRegisteredPublishers(List<MessageEventPublisher> registeredPublishers) {
        
        this.registeredPublishers = registeredPublishers;
        for (MessageEventPublisher m: registeredPublishers)
        {
            m.setMediator(this);
        }
    }

    @Override
    public void sendMessage(MessageEvent arg) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;

        synchronized (this) {
            /* We don't want the Observer doing callbacks into
             * arbitrary code while holding its own Monitor.
             * The code where we extract each Observable from
             * the Vector and store the state of the Observer
             * needs synchronization, but notifying observers
             * does not (should not).  The worst result of any
             * potential race-condition here is that:
             * 1) a newly-added Observer will miss a
             *   notification in progress
             * 2) a recently unregistered Observer will be
             *   wrongly notified when it doesn't care
             */

            arrLocal = registeredListeners.toArray();
        }

        for (int i = arrLocal.length - 1; i >= 0; i--) {
            ((MessageEventListener) arrLocal[i]).receiveMessage(arg);
        }
    }

    @Override
    public String toString() {
        String info = "null";
        if (registeredListeners != null) {
            info = " listeners "+registeredListeners.size() + " ";
        }
         if (registeredPublishers != null) {
            info = " publishers"+registeredPublishers.size() + " ";
        }
       return "Mediator (" + info + ")";
    }

    /**
     * @return the registeredListeners
     */
    public List<MessageEventListener> getRegisteredListeners() {
        return registeredListeners;
    }

    /**
     * @param registeredListeners the registeredListeners to set
     */
    public void setRegisteredListeners(List<MessageEventListener> registeredListeners) {
        this.registeredListeners = registeredListeners;
    }

     

}
