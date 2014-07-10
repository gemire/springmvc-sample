package com.dhenton9000.spring.events.async;

import com.dhenton9000.spring.events.MessageEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;

public class ResponseHandler implements ApplicationListener<MessageEvent> {

    private static final Logger log = LogManager.getLogger(ResponseHandler.class);
    private String name = null;

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {

        log.debug("responder " + getName() + ": " + messageEvent);

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
