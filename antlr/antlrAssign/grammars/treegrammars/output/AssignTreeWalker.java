// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g 2011-03-23 10:31:37

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


public class AssignTreeWalker extends TreeParser {
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


        public AssignTreeWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public AssignTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return AssignTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g"; }


    public static class program_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:9:1: program : ^( PROGRAM ( statements )+ ) ;
    public final AssignTreeWalker.program_return program() throws RecognitionException {
        AssignTreeWalker.program_return retval = new AssignTreeWalker.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PROGRAM1=null;
        AssignTreeWalker.statements_return statements2 = null;


        CommonTree PROGRAM1_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:9:9: ( ^( PROGRAM ( statements )+ ) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:12:2: ^( PROGRAM ( statements )+ )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            PROGRAM1=(CommonTree)match(input,PROGRAM,FOLLOW_PROGRAM_in_program43); 
            PROGRAM1_tree = (CommonTree)adaptor.dupNode(PROGRAM1);

            root_1 = (CommonTree)adaptor.becomeRoot(PROGRAM1_tree, root_1);



            match(input, Token.DOWN, null); 
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:12:12: ( statements )+
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
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:12:14: statements
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statements_in_program47);
            	    statements2=statements();

            	    state._fsp--;

            	    adaptor.addChild(root_1, statements2.getTree());

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


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class statements_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statements"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:14:1: statements : ( ifStatement | usingStatement );
    public final AssignTreeWalker.statements_return statements() throws RecognitionException {
        AssignTreeWalker.statements_return retval = new AssignTreeWalker.statements_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AssignTreeWalker.ifStatement_return ifStatement3 = null;

        AssignTreeWalker.usingStatement_return usingStatement4 = null;



        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:15:2: ( ifStatement | usingStatement )
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
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:16:5: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statements65);
                    ifStatement3=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement3.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:16:19: usingStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_usingStatement_in_statements69);
                    usingStatement4=usingStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, usingStatement4.getTree());

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statements"

    public static class usingStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "usingStatement"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:19:1: usingStatement : ^( USING ^( IDENT ( ifStatement )+ ) ) -> ( ifStatement )+ ;
    public final AssignTreeWalker.usingStatement_return usingStatement() throws RecognitionException {
        AssignTreeWalker.usingStatement_return retval = new AssignTreeWalker.usingStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree USING5=null;
        CommonTree IDENT6=null;
        AssignTreeWalker.ifStatement_return ifStatement7 = null;


        CommonTree USING5_tree=null;
        CommonTree IDENT6_tree=null;
        RewriteRuleNodeStream stream_USING=new RewriteRuleNodeStream(adaptor,"token USING");
        RewriteRuleNodeStream stream_IDENT=new RewriteRuleNodeStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_ifStatement=new RewriteRuleSubtreeStream(adaptor,"rule ifStatement");
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:20:2: ( ^( USING ^( IDENT ( ifStatement )+ ) ) -> ( ifStatement )+ )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:21:2: ^( USING ^( IDENT ( ifStatement )+ ) )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            USING5=(CommonTree)match(input,USING,FOLLOW_USING_in_usingStatement84);  
            stream_USING.add(USING5);



            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_usingStatement87);  
            stream_IDENT.add(IDENT6);



            match(input, Token.DOWN, null); 
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:21:18: ( ifStatement )+
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
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:21:19: ifStatement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_ifStatement_in_usingStatement90);
            	    ifStatement7=ifStatement();

            	    state._fsp--;

            	    stream_ifStatement.add(ifStatement7.getTree());

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


            match(input, Token.UP, null); adaptor.addChild(root_1, root_2);_last = _save_last_2;
            }


            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }



            // AST REWRITE
            // elements: ifStatement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 21:35: -> ( ifStatement )+
            {
                if ( !(stream_ifStatement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ifStatement.hasNext() ) {
                    adaptor.addChild(root_0, stream_ifStatement.nextTree());

                }
                stream_ifStatement.reset();

            }

            retval.tree = root_0;
            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "usingStatement"

    public static class ifStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:24:1: ifStatement : ^( IF ( consequence )+ comparison ) ;
    public final AssignTreeWalker.ifStatement_return ifStatement() throws RecognitionException {
        AssignTreeWalker.ifStatement_return retval = new AssignTreeWalker.ifStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF8=null;
        AssignTreeWalker.consequence_return consequence9 = null;

        AssignTreeWalker.comparison_return comparison10 = null;


        CommonTree IF8_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:25:2: ( ^( IF ( consequence )+ comparison ) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:26:2: ^( IF ( consequence )+ comparison )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            IF8=(CommonTree)match(input,IF,FOLLOW_IF_in_ifStatement117); 
            IF8_tree = (CommonTree)adaptor.dupNode(IF8);

            root_1 = (CommonTree)adaptor.becomeRoot(IF8_tree, root_1);



            match(input, Token.DOWN, null); 
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:26:7: ( consequence )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=TRUE && LA4_0<=FALSE)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:26:8: consequence
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_consequence_in_ifStatement120);
            	    consequence9=consequence();

            	    state._fsp--;

            	    adaptor.addChild(root_1, consequence9.getTree());

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

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_comparison_in_ifStatement124);
            comparison10=comparison();

            state._fsp--;

            adaptor.addChild(root_1, comparison10.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ifStatement"

    public static class consequence_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "consequence"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:29:1: consequence : ( ^( TRUE ( assignment )+ ) | ^( FALSE ( assignment )+ ) );
    public final AssignTreeWalker.consequence_return consequence() throws RecognitionException {
        AssignTreeWalker.consequence_return retval = new AssignTreeWalker.consequence_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TRUE11=null;
        CommonTree FALSE13=null;
        AssignTreeWalker.assignment_return assignment12 = null;

        AssignTreeWalker.assignment_return assignment14 = null;


        CommonTree TRUE11_tree=null;
        CommonTree FALSE13_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:30:2: ( ^( TRUE ( assignment )+ ) | ^( FALSE ( assignment )+ ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==TRUE) ) {
                alt7=1;
            }
            else if ( (LA7_0==FALSE) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:31:3: ^( TRUE ( assignment )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    TRUE11=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_consequence142); 
                    TRUE11_tree = (CommonTree)adaptor.dupNode(TRUE11);

                    root_1 = (CommonTree)adaptor.becomeRoot(TRUE11_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:31:10: ( assignment )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==BECOMES) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:31:11: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_consequence145);
                    	    assignment12=assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, assignment12.getTree());

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


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:32:5: ^( FALSE ( assignment )+ )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    FALSE13=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_consequence156); 
                    FALSE13_tree = (CommonTree)adaptor.dupNode(FALSE13);

                    root_1 = (CommonTree)adaptor.becomeRoot(FALSE13_tree, root_1);



                    match(input, Token.DOWN, null); 
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:32:13: ( assignment )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==BECOMES) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:32:14: assignment
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_assignment_in_consequence159);
                    	    assignment14=assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_1, assignment14.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "consequence"

    public static class assignment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:38:1: assignment : ( ^( BECOMES var var ) | ^( BECOMES var STRING ) | ^( BECOMES var VALUE ) );
    public final AssignTreeWalker.assignment_return assignment() throws RecognitionException {
        AssignTreeWalker.assignment_return retval = new AssignTreeWalker.assignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BECOMES15=null;
        CommonTree BECOMES18=null;
        CommonTree STRING20=null;
        CommonTree BECOMES21=null;
        CommonTree VALUE23=null;
        AssignTreeWalker.var_return var16 = null;

        AssignTreeWalker.var_return var17 = null;

        AssignTreeWalker.var_return var19 = null;

        AssignTreeWalker.var_return var22 = null;


        CommonTree BECOMES15_tree=null;
        CommonTree BECOMES18_tree=null;
        CommonTree STRING20_tree=null;
        CommonTree BECOMES21_tree=null;
        CommonTree VALUE23_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:39:2: ( ^( BECOMES var var ) | ^( BECOMES var STRING ) | ^( BECOMES var VALUE ) )
            int alt8=3;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:40:2: ^( BECOMES var var )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BECOMES15=(CommonTree)match(input,BECOMES,FOLLOW_BECOMES_in_assignment180); 
                    BECOMES15_tree = (CommonTree)adaptor.dupNode(BECOMES15);

                    root_1 = (CommonTree)adaptor.becomeRoot(BECOMES15_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_in_assignment182);
                    var16=var();

                    state._fsp--;

                    adaptor.addChild(root_1, var16.getTree());
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_in_assignment184);
                    var17=var();

                    state._fsp--;

                    adaptor.addChild(root_1, var17.getTree());

                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:40:22: ^( BECOMES var STRING )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BECOMES18=(CommonTree)match(input,BECOMES,FOLLOW_BECOMES_in_assignment189); 
                    BECOMES18_tree = (CommonTree)adaptor.dupNode(BECOMES18);

                    root_1 = (CommonTree)adaptor.becomeRoot(BECOMES18_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_in_assignment191);
                    var19=var();

                    state._fsp--;

                    adaptor.addChild(root_1, var19.getTree());
                    _last = (CommonTree)input.LT(1);
                    STRING20=(CommonTree)match(input,STRING,FOLLOW_STRING_in_assignment193); 
                    STRING20_tree = (CommonTree)adaptor.dupNode(STRING20);

                    adaptor.addChild(root_1, STRING20_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:40:46: ^( BECOMES var VALUE )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    BECOMES21=(CommonTree)match(input,BECOMES,FOLLOW_BECOMES_in_assignment199); 
                    BECOMES21_tree = (CommonTree)adaptor.dupNode(BECOMES21);

                    root_1 = (CommonTree)adaptor.becomeRoot(BECOMES21_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_in_assignment201);
                    var22=var();

                    state._fsp--;

                    adaptor.addChild(root_1, var22.getTree());
                    _last = (CommonTree)input.LT(1);
                    VALUE23=(CommonTree)match(input,VALUE,FOLLOW_VALUE_in_assignment203); 
                    VALUE23_tree = (CommonTree)adaptor.dupNode(VALUE23);

                    adaptor.addChild(root_1, VALUE23_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class var_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:43:1: var : ( ^( VAR IDENT IDENT ) | ^( IMPLICIT_VAR id1= IDENT id2= IDENT ) -> ^( VAR $id2 $id1) );
    public final AssignTreeWalker.var_return var() throws RecognitionException {
        AssignTreeWalker.var_return retval = new AssignTreeWalker.var_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree id1=null;
        CommonTree id2=null;
        CommonTree VAR24=null;
        CommonTree IDENT25=null;
        CommonTree IDENT26=null;
        CommonTree IMPLICIT_VAR27=null;

        CommonTree id1_tree=null;
        CommonTree id2_tree=null;
        CommonTree VAR24_tree=null;
        CommonTree IDENT25_tree=null;
        CommonTree IDENT26_tree=null;
        CommonTree IMPLICIT_VAR27_tree=null;
        RewriteRuleNodeStream stream_IMPLICIT_VAR=new RewriteRuleNodeStream(adaptor,"token IMPLICIT_VAR");
        RewriteRuleNodeStream stream_IDENT=new RewriteRuleNodeStream(adaptor,"token IDENT");

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:43:5: ( ^( VAR IDENT IDENT ) | ^( IMPLICIT_VAR id1= IDENT id2= IDENT ) -> ^( VAR $id2 $id1) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==VAR) ) {
                alt9=1;
            }
            else if ( (LA9_0==IMPLICIT_VAR) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:44:2: ^( VAR IDENT IDENT )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    VAR24=(CommonTree)match(input,VAR,FOLLOW_VAR_in_var218); 
                    VAR24_tree = (CommonTree)adaptor.dupNode(VAR24);

                    root_1 = (CommonTree)adaptor.becomeRoot(VAR24_tree, root_1);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    IDENT25=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_var220); 
                    IDENT25_tree = (CommonTree)adaptor.dupNode(IDENT25);

                    adaptor.addChild(root_1, IDENT25_tree);

                    _last = (CommonTree)input.LT(1);
                    IDENT26=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_var222); 
                    IDENT26_tree = (CommonTree)adaptor.dupNode(IDENT26);

                    adaptor.addChild(root_1, IDENT26_tree);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:46:3: ^( IMPLICIT_VAR id1= IDENT id2= IDENT )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
                    IMPLICIT_VAR27=(CommonTree)match(input,IMPLICIT_VAR,FOLLOW_IMPLICIT_VAR_in_var230);  
                    stream_IMPLICIT_VAR.add(IMPLICIT_VAR27);



                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    id1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_var234);  
                    stream_IDENT.add(id1);

                    _last = (CommonTree)input.LT(1);
                    id2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_var238);  
                    stream_IDENT.add(id2);


                    match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
                    }



                    // AST REWRITE
                    // elements: id1, id2
                    // token labels: id1, id2
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleNodeStream stream_id1=new RewriteRuleNodeStream(adaptor,"token id1",id1);
                    RewriteRuleNodeStream stream_id2=new RewriteRuleNodeStream(adaptor,"token id2",id2);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 46:40: -> ^( VAR $id2 $id1)
                    {
                        // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:46:43: ^( VAR $id2 $id1)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);

                        adaptor.addChild(root_1, stream_id2.nextNode());
                        adaptor.addChild(root_1, stream_id1.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var"

    public static class comparison_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparison"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:50:1: comparison : ^( comparator var var ) ;
    public final AssignTreeWalker.comparison_return comparison() throws RecognitionException {
        AssignTreeWalker.comparison_return retval = new AssignTreeWalker.comparison_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AssignTreeWalker.comparator_return comparator28 = null;

        AssignTreeWalker.var_return var29 = null;

        AssignTreeWalker.var_return var30 = null;



        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:51:2: ( ^( comparator var var ) )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:53:5: ^( comparator var var )
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();_last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_comparator_in_comparison272);
            comparator28=comparator();

            state._fsp--;

            root_1 = (CommonTree)adaptor.becomeRoot(comparator28.getTree(), root_1);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_var_in_comparison274);
            var29=var();

            state._fsp--;

            adaptor.addChild(root_1, var29.getTree());
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_var_in_comparison276);
            var30=var();

            state._fsp--;

            adaptor.addChild(root_1, var30.getTree());

            match(input, Token.UP, null); adaptor.addChild(root_0, root_1);_last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparison"

    public static class comparator_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparator"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:56:1: comparator : ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' );
    public final AssignTreeWalker.comparator_return comparator() throws RecognitionException {
        AssignTreeWalker.comparator_return retval = new AssignTreeWalker.comparator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set31=null;

        CommonTree set31_tree=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:57:2: ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeWalker.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            _last = (CommonTree)input.LT(1);
            set31=(CommonTree)input.LT(1);
            if ( (input.LA(1)>=28 && input.LA(1)<=34) ) {
                input.consume();

                set31_tree = (CommonTree)adaptor.dupNode(set31);

                adaptor.addChild(root_0, set31_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparator"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\20\uffff";
    static final String DFA8_eofS =
        "\20\uffff";
    static final String DFA8_minS =
        "\1\14\1\2\1\22\2\2\4\5\2\3\2\17\3\uffff";
    static final String DFA8_maxS =
        "\1\14\1\2\1\23\2\2\4\5\2\3\2\23\3\uffff";
    static final String DFA8_acceptS =
        "\15\uffff\1\1\1\2\1\3";
    static final String DFA8_specialS =
        "\20\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\5",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\17\1\16\1\uffff\2\15",
            "\1\17\1\16\1\uffff\2\15",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "38:1: assignment : ( ^( BECOMES var var ) | ^( BECOMES var STRING ) | ^( BECOMES var VALUE ) );";
        }
    }
 

    public static final BitSet FOLLOW_PROGRAM_in_program43 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statements_in_program47 = new BitSet(new long[]{0x0000000000000058L});
    public static final BitSet FOLLOW_ifStatement_in_statements65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_usingStatement_in_statements69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_usingStatement84 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_usingStatement87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifStatement_in_usingStatement90 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_IF_in_ifStatement117 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_consequence_in_ifStatement120 = new BitSet(new long[]{0x00000007F0006000L});
    public static final BitSet FOLLOW_comparison_in_ifStatement124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRUE_in_consequence142 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_consequence145 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_FALSE_in_consequence156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_consequence159 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_BECOMES_in_assignment180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_assignment182 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_var_in_assignment184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BECOMES_in_assignment189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_assignment191 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_assignment193 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BECOMES_in_assignment199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_assignment201 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_assignment203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VAR_in_var218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_var220 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_var222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IMPLICIT_VAR_in_var230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_var234 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_var238 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_comparator_in_comparison272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_comparison274 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_var_in_comparison276 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_comparator0 = new BitSet(new long[]{0x0000000000000002L});

}