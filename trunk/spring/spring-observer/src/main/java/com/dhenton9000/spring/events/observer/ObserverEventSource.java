/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.events.observer;

/**
 *
 * @author dhenton
 */
import com.dhenton9000.spring.events.MessageEvent;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * in this demo, this is both  a source and a consumer of events
 * 
 * @author dhenton
 */
public class ObserverEventSource implements MessageEventPublisher, MessageEventListener, BeanPostProcessor {
    
    private static final Logger log = LogManager.getLogger(ObserverEventSource.class);
    private Timer timer;
    private TimerTask timerTask;
    private int counter = 0;
    private long repeatTime = 0L;
    private String name = null;
    private EventMediator  mediator = null;

    public ObserverEventSource() {

    }

    /**
     * @return the repeatTime
     */
    public long getRepeatTime() {
        return repeatTime;
    }

    /**
     * @param repeatTime the repeatTime to set
     */
    public void setRepeatTime(long repeatTime) {
        this.repeatTime = repeatTime;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        this.timerTask = new TimerTask() {

            @Override
            public void run() {
                getMediator().sendMessage(new MessageEvent(ObserverEventSource.this,getName()+" ["+(counter++)+"]"));
 
            }

        };

        this.timer = new Timer();
        this.timer.schedule(timerTask, 1200L, getRepeatTime());

        return bean;

    }

    @Override
    public void receiveMessage(MessageEvent ev) {
        log.debug("received in "+getName()+": "+ev);
    }

    /**
     * @return the mediator
     */
    public EventMediator  getMediator() {
        return mediator;
    }

    /**
     * @param mediator the mediator to set
     */
    @Override
    public void setMediator(EventMediator  mediator) {
        log.debug("mediator set for "+getName()+" '"+mediator+"'");
        this.mediator = mediator;
    }

     
    
}
