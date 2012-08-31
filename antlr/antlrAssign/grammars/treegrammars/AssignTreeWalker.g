tree grammar AssignTreeWalker;
options
{
  tokenVocab=Assign10; 
  ASTLabelType=CommonTree;
  output=AST;
}

program	:	


	^(PROGRAM ( statements)+ );

statements
	:	
	   ifStatement | usingStatement 
	;

usingStatement
	:	
	^(USING ^(IDENT (ifStatement)+)) -> (ifStatement)+	
	;
	
ifStatement
	:	
	^(IF (consequence)+ comparison) 	
	;

consequence
	:	
		^(TRUE (assignment)+) 
		| ^(FALSE (assignment)+)
	
	;



assignment
	:	
	^(BECOMES var var) |^(BECOMES var STRING) | ^(BECOMES var VALUE) 
	;

var	:	
	^(VAR IDENT IDENT)
	
	|^(IMPLICIT_VAR id1=IDENT id2=IDENT)  -> ^(VAR $id2 $id1)
	;


comparison
	:	
	
	   ^(comparator var var)
	;
	
comparator
	:		
'<>'|'=='|'!='|'>'|'>='|'<'|'<=' ;	


	