tree grammar AssignTreeTmplWalker;
options
{
  tokenVocab=Assign; 
  output=template;
}

program	:	


	^(PROGRAM (iff1+=ifStatement)+ ) -> program(p1={$iff1})
	
	;

ifStatement
	:	
	^(IF (con200+=consequence)+ comp200=comparison)  -> ifPrint(c1={$con200},c2={$comp200.text})	
	;

consequence
	:	
			^(TRUE  (as1+=assignment)+)      -> trueBranch(bt={$as1})
		| 	^(FALSE (as2+=assignment)+)      -> falseBranch(bf={$as2})
	
	;


assignment
	:
		
	  ^(BECOMES vv1=var vv2=var) 		-> assignment(v1={$vv1.text},v2={$vv2.text})
	| ^(BECOMES vv3=var s100=STRING)        -> assignment(v1={$vv3.text},v2={$s100})
	| ^(BECOMES vv4=var v100=VALUE)         -> assignment(v1={$vv4.text},v2={$v100})
	
	;

var	:	
	^(VAR id1=IDENT id2=IDENT) -> var(id1={$id1},id2={$id2}) 
	;


comparison
	:	
	
	   ^(cc1=comparator vv3=var vv4=var) ->  comparison(var1={$vv3.text},c1={$cc1.text},var2={$vv4.text});
	 
	
comparator
	:		
'<>'|'=='|'!='|'>'|'>='|'<'|'<=' ;	


	