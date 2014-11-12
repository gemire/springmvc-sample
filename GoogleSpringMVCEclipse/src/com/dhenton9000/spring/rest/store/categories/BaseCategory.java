package com.dhenton9000.spring.rest.store.categories;

  

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dhenton
 */
public class BaseCategory {
    
    private Integer id = null;
    private String name = null;
    private List<BaseCategory> children = new ArrayList<BaseCategory>();  

    public BaseCategory()
    {
        
    }
    
    public BaseCategory(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * @return the children
     */
    public List<BaseCategory> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<BaseCategory> children) {
        this.children = children;
    }
    
    
    
    
    
}