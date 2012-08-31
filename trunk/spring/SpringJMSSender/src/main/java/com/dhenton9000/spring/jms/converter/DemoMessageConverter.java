/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.jms.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * A demonstration message converter only evoked by JmsTemplate convert* 
 * methods
 * @author dhenton
 */
public class DemoMessageConverter implements MessageConverter{

    public Message toMessage(Object o, Session sn) throws JMSException, MessageConversionException {
         TextMessage t = null;
        if (o instanceof String)
          {
        
          t = sn.createTextMessage();
          t.setText(o.toString());
          }
          else
          {
              throw new IllegalStateException("can only send Strings");
          }
          
          
          
          
          return t;
    }

    public Object fromMessage(Message msg) throws JMSException, MessageConversionException {
        Object o = null;
        if (msg instanceof TextMessage)
         {
              TextMessage t = (TextMessage) msg;
              o = t.getText();
         }
        else
        {
            throw new RuntimeException("can only convert Text not "+msg.getClass().getName());
        }
        
        return o;
    }
    
}
