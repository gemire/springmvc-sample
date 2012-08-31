package com.dhenton9000.strutsdemo.controllers.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.action.ActionMapping;

public class DemoActionMappings extends ActionMapping {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6318527597262741305L;
	private String sharedInformation = "test";
	private boolean firstTime = true;
	private Map demoMap = new HashMap();
	
	 
	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}
	public boolean isFirstTime() {
		return firstTime;
	}
	public void setSharedInformation(String sharedInformation) {
		this.sharedInformation = sharedInformation;
	}
	public String getSharedInformation() {
		return sharedInformation;
	}
	public void setDemoMap(Map demoMap) {
		this.demoMap = demoMap;
	}
	public Map getDemoMap() {
		return demoMap;
	}
	 
	
}
