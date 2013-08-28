/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springdemos;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhenton
 */
@Service
public class DependencyDemo {
    
    @Resource
    private ScannedDependency dependency;
    
    
    
    public String getMessage()
    {
        return dependency.getMessage();
    }
    
    public Class getDependencyClass()
    {
        return dependency.getClass();
    }
    
    
}
