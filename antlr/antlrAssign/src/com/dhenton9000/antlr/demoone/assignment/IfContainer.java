package com.dhenton9000.antlr.demoone.assignment;

import java.util.ArrayList;

import org.antlr.runtime.tree.Tree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class IfContainer extends BaseComponent {

	private ArrayList<Assignment> trueAssignments = new ArrayList<Assignment>();
	private ArrayList<Assignment> falseAssignments = new ArrayList<Assignment>();
	private static Logger log = LogManager.getLogger(IfContainer.class);
	private Conditional condition = null;
	private boolean hasFalseBranch = false;

	public IfContainer() {
	}

	public void loadFromTree(Tree ifTree) {
		Tree conditionalTree = ifTree.getChild(ifTree.getChildCount() - 1);
		condition = new Conditional(conditionalTree);
		int ifTreeChildCount = ifTree.getChildCount();
		// 3 means a true false and conditional , conditional is always last
		Tree trueTree = ifTree.getChild(0);
		for (int k = 0; k < trueTree.getChildCount(); k++) {
			Tree tA = trueTree.getChild(k);
			this.trueAssignments.add(new Assignment(tA));
		}
		if (ifTreeChildCount == 3) {
			hasFalseBranch = true;
			Tree falseTree = ifTree.getChild(1);
			for (int k = 0; k < falseTree.getChildCount(); k++) {
				Tree tA = falseTree.getChild(k);
				this.falseAssignments.add(new Assignment(tA));
			}

		}// end if false branch exists

	}

	public ArrayList<Assignment> getTrueAssignments() {
		return trueAssignments;
	}

	public ArrayList<Assignment> getFalseAssignments() {
		return falseAssignments;
	}

	public void setCondition(Conditional condition) {
		this.condition = condition;
	}

	public Conditional getCondition() {
		return condition;
	}

	public String toString() {
		String info = "";
		info += "IF " + getCondition().toString() + " THEN \n";
		for (Assignment a1 : trueAssignments)
			info += indent + a1.toString() + "\n";
		if (hasFalseBranch) {
			info += "ELSE\n";

			for (Assignment a1 : falseAssignments)
				info += indent + a1.toString() + "\n";
		}
		info += "ENDIF\n";
		return info;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((condition == null) ? 0 : condition.hashCode());
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
		IfContainer other = (IfContainer) obj;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		return true;
	}

	public boolean isHasFalseBranch() {
		return hasFalseBranch;
	}

}
