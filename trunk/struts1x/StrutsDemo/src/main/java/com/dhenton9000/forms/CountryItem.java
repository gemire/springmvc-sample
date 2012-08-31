package com.dhenton9000.forms;

import java.io.Serializable;

public class CountryItem implements Serializable {
  
private static final long serialVersionUID = 5365972430104981045L;
private String label = null;
   private int value = 0;
public CountryItem(String ct, int val) {
	value = val;
	label = ct;
}
public void setValue(int value) {
	this.value = value;
}
public int getValue() {
	return value;
}
public void setLabel(String label) {
	this.label = label;
}
public String getLabel() {
	return label;
}
   
   
   
   
   
}
