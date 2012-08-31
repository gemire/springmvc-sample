// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g 2011-03-23 12:24:41

  package com.dhenton9000.assign.parsers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class AssignNWSParser extends Parser {
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


        public AssignNWSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public AssignNWSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return AssignNWSParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g"; }


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:24:1: program : ( statements )+ -> ^( PROGRAM ( statements )+ ) ;
    public final AssignNWSParser.program_return program() throws RecognitionException {
        AssignNWSParser.program_return retval = new AssignNWSParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        AssignNWSParser.statements_return statements1 = null;


        RewriteRuleSubtreeStream stream_statements=new RewriteRuleSubtreeStream(adaptor,"rule statements");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:24:9: ( ( statements )+ -> ^( PROGRAM ( statements )+ ) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:27:2: ( statements )+
            {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:27:2: ( statements )+
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
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:27:3: statements
            	    {
            	    pushFollow(FOLLOW_statements_in_program61);
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
            // 27:16: -> ^( PROGRAM ( statements )+ )
            {
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:27:20: ^( PROGRAM ( statements )+ )
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:29:1: statements : ( ifStatement | usingStatement );
    public final AssignNWSParser.statements_return statements() throws RecognitionException {
        AssignNWSParser.statements_return retval = new AssignNWSParser.statements_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        AssignNWSParser.ifStatement_return ifStatement2 = null;

        AssignNWSParser.usingStatement_return usingStatement3 = null;



        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:30:2: ( ifStatement | usingStatement )
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:30:4: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statements84);
                    ifStatement2=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement2.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:30:18: usingStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_usingStatement_in_statements88);
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
        String idTokenText;
        Token idToken;
    }
    protected Stack usingStatement_stack = new Stack();

    public static class usingStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "usingStatement"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:32:1: usingStatement : USING identVar= IDENT ( implicitIfStatement )+ 'END_USING' -> ( implicitIfStatement )+ ;
    public final AssignNWSParser.usingStatement_return usingStatement() throws RecognitionException {
        usingStatement_stack.push(new usingStatement_scope());
        AssignNWSParser.usingStatement_return retval = new AssignNWSParser.usingStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token identVar=null;
        Token USING4=null;
        Token string_literal6=null;
        AssignNWSParser.implicitIfStatement_return implicitIfStatement5 = null;


        CommonTree identVar_tree=null;
        CommonTree USING4_tree=null;
        CommonTree string_literal6_tree=null;
        RewriteRuleTokenStream stream_USING=new RewriteRuleTokenStream(adaptor,"token USING");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleSubtreeStream stream_implicitIfStatement=new RewriteRuleSubtreeStream(adaptor,"rule implicitIfStatement");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:39:2: ( USING identVar= IDENT ( implicitIfStatement )+ 'END_USING' -> ( implicitIfStatement )+ )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:40:2: USING identVar= IDENT ( implicitIfStatement )+ 'END_USING'
            {
            USING4=(Token)match(input,USING,FOLLOW_USING_in_usingStatement108);  
            stream_USING.add(USING4);

            identVar=(Token)match(input,IDENT,FOLLOW_IDENT_in_usingStatement113);  
            stream_IDENT.add(identVar);

            ((usingStatement_scope)usingStatement_stack.peek()).idTokenText = (identVar!=null?identVar.getText():null); ((usingStatement_scope)usingStatement_stack.peek()).idToken = identVar;   
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:41:3: ( implicitIfStatement )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IF) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:41:4: implicitIfStatement
            	    {
            	    pushFollow(FOLLOW_implicitIfStatement_in_usingStatement120);
            	    implicitIfStatement5=implicitIfStatement();

            	    state._fsp--;

            	    stream_implicitIfStatement.add(implicitIfStatement5.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            string_literal6=(Token)match(input,27,FOLLOW_27_in_usingStatement128);  
            stream_27.add(string_literal6);



            // AST REWRITE
            // elements: implicitIfStatement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 46:7: -> ( implicitIfStatement )+
            {
                if ( !(stream_implicitIfStatement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_implicitIfStatement.hasNext() ) {
                    adaptor.addChild(root_0, stream_implicitIfStatement.nextTree());

                }
                stream_implicitIfStatement.reset();

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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:51:1: implicitIfStatement : IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison ) ;
    public final AssignNWSParser.implicitIfStatement_return implicitIfStatement() throws RecognitionException {
        AssignNWSParser.implicitIfStatement_return retval = new AssignNWSParser.implicitIfStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF7=null;
        Token THEN9=null;
        Token ELSE10=null;
        Token ENDIF11=null;
        List list_strue2=null;
        List list_sfalse2=null;
        AssignNWSParser.implicit_comparison_return implicit_comparison8 = null;

        RuleReturnScope strue2 = null;
        RuleReturnScope sfalse2 = null;
        CommonTree IF7_tree=null;
        CommonTree THEN9_tree=null;
        CommonTree ELSE10_tree=null;
        CommonTree ENDIF11_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_implicit_assignment=new RewriteRuleSubtreeStream(adaptor,"rule implicit_assignment");
        RewriteRuleSubtreeStream stream_implicit_comparison=new RewriteRuleSubtreeStream(adaptor,"rule implicit_comparison");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:54:2: ( IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison ) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:55:2: IF implicit_comparison THEN (strue2+= implicit_assignment )+ ( ELSE (sfalse2+= implicit_assignment )+ )? ENDIF
            {
            IF7=(Token)match(input,IF,FOLLOW_IF_in_implicitIfStatement175);  
            stream_IF.add(IF7);

            pushFollow(FOLLOW_implicit_comparison_in_implicitIfStatement178);
            implicit_comparison8=implicit_comparison();

            state._fsp--;

            stream_implicit_comparison.add(implicit_comparison8.getTree());
            THEN9=(Token)match(input,THEN,FOLLOW_THEN_in_implicitIfStatement183);  
            stream_THEN.add(THEN9);

            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:56:3: (strue2+= implicit_assignment )+
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
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:56:4: strue2+= implicit_assignment
            	    {
            	    pushFollow(FOLLOW_implicit_assignment_in_implicitIfStatement191);
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

            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:58:2: ( ELSE (sfalse2+= implicit_assignment )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ELSE) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:58:3: ELSE (sfalse2+= implicit_assignment )+
                    {
                    ELSE10=(Token)match(input,ELSE,FOLLOW_ELSE_in_implicitIfStatement199);  
                    stream_ELSE.add(ELSE10);

                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:58:9: (sfalse2+= implicit_assignment )+
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
                    	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:58:10: sfalse2+= implicit_assignment
                    	    {
                    	    pushFollow(FOLLOW_implicit_assignment_in_implicitIfStatement205);
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

            ENDIF11=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_implicitIfStatement212);  
            stream_ENDIF.add(ENDIF11);



            // AST REWRITE
            // elements: sfalse2, IF, implicit_comparison, strue2
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: sfalse2, strue2
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_sfalse2=new RewriteRuleSubtreeStream(adaptor,"token sfalse2",list_sfalse2);
            RewriteRuleSubtreeStream stream_strue2=new RewriteRuleSubtreeStream(adaptor,"token strue2",list_strue2);
            root_0 = (CommonTree)adaptor.nil();
            // 60:2: -> ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison )
            {
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:60:5: ^( IF ^( TRUE ( $strue2)+ ) ( ^( FALSE ( $sfalse2)+ ) )? implicit_comparison )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:60:10: ^( TRUE ( $strue2)+ )
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
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:60:27: ( ^( FALSE ( $sfalse2)+ ) )?
                if ( stream_sfalse2.hasNext() ) {
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:60:27: ^( FALSE ( $sfalse2)+ )
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:64:1: ifStatement : IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison ) ;
    public final AssignNWSParser.ifStatement_return ifStatement() throws RecognitionException {
        AssignNWSParser.ifStatement_return retval = new AssignNWSParser.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF12=null;
        Token THEN14=null;
        Token ELSE15=null;
        Token ENDIF16=null;
        List list_strue1=null;
        List list_sfalse1=null;
        AssignNWSParser.explicit_comparison_return explicit_comparison13 = null;

        RuleReturnScope strue1 = null;
        RuleReturnScope sfalse1 = null;
        CommonTree IF12_tree=null;
        CommonTree THEN14_tree=null;
        CommonTree ELSE15_tree=null;
        CommonTree ENDIF16_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_explicit_assignment=new RewriteRuleSubtreeStream(adaptor,"rule explicit_assignment");
        RewriteRuleSubtreeStream stream_explicit_comparison=new RewriteRuleSubtreeStream(adaptor,"rule explicit_comparison");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:65:2: ( IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison ) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:67:2: IF explicit_comparison THEN (strue1+= explicit_assignment )+ ( ELSE (sfalse1+= explicit_assignment )+ )? ENDIF
            {
            IF12=(Token)match(input,IF,FOLLOW_IF_in_ifStatement257);  
            stream_IF.add(IF12);

            pushFollow(FOLLOW_explicit_comparison_in_ifStatement260);
            explicit_comparison13=explicit_comparison();

            state._fsp--;

            stream_explicit_comparison.add(explicit_comparison13.getTree());
            THEN14=(Token)match(input,THEN,FOLLOW_THEN_in_ifStatement265);  
            stream_THEN.add(THEN14);

            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:68:3: (strue1+= explicit_assignment )+
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
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:68:4: strue1+= explicit_assignment
            	    {
            	    pushFollow(FOLLOW_explicit_assignment_in_ifStatement273);
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

            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:70:2: ( ELSE (sfalse1+= explicit_assignment )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ELSE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:70:3: ELSE (sfalse1+= explicit_assignment )+
                    {
                    ELSE15=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStatement281);  
                    stream_ELSE.add(ELSE15);

                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:70:9: (sfalse1+= explicit_assignment )+
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
                    	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:70:10: sfalse1+= explicit_assignment
                    	    {
                    	    pushFollow(FOLLOW_explicit_assignment_in_ifStatement287);
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

            ENDIF16=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_ifStatement294);  
            stream_ENDIF.add(ENDIF16);



            // AST REWRITE
            // elements: strue1, IF, sfalse1, explicit_comparison
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: sfalse1, strue1
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_sfalse1=new RewriteRuleSubtreeStream(adaptor,"token sfalse1",list_sfalse1);
            RewriteRuleSubtreeStream stream_strue1=new RewriteRuleSubtreeStream(adaptor,"token strue1",list_strue1);
            root_0 = (CommonTree)adaptor.nil();
            // 72:2: -> ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison )
            {
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:72:5: ^( IF ^( TRUE ( $strue1)+ ) ( ^( FALSE ( $sfalse1)+ ) )? explicit_comparison )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:72:10: ^( TRUE ( $strue1)+ )
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
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:72:27: ( ^( FALSE ( $sfalse1)+ ) )?
                if ( stream_sfalse1.hasNext() ) {
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:72:27: ^( FALSE ( $sfalse1)+ )
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:77:1: logical_operator : ( AND | OR );
    public final AssignNWSParser.logical_operator_return logical_operator() throws RecognitionException {
        AssignNWSParser.logical_operator_return retval = new AssignNWSParser.logical_operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set17=null;

        CommonTree set17_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:78:2: ( AND | OR )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:94:1: explicit_assignment : (v1= explicit_variable BECOMES v2= explicit_variable -> ^( BECOMES $v1 $v2) | v3= explicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= explicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) );
    public final AssignNWSParser.explicit_assignment_return explicit_assignment() throws RecognitionException {
        AssignNWSParser.explicit_assignment_return retval = new AssignNWSParser.explicit_assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BECOMES18=null;
        Token BECOMES19=null;
        Token VALUE20=null;
        Token BECOMES21=null;
        Token STRING22=null;
        AssignNWSParser.explicit_variable_return v1 = null;

        AssignNWSParser.explicit_variable_return v2 = null;

        AssignNWSParser.explicit_variable_return v3 = null;

        AssignNWSParser.explicit_variable_return v4 = null;


        CommonTree BECOMES18_tree=null;
        CommonTree BECOMES19_tree=null;
        CommonTree VALUE20_tree=null;
        CommonTree BECOMES21_tree=null;
        CommonTree STRING22_tree=null;
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleTokenStream stream_BECOMES=new RewriteRuleTokenStream(adaptor,"token BECOMES");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:95:2: (v1= explicit_variable BECOMES v2= explicit_variable -> ^( BECOMES $v1 $v2) | v3= explicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= explicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) )
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:95:4: v1= explicit_variable BECOMES v2= explicit_variable
                    {
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment426);
                    v1=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v1.getTree());
                    BECOMES18=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment428);  
                    stream_BECOMES.add(BECOMES18);

                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment432);
                    v2=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v2.getTree());


                    // AST REWRITE
                    // elements: v2, v1, BECOMES
                    // token labels: 
                    // rule labels: v1, v2, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v1=new RewriteRuleSubtreeStream(adaptor,"rule v1",v1!=null?v1.tree:null);
                    RewriteRuleSubtreeStream stream_v2=new RewriteRuleSubtreeStream(adaptor,"rule v2",v2!=null?v2.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 95:54: -> ^( BECOMES $v1 $v2)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:95:57: ^( BECOMES $v1 $v2)
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:96:4: v3= explicit_variable BECOMES VALUE
                    {
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment454);
                    v3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v3.getTree());
                    BECOMES19=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment456);  
                    stream_BECOMES.add(BECOMES19);

                    VALUE20=(Token)match(input,VALUE,FOLLOW_VALUE_in_explicit_assignment458);  
                    stream_VALUE.add(VALUE20);



                    // AST REWRITE
                    // elements: BECOMES, VALUE, v3
                    // token labels: 
                    // rule labels: v3, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v3=new RewriteRuleSubtreeStream(adaptor,"rule v3",v3!=null?v3.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 96:40: -> ^( BECOMES $v3 VALUE )
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:96:43: ^( BECOMES $v3 VALUE )
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:97:4: v4= explicit_variable BECOMES STRING
                    {
                    pushFollow(FOLLOW_explicit_variable_in_explicit_assignment487);
                    v4=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(v4.getTree());
                    BECOMES21=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_explicit_assignment489);  
                    stream_BECOMES.add(BECOMES21);

                    STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_explicit_assignment491);  
                    stream_STRING.add(STRING22);



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
                    // 97:40: -> ^( BECOMES $v4 STRING )
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:97:43: ^( BECOMES $v4 STRING )
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:101:1: comparison : ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' );
    public final AssignNWSParser.comparison_return comparison() throws RecognitionException {
        AssignNWSParser.comparison_return retval = new AssignNWSParser.comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set23=null;

        CommonTree set23_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:102:2: ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:105:1: implicit_assignment : ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) );
    public final AssignNWSParser.implicit_assignment_return implicit_assignment() throws RecognitionException {
        AssignNWSParser.implicit_assignment_return retval = new AssignNWSParser.implicit_assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BECOMES25=null;
        Token BECOMES26=null;
        Token VALUE27=null;
        Token BECOMES28=null;
        Token STRING29=null;
        Token BECOMES30=null;
        Token BECOMES31=null;
        AssignNWSParser.implicit_variable_return v1 = null;

        AssignNWSParser.implicit_variable_return v2 = null;

        AssignNWSParser.implicit_variable_return v3 = null;

        AssignNWSParser.implicit_variable_return v4 = null;

        AssignNWSParser.implicit_variable_return x1 = null;

        AssignNWSParser.explicit_variable_return x2 = null;

        AssignNWSParser.explicit_variable_return x3 = null;

        AssignNWSParser.implicit_variable_return x4 = null;

        AssignNWSParser.explicit_assignment_return explicit_assignment24 = null;


        CommonTree BECOMES25_tree=null;
        CommonTree BECOMES26_tree=null;
        CommonTree VALUE27_tree=null;
        CommonTree BECOMES28_tree=null;
        CommonTree STRING29_tree=null;
        CommonTree BECOMES30_tree=null;
        CommonTree BECOMES31_tree=null;
        RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
        RewriteRuleTokenStream stream_BECOMES=new RewriteRuleTokenStream(adaptor,"token BECOMES");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_implicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule implicit_variable");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:106:2: ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) )
            int alt11=6;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:108:1: explicit_assignment
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_explicit_assignment_in_implicit_assignment544);
                    explicit_assignment24=explicit_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, explicit_assignment24.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:110:4: v1= implicit_variable BECOMES v2= implicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment555);
                    v1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v1.getTree());
                    BECOMES25=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment557);  
                    stream_BECOMES.add(BECOMES25);

                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment561);
                    v2=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v2.getTree());


                    // AST REWRITE
                    // elements: v1, v2, BECOMES
                    // token labels: 
                    // rule labels: v1, v2, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v1=new RewriteRuleSubtreeStream(adaptor,"rule v1",v1!=null?v1.tree:null);
                    RewriteRuleSubtreeStream stream_v2=new RewriteRuleSubtreeStream(adaptor,"rule v2",v2!=null?v2.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 110:54: -> ^( BECOMES $v1 $v2)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:110:57: ^( BECOMES $v1 $v2)
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:111:4: v3= implicit_variable BECOMES VALUE
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment584);
                    v3=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v3.getTree());
                    BECOMES26=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment586);  
                    stream_BECOMES.add(BECOMES26);

                    VALUE27=(Token)match(input,VALUE,FOLLOW_VALUE_in_implicit_assignment588);  
                    stream_VALUE.add(VALUE27);



                    // AST REWRITE
                    // elements: BECOMES, VALUE, v3
                    // token labels: 
                    // rule labels: v3, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v3=new RewriteRuleSubtreeStream(adaptor,"rule v3",v3!=null?v3.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 111:40: -> ^( BECOMES $v3 VALUE )
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:111:43: ^( BECOMES $v3 VALUE )
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:112:4: v4= implicit_variable BECOMES STRING
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment620);
                    v4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(v4.getTree());
                    BECOMES28=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment622);  
                    stream_BECOMES.add(BECOMES28);

                    STRING29=(Token)match(input,STRING,FOLLOW_STRING_in_implicit_assignment624);  
                    stream_STRING.add(STRING29);



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
                    // 112:40: -> ^( BECOMES $v4 STRING )
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:112:43: ^( BECOMES $v4 STRING )
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:113:4: x1= implicit_variable BECOMES x2= explicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment643);
                    x1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(x1.getTree());
                    BECOMES30=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment645);  
                    stream_BECOMES.add(BECOMES30);

                    pushFollow(FOLLOW_explicit_variable_in_implicit_assignment649);
                    x2=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(x2.getTree());


                    // AST REWRITE
                    // elements: BECOMES, x2, x1
                    // token labels: 
                    // rule labels: x2, x1, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_x2=new RewriteRuleSubtreeStream(adaptor,"rule x2",x2!=null?x2.tree:null);
                    RewriteRuleSubtreeStream stream_x1=new RewriteRuleSubtreeStream(adaptor,"rule x1",x1!=null?x1.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 113:54: -> ^( BECOMES $x1 $x2)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:113:57: ^( BECOMES $x1 $x2)
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:114:4: x3= explicit_variable BECOMES x4= implicit_variable
                    {
                    pushFollow(FOLLOW_explicit_variable_in_implicit_assignment671);
                    x3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(x3.getTree());
                    BECOMES31=(Token)match(input,BECOMES,FOLLOW_BECOMES_in_implicit_assignment673);  
                    stream_BECOMES.add(BECOMES31);

                    pushFollow(FOLLOW_implicit_variable_in_implicit_assignment677);
                    x4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(x4.getTree());


                    // AST REWRITE
                    // elements: x4, x3, BECOMES
                    // token labels: 
                    // rule labels: x4, x3, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_x4=new RewriteRuleSubtreeStream(adaptor,"rule x4",x4!=null?x4.tree:null);
                    RewriteRuleSubtreeStream stream_x3=new RewriteRuleSubtreeStream(adaptor,"rule x3",x3!=null?x3.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 114:54: -> ^( BECOMES $x3 $x4)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:114:57: ^( BECOMES $x3 $x4)
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:119:1: explicit_comparison : exp1= explicit_variable comparison exp2= explicit_variable -> ^( comparison $exp1 $exp2) ;
    public final AssignNWSParser.explicit_comparison_return explicit_comparison() throws RecognitionException {
        AssignNWSParser.explicit_comparison_return retval = new AssignNWSParser.explicit_comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        AssignNWSParser.explicit_variable_return exp1 = null;

        AssignNWSParser.explicit_variable_return exp2 = null;

        AssignNWSParser.comparison_return comparison32 = null;


        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:120:2: (exp1= explicit_variable comparison exp2= explicit_variable -> ^( comparison $exp1 $exp2) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:120:6: exp1= explicit_variable comparison exp2= explicit_variable
            {
            pushFollow(FOLLOW_explicit_variable_in_explicit_comparison713);
            exp1=explicit_variable();

            state._fsp--;

            stream_explicit_variable.add(exp1.getTree());
            pushFollow(FOLLOW_comparison_in_explicit_comparison715);
            comparison32=comparison();

            state._fsp--;

            stream_comparison.add(comparison32.getTree());
            pushFollow(FOLLOW_explicit_variable_in_explicit_comparison720);
            exp2=explicit_variable();

            state._fsp--;

            stream_explicit_variable.add(exp2.getTree());


            // AST REWRITE
            // elements: exp1, comparison, exp2
            // token labels: 
            // rule labels: exp2, retval, exp1
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_exp2=new RewriteRuleSubtreeStream(adaptor,"rule exp2",exp2!=null?exp2.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exp1=new RewriteRuleSubtreeStream(adaptor,"rule exp1",exp1!=null?exp1.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 120:64: -> ^( comparison $exp1 $exp2)
            {
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:120:67: ^( comparison $exp1 $exp2)
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:122:1: implicit_comparison : ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) );
    public final AssignNWSParser.implicit_comparison_return implicit_comparison() throws RecognitionException {
        AssignNWSParser.implicit_comparison_return retval = new AssignNWSParser.implicit_comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        AssignNWSParser.implicit_variable_return ixp1 = null;

        AssignNWSParser.implicit_variable_return ixp2 = null;

        AssignNWSParser.explicit_variable_return exp3 = null;

        AssignNWSParser.implicit_variable_return ixp4 = null;

        AssignNWSParser.implicit_variable_return ixp5 = null;

        AssignNWSParser.explicit_variable_return exp4 = null;

        AssignNWSParser.explicit_comparison_return explicit_comparison33 = null;

        AssignNWSParser.comparison_return comparison34 = null;

        AssignNWSParser.comparison_return comparison35 = null;

        AssignNWSParser.comparison_return comparison36 = null;


        RewriteRuleSubtreeStream stream_explicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule explicit_variable");
        RewriteRuleSubtreeStream stream_implicit_variable=new RewriteRuleSubtreeStream(adaptor,"rule implicit_variable");
        RewriteRuleSubtreeStream stream_comparison=new RewriteRuleSubtreeStream(adaptor,"rule comparison");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:125:2: ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) )
            int alt12=4;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:125:4: explicit_comparison
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_explicit_comparison_in_implicit_comparison744);
                    explicit_comparison33=explicit_comparison();

                    state._fsp--;

                    adaptor.addChild(root_0, explicit_comparison33.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:126:3: ixp1= implicit_variable comparison ixp2= implicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison752);
                    ixp1=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp1.getTree());
                    pushFollow(FOLLOW_comparison_in_implicit_comparison754);
                    comparison34=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison34.getTree());
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison758);
                    ixp2=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp2.getTree());


                    // AST REWRITE
                    // elements: ixp1, comparison, ixp2
                    // token labels: 
                    // rule labels: ixp1, retval, ixp2
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ixp1=new RewriteRuleSubtreeStream(adaptor,"rule ixp1",ixp1!=null?ixp1.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ixp2=new RewriteRuleSubtreeStream(adaptor,"rule ixp2",ixp2!=null?ixp2.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 126:60: -> ^( comparison $ixp1 $ixp2)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:126:63: ^( comparison $ixp1 $ixp2)
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:127:3: exp3= explicit_variable comparison ixp4= implicit_variable
                    {
                    pushFollow(FOLLOW_explicit_variable_in_implicit_comparison778);
                    exp3=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(exp3.getTree());
                    pushFollow(FOLLOW_comparison_in_implicit_comparison780);
                    comparison35=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison35.getTree());
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison784);
                    ixp4=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp4.getTree());


                    // AST REWRITE
                    // elements: exp3, ixp4, comparison
                    // token labels: 
                    // rule labels: ixp4, retval, exp3
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ixp4=new RewriteRuleSubtreeStream(adaptor,"rule ixp4",ixp4!=null?ixp4.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exp3=new RewriteRuleSubtreeStream(adaptor,"rule exp3",exp3!=null?exp3.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 127:60: -> ^( comparison $exp3 $ixp4)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:127:63: ^( comparison $exp3 $ixp4)
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:128:3: ixp5= implicit_variable comparison exp4= explicit_variable
                    {
                    pushFollow(FOLLOW_implicit_variable_in_implicit_comparison810);
                    ixp5=implicit_variable();

                    state._fsp--;

                    stream_implicit_variable.add(ixp5.getTree());
                    pushFollow(FOLLOW_comparison_in_implicit_comparison812);
                    comparison36=comparison();

                    state._fsp--;

                    stream_comparison.add(comparison36.getTree());
                    pushFollow(FOLLOW_explicit_variable_in_implicit_comparison816);
                    exp4=explicit_variable();

                    state._fsp--;

                    stream_explicit_variable.add(exp4.getTree());


                    // AST REWRITE
                    // elements: ixp5, exp4, comparison
                    // token labels: 
                    // rule labels: ixp5, retval, exp4
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ixp5=new RewriteRuleSubtreeStream(adaptor,"rule ixp5",ixp5!=null?ixp5.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_exp4=new RewriteRuleSubtreeStream(adaptor,"rule exp4",exp4!=null?exp4.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 128:60: -> ^( comparison $ixp5 $exp4)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:128:63: ^( comparison $ixp5 $exp4)
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:132:1: implicit_variable : dot_operation d0= IDENT -> ^( VAR IDENT[$usingStatement::idToken,$usingStatement::idTokenText] $d0) ;
    public final AssignNWSParser.implicit_variable_return implicit_variable() throws RecognitionException {
        AssignNWSParser.implicit_variable_return retval = new AssignNWSParser.implicit_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token d0=null;
        AssignNWSParser.dot_operation_return dot_operation37 = null;


        CommonTree d0_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_dot_operation=new RewriteRuleSubtreeStream(adaptor,"rule dot_operation");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:136:2: ( dot_operation d0= IDENT -> ^( VAR IDENT[$usingStatement::idToken,$usingStatement::idTokenText] $d0) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:136:5: dot_operation d0= IDENT
            {
            pushFollow(FOLLOW_dot_operation_in_implicit_variable845);
            dot_operation37=dot_operation();

            state._fsp--;

            stream_dot_operation.add(dot_operation37.getTree());
            d0=(Token)match(input,IDENT,FOLLOW_IDENT_in_implicit_variable850);  
            stream_IDENT.add(d0);



            // AST REWRITE
            // elements: d0, IDENT
            // token labels: d0
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_d0=new RewriteRuleTokenStream(adaptor,"token d0",d0);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 139:3: -> ^( VAR IDENT[$usingStatement::idToken,$usingStatement::idTokenText] $d0)
            {
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:139:6: ^( VAR IDENT[$usingStatement::idToken,$usingStatement::idTokenText] $d0)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                adaptor.addChild(root_1, (CommonTree)adaptor.create(IDENT, ((usingStatement_scope)usingStatement_stack.peek()).idToken, ((usingStatement_scope)usingStatement_stack.peek()).idTokenText));
                adaptor.addChild(root_1, stream_d0.nextNode());

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
    // $ANTLR end "implicit_variable"

    public static class explicit_variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "explicit_variable"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:150:1: explicit_variable : c0= IDENT dot_operation c1= IDENT -> ^( VAR $c0 $c1) ;
    public final AssignNWSParser.explicit_variable_return explicit_variable() throws RecognitionException {
        AssignNWSParser.explicit_variable_return retval = new AssignNWSParser.explicit_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token c0=null;
        Token c1=null;
        AssignNWSParser.dot_operation_return dot_operation38 = null;


        CommonTree c0_tree=null;
        CommonTree c1_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_dot_operation=new RewriteRuleSubtreeStream(adaptor,"rule dot_operation");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:151:2: (c0= IDENT dot_operation c1= IDENT -> ^( VAR $c0 $c1) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:151:4: c0= IDENT dot_operation c1= IDENT
            {
            c0=(Token)match(input,IDENT,FOLLOW_IDENT_in_explicit_variable913);  
            stream_IDENT.add(c0);

            pushFollow(FOLLOW_dot_operation_in_explicit_variable915);
            dot_operation38=dot_operation();

            state._fsp--;

            stream_dot_operation.add(dot_operation38.getTree());
            c1=(Token)match(input,IDENT,FOLLOW_IDENT_in_explicit_variable919);  
            stream_IDENT.add(c1);



            // AST REWRITE
            // elements: c0, c1
            // token labels: c0, c1
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_c0=new RewriteRuleTokenStream(adaptor,"token c0",c0);
            RewriteRuleTokenStream stream_c1=new RewriteRuleTokenStream(adaptor,"token c1",c1);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 151:37: -> ^( VAR $c0 $c1)
            {
                // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:151:40: ^( VAR $c0 $c1)
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
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:154:1: dot_operation : DOT_OP ;
    public final AssignNWSParser.dot_operation_return dot_operation() throws RecognitionException {
        AssignNWSParser.dot_operation_return retval = new AssignNWSParser.dot_operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DOT_OP39=null;

        CommonTree DOT_OP39_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:155:2: ( DOT_OP )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\AssignNWS.g:155:4: DOT_OP
            {
            root_0 = (CommonTree)adaptor.nil();

            DOT_OP39=(Token)match(input,DOT_OP,FOLLOW_DOT_OP_in_dot_operation946); 
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
            return "105:1: implicit_assignment : ( explicit_assignment | v1= implicit_variable BECOMES v2= implicit_variable -> ^( BECOMES $v1 $v2) | v3= implicit_variable BECOMES VALUE -> ^( BECOMES $v3 VALUE ) | v4= implicit_variable BECOMES STRING -> ^( BECOMES $v4 STRING ) | x1= implicit_variable BECOMES x2= explicit_variable -> ^( BECOMES $x1 $x2) | x3= explicit_variable BECOMES x4= implicit_variable -> ^( BECOMES $x3 $x4) );";
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
            return "122:1: implicit_comparison : ( explicit_comparison | ixp1= implicit_variable comparison ixp2= implicit_variable -> ^( comparison $ixp1 $ixp2) | exp3= explicit_variable comparison ixp4= implicit_variable -> ^( comparison $exp3 $ixp4) | ixp5= implicit_variable comparison exp4= explicit_variable -> ^( comparison $ixp5 $exp4) );";
        }
    }
 

    public static final BitSet FOLLOW_statements_in_program61 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_ifStatement_in_statements84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_usingStatement_in_statements88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_usingStatement108 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_usingStatement113 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_implicitIfStatement_in_usingStatement120 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_27_in_usingStatement128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_implicitIfStatement175 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_comparison_in_implicitIfStatement178 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_THEN_in_implicitIfStatement183 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_assignment_in_implicitIfStatement191 = new BitSet(new long[]{0x0000000000020320L});
    public static final BitSet FOLLOW_ELSE_in_implicitIfStatement199 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_implicit_assignment_in_implicitIfStatement205 = new BitSet(new long[]{0x0000000000020220L});
    public static final BitSet FOLLOW_ENDIF_in_implicitIfStatement212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_comparison_in_ifStatement260 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_THEN_in_ifStatement265 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_assignment_in_ifStatement273 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement281 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_assignment_in_ifStatement287 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_ENDIF_in_ifStatement294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_logical_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment426 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment428 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment454 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment456 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_explicit_assignment458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_assignment487 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_explicit_assignment489 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_explicit_assignment491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparison0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_assignment_in_implicit_assignment544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment555 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment557 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment584 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment586 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_implicit_assignment588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment620 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment622 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_implicit_assignment624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment643 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_assignment649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_assignment671 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BECOMES_in_implicit_assignment673 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_assignment677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_comparison713 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_explicit_comparison715 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_explicit_comparison720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_comparison_in_implicit_comparison744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison752 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison754 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_comparison778 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison780 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_implicit_variable_in_implicit_comparison810 = new BitSet(new long[]{0x00000007F0000000L});
    public static final BitSet FOLLOW_comparison_in_implicit_comparison812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_explicit_variable_in_implicit_comparison816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dot_operation_in_implicit_variable845 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_implicit_variable850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_explicit_variable913 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_dot_operation_in_explicit_variable915 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_explicit_variable919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_OP_in_dot_operation946 = new BitSet(new long[]{0x0000000000000002L});

}