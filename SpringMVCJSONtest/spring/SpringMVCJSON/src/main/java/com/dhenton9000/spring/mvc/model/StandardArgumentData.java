package com.dhenton9000.spring.mvc.model;

import java.io.Serializable;

public class StandardArgumentData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5558427175857183858L;
	private String description;
	private String result;
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult() {
		return result;
	}
	
	public String toString()
	{
		return "results: "+result+" description: "+description;
	}
	
	
}
