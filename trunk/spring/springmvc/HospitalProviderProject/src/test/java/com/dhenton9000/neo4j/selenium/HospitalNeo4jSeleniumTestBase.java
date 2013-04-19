/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.neo4j.selenium;

import com.dhenton9000.neo4j.hospital.HospitalDbMaker;
import com.dhenton9000.neo4j.hospital.service.HospitalTestBase;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhenton
 */
public class HospitalNeo4jSeleniumTestBase {

    protected static JavascriptExecutor js;
    private final static Logger logger =
            LoggerFactory.getLogger(HospitalNeo4jSeleniumTestBase.class);
    protected static WebDriver driver;
    private static final String FIND_NODE_NAME_SCRIPT =
            "return $('#tree1').tree('getSelectedNode').name";
     private static final String FIND_NODE_ID_SCRIPT =
            "return $('#tree1').tree('getSelectedNode').id";
    private String UNDEFINED = "undefined";
    private String SELECT_NODE_SCRIPT_FORMAT = "$('#tree1').tree('selectNode', $('#tree1').tree('getNodeById', %d));";
    private String HOME_PAGE = "http://localhost:7070/neo4j";

    @BeforeClass
    public static void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

    }

    // create a tree
    // get the newly selected node remember its id
    //
    
    
    protected HospitalNeo4jSeleniumTestBase createTree(String treeName) {

        WebElement c = driver.findElement(By.id("createTreeName"));
        c.sendKeys(treeName);
        WebElement subButton = driver.findElement(By.id("createTreeSubmit"));
        subButton.click();
        return this;
    }
    
    protected HospitalNeo4jSeleniumTestBase removeNode(String nodeName) {

        
        return this;
    }
    

    
    protected String getFormText(String textboxId) {
        WebElement c = driver.findElement(By.id(textboxId));
        return c.getAttribute("value");
    }

    protected HospitalNeo4jSeleniumTestBase go() {
        driver.get(HOME_PAGE);
        WebElement c = driver.findElement(By.linkText("Node Edit"));
        c.click();
        return this;
    }

    protected HospitalNeo4jSeleniumTestBase addNodeToCurrent(String newNodeLabel)
    {
        
        WebElement c = driver.findElement(By.id("insertName"));
        c.sendKeys(newNodeLabel);
        WebElement subButton = driver.findElement(By.id("insertNodeSubmit"));
        subButton.click();
        
        return this;
    }
    
    
    
    /**
     * select a node via the jquery Tree
     * @param nodeId
     * @return 
     */
    protected HospitalNeo4jSeleniumTestBase selectNode(int nodeId) {
        Object[] obj = new Object[0];
        String t = String.format(SELECT_NODE_SCRIPT_FORMAT, nodeId);
        js.executeScript(t, obj);
        return this;
    }

    /**
     * get the selected node from the jquery tree
     * @return 
     */
    protected String getSelectedNodeName() {
        String name = null;
        Object[] obj = new Object[0];
        name = (String) js.executeScript(FIND_NODE_NAME_SCRIPT, obj);
        if (name != null && name.equals(UNDEFINED)) {
            return null;
        }

        return name;
    }
    
     protected Long getSelectedNodeId() {
        Long name = null;
        Object[] obj = new Object[0];
        name = (Long) js.executeScript(FIND_NODE_ID_SCRIPT, obj);
        return name;
    }

    /**
     * select an item from a dropdown box at the ith position
     *
     * @param id
     * @param position (zero based)
     * @return
     */
    protected HospitalNeo4jSeleniumTestBase selectATree(int position) {
        WebElement dropDownListBox =
                driver.findElement(By.id("selectATree"));
        int cc = 0;
        Select clickThis = new Select(dropDownListBox);
        List<WebElement> items = clickThis.getOptions();
        for (WebElement w : items) {
            if (cc == position) {
                w.click();
                break;
            }
            cc++;
        }
        WebElement subButton = driver.findElement(By.id("selectTreeSubmit"));
        subButton.click();
        return this;
    }

    /**
     * select an item from a dropdown box by text
     *
     * @param id
     * @param position (zero based)
     * @return
     */
    protected HospitalNeo4jSeleniumTestBase selectATree(String label) {
        WebElement dropDownListBox =
                driver.findElement(By.id("selectATree"));
        int cc = 0;
        Select clickThis = new Select(dropDownListBox);
        List<WebElement> items = clickThis.getOptions();
        for (WebElement w : items) {
            if (w.getText().equals(label)) {
                w.click();
                break;
            }
            cc++;
        }
        WebElement subButton = driver.findElement(By.id("selectTreeSubmit"));
        subButton.click();
        return this;
    }
}
