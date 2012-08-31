package com.dhenton9000.antlr.demoone.assignment;

import org.antlr.runtime.tree.Tree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This class is a variable in the marshalled object which has 3 forms
 * VARIABLE fred.ted the varname is fred, the attribute is ted
 * STRING "get a job" the varname is 'get a job' the attribute is null
 * INTEGER 67 the varname is "67" and the attribute is null
 * Handling this is done in the {#@link Assignment} class.
 * @author <username>
 *
 */
public class Var {
	private static Logger log = LogManager.getLogger(Var.class);
	private String varName;
	private String attribute;

	public enum VAR_TYPE {
		NOT_SET, VARIABLE, INTEGER, STRING;
	}

	public Var() {
	}

	public Var(Tree t) {
		// assumes that the tree submitted is a var tree

		if (t.getChildCount() == 0)
			throw new RuntimeException("Zero count");

		if (t.getChild(0) != null)
			setVarName(t.getChild(0).getText());
		setAttribute(t.getChild(1).getText());

	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {

		varName = varName.replaceAll("\"", "");

		this.varName = varName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((varName == null) ? 0 : varName.hashCode());
		return result;
	}

	public String toString() {
		 
		String ret = "";
		VAR_TYPE v = getVarType();
		switch (v) {
		case INTEGER:
			ret = getVarName();
			break;

		case STRING:
			ret += "\"" + getVarName() + "\"";
			break;

		case VARIABLE:
			ret = getVarName()+"."+getAttribute();
			break;
		}

		return ret;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return attribute;
	}

	public VAR_TYPE getVarType() {

		if (getAttribute() != null && getVarName() != null) {
			return VAR_TYPE.VARIABLE;
		}
		if (getAttribute() == null && getVarName() != null) {
			boolean isInteger = true;
			try {
				Integer.parseInt(getVarName());
			} catch (NumberFormatException e) {
				isInteger = false;
			}
			if (isInteger)
				return VAR_TYPE.INTEGER;
			else
				return VAR_TYPE.STRING;

		}// end attribute null

		return VAR_TYPE.NOT_SET;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Var other = (Var) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (varName == null) {
			if (other.varName != null)
				return false;
		} else if (!varName.equals(other.varName))
			return false;
		return true;
	}

}
