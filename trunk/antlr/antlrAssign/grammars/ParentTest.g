grammar ParentTest;
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

	parent+;

	


parent	:	

	PARENT '(' ii=id ')'
	
	inf=information
	
	//(childrecord[$ii.text, inf.tree])+
	(childrecord)+
	
	END_PARENT  ->  ^(CHILD ^({$inf.tree}) childrecord)+

		
	;

id	:	ID;

//childrecord[String t, Object tree]	:	z1=CHILD ID ';' -> ^(CHILD ^({$tree}) ^(PARENT_INFO[$z1,$t] )   ID) ;
childrecord 
	:	child1=CHILD id1=ID ';' ->^(ID);
information 
	: INFO^ ID ID	';'!
	;

INFO	:	'INFO';
PARENT_INFO	:	'PARENT_INFO';
CHILD	:	'CHILD';
PARENT	:	 'PARENT';
END_PARENT
	:	'END_PARENT';

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

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

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
