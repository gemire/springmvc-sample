/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.springdemos.annotations;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhenton
 */
@Service
public class AnnotatedResourceSample {
    
    
    @Resource
    private ReportService reporterService ;
    
    
    public String report()
    {
        return reporterService.report();
    }
    
}
