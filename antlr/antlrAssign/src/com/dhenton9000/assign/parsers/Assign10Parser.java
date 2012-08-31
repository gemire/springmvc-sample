// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g 2011-03-20 07:21:30

  package com.dhenton9000.assign.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class Assign10Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "USING", "IDENT", "IF", "THEN", "ELSE", "ENDIF", "AND", "OR", "BECOMES", "TRUE", "FALSE", "VALUE", "STRING", "DOT_OP", "VAR", "IMPLICIT_VAR", "COMMENT", "WS", "ESC_SEQ", "CHAR", "LETTER", "DIGIT", "PROGRAM", "'END_USING'", "'<>'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='"
    };
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int USING=4;
    public static final int IDENT=5;
    public static final int IF=6;
    public static final int THEN=7;
    public static final int ELSE=8;
    public static final int ENDIF=9;
    public static final int AND=10;
    public static final int OR=11;
    public static final int BECOMES=12;
    public static final int TRUE=13;
    public static final int FALSE=14;
    public static final int VALUE=15;
    public static final int STRING=16;
    public static final int DOT_OP=17;
    public static final int VAR=18;
    public static final int IMPLICIT_VAR=19;
    public static final int COMMENT=20;
    public static final int WS=21;
    public static final int ESC_SEQ=22;
    public static final int CHAR=23;
    public static final int LETTER=24;
    public static final int DIGIT=25;
    public static final int PROGRAM=26;

    // delegates
    // delegators


        public Assign10Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Assign10Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return Assign10Parser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g"; }


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:19:1: program : ( statements )+ -> ^( PROGRAM ( statements )+ ) ;
    public final Assign10Parser.program_return program() throws RecognitionException {
        Assign10Parser.program_return retval = new Assign10Parser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Assign10Parser.statements_return statements1 = null;


        RewriteRuleSubtreeStream stream_statements=new RewriteRuleSubtreeStream(adaptor,"rule statements");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:19:9: ( ( statements )+ -> ^( PROGRAM ( statements )+ ) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:22:2: ( statements )+
            {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:22:2: ( statements )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==USING||LA1_0==IF) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:22:3: statements
            	    {
            	    pushFollow(FOLLOW_statements_in_program60);
            	    statements1=statements();

            	    state._fsp--;

            	    stream_statements.add(statements1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);



            // AST REWRITE
            // elements: statements
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 22:16: -> ^( PROGRAM ( statements )+ )
            {
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:22:20: ^( PROGRAM ( statements )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROGRAM, "PROGRAM"), root_1);

                if ( !(stream_statements.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statements.hasNext() ) {
                    adaptor.addChild(root_1, stream_statements.nextTree());

                }
                stream_statements.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class statements_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statements"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:24:1: statements : ( ifStatement | usingStatement );
    public final Assign10Parser.statements_return statements() throws RecognitionException {
        Assign10Parser.statements_return retval = new Assign10Parser.statements_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Assign10Parser.ifStatement_return ifStatement2 = null;

        Assign10Parser.usingStatement_return usingStatement3 = null;



        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:25:2: ( ifStatement | usingStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IF) ) {
                alt2=1;
            }
            else if ( (LA2_0==USING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:25:4: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statements83);
                    ifStatement2=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement2.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:25:18: usingStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_usingStatement_in_statements87);
                    usingStatement3=usingStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, usingStatement3.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statements"

    protected static class usingStatement_scope {
        Token idToken;
    }
    protected Stack usingStatement_stack = new Stack();

    public static class usingStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "usingStatement"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:27:1: usingStatement : USING identVar= IDENT ( implicitIfStatement )* 'END_USING' -> ^( USING ^( IDENT ( implicitIfStatement )* ) ) ;
    public final Assign10Parser.usingStatement_return usingStatement() throws RecognitionException {
        usingStatement_stack.push(new usingStatement_scope());
        Assign10Parser.usingStatement_return retval = new Assign10Parser.usingStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token identVar=null;
        Token USING4=null;
        Token string_literal6=null;
        Assign10Parser.implicitIfStatement_return implicitIfStatement5 = null;


        CommonTree identVar_tree=null;
        CommonTree USING4_tree=null;
        CommonTree string_literal6_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_USING=new RewriteRuleTokenStream(adaptor,"token USING");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleSubtreeStream stream_implicitIfStatement=new RewriteRuleSubtreeStream(adaptor,"rule implicitIfStatement");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:34:1: ( USING identVar= IDENT ( implicitIfStatement )* 'END_USING' -> ^( USING ^( IDENT ( implicitIfStatement )* ) ) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:35:4: USING identVar= IDENT ( implicitIfStatement )* 'END_USING'
            {
            USING4=(Token)match(input,USING,FOLLOW_USING_in_usingStatement109);  
            stream_USING.add(USING4);

            identVar=(Token)match(input,IDENT,FOLLOW_IDENT_in_usingStatement114);  
            stream_IDENT.add(identVar);

            ((usingStatement_scope)usingStatement_stack.peek()).idToken = identVar;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:37:4: ( implicitIfStatement )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IF) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:37:5: implicitIfStatement
            	    {
            	    pushFollow(FOLLOW_implicitIfStatement_in_usingStatement123);
            	    implicitIfStatement5=implicitIfStatement();

            	    state._fsp--;

            	    stream_implicitIfStatement.add(implicitIfStatement5.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            string_literal6=(Token)match(input,27,FOLLOW_27_in_usingStatement137);  
            stream_27.add(string_literal6);



            // AST REWRITE
            // elements: USING, implicitIfStatement, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 41:8: -> ^( USING ^( IDENT ( implicitIfStatement )* ) )
            {
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:41:10: ^( USING ^( IDENT ( implicitIfStatement )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_USING.nextNode(), root_1);

                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:41:18: ^( IDENT ( implicitIfStatement )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(stream_IDENT.nextNode(), root_2);

                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:41:26: ( implicitIfStatement )*
                while ( stream_implicitIfStatement.hasNext() ) {
                    adaptor.addChild(root_2, stream_implicitIfStatement.nextTree());

                }
                stream_implicitIfStatement.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            usingStatement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "usingStatement"

    public static class implicitIfStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicitIfStatement"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:46:1: implicitIfStatement : IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison ) ;
    public final Assign10Parser.implicitIfStatement_return implicitIfStatement() throws RecognitionException {
        Assign10Parser.implicitIfStatement_return retval = new Assign10Parser.implicitIfStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF7=null;
        Token THEN9=null;
        Token ELSE10=null;
        Token ENDIF11=null;
        List list_strue2=null;
        List list_sfalse2=null;
        Assign10Parser.implicit_comparison_return implicit_comparison8 = null;

        RuleReturnScope strue2 = null;
        RuleReturnScope sfalse2 = null;
        CommonTree IF7_tree=null;
        CommonTree THEN9_tree=null;
        CommonTree ELSE10_tree=null;
        CommonTree ENDIF11_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_implicit_comparison=new RewriteRuleSubtreeStream(adaptor,"rule implicit_comparison");
        RewriteRuleSubtreeStream stream_implicit_assignment=new RewriteRuleSubtreeStream(adaptor,"rule implicit_assignment");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:49:2: ( IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison ) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:51:2: IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF
            {
            IF7=(Token)match(input,IF,FOLLOW_IF_in_implicitIfStatement187);  
            stream_IF.add(IF7);

            pushFollow(FOLLOW_implicit_comparison_in_implicitIfStatement190);
            implicit_comparison8=implicit_comparison();

            state._fsp--;

            stream_implicit_comparison.add(implicit_comparison8.getTree());
            THEN9=(Token)match(input,THEN,FOLLOW_THEN_in_implicitIfStatement195);  
            stream_THEN.add(THEN9);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:52:3: (strue2+= implicit_assignment )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT||LA4_0==DOT_OP) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:52:4: strue2+= implicit_assignment
            	    {
            	    pushFollow(FOLLOW_implicit_assignment_in_implicitIfStatement203);
            	    strue2=implicit_assignment();

            	    state._fsp--;

            	    stream_implicit_assignment.add(strue2.getTree());
            	    if (list_strue2==null) list_strue2=new ArrayList();
            	    list_strue2.add(strue2.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:54:2: ( ELSE (sfalse2+= implicit_assignment )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ELSE) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:54:3: ELSE (sfalse2+= implicit_assignment )+
                    {
                    ELSE10=(Token)match(input,ELSE,FOLLOW_ELSE_in_implicitIfStatement211);  
                    stream_ELSE.add(ELSE10);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:54:9: (sfalse2+= implicit_assignment )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==IDENT||LA5_0==DOT_OP) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:54:10: sfalse2+= implicit_assignment
                    	    {
                    	    pushFollow(FOLLOW_implicit_assignment_in_implicitIfStatement217);
                    	    sfalse2=implicit_assignment();

                    	    state._fsp--;

                    	    stream_implicit_assignment.add(sfalse2.getTree());
                    	    if (list_sfalse2==null) list_sfalse2=new ArrayList();
                    	    list_sfalse2.add(sfalse2.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }

            ENDIF11=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_implicitIfStatement224);  
            stream_ENDIF.add(ENDIF11);



            // AST REWRITE
            // elements: implicit_comparison, IF, strue2, sfalse2
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: strue2, sfalse2
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_strue2=new RewriteRuleSubtreeStream(adaptor,"token strue2",list_strue2);
            RewriteRuleSubtreeStream stream_sfalse2=new RewriteRuleSubtreeStream(adaptor,"token sfalse2",list_sfalse2);
            root_0 = (CommonTree)adaptor.nil();
            // 56:2: -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison )
            {
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:56:5: ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:56:10: ^( TRUE ( $strue2)+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRUE, "TRUE"), root_2);

                if ( !(stream_strue2.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_strue2.hasNext() ) {
                    adaptor.addChild(root_2, stream_strue2.nextTree());

                }
                stream_strue2.reset();

                adaptor.addChild(root_1, root_2);
                }
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:56:27: ( ^( FALSE ( $sfalse2)+ ) )?
                if ( stream_sfalse2.hasNext() ) {
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:56:27: ^( FALSE ( $sfalse2)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FALSE, "FALSE"), root_2);

                    if ( !(stream_sfalse2.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_sfalse2.hasNext() ) {
                        adaptor.addChild(root_2, stream_sfalse2.nextTree());

                    }
                    stream_sfalse2.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_sfalse2.reset();
                adaptor.addChild(root_1, stream_implicit_comparison.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "implicitIfStatement"

    public static class ifStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:60:1: ifStatement : IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison ) ;
    public final Assign10Parser.ifStatement_return ifStatement() throws RecognitionException {
        Assign10Parser.ifStatement_return retval = new Assign10Parser.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF12=null;
        Token THEN14=null;
        Token ELSE15=null;
        Token ENDIF16=null;
        List list_strue1=null;
        List list_sfalse1=null;
        Assign10Parser.explicit_comparison_return explicit_comparison13 = null;

        RuleReturnScope strue1 = null;
        RuleReturnScope sfalse1 = null;
        CommonTree IF12_tree=null;
        CommonTree THEN14_tree=null;
        CommonTree ELSE15_tree=null;
        CommonTree ENDIF16_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_explicit_assignment=new RewriteRuleSubtreeStream(adaptor,"rule explicit_assignment");
        RewriteRuleSubtreeStream stream_explicit_comparison=new RewriteRuleSubtreeStream(adaptor,"rule explicit_comparison");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:61:2: ( IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison ) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:63:2: IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF
            {
            IF12=(Token)match(input,IF,FOLLOW_IF_in_ifStatement269);  
            stream_IF.add(IF12);

            pushFollow(FOLLOW_explicit_comparison_in_ifStatement272);
            explicit_comparison13=explicit_comparison();

            state._fsp--;

            stream_explicit_comparison.add(explicit_comparison13.getTree());
            THEN14=(Token)match(input,THEN,FOLLOW_THEN_in_ifStatement277);  
            stream_THEN.add(THEN14);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:64:3: (strue1+= explicit_assignment )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:64:4: strue1+= explicit_assignment
            	    {
            	    pushFollow(FOLLOW_explicit_assignment_in_ifStatement285);
            	    strue1=explicit_assignment();

            	    state._fsp--;

            	    stream_explicit_assignment.add(strue1.getTree());
            	    if (list_strue1==null) list_strue1=new ArrayList();
            	    list_strue1.add(strue1.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:66:2: ( ELSE (sfalse1+= explicit_assignment )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ELSE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:66:3: ELSE (sfalse1+= explicit_assignment )+
                    {
                    ELSE15=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStatement293);  
                    stream_ELSE.add(ELSE15);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:66:9: (sfalse1+= explicit_assignment )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==IDENT) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:66:10: sfalse1+= explicit_assignment
                    	    {
                    	    pushFollow(FOLLOW_explicit_assignment_in_ifStatement299);
                    	    sfalse1=explicit_assignment();

                    	    state._fsp--;

                    	    stream_explicit_assignment.add(sfalse1.getTree());
                    	    if (list_sfalse1==null) list_sfalse1=new ArrayList();
                    	    list_sfalse1.add(sfalse1.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

            }

            ENDIF16=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_ifStatement306);  
            stream_ENDIF.add(ENDIF16);



            // AST REWRITE
            // elements: sfalse1, explicit_comparison, strue1, IF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: strue1, sfalse1
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_strue1=new RewriteRuleSubtreeStream(adaptor,"token strue1",list_strue1);
            RewriteRuleSubtreeStream stream_sfalse1=new RewriteRuleSubtreeStream(adaptor,"token sfalse1",list_sfalse1);
            root_0 = (CommonTree)adaptor.nil();
            // 68:2: -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison )
            {
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:68:5: ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:68:10: ^( TRUE ( $strue1)+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRUE, "TRUE"), root_2);

                if ( !(stream_strue1.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_strue1.hasNext() ) {
                    adaptor.addChild(root_2, stream_strue1.nextTree());

                }
                stream_strue1.reset();

                adaptor.addChild(root_1, root_2);
                }
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:68:27: ( ^( FALSE ( $sfalse1)+ ) )?
                if ( stream_sfalse1.hasNext() ) {
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:68:27: ^( FALSE ( $sfalse1)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FALSE, "FALSE"), root_2);

                    if ( !(stream_sfalse1.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_sfalse1.hasNext() ) {
                        adaptor.addChild(root_2, stream_sfalse1.nextTree());

                    }
                    stream_sfalse1.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_sfalse1.reset();
                adaptor.addChild(root_1, stream_explicit_comparison.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifStatement"

    public static class logical_operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logical_operator"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:73:1: logical_operator : ( AND | OR );
    public final Assign10Parser.logical_operator_return logical_operator() throws RecognitionException {
        Assign10Parser.logical_operator_return retval = new Assign10Parser.logical_operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set17=null;

        CommonTree set17_tree=null;

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:74:2: ( AND | OR )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set17=(Token)input.LT(1);
            if ( (input.LA(1)>=AND && input.LA(1)<=OR) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set17));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logical_operator"

    public static class explicit_assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "explicit_assignment"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:90:1: explicit_assignment : (v1= explicit_variable BECOMES v2= explicit_variable -> ^( BECOMES $v1 $v2) | v3= explicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= explicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) );
    public final Assign10Parser.explicit_assignment_return explicit_assignment() throws RecognitionException {
        Assign10Parser.explicit_assignment_return retval = new Assign10Parser.explicit_assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BECOMES18=null;
        Token BECOMES19=null;
        Token VALUE20=null;
        Token BECOMES21=null;
        Token STRING22=null;
        Assign10Parser.explicit_variable_return v1 = null;

        Assign10Parser.explicit_variable_return v2 = null;

        Assign10Parser.explicit_variable_return v3 = null;

        Assign10Parser.explicit_variable_return v4 = null;


        CommonTree BECOMES18_tree=null;
        CommonTree BECOMES19_tree=null;
        CommonTree VALUE20_tree=null;
        CommonTree BECOMES21_tree=null;
        CommonTree STRING22_tree=null;
        RewriteRuleTokenStream stream_BECOMES=new RewriteRuleTokenStream(adaptor,"token BECOMES");
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:91:2: (v1= explicit_variable BECOMES v2= explicit_variable -> ^( BECOMES $v1 $v2) | v3= explicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= explicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENT) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==DOT_OP) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==IDENT) ) {
                        int LA10_3 = input.LA(4);

                        if ( (LA10_3==BECOMES) ) {
                            switch ( input.LA(5) ) {
                            case VALUE:
                                {
                                alt10=2;
                                }
                                break;
                            case STRING:
                                {
                                alt10=3;
                                }
                                break;
                            case IDENT:
                                {
                                alt10=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 4, input);

                                throw nvae;
                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:91:4: v1= explicit_variable BECOMES v2= explicit_variable
                    {
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment438);
                    v1=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v1.getTree());
                    BECOMES18=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment440);  
                    stream_BECOMES.add(BECOMES18);

                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment444);
                    v2=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v2.getTree());


                    // AST REWRITE
                    // elements: v1, v2, BECOMES
                    // token labels: 
                    // rule labels: v1, retval, v2
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v1=new RewriteRuleSubtreeStream(adaptor,"rule v1",v1!=null?v1.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v2=new RewriteRuleSubtreeStream(adaptor,"rule v2",v2!=null?v2.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 91:54: -> ^( BECOMES $v1 $v2)
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:91:57: ^( BECOMES $v1 $v2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_v1.nextTree());
                        adaptor.addChild(root_1, stream_v2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:92:2: v3= explicit_variable BECOMES VALUE
                    {
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment464);
                    v3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v3.getTree());
                    BECOMES19=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment466);  
                    stream_BECOMES.add(BECOMES19);

                    VALUE20=(Token)match(input,VALUE,FOLLOW_VALUE_in_explicit_assignment468);  
                    stream_VALUE.add(VALUE20);



                    // AST REWRITE
                    // elements: BECOMES, VALUE, v3
                    // token labels: 
                    // rule labels: retval, v3
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v3=new RewriteRuleSubtreeStream(adaptor,"rule v3",v3!=null?v3.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 92:37: -> ^( BECOMES $v3 VALUE )
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:92:40: ^( BECOMES $v3 VALUE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_v3.nextTree());
                        adaptor.addChild(root_1, stream_VALUE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:93:2: v4= explicit_variable BECOMES STRING
                    {
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment494);
                    v4=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v4.getTree());
                    BECOMES21=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment496);  
                    stream_BECOMES.add(BECOMES21);

                    STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_explicit_assignment498);  
                    stream_STRING.add(STRING22);



                    // AST REWRITE
                    // elements: BECOMES, v4, STRING
                    // token labels: 
                    // rule labels: retval, v4
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v4=new RewriteRuleSubtreeStream(adaptor,"rule v4",v4!=null?v4.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 93:38: -> ^( BECOMES $v4 STRING )
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:93:41: ^( BECOMES $v4 STRING )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_v4.nextTree());
                        adaptor.addChild(root_1, stream_STRING.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "explicit_assignment"

    public static class comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparison"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:97:1: comparison : ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' );
    public final Assign10Parser.comparison_return comparison() throws RecognitionException {
        Assign10Parser.comparison_return retval = new Assign10Parser.comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set23=null;

        CommonTree set23_tree=null;

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:98:2: ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set23=(Token)input.LT(1);
            if ( (input.LA(1)>=28 && input.LA(1)<=34) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set23));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparison"

    public static class implicit_assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicit_assignment"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:101:1: implicit_assignment : ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) );
    public final Assign10Parser.implicit_assignment_return implicit_assignment() throws RecognitionException {
        Assign10Parser.implicit_assignment_return retval = new Assign10Parser.implicit_assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BECOMES25=null;
        Token BECOMES26=null;
        Token VALUE27=null;
        Token BECOMES28=null;
        Token STRING29=null;
        Token BECOMES30=null;
        Token BECOMES31=null;
        Assign10Parser.implicit_variable_return v1 = null;

        Assign10Parser.implicit_variable_return v2 = null;

        Assign10Parser.implicit_variable_return v3 = null;

        Assign10Parser.implicit_variable_return v4 = null;

        Assign10Parser.implicit_variable_return x1 = null;

        Assign10Parser.explicit_variable_return x2 = null;

        Assign10Parser.explicit_variable_return x3 = null;

        Assign10Parser.implicit_variable_return x4 = null;

        Assign10Parser.explicit_assignment_return explicit_assignment24 = null;


        CommonTree BECOMES25_tree=null;
        CommonTree BECOMES26_tree=null;
        CommonTree VALUE27_tree=null;
        CommonTree BECOMES28_tree=null;
        CommonTree STRING29_tree=null;
        CommonTree BECOMES30_tree=null;
        CommonTree BECOMES31_tree=null;
        RewriteRuleTokenStream stream_BECOMES=new RewriteRuleTokenStream(adaptor,"token BECOMES");
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_implicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule implicit_variable");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:101:21: ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) )
            int alt11=6;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:103:1: explicit_assignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_explicit_assignment_in_implicit_assignment549);
                    explicit_assignment24=explicit_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, explicit_assignment24.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:105:2: v1= implicit_variable BECOMES v2= implicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment558);
                    v1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v1.getTree());
                    BECOMES25=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment560);  
                    stream_BECOMES.add(BECOMES25);

                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment564);
                    v2=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v2.getTree());


                    // AST REWRITE
                    // elements: BECOMES, v2, v1
                    // token labels: 
                    // rule labels: v1, retval, v2
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v1=new RewriteRuleSubtreeStream(adaptor,"rule v1",v1!=null?v1.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v2=new RewriteRuleSubtreeStream(adaptor,"rule v2",v2!=null?v2.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 105:52: -> ^( BECOMES $v1 $v2)
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:105:55: ^( BECOMES $v1 $v2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_v1.nextTree());
                        adaptor.addChild(root_1, stream_v2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:106:2: v3= implicit_variable BECOMES VALUE
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment587);
                    v3=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v3.getTree());
                    BECOMES26=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment589);  
                    stream_BECOMES.add(BECOMES26);

                    VALUE27=(Token)match(input,VALUE,FOLLOW_VALUE_in_implicit_assignment591);  
                    stream_VALUE.add(VALUE27);



                    // AST REWRITE
                    // elements: v3, BECOMES, VALUE
                    // token labels: 
                    // rule labels: retval, v3
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v3=new RewriteRuleSubtreeStream(adaptor,"rule v3",v3!=null?v3.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 106:38: -> ^( BECOMES $v3 VALUE )
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:106:41: ^( BECOMES $v3 VALUE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_v3.nextTree());
                        adaptor.addChild(root_1, stream_VALUE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:107:2: v4= implicit_variable BECOMES STRING
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment622);
                    v4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v4.getTree());
                    BECOMES28=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment624);  
                    stream_BECOMES.add(BECOMES28);

                    STRING29=(Token)match(input,STRING,FOLLOW_STRING_in_implicit_assignment626);  
                    stream_STRING.add(STRING29);



                    // AST REWRITE
                    // elements: BECOMES, v4, STRING
                    // token labels: 
                    // rule labels: retval, v4
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v4=new RewriteRuleSubtreeStream(adaptor,"rule v4",v4!=null?v4.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 107:38: -> ^( BECOMES $v4 STRING )
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:107:41: ^( BECOMES $v4 STRING )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_v4.nextTree());
                        adaptor.addChild(root_1, stream_STRING.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:109:4: x1= implicit_variable BECOMES x2= explicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment647);
                    x1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(x1.getTree());
                    BECOMES30=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment649);  
                    stream_BECOMES.add(BECOMES30);

                    pushFollow(FOLLOW_explicit_variable_in_implicit_assignment653);
                    x2=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(x2.getTree());


                    // AST REWRITE
                    // elements: x1, x2, BECOMES
                    // token labels: 
                    // rule labels: retval, x2, x1
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_x2=new RewriteRuleSubtreeStream(adaptor,"rule x2",x2!=null?x2.tree:null);
                    RewriteRuleSubtreeStream stream_x1=new RewriteRuleSubtreeStream(adaptor,"rule x1",x1!=null?x1.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 109:54: -> ^( BECOMES $x1 $x2)
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:109:57: ^( BECOMES $x1 $x2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_x1.nextTree());
                        adaptor.addChild(root_1, stream_x2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:110:4: x3= explicit_variable BECOMES x4= implicit_variable
                    {
                    pushFollow(FOLLOW_explicit_variable_in_implicit_assignment675);
                    x3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(x3.getTree());
                    BECOMES31=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment677);  
                    stream_BECOMES.add(BECOMES31);

                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment681);
                    x4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(x4.getTree());


                    // AST REWRITE
                    // elements: BECOMES, x4, x3
                    // token labels: 
                    // rule labels: retval, x4, x3
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_x4=new RewriteRuleSubtreeStream(adaptor,"rule x4",x4!=null?x4.tree:null);
                    RewriteRuleSubtreeStream stream_x3=new RewriteRuleSubtreeStream(adaptor,"rule x3",x3!=null?x3.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 110:54: -> ^( BECOMES $x3 $x4)
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:110:57: ^( BECOMES $x3 $x4)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_x3.nextTree());
                        adaptor.addChild(root_1, stream_x4.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "implicit_assignment"

    public static class explicit_comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "explicit_comparison"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:115:1: explicit_comparison : exp1= explicit_variable comparison exp2= explicit_variable -> ^( comparison $exp1 $exp2) ;
    public final Assign10Parser.explicit_comparison_return explicit_comparison() throws RecognitionException {
        Assign10Parser.explicit_comparison_return retval = new Assign10Parser.explicit_comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Assign10Parser.explicit_variable_return exp1 = null;

        Assign10Parser.explicit_variable_return exp2 = null;

        Assign10Parser.comparison_return comparison32 = null;


        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:116:2: (exp1= explicit_variable comparison exp2= explicit_variable -> ^( comparison $exp1 $exp2) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:116:6: exp1= explicit_variable comparison exp2= explicit_variable
            {
            pushFollow(FOLLOW_explicit_variable_in_explicit_comparison717);
            exp1=explicit_variable();

            state._fsp--;

            stream_explicit_variable.add(exp1.getTree());
            pushFollow(FOLLOW_comparison_in_explicit_comparison719);
            comparison32=comparison();

            state._fsp--;

            stream_comparison.add(comparison32.getTree());
            pushFollow(FOLLOW_explicit_variable_in_explicit_comparison724);
            exp2=explicit_variable();

            state._fsp--;

            stream_explicit_variable.add(exp2.getTree());


            // AST REWRITE
            // elements: exp2, comparison, exp1
            // token labels: 
            // rule labels: retval, exp2, exp1
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exp2=new RewriteRuleSubtreeStream(adaptor,"rule exp2",exp2!=null?exp2.tree:null);
            RewriteRuleSubtreeStream stream_exp1=new RewriteRuleSubtreeStream(adaptor,"rule exp1",exp1!=null?exp1.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 116:64: -> ^( comparison $exp1 $exp2)
            {
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:116:67: ^( comparison $exp1 $exp2)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                adaptor.addChild(root_1, stream_exp1.nextTree());
                adaptor.addChild(root_1, stream_exp2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "explicit_comparison"

    public static class implicit_comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicit_comparison"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:118:1: implicit_comparison : ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) );
    public final Assign10Parser.implicit_comparison_return implicit_comparison() throws RecognitionException {
        Assign10Parser.implicit_comparison_return retval = new Assign10Parser.implicit_comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Assign10Parser.implicit_variable_return ixp1 = null;

        Assign10Parser.implicit_variable_return ixp2 = null;

        Assign10Parser.explicit_variable_return exp3 = null;

        Assign10Parser.implicit_variable_return ixp4 = null;

        Assign10Parser.implicit_variable_return ixp5 = null;

        Assign10Parser.explicit_variable_return exp4 = null;

        Assign10Parser.explicit_comparison_return explicit_comparison33 = null;

        Assign10Parser.comparison_return comparison34 = null;

        Assign10Parser.comparison_return comparison35 = null;

        Assign10Parser.comparison_return comparison36 = null;


        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_implicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule implicit_variable");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:121:2: ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) )
            int alt12=4;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:121:4: explicit_comparison
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_explicit_comparison_in_implicit_comparison748);
                    explicit_comparison33=explicit_comparison();

                    state._fsp--;

                    adaptor.addChild(root_0, explicit_comparison33.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:122:3: ixp1= implicit_variable comparison ixp2= implicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison756);
                    ixp1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp1.getTree());
                    pushFollow(FOLLOW_comparison_in_implicit_comparison758);
                    comparison34=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison34.getTree());
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison762);
                    ixp2=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp2.getTree());


                    // AST REWRITE
                    // elements: ixp1, comparison, ixp2
                    // token labels: 
                    // rule labels: retval, ixp2, ixp1
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ixp2=new RewriteRuleSubtreeStream(adaptor,"rule ixp2",ixp2!=null?ixp2.tree:null);
                    RewriteRuleSubtreeStream stream_ixp1=new RewriteRuleSubtreeStream(adaptor,"rule ixp1",ixp1!=null?ixp1.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 122:60: -> ^( comparison $ixp1 $ixp2)
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:122:63: ^( comparison $ixp1 $ixp2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ixp1.nextTree());
                        adaptor.addChild(root_1, stream_ixp2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:123:3: exp3= explicit_variable comparison ixp4= implicit_variable
                    {
                    pushFollow(FOLLOW_explicit_variable_in_implicit_comparison782);
                    exp3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(exp3.getTree());
                    pushFollow(FOLLOW_comparison_in_implicit_comparison784);
                    comparison35=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison35.getTree());
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison788);
                    ixp4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp4.getTree());


                    // AST REWRITE
                    // elements: exp3, ixp4, comparison
                    // token labels: 
                    // rule labels: retval, ixp4, exp3
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ixp4=new RewriteRuleSubtreeStream(adaptor,"rule ixp4",ixp4!=null?ixp4.tree:null);
                    RewriteRuleSubtreeStream stream_exp3=new RewriteRuleSubtreeStream(adaptor,"rule exp3",exp3!=null?exp3.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 123:60: -> ^( comparison $exp3 $ixp4)
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:123:63: ^( comparison $exp3 $ixp4)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_exp3.nextTree());
                        adaptor.addChild(root_1, stream_ixp4.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:124:3: ixp5= implicit_variable comparison exp4= explicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison814);
                    ixp5=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp5.getTree());
                    pushFollow(FOLLOW_comparison_in_implicit_comparison816);
                    comparison36=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison36.getTree());
                    pushFollow(FOLLOW_explicit_variable_in_implicit_comparison820);
                    exp4=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(exp4.getTree());


                    // AST REWRITE
                    // elements: ixp5, comparison, exp4
                    // token labels: 
                    // rule labels: retval, exp4, ixp5
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exp4=new RewriteRuleSubtreeStream(adaptor,"rule exp4",exp4!=null?exp4.tree:null);
                    RewriteRuleSubtreeStream stream_ixp5=new RewriteRuleSubtreeStream(adaptor,"rule ixp5",ixp5!=null?ixp5.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 124:60: -> ^( comparison $ixp5 $exp4)
                    {
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:124:63: ^( comparison $ixp5 $exp4)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_ixp5.nextTree());
                        adaptor.addChild(root_1, stream_exp4.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "implicit_comparison"

    public static class implicit_variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicit_variable"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:128:1: implicit_variable : dot_operation d0= IDENT -> ^( IMPLICIT_VAR $d0) ;
    public final Assign10Parser.implicit_variable_return implicit_variable() throws RecognitionException {
        Assign10Parser.implicit_variable_return retval = new Assign10Parser.implicit_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token d0=null;
        Assign10Parser.dot_operation_return dot_operation37 = null;


        CommonTree d0_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_dot_operation=new RewriteRuleSubtreeStream(adaptor,"rule dot_operation");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:151:2: ( dot_operation d0= IDENT -> ^( IMPLICIT_VAR $d0) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:151:5: dot_operation d0= IDENT
            {
            pushFollow(FOLLOW_dot_operation_in_implicit_variable857);
            dot_operation37=dot_operation();

            state._fsp--;

            stream_dot_operation.add(dot_operation37.getTree());
            d0=(Token)match(input,IDENT,FOLLOW_IDENT_in_implicit_variable862);  
            stream_IDENT.add(d0);



            // AST REWRITE
            // elements: d0
            // token labels: d0
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_d0=new RewriteRuleTokenStream(adaptor,"token d0",d0);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 154:3: -> ^( IMPLICIT_VAR $d0)
            {
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:154:6: ^( IMPLICIT_VAR $d0)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IMPLICIT_VAR, "IMPLICIT_VAR"), root_1);

                adaptor.addChild(root_1, stream_d0.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


               	
              Object ID1_tree = (Object)adaptor.create(((usingStatement_scope)usingStatement_stack.peek()).idToken);
              adaptor.addChild(((CommonTree)retval.tree), ID1_tree);
              /*
              CommonTree firstChild =	(CommonTree) adaptor.getChild(((CommonTree)retval.tree),0);
              CommonTree secondChild = (CommonTree) ID1_tree;
              String member =  firstChild.getText();
              String objName = secondChild.getText();
              firstChild.getToken().setText("fred");
              secondChild.getToken().setText("ted");
              
             */
              	

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "implicit_variable"

    public static class explicit_variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "explicit_variable"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:165:1: explicit_variable : c0= IDENT dot_operation c1= IDENT -> ^( VAR $c0 $c1) ;
    public final Assign10Parser.explicit_variable_return explicit_variable() throws RecognitionException {
        Assign10Parser.explicit_variable_return retval = new Assign10Parser.explicit_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c0=null;
        Token c1=null;
        Assign10Parser.dot_operation_return dot_operation38 = null;


        CommonTree c0_tree=null;
        CommonTree c1_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_dot_operation=new RewriteRuleSubtreeStream(adaptor,"rule dot_operation");
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:166:2: (c0= IDENT dot_operation c1= IDENT -> ^( VAR $c0 $c1) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:166:4: c0= IDENT dot_operation c1= IDENT
            {
            c0=(Token)match(input,IDENT,FOLLOW_IDENT_in_explicit_variable923);  
            stream_IDENT.add(c0);

            pushFollow(FOLLOW_dot_operation_in_explicit_variable925);
            dot_operation38=dot_operation();

            state._fsp--;

            stream_dot_operation.add(dot_operation38.getTree());
            c1=(Token)match(input,IDENT,FOLLOW_IDENT_in_explicit_variable929);  
            stream_IDENT.add(c1);



            // AST REWRITE
            // elements: c1, c0
            // token labels: c1, c0
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_c1=new RewriteRuleTokenStream(adaptor,"token c1",c1);
            RewriteRuleTokenStream stream_c0=new RewriteRuleTokenStream(adaptor,"token c0",c0);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 166:37: -> ^( VAR $c0 $c1)
            {
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:166:40: ^( VAR $c0 $c1)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                adaptor.addChild(root_1, stream_c0.nextNode());
                adaptor.addChild(root_1, stream_c1.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "explicit_variable"

    public static class dot_operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dot_operation"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:169:1: dot_operation : DOT_OP ;
    public final Assign10Parser.dot_operation_return dot_operation() throws RecognitionException {
        Assign10Parser.dot_operation_return retval = new Assign10Parser.dot_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DOT_OP39=null;

        CommonTree DOT_OP39_tree=null;

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:170:2: ( DOT_OP )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:170:4: DOT_OP
            {
            root_0 = (CommonTree)adaptor.nil();

            DOT_OP39=(Token)match(input,DOT_OP,FOLLOW_DOT_OP_in_dot_operation956); 
            DOT_OP39_tree = (CommonTree)adaptor.create(DOT_OP39);
            adaptor.addChild(root_0, DOT_OP39_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dot_operation"

    // Delegated rules


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA11_eotS =
        "\16\uffff";
    static final String DFA11_eofS =
        "\16\uffff";
    static final String DFA11_minS =
        "\1\5\1\21\2\5\2\14\2\5\6\uffff";
    static final String DFA11_maxS =
        "\2\21\2\5\2\14\2\21\6\uffff";
    static final String DFA11_acceptS =
        "\10\uffff\1\3\1\4\1\2\1\5\1\1\1\6";
    static final String DFA11_specialS =
        "\16\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\13\uffff\1\2",
            "\1\3",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\7",
            "\1\13\11\uffff\1\10\1\11\1\12",
            "\1\14\11\uffff\2\14\1\15",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "101:1: implicit_assignment : ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) );";
        }
    }
    static final String DFA12_eotS =
        "\14\uffff";
    static final String DFA12_eofS =
        "\14\uffff";
    static final String DFA12_minS =
        "\1\5\1\21\2\5\2\34\2\5\4\uffff";
    static final String DFA12_maxS =
        "\2\21\2\5\2\42\2\21\4\uffff";
    static final String DFA12_acceptS =
        "\10\uffff\1\2\1\4\1\1\1\3";
    static final String DFA12_specialS =
        "\14\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\13\uffff\1\2",
            "\1\3",
            "\1\4",
            "\1\5",
            "\7\6",
            "\7\7",
            "\1\11\13\uffff\1\10",
            "\1\12\13\uffff\1\13",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "118:1: implicit_comparison : ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) );";
        }
    }
 

    public static final BitSet FOLLOW_statements_in_program60 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_ifStatement_in_statements83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_usingStatement_in_statements87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_usingStatement109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_usingStatement114 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_implicitIfStatement_in_usingStatement123 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_27_in_usingStatement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_implicitIfStatement187 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_comparison_in_implicitIfStatement190 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_THEN_in_implicitIfStatement195 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_assignment_in_implicitIfStatement203 = new BitSet(new long[]{0x0000000000020320L});
    public static final BitSet FOLLOW_ELSE_in_implicitIfStatement211 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_assignment_in_implicitIfStatement217 = new BitSet(new long[]{0x0000000000020220L});
    public static final BitSet FOLLOW_ENDIF_in_implicitIfStatement224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement269 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_comparison_in_ifStatement272 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_THEN_in_ifStatement277 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_assignment_in_ifStatement285 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_assignment_in_ifStatement299 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_ENDIF_in_ifStatement306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_logical_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment438 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment440 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment464 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment466 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_explicit_assignment468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment494 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment496 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_explicit_assignment498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparison0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_assignment_in_implicit_assignment549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment558 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment560 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment587 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment589 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_implicit_assignment591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment622 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment624 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_implicit_assignment626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment647 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment649 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_assignment653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_assignment675 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment677 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_comparison717 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_explicit_comparison719 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_comparison724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_comparison_in_implicit_comparison748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison756 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison758 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_comparison782 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison784 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison814 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison816 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_comparison820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dot_operation_in_implicit_variable857 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_implicit_variable862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_explicit_variable923 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_dot_operation_in_explicit_variable925 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_explicit_variable929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_OP_in_dot_operation956 = new BitSet(new long[]{0x0000000000000002L});

}