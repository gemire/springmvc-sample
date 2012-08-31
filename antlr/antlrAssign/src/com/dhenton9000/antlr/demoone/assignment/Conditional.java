package com.dhenton9000.antlr.demoone.assignment;

import org.antlr.runtime.tree.Tree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Conditional  extends BaseComponent {

	private Var leftVar = null;
	private Var rightVar = null;
	private String conditionalOperation = null;
	private static Logger log = LogManager.getLogger(Conditional.class);

	public Conditional() {
	}

	public Conditional(Tree t) {
		// assumes a conditional tree segment

		setConditionalOperation(t.getText());
		setLeftVar(new Var(t.getChild(0)));
		setRightVar(new Var(t.getChild(1)));
		
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

	public String getConditionalOperation() {
		return conditionalOperation;
	}

	public void setConditionalOperation(String conditionalOperation) {
		this.conditionalOperation = conditionalOperation;
	}

	public String toString() {

		if (getLeftVar() == null || getRightVar() == null)
			return null;
		else
			return getLeftVar().toString()+" " + getConditionalOperation()
					+ " "+getRightVar().toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((conditionalOperation == null) ? 0 : conditionalOperation
						.hashCode());
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
		Conditional other = (Conditional) obj;
		if (conditionalOperation == null) {
			if (other.conditionalOperation != null)
				return false;
		} else if (!conditionalOperation.equals(other.conditionalOperation))
			return false;
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

}
