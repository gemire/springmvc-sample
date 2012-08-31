grammar Assign10;


options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header {
  package com.dhenton9000.assign.parsers;
}

@lexer::header {
  package com.dhenton9000.assign.lexers;
}


program	:	


	(statements)+ ->  ^(PROGRAM (statements)+);

statements
	:	ifStatement | usingStatement;

usingStatement	  
scope 
{
	Token idToken;
}


: 
			USING  identVar=IDENT {$usingStatement::idToken = $identVar;}

			(implicitIfStatement)*
		
		     'END_USING'	
		     
		     ->^(USING ^(IDENT (implicitIfStatement)*))

	;
	

implicitIfStatement


	:	
	
	IF  implicit_comparison    THEN 
		(strue2+=implicit_assignment)+
	
	(ELSE  (sfalse2+=implicit_assignment)+)?
	ENDIF
	-> ^(IF ^(TRUE $strue2+) ^(FALSE $sfalse2+)? implicit_comparison )	
	;


ifStatement 
	:	
	
	IF  explicit_comparison    THEN 
		(strue1+=explicit_assignment)+
	
	(ELSE  (sfalse1+=explicit_assignment)+)?
	ENDIF
	-> ^(IF ^(TRUE $strue1+) ^(FALSE $sfalse1+)? explicit_comparison )	
	
	;


logical_operator
	:	AND|OR;	
	
IF	:	'IF';
THEN	:	'THEN';
ENDIF	:	'ENDIF';
ELSE	:	'ELSE';
AND	:	'&&';
OR	:	'||';

BECOMES	:	':=';
TRUE	:	'TRUE';
FALSE	:	'FALSE';
USING	:	'USING';


	
explicit_assignment
	: v1=explicit_variable BECOMES v2=explicit_variable -> ^(BECOMES $v1 $v2) | 
	v3=explicit_variable BECOMES VALUE -> ^(BECOMES $v3 VALUE)         |
	v4=explicit_variable BECOMES STRING -> ^(BECOMES $v4 STRING)
	
	;
	
comparison
	:		
'<>'|'=='|'!='|'>'|'>='|'<'|'<=' ;
	
implicit_assignment	:	

explicit_assignment |
	
	v1=implicit_variable BECOMES v2=implicit_variable -> ^(BECOMES   $v1 $v2 ) | 
	v3=implicit_variable BECOMES VALUE  -> ^(BECOMES  $v3 VALUE   )         |
	v4=implicit_variable BECOMES STRING -> ^(BECOMES  $v4 STRING)
	
	| x1=implicit_variable BECOMES x2=explicit_variable -> ^(BECOMES   $x1 $x2 )
	| x3=explicit_variable BECOMES x4=implicit_variable -> ^(BECOMES   $x3 $x4)
	
	;	
		
	
explicit_comparison
	:   exp1=explicit_variable comparison  exp2=explicit_variable -> ^(comparison $exp1 $exp2)	;

implicit_comparison


	: explicit_comparison |
		ixp1=implicit_variable comparison ixp2=implicit_variable -> ^(comparison $ixp1 $ixp2)	|
		exp3=explicit_variable comparison ixp4=implicit_variable -> ^(comparison $exp3 $ixp4)       |
		ixp5=implicit_variable comparison exp4=explicit_variable -> ^(comparison $ixp5 $exp4)
	;


implicit_variable

@after
{
   	
  Object ID1_tree = (Object)adaptor.create($usingStatement::idToken);
  adaptor.addChild($implicit_variable.tree, ID1_tree);
  /*
  CommonTree firstChild =	(CommonTree) adaptor.getChild($implicit_variable.tree,0);
  CommonTree secondChild = (CommonTree) ID1_tree;
  String member =  firstChild.getText();
  String objName = secondChild.getText();
  firstChild.getToken().setText("fred");
  secondChild.getToken().setText("ted");
  
 */
  	
}



	

	:	 dot_operation  d0=IDENT  
	
	
	 -> ^(IMPLICIT_VAR  $d0)   
	 
	 
	 
	 
	 
	  ;
	
	 
	 	
	
explicit_variable
	:	c0=IDENT dot_operation c1=IDENT  -> ^(VAR $c0 $c1)  ;
	
	
dot_operation
	:	DOT_OP;	
	

VAR
	:	'VAR';
IMPLICIT_VAR
	:	'IMPLICIT_VAR';
	
	
	
DOT_OP	:	'.';
COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;


ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
PROGRAM	:	 'PROGRAM' ;


VALUE : DIGIT+ ;
IDENT : LETTER (LETTER | DIGIT)*;