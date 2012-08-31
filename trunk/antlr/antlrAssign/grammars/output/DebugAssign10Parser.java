// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g 2011-03-19 19:13:15

  package com.dhenton9000.assign.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class Assign10Parser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "USING", "IDENT", "IF", "THEN", "ELSE", "ENDIF", "AND", "OR", "BECOMES", "TRUE", "FALSE", "VALUE", "STRING", "DOT_OP", "VAR", "IMPLICIT_VAR", "COMMENT", "WS", "ESC_SEQ", "CHAR", "LETTER", "DIGIT", "'END_USING'", "'<>'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='"
    };
    public static final int EOF=-1;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
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

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "explicit_assignment", "implicitIfStatement", "comparison", 
        "implicit_variable", "dot_operation", "explicit_comparison", "implicit_comparison", 
        "explicit_variable", "program", "logical_operator", "usingStatement", 
        "ifStatement", "implicit_assignment"
    };
    public static final boolean[] decisionCanBacktrack = new boolean[] {
        false, // invalid decision
        false, false, false, false, false, false, false, false, false, 
            false, false, false
    };

     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public Assign10Parser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public Assign10Parser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public Assign10Parser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

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
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:19:1: program : ( ifStatement )* ( usingStatement )* ;
    public final Assign10Parser.program_return program() throws RecognitionException {
        Assign10Parser.program_return retval = new Assign10Parser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Assign10Parser.ifStatement_return ifStatement1 = null;

        Assign10Parser.usingStatement_return usingStatement2 = null;



        try { dbg.enterRule(getGrammarFileName(), "program");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:19:9: ( ( ifStatement )* ( usingStatement )* )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:22:2: ( ifStatement )* ( usingStatement )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(22,2);
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:22:2: ( ifStatement )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==IF) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:22:3: ifStatement
            	    {
            	    dbg.location(22,3);
            	    pushFollow(FOLLOW_ifStatement_in_program60);
            	    ifStatement1=ifStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, ifStatement1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(23,2);
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:23:2: ( usingStatement )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==USING) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:23:3: usingStatement
            	    {
            	    dbg.location(23,3);
            	    pushFollow(FOLLOW_usingStatement_in_program66);
            	    usingStatement2=usingStatement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, usingStatement2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}


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
        dbg.location(23, 19);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "program");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "program"

    protected static class usingStatement_scope {
        Token idToken;
    }
    protected Stack usingStatement_stack = new Stack();

    public static class usingStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "usingStatement"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:26:1: usingStatement : USING identVar= IDENT ( implicitIfStatement )* 'END_USING' -> ^( USING ^( IDENT ( implicitIfStatement )* ) ) ;
    public final Assign10Parser.usingStatement_return usingStatement() throws RecognitionException {
        usingStatement_stack.push(new usingStatement_scope());
        Assign10Parser.usingStatement_return retval = new Assign10Parser.usingStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token identVar=null;
        Token USING3=null;
        Token string_literal5=null;
        Assign10Parser.implicitIfStatement_return implicitIfStatement4 = null;


        CommonTree identVar_tree=null;
        CommonTree USING3_tree=null;
        CommonTree string_literal5_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_USING=new RewriteRuleTokenStream(adaptor,"token USING");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_implicitIfStatement=new RewriteRuleSubtreeStream(adaptor,"rule implicitIfStatement");
        try { dbg.enterRule(getGrammarFileName(), "usingStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:33:1: ( USING identVar= IDENT ( implicitIfStatement )* 'END_USING' -> ^( USING ^( IDENT ( implicitIfStatement )* ) ) )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:34:4: USING identVar= IDENT ( implicitIfStatement )* 'END_USING'
            {
            dbg.location(34,4);
            USING3=(Token)match(input,USING,FOLLOW_USING_in_usingStatement91);  
            stream_USING.add(USING3);

            dbg.location(34,19);
            identVar=(Token)match(input,IDENT,FOLLOW_IDENT_in_usingStatement96);  
            stream_IDENT.add(identVar);

            dbg.location(34,26);
            ((usingStatement_scope)usingStatement_stack.peek()).idToken = identVar;
            dbg.location(36,4);
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:36:4: ( implicitIfStatement )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==IF) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:36:5: implicitIfStatement
            	    {
            	    dbg.location(36,5);
            	    pushFollow(FOLLOW_implicitIfStatement_in_usingStatement105);
            	    implicitIfStatement4=implicitIfStatement();

            	    state._fsp--;

            	    stream_implicitIfStatement.add(implicitIfStatement4.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}

            dbg.location(38,8);
            string_literal5=(Token)match(input,26,FOLLOW_26_in_usingStatement119);  
            stream_26.add(string_literal5);



            // AST REWRITE
            // elements: USING, IDENT, implicitIfStatement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 40:8: -> ^( USING ^( IDENT ( implicitIfStatement )* ) )
            {
                dbg.location(40,10);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:40:10: ^( USING ^( IDENT ( implicitIfStatement )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(40,12);
                root_1 = (CommonTree)adaptor.becomeRoot(stream_USING.nextNode(), root_1);

                dbg.location(40,18);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:40:18: ^( IDENT ( implicitIfStatement )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(40,20);
                root_2 = (CommonTree)adaptor.becomeRoot(stream_IDENT.nextNode(), root_2);

                dbg.location(40,26);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:40:26: ( implicitIfStatement )*
                while ( stream_implicitIfStatement.hasNext() ) {
                    dbg.location(40,27);
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
        dbg.location(42, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "usingStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "usingStatement"

    public static class implicitIfStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicitIfStatement"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:45:1: implicitIfStatement : IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison ) ;
    public final Assign10Parser.implicitIfStatement_return implicitIfStatement() throws RecognitionException {
        Assign10Parser.implicitIfStatement_return retval = new Assign10Parser.implicitIfStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF6=null;
        Token THEN8=null;
        Token ELSE9=null;
        Token ENDIF10=null;
        List list_strue2=null;
        List list_sfalse2=null;
        Assign10Parser.implicit_comparison_return implicit_comparison7 = null;

        RuleReturnScope strue2 = null;
        RuleReturnScope sfalse2 = null;
        CommonTree IF6_tree=null;
        CommonTree THEN8_tree=null;
        CommonTree ELSE9_tree=null;
        CommonTree ENDIF10_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_implicit_comparison=new RewriteRuleSubtreeStream(adaptor,"rule implicit_comparison");
        RewriteRuleSubtreeStream stream_implicit_assignment=new RewriteRuleSubtreeStream(adaptor,"rule implicit_assignment");
        try { dbg.enterRule(getGrammarFileName(), "implicitIfStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:48:2: ( IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison ) )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:50:2: IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF
            {
            dbg.location(50,2);
            IF6=(Token)match(input,IF,FOLLOW_IF_in_implicitIfStatement169);  
            stream_IF.add(IF6);

            dbg.location(50,6);
            pushFollow(FOLLOW_implicit_comparison_in_implicitIfStatement172);
            implicit_comparison7=implicit_comparison();

            state._fsp--;

            stream_implicit_comparison.add(implicit_comparison7.getTree());
            dbg.location(50,29);
            THEN8=(Token)match(input,THEN,FOLLOW_THEN_in_implicitIfStatement177);  
            stream_THEN.add(THEN8);

            dbg.location(51,3);
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:51:3: (strue2+= implicit_assignment )+
            int cnt4=0;
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=2;
                try { dbg.enterDecision(4, decisionCanBacktrack[4]);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT||LA4_0==DOT_OP) ) {
                    alt4=1;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:51:4: strue2+= implicit_assignment
            	    {
            	    dbg.location(51,10);
            	    pushFollow(FOLLOW_implicit_assignment_in_implicitIfStatement185);
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
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt4++;
            } while (true);
            } finally {dbg.exitSubRule(4);}

            dbg.location(53,2);
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:53:2: ( ELSE (sfalse2+= implicit_assignment )+ )?
            int alt6=2;
            try { dbg.enterSubRule(6);
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==ELSE) ) {
                alt6=1;
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:53:3: ELSE (sfalse2+= implicit_assignment )+
                    {
                    dbg.location(53,3);
                    ELSE9=(Token)match(input,ELSE,FOLLOW_ELSE_in_implicitIfStatement193);  
                    stream_ELSE.add(ELSE9);

                    dbg.location(53,9);
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:53:9: (sfalse2+= implicit_assignment )+
                    int cnt5=0;
                    try { dbg.enterSubRule(5);

                    loop5:
                    do {
                        int alt5=2;
                        try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==IDENT||LA5_0==DOT_OP) ) {
                            alt5=1;
                        }


                        } finally {dbg.exitDecision(5);}

                        switch (alt5) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:53:10: sfalse2+= implicit_assignment
                    	    {
                    	    dbg.location(53,17);
                    	    pushFollow(FOLLOW_implicit_assignment_in_implicitIfStatement199);
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
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt5++;
                    } while (true);
                    } finally {dbg.exitSubRule(5);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(6);}

            dbg.location(54,2);
            ENDIF10=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_implicitIfStatement206);  
            stream_ENDIF.add(ENDIF10);



            // AST REWRITE
            // elements: IF, sfalse2, strue2, implicit_comparison
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
            // 55:2: -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison )
            {
                dbg.location(55,5);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:55:5: ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(55,7);
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                dbg.location(55,10);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:55:10: ^( TRUE ( $strue2)+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(55,12);
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRUE, "TRUE"), root_2);

                dbg.location(55,17);
                if ( !(stream_strue2.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_strue2.hasNext() ) {
                    dbg.location(55,17);
                    adaptor.addChild(root_2, stream_strue2.nextTree());

                }
                stream_strue2.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(55,27);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:55:27: ( ^( FALSE ( $sfalse2)+ ) )?
                if ( stream_sfalse2.hasNext() ) {
                    dbg.location(55,27);
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:55:27: ^( FALSE ( $sfalse2)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    dbg.location(55,29);
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FALSE, "FALSE"), root_2);

                    dbg.location(55,35);
                    if ( !(stream_sfalse2.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_sfalse2.hasNext() ) {
                        dbg.location(55,35);
                        adaptor.addChild(root_2, stream_sfalse2.nextTree());

                    }
                    stream_sfalse2.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_sfalse2.reset();
                dbg.location(55,47);
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
        dbg.location(56, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "implicitIfStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "implicitIfStatement"

    public static class ifStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:59:1: ifStatement : IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison ) ;
    public final Assign10Parser.ifStatement_return ifStatement() throws RecognitionException {
        Assign10Parser.ifStatement_return retval = new Assign10Parser.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF11=null;
        Token THEN13=null;
        Token ELSE14=null;
        Token ENDIF15=null;
        List list_strue1=null;
        List list_sfalse1=null;
        Assign10Parser.explicit_comparison_return explicit_comparison12 = null;

        RuleReturnScope strue1 = null;
        RuleReturnScope sfalse1 = null;
        CommonTree IF11_tree=null;
        CommonTree THEN13_tree=null;
        CommonTree ELSE14_tree=null;
        CommonTree ENDIF15_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_explicit_assignment=new RewriteRuleSubtreeStream(adaptor,"rule explicit_assignment");
        RewriteRuleSubtreeStream stream_explicit_comparison=new RewriteRuleSubtreeStream(adaptor,"rule explicit_comparison");
        try { dbg.enterRule(getGrammarFileName(), "ifStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(59, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:60:2: ( IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison ) )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:62:2: IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF
            {
            dbg.location(62,2);
            IF11=(Token)match(input,IF,FOLLOW_IF_in_ifStatement251);  
            stream_IF.add(IF11);

            dbg.location(62,6);
            pushFollow(FOLLOW_explicit_comparison_in_ifStatement254);
            explicit_comparison12=explicit_comparison();

            state._fsp--;

            stream_explicit_comparison.add(explicit_comparison12.getTree());
            dbg.location(62,29);
            THEN13=(Token)match(input,THEN,FOLLOW_THEN_in_ifStatement259);  
            stream_THEN.add(THEN13);

            dbg.location(63,3);
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:63:3: (strue1+= explicit_assignment )+
            int cnt7=0;
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:63:4: strue1+= explicit_assignment
            	    {
            	    dbg.location(63,10);
            	    pushFollow(FOLLOW_explicit_assignment_in_ifStatement267);
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
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt7++;
            } while (true);
            } finally {dbg.exitSubRule(7);}

            dbg.location(65,2);
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:65:2: ( ELSE (sfalse1+= explicit_assignment )+ )?
            int alt9=2;
            try { dbg.enterSubRule(9);
            try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            int LA9_0 = input.LA(1);

            if ( (LA9_0==ELSE) ) {
                alt9=1;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:65:3: ELSE (sfalse1+= explicit_assignment )+
                    {
                    dbg.location(65,3);
                    ELSE14=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStatement275);  
                    stream_ELSE.add(ELSE14);

                    dbg.location(65,9);
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:65:9: (sfalse1+= explicit_assignment )+
                    int cnt8=0;
                    try { dbg.enterSubRule(8);

                    loop8:
                    do {
                        int alt8=2;
                        try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==IDENT) ) {
                            alt8=1;
                        }


                        } finally {dbg.exitDecision(8);}

                        switch (alt8) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:65:10: sfalse1+= explicit_assignment
                    	    {
                    	    dbg.location(65,17);
                    	    pushFollow(FOLLOW_explicit_assignment_in_ifStatement281);
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
                                dbg.recognitionException(eee);

                                throw eee;
                        }
                        cnt8++;
                    } while (true);
                    } finally {dbg.exitSubRule(8);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}

            dbg.location(66,2);
            ENDIF15=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_ifStatement288);  
            stream_ENDIF.add(ENDIF15);



            // AST REWRITE
            // elements: strue1, sfalse1, IF, explicit_comparison
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
            // 67:2: -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison )
            {
                dbg.location(67,5);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:67:5: ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(67,7);
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                dbg.location(67,10);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:67:10: ^( TRUE ( $strue1)+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(67,12);
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRUE, "TRUE"), root_2);

                dbg.location(67,17);
                if ( !(stream_strue1.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_strue1.hasNext() ) {
                    dbg.location(67,17);
                    adaptor.addChild(root_2, stream_strue1.nextTree());

                }
                stream_strue1.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(67,27);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:67:27: ( ^( FALSE ( $sfalse1)+ ) )?
                if ( stream_sfalse1.hasNext() ) {
                    dbg.location(67,27);
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:67:27: ^( FALSE ( $sfalse1)+ )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    dbg.location(67,29);
                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FALSE, "FALSE"), root_2);

                    dbg.location(67,35);
                    if ( !(stream_sfalse1.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_sfalse1.hasNext() ) {
                        dbg.location(67,35);
                        adaptor.addChild(root_2, stream_sfalse1.nextTree());

                    }
                    stream_sfalse1.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_sfalse1.reset();
                dbg.location(67,47);
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
        dbg.location(69, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ifStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "ifStatement"

    public static class logical_operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logical_operator"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:72:1: logical_operator : ( AND | OR );
    public final Assign10Parser.logical_operator_return logical_operator() throws RecognitionException {
        Assign10Parser.logical_operator_return retval = new Assign10Parser.logical_operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set16=null;

        CommonTree set16_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "logical_operator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(72, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:73:2: ( AND | OR )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(73,2);
            set16=(Token)input.LT(1);
            if ( (input.LA(1)>=AND && input.LA(1)<=OR) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set16));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(73, 10);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "logical_operator");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "logical_operator"

    public static class explicit_assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "explicit_assignment"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:89:1: explicit_assignment : (v1= explicit_variable BECOMES v2= explicit_variable -> ^( BECOMES $v1 $v2) | v3= explicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= explicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) );
    public final Assign10Parser.explicit_assignment_return explicit_assignment() throws RecognitionException {
        Assign10Parser.explicit_assignment_return retval = new Assign10Parser.explicit_assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BECOMES17=null;
        Token BECOMES18=null;
        Token VALUE19=null;
        Token BECOMES20=null;
        Token STRING21=null;
        Assign10Parser.explicit_variable_return v1 = null;

        Assign10Parser.explicit_variable_return v2 = null;

        Assign10Parser.explicit_variable_return v3 = null;

        Assign10Parser.explicit_variable_return v4 = null;


        CommonTree BECOMES17_tree=null;
        CommonTree BECOMES18_tree=null;
        CommonTree VALUE19_tree=null;
        CommonTree BECOMES20_tree=null;
        CommonTree STRING21_tree=null;
        RewriteRuleTokenStream stream_BECOMES=new RewriteRuleTokenStream(adaptor,"token BECOMES");
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        try { dbg.enterRule(getGrammarFileName(), "explicit_assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(89, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:90:2: (v1= explicit_variable BECOMES v2= explicit_variable -> ^( BECOMES $v1 $v2) | v3= explicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= explicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) )
            int alt10=3;
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

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

                                dbg.recognitionException(nvae);
                                throw nvae;
                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 3, input);

                            dbg.recognitionException(nvae);
                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        dbg.recognitionException(nvae);
                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:90:4: v1= explicit_variable BECOMES v2= explicit_variable
                    {
                    dbg.location(90,6);
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment420);
                    v1=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v1.getTree());
                    dbg.location(90,25);
                    BECOMES17=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment422);  
                    stream_BECOMES.add(BECOMES17);

                    dbg.location(90,35);
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment426);
                    v2=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v2.getTree());


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
                    // 90:54: -> ^( BECOMES $v1 $v2)
                    {
                        dbg.location(90,57);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:90:57: ^( BECOMES $v1 $v2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(90,59);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(90,67);
                        adaptor.addChild(root_1, stream_v1.nextTree());
                        dbg.location(90,71);
                        adaptor.addChild(root_1, stream_v2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:91:2: v3= explicit_variable BECOMES VALUE
                    {
                    dbg.location(91,4);
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment446);
                    v3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v3.getTree());
                    dbg.location(91,23);
                    BECOMES18=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment448);  
                    stream_BECOMES.add(BECOMES18);

                    dbg.location(91,31);
                    VALUE19=(Token)match(input,VALUE,FOLLOW_VALUE_in_explicit_assignment450);  
                    stream_VALUE.add(VALUE19);



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
                    // 91:37: -> ^( BECOMES $v3 VALUE )
                    {
                        dbg.location(91,40);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:91:40: ^( BECOMES $v3 VALUE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(91,42);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(91,50);
                        adaptor.addChild(root_1, stream_v3.nextTree());
                        dbg.location(91,54);
                        adaptor.addChild(root_1, stream_VALUE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:92:2: v4= explicit_variable BECOMES STRING
                    {
                    dbg.location(92,4);
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment476);
                    v4=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v4.getTree());
                    dbg.location(92,23);
                    BECOMES20=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment478);  
                    stream_BECOMES.add(BECOMES20);

                    dbg.location(92,31);
                    STRING21=(Token)match(input,STRING,FOLLOW_STRING_in_explicit_assignment480);  
                    stream_STRING.add(STRING21);



                    // AST REWRITE
                    // elements: v4, BECOMES, STRING
                    // token labels: 
                    // rule labels: retval, v4
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v4=new RewriteRuleSubtreeStream(adaptor,"rule v4",v4!=null?v4.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 92:38: -> ^( BECOMES $v4 STRING )
                    {
                        dbg.location(92,41);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:92:41: ^( BECOMES $v4 STRING )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(92,43);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(92,51);
                        adaptor.addChild(root_1, stream_v4.nextTree());
                        dbg.location(92,55);
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
        dbg.location(94, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "explicit_assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "explicit_assignment"

    public static class comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparison"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:96:1: comparison : ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' );
    public final Assign10Parser.comparison_return comparison() throws RecognitionException {
        Assign10Parser.comparison_return retval = new Assign10Parser.comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set22=null;

        CommonTree set22_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "comparison");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(96, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:97:2: ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(97,2);
            set22=(Token)input.LT(1);
            if ( (input.LA(1)>=27 && input.LA(1)<=33) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set22));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(98, 34);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "comparison");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "comparison"

    public static class implicit_assignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicit_assignment"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:100:1: implicit_assignment : ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) );
    public final Assign10Parser.implicit_assignment_return implicit_assignment() throws RecognitionException {
        Assign10Parser.implicit_assignment_return retval = new Assign10Parser.implicit_assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BECOMES24=null;
        Token BECOMES25=null;
        Token VALUE26=null;
        Token BECOMES27=null;
        Token STRING28=null;
        Token BECOMES29=null;
        Token BECOMES30=null;
        Assign10Parser.implicit_variable_return v1 = null;

        Assign10Parser.implicit_variable_return v2 = null;

        Assign10Parser.implicit_variable_return v3 = null;

        Assign10Parser.implicit_variable_return v4 = null;

        Assign10Parser.implicit_variable_return x1 = null;

        Assign10Parser.explicit_variable_return x2 = null;

        Assign10Parser.explicit_variable_return x3 = null;

        Assign10Parser.implicit_variable_return x4 = null;

        Assign10Parser.explicit_assignment_return explicit_assignment23 = null;


        CommonTree BECOMES24_tree=null;
        CommonTree BECOMES25_tree=null;
        CommonTree VALUE26_tree=null;
        CommonTree BECOMES27_tree=null;
        CommonTree STRING28_tree=null;
        CommonTree BECOMES29_tree=null;
        CommonTree BECOMES30_tree=null;
        RewriteRuleTokenStream stream_BECOMES=new RewriteRuleTokenStream(adaptor,"token BECOMES");
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_implicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule implicit_variable");
        try { dbg.enterRule(getGrammarFileName(), "implicit_assignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(100, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:100:21: ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) )
            int alt11=6;
            try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            try {
                isCyclicDecision = true;
                alt11 = dfa11.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:102:1: explicit_assignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(102,1);
                    pushFollow(FOLLOW_explicit_assignment_in_implicit_assignment531);
                    explicit_assignment23=explicit_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, explicit_assignment23.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:104:2: v1= implicit_variable BECOMES v2= implicit_variable
                    {
                    dbg.location(104,4);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment540);
                    v1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v1.getTree());
                    dbg.location(104,23);
                    BECOMES24=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment542);  
                    stream_BECOMES.add(BECOMES24);

                    dbg.location(104,33);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment546);
                    v2=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v2.getTree());


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
                    // 104:52: -> ^( BECOMES $v1 $v2)
                    {
                        dbg.location(104,55);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:104:55: ^( BECOMES $v1 $v2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(104,57);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(104,67);
                        adaptor.addChild(root_1, stream_v1.nextTree());
                        dbg.location(104,71);
                        adaptor.addChild(root_1, stream_v2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:105:2: v3= implicit_variable BECOMES VALUE
                    {
                    dbg.location(105,4);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment569);
                    v3=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v3.getTree());
                    dbg.location(105,23);
                    BECOMES25=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment571);  
                    stream_BECOMES.add(BECOMES25);

                    dbg.location(105,31);
                    VALUE26=(Token)match(input,VALUE,FOLLOW_VALUE_in_implicit_assignment573);  
                    stream_VALUE.add(VALUE26);



                    // AST REWRITE
                    // elements: VALUE, v3, BECOMES
                    // token labels: 
                    // rule labels: retval, v3
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v3=new RewriteRuleSubtreeStream(adaptor,"rule v3",v3!=null?v3.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 105:38: -> ^( BECOMES $v3 VALUE )
                    {
                        dbg.location(105,41);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:105:41: ^( BECOMES $v3 VALUE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(105,43);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(105,52);
                        adaptor.addChild(root_1, stream_v3.nextTree());
                        dbg.location(105,56);
                        adaptor.addChild(root_1, stream_VALUE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:106:2: v4= implicit_variable BECOMES STRING
                    {
                    dbg.location(106,4);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment604);
                    v4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v4.getTree());
                    dbg.location(106,23);
                    BECOMES27=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment606);  
                    stream_BECOMES.add(BECOMES27);

                    dbg.location(106,31);
                    STRING28=(Token)match(input,STRING,FOLLOW_STRING_in_implicit_assignment608);  
                    stream_STRING.add(STRING28);



                    // AST REWRITE
                    // elements: v4, STRING, BECOMES
                    // token labels: 
                    // rule labels: retval, v4
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_v4=new RewriteRuleSubtreeStream(adaptor,"rule v4",v4!=null?v4.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 106:38: -> ^( BECOMES $v4 STRING )
                    {
                        dbg.location(106,41);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:106:41: ^( BECOMES $v4 STRING )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(106,43);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(106,52);
                        adaptor.addChild(root_1, stream_v4.nextTree());
                        dbg.location(106,56);
                        adaptor.addChild(root_1, stream_STRING.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:108:4: x1= implicit_variable BECOMES x2= explicit_variable
                    {
                    dbg.location(108,6);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment629);
                    x1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(x1.getTree());
                    dbg.location(108,25);
                    BECOMES29=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment631);  
                    stream_BECOMES.add(BECOMES29);

                    dbg.location(108,35);
                    pushFollow(FOLLOW_explicit_variable_in_implicit_assignment635);
                    x2=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(x2.getTree());


                    // AST REWRITE
                    // elements: x1, BECOMES, x2
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
                    // 108:54: -> ^( BECOMES $x1 $x2)
                    {
                        dbg.location(108,57);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:108:57: ^( BECOMES $x1 $x2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(108,59);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(108,69);
                        adaptor.addChild(root_1, stream_x1.nextTree());
                        dbg.location(108,73);
                        adaptor.addChild(root_1, stream_x2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:109:4: x3= explicit_variable BECOMES x4= implicit_variable
                    {
                    dbg.location(109,6);
                    pushFollow(FOLLOW_explicit_variable_in_implicit_assignment657);
                    x3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(x3.getTree());
                    dbg.location(109,25);
                    BECOMES30=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment659);  
                    stream_BECOMES.add(BECOMES30);

                    dbg.location(109,35);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment663);
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
                    // 109:54: -> ^( BECOMES $x3 $x4)
                    {
                        dbg.location(109,57);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:109:57: ^( BECOMES $x3 $x4)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(109,59);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BECOMES.nextNode(), root_1);

                        dbg.location(109,69);
                        adaptor.addChild(root_1, stream_x3.nextTree());
                        dbg.location(109,73);
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
        dbg.location(111, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "implicit_assignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "implicit_assignment"

    public static class explicit_comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "explicit_comparison"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:114:1: explicit_comparison : exp1= explicit_variable comparison exp2= explicit_variable -> ^( comparison $exp1 $exp2) ;
    public final Assign10Parser.explicit_comparison_return explicit_comparison() throws RecognitionException {
        Assign10Parser.explicit_comparison_return retval = new Assign10Parser.explicit_comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Assign10Parser.explicit_variable_return exp1 = null;

        Assign10Parser.explicit_variable_return exp2 = null;

        Assign10Parser.comparison_return comparison31 = null;


        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try { dbg.enterRule(getGrammarFileName(), "explicit_comparison");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(114, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:115:2: (exp1= explicit_variable comparison exp2= explicit_variable -> ^( comparison $exp1 $exp2) )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:115:6: exp1= explicit_variable comparison exp2= explicit_variable
            {
            dbg.location(115,10);
            pushFollow(FOLLOW_explicit_variable_in_explicit_comparison699);
            exp1=explicit_variable();

            state._fsp--;

            stream_explicit_variable.add(exp1.getTree());
            dbg.location(115,29);
            pushFollow(FOLLOW_comparison_in_explicit_comparison701);
            comparison31=comparison();

            state._fsp--;

            stream_comparison.add(comparison31.getTree());
            dbg.location(115,45);
            pushFollow(FOLLOW_explicit_variable_in_explicit_comparison706);
            exp2=explicit_variable();

            state._fsp--;

            stream_explicit_variable.add(exp2.getTree());


            // AST REWRITE
            // elements: exp2, exp1, comparison
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
            // 115:64: -> ^( comparison $exp1 $exp2)
            {
                dbg.location(115,67);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:115:67: ^( comparison $exp1 $exp2)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(115,69);
                root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                dbg.location(115,80);
                adaptor.addChild(root_1, stream_exp1.nextTree());
                dbg.location(115,86);
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
        dbg.location(115, 93);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "explicit_comparison");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "explicit_comparison"

    public static class implicit_comparison_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicit_comparison"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:117:1: implicit_comparison : ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) );
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

        Assign10Parser.explicit_comparison_return explicit_comparison32 = null;

        Assign10Parser.comparison_return comparison33 = null;

        Assign10Parser.comparison_return comparison34 = null;

        Assign10Parser.comparison_return comparison35 = null;


        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_implicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule implicit_variable");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try { dbg.enterRule(getGrammarFileName(), "implicit_comparison");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(117, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:120:2: ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) )
            int alt12=4;
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            try {
                isCyclicDecision = true;
                alt12 = dfa12.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:120:4: explicit_comparison
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(120,4);
                    pushFollow(FOLLOW_explicit_comparison_in_implicit_comparison730);
                    explicit_comparison32=explicit_comparison();

                    state._fsp--;

                    adaptor.addChild(root_0, explicit_comparison32.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:121:3: ixp1= implicit_variable comparison ixp2= implicit_variable
                    {
                    dbg.location(121,7);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison738);
                    ixp1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp1.getTree());
                    dbg.location(121,26);
                    pushFollow(FOLLOW_comparison_in_implicit_comparison740);
                    comparison33=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison33.getTree());
                    dbg.location(121,41);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison744);
                    ixp2=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp2.getTree());


                    // AST REWRITE
                    // elements: ixp1, ixp2, comparison
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
                    // 121:60: -> ^( comparison $ixp1 $ixp2)
                    {
                        dbg.location(121,63);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:121:63: ^( comparison $ixp1 $ixp2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(121,65);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                        dbg.location(121,76);
                        adaptor.addChild(root_1, stream_ixp1.nextTree());
                        dbg.location(121,82);
                        adaptor.addChild(root_1, stream_ixp2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:122:3: exp3= explicit_variable comparison ixp4= implicit_variable
                    {
                    dbg.location(122,7);
                    pushFollow(FOLLOW_explicit_variable_in_implicit_comparison764);
                    exp3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(exp3.getTree());
                    dbg.location(122,26);
                    pushFollow(FOLLOW_comparison_in_implicit_comparison766);
                    comparison34=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison34.getTree());
                    dbg.location(122,41);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison770);
                    ixp4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp4.getTree());


                    // AST REWRITE
                    // elements: exp3, comparison, ixp4
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
                    // 122:60: -> ^( comparison $exp3 $ixp4)
                    {
                        dbg.location(122,63);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:122:63: ^( comparison $exp3 $ixp4)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(122,65);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                        dbg.location(122,76);
                        adaptor.addChild(root_1, stream_exp3.nextTree());
                        dbg.location(122,82);
                        adaptor.addChild(root_1, stream_ixp4.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:123:3: ixp5= implicit_variable comparison exp4= explicit_variable
                    {
                    dbg.location(123,7);
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison796);
                    ixp5=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp5.getTree());
                    dbg.location(123,26);
                    pushFollow(FOLLOW_comparison_in_implicit_comparison798);
                    comparison35=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison35.getTree());
                    dbg.location(123,41);
                    pushFollow(FOLLOW_explicit_variable_in_implicit_comparison802);
                    exp4=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(exp4.getTree());


                    // AST REWRITE
                    // elements: exp4, ixp5, comparison
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
                    // 123:60: -> ^( comparison $ixp5 $exp4)
                    {
                        dbg.location(123,63);
                        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:123:63: ^( comparison $ixp5 $exp4)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(123,65);
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_comparison.nextNode(), root_1);

                        dbg.location(123,76);
                        adaptor.addChild(root_1, stream_ixp5.nextTree());
                        dbg.location(123,82);
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
        dbg.location(124, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "implicit_comparison");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "implicit_comparison"

    public static class implicit_variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "implicit_variable"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:127:1: implicit_variable : dot_operation d0= IDENT -> ^( IMPLICIT_VAR $d0) ;
    public final Assign10Parser.implicit_variable_return implicit_variable() throws RecognitionException {
        Assign10Parser.implicit_variable_return retval = new Assign10Parser.implicit_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token d0=null;
        Assign10Parser.dot_operation_return dot_operation36 = null;


        CommonTree d0_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_dot_operation=new RewriteRuleSubtreeStream(adaptor,"rule dot_operation");
        try { dbg.enterRule(getGrammarFileName(), "implicit_variable");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(127, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:150:2: ( dot_operation d0= IDENT -> ^( IMPLICIT_VAR $d0) )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:150:5: dot_operation d0= IDENT
            {
            dbg.location(150,5);
            pushFollow(FOLLOW_dot_operation_in_implicit_variable839);
            dot_operation36=dot_operation();

            state._fsp--;

            stream_dot_operation.add(dot_operation36.getTree());
            dbg.location(150,22);
            d0=(Token)match(input,IDENT,FOLLOW_IDENT_in_implicit_variable844);  
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
            // 153:3: -> ^( IMPLICIT_VAR $d0)
            {
                dbg.location(153,6);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:153:6: ^( IMPLICIT_VAR $d0)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(153,8);
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IMPLICIT_VAR, "IMPLICIT_VAR"), root_1);

                dbg.location(153,22);
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
        dbg.location(159, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "implicit_variable");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "implicit_variable"

    public static class explicit_variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "explicit_variable"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:164:1: explicit_variable : c0= IDENT dot_operation c1= IDENT -> ^( VAR $c0 $c1) ;
    public final Assign10Parser.explicit_variable_return explicit_variable() throws RecognitionException {
        Assign10Parser.explicit_variable_return retval = new Assign10Parser.explicit_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c0=null;
        Token c1=null;
        Assign10Parser.dot_operation_return dot_operation37 = null;


        CommonTree c0_tree=null;
        CommonTree c1_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_dot_operation=new RewriteRuleSubtreeStream(adaptor,"rule dot_operation");
        try { dbg.enterRule(getGrammarFileName(), "explicit_variable");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(164, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:165:2: (c0= IDENT dot_operation c1= IDENT -> ^( VAR $c0 $c1) )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:165:4: c0= IDENT dot_operation c1= IDENT
            {
            dbg.location(165,6);
            c0=(Token)match(input,IDENT,FOLLOW_IDENT_in_explicit_variable905);  
            stream_IDENT.add(c0);

            dbg.location(165,13);
            pushFollow(FOLLOW_dot_operation_in_explicit_variable907);
            dot_operation37=dot_operation();

            state._fsp--;

            stream_dot_operation.add(dot_operation37.getTree());
            dbg.location(165,29);
            c1=(Token)match(input,IDENT,FOLLOW_IDENT_in_explicit_variable911);  
            stream_IDENT.add(c1);



            // AST REWRITE
            // elements: c0, c1
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
            // 165:37: -> ^( VAR $c0 $c1)
            {
                dbg.location(165,40);
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:165:40: ^( VAR $c0 $c1)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(165,42);
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                dbg.location(165,46);
                adaptor.addChild(root_1, stream_c0.nextNode());
                dbg.location(165,50);
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
        dbg.location(165, 56);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "explicit_variable");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "explicit_variable"

    public static class dot_operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dot_operation"
    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:168:1: dot_operation : DOT_OP ;
    public final Assign10Parser.dot_operation_return dot_operation() throws RecognitionException {
        Assign10Parser.dot_operation_return retval = new Assign10Parser.dot_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DOT_OP38=null;

        CommonTree DOT_OP38_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "dot_operation");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(168, 1);

        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:169:2: ( DOT_OP )
            dbg.enterAlt(1);

            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:169:4: DOT_OP
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(169,4);
            DOT_OP38=(Token)match(input,DOT_OP,FOLLOW_DOT_OP_in_dot_operation938); 
            DOT_OP38_tree = (CommonTree)adaptor.create(DOT_OP38);
            adaptor.addChild(root_0, DOT_OP38_tree);


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
        dbg.location(169, 10);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "dot_operation");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
            return "100:1: implicit_assignment : ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA12_eotS =
        "\14\uffff";
    static final String DFA12_eofS =
        "\14\uffff";
    static final String DFA12_minS =
        "\1\5\1\21\2\5\2\33\2\5\4\uffff";
    static final String DFA12_maxS =
        "\2\21\2\5\2\41\2\21\4\uffff";
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
            return "117:1: implicit_comparison : ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_ifStatement_in_program60 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_usingStatement_in_program66 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_USING_in_usingStatement91 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_usingStatement96 = new BitSet(new long[]{0x0000000004000040L});
    public static final BitSet FOLLOW_implicitIfStatement_in_usingStatement105 = new BitSet(new long[]{0x0000000004000040L});
    public static final BitSet FOLLOW_26_in_usingStatement119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_implicitIfStatement169 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_comparison_in_implicitIfStatement172 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_THEN_in_implicitIfStatement177 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_assignment_in_implicitIfStatement185 = new BitSet(new long[]{0x0000000000020320L});
    public static final BitSet FOLLOW_ELSE_in_implicitIfStatement193 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_assignment_in_implicitIfStatement199 = new BitSet(new long[]{0x0000000000020220L});
    public static final BitSet FOLLOW_ENDIF_in_implicitIfStatement206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement251 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_comparison_in_ifStatement254 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_THEN_in_ifStatement259 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_assignment_in_ifStatement267 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement275 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_assignment_in_ifStatement281 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_ENDIF_in_ifStatement288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_logical_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment420 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment422 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment446 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment448 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_explicit_assignment450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment476 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment478 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_explicit_assignment480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparison0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_assignment_in_implicit_assignment531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment540 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment542 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment569 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment571 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_implicit_assignment573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment604 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment606 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_implicit_assignment608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment629 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment631 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_assignment635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_assignment657 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment659 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_comparison699 = new BitSet(new long[]{0x00000003F8000000L});
    public static final BitSet FOLLOW_comparison_in_explicit_comparison701 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_comparison706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_comparison_in_implicit_comparison730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison738 = new BitSet(new long[]{0x00000003F8000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison740 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_comparison764 = new BitSet(new long[]{0x00000003F8000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison766 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison796 = new BitSet(new long[]{0x00000003F8000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison798 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_comparison802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dot_operation_in_implicit_variable839 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_implicit_variable844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_explicit_variable905 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_dot_operation_in_explicit_variable907 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_explicit_variable911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_OP_in_dot_operation938 = new BitSet(new long[]{0x0000000000000002L});

}