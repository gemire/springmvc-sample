package com.dhenton9000.spring.events.async;

import com.dhenton9000.spring.events.MessageEvent;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class EventSource implements  ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher ;
    private Timer timer;
    private TimerTask timerTask;
    private int counter = 0;
    private long repeatTime = 0L;
    private String name = null;
    
    @Override
    public void setApplicationEventPublisher(
           final ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.timerTask = new TimerTask()
        {

            @Override
            public void run() {
                ApplicationEvent ae  = new MessageEvent(EventSource.this,getName()+" ["+(counter++)+"]");
                applicationEventPublisher.publishEvent(ae);
                
            }
            
        };
        
        this.timer = new Timer();
        this.timer.schedule(timerTask, 200L, getRepeatTime());
        
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

 
    
}
