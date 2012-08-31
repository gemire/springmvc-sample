/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.mapping.demo.two;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHOICE_TWO")
public class ChoiceTwo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHOICE_ID")
    private Long id;
    @Column(name = "TEXT")
    private String text;
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID", updatable = false, insertable = false)
    private QuestionTwo question;

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
     * @return the question
     */
    public QuestionTwo getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(QuestionTwo question) {
        this.question = question;
    }
}