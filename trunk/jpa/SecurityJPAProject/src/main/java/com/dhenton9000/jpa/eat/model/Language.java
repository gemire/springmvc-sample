package com.dhenton9000.jpa.eat.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Language implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(updatable = false, length = 36)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /**
     * two characters iso2, it, en...
     */
    public static final String LANGUAGE_FIELD = "language";
    /**
     * two characters iso2, IT, EN ...
     */
    public static final String COUNTRY_FIELD = "country";
    private String language;
    private String country;

    public Language() {
        super();
    }

    public Language(String language, String country) {
        super();
        this.language = language;
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return language;
    }
}