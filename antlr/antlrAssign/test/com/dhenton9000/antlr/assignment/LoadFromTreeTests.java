package com.dhenton9000.antlr.assignment;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.dhenton9000.antlr.demoone.assignment.Assignment;
import com.dhenton9000.antlr.demoone.assignment.IfContainer;
import com.dhenton9000.antlr.demoone.assignment.Program;
import com.dhenton9000.antlr.demoone.assignment.Var;
import com.dhenton9000.antlr.demoone.assignment.Var.VAR_TYPE;

public class LoadFromTreeTests extends BaseTest {

	
	
	@Test
	public void testConditional() throws IOException
	{
		
		Program p = this.getSampleProgram("samples/using.txt");
		assertEquals(3,p.getIfStatements().size());
		IfContainer iFc = p.getIfStatements().get(0);
		Var left = iFc.getCondition().getLeftVar();
		assertEquals("zzz",left.getVarName());
		assertEquals("u1",left.getAttribute());
		Var right = iFc.getCondition().getRightVar();
		assertEquals("zzz",right.getVarName());
		assertEquals("frump",right.getAttribute());
		
		String c = iFc.getCondition().getConditionalOperation();
		assertEquals("==",c);
		
		iFc = p.getIfStatements().get(2);
		left = iFc.getCondition().getLeftVar();
		assertEquals("fromusing",left.getVarName());
		assertEquals("boss",left.getAttribute());
		right = iFc.getCondition().getRightVar();
		assertEquals("fromusing",right.getVarName());
		assertEquals("tweed",right.getAttribute());
		
		
	}
	
	@Test
	public void testAssignments() throws Exception
	{
		Program p = this.getSampleProgram("samples/using.txt");
		IfContainer iFc = p.getIfStatements().get(0);
		assertFalse(iFc.isHasFalseBranch());
		assertEquals(2,iFc.getTrueAssignments().size());
		Assignment a1 = iFc.getTrueAssignments().get(0);
		
		Var left = a1.getLeftVar();
		assertEquals("exp",left.getVarName());
		assertEquals("exp1",left.getAttribute());
		Var right = a1.getRightVar();
		assertEquals("zzz",right.getVarName());
		assertEquals("u2",right.getAttribute());

		
	}
	
	@Test
	public void testStringAssigment() throws Exception
	{
		Program p = this.getSampleProgram("samples/s3.txt");
		IfContainer iFc = p.getIfStatements().get(0);
		assertTrue(iFc.isHasFalseBranch());
		assertEquals(3,iFc.getTrueAssignments().size());
		Assignment a1 = iFc.getTrueAssignments().get(0);
		assertEquals(2,iFc.getFalseAssignments().size());
		Var left = a1.getLeftVar();
		assertEquals("fred",left.getVarName());
		assertEquals("ted",left.getAttribute());
		Var right = a1.getRightVar();
		assertEquals(VAR_TYPE.STRING,right.getVarType());
		assertEquals("get a job",right.getVarName());
		assertNull(right.getAttribute());

		String c = iFc.getCondition().getConditionalOperation();
		assertEquals(">",c);

	}	
	
	
}
