package com.nitro.falcon.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Quizz
 * @author leops
 */
@Entity
public class Quizz implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private List<String> questions;
    
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(final List<String> questions) {
        this.questions = questions;
    }
    
    
}
