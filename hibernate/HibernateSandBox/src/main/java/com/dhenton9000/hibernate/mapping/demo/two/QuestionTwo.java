/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.mapping.demo.two;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "QUESTION_TWO")
public class QuestionTwo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QUESTION_ID")
    private Long id;
    @Column(name = "TEXT")
    private String text;
    
    
  
   @OneToMany
   @JoinColumn (name = "QUESTION_ID")
   private Set<ChoiceTwo> choices = new HashSet();
    
    
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the choices
     */
    public Set<ChoiceTwo> getChoices() {
        return choices;
    }

    /**
     * @param choices the choices to set
     */
    public void setChoices(Set<ChoiceTwo> choices) {
        this.choices = choices;
    }
}
