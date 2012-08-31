package com.dhenton9000.antlr.demoone.assignment;

import org.antlr.runtime.tree.Tree;

public class Assignment extends BaseComponent {

	private Var leftVar;
	private Var rightVar;

	public Assignment() {
	}

	public Assignment(Tree t) {
		// alway have a VARIABLE on the left
		setLeftVar(new Var(t.getChild(0)));
		// may have VARIABLE, STRING, INTEGER
		// if former let the VAR format itself
		// otherwise place the value from the tree into the varname portion of
		// a new VAR object
		
		if (t.getChild(1).getText().equals(TOKEN_NAMES.VAR.toString()))
		{
			setRightVar(new Var(t.getChild(1)));
		}
		else
		{
			Var v = new Var();
			v.setVarName(t.getChild(1).getText());
			setRightVar(v);
			
		}// handle assignment to single string
		
		
		
		
	}

	public Var getLeftVar() {
		return leftVar;
	}

	public void setLeftVar(Var leftVar) {
		this.leftVar = leftVar;
	}

	public Var getRightVar() {
		return rightVar;
	}

	public void setRightVar(Var rightVar) {
		this.rightVar = rightVar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leftVar == null) ? 0 : leftVar.hashCode());
		result = prime * result
				+ ((rightVar == null) ? 0 : rightVar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment other = (Assignment) obj;
		if (leftVar == null) {
			if (other.leftVar != null)
				return false;
		} else if (!leftVar.equals(other.leftVar))
			return false;
		if (rightVar == null) {
			if (other.rightVar != null)
				return false;
		} else if (!rightVar.equals(other.rightVar))
			return false;
		return true;
	}

	public String toString() {

		if (getLeftVar() == null || getRightVar() == null)
			return null;
		else
			return getLeftVar().toString() + " := " + getRightVar().toString();
	}

}
