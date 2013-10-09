/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.mvc.controllers;

import com.dhenton9000.spring.mvc.model.BookMaker;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Don
 */
@Controller
@RequestMapping(value = "/context/*")
public class ContextDemoController implements ApplicationContextAware {

    private ApplicationContext context;
    private String message;
    private BookMaker bookMaker;

    @RequestMapping(value = "bookMaker")
    public ModelAndView showBookMaker() {
        setBookMaker((BookMaker) getContext().getBean("bookMaker"));
        return new ModelAndView("tiles.context.load", "controller", this);

    }

    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        context = ac;
    }

    /**
     * @return the context
     */
    public ApplicationContext getContext() {
        return context;
    }

   
    /**
     * @return the message
     */
    public String getMessage() {
       if (message == null)
       {
           return "null message";
       }
       
       return message;
       
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        System.out.println("!!!!!!!!!!!!!!! "+message);
        this.message = message;
    }

    /**
     * @return the bookMaker
     */
    public BookMaker getBookMaker() {
        return bookMaker;
    }

    /**
     * @param bookMaker the bookMaker to set
     */
    public void setBookMaker(BookMaker bookMaker) {
        this.bookMaker = bookMaker;
    }
}
