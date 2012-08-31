package com.dhenton9000.assign.treewalker;

// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g 2011-03-23 11:46:52

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class AssignTreeTmplWalker extends TreeParser {
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


        public AssignTreeTmplWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public AssignTreeTmplWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("AssignTreeTmplWalkerTemplates", AngleBracketTemplateLexer.class);

    public void setTemplateLib(StringTemplateGroup templateLib) {
      this.templateLib = templateLib;
    }
    public StringTemplateGroup getTemplateLib() {
      return templateLib;
    }
    /** allows convenient multi-value initialization:
     *  "new STAttrMap().put(...).put(...)"
     */
    public static class STAttrMap extends HashMap {
      public STAttrMap put(String attrName, Object value) {
        super.put(attrName, value);
        return this;
      }
      public STAttrMap put(String attrName, int value) {
        super.put(attrName, new Integer(value));
        return this;
      }
    }

    public String[] getTokenNames() { return AssignTreeTmplWalker.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g"; }


    public static class program_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "program"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:8:1: program : ^( PROGRAM (iff1+= ifStatement )+ ) -> program(p1=$iff1);
    public final AssignTreeTmplWalker.program_return program() throws RecognitionException {
        AssignTreeTmplWalker.program_return retval = new AssignTreeTmplWalker.program_return();
        retval.start = input.LT(1);

        List list_iff1=null;
        RuleReturnScope iff1 = null;
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:8:9: ( ^( PROGRAM (iff1+= ifStatement )+ ) -> program(p1=$iff1))
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:11:2: ^( PROGRAM (iff1+= ifStatement )+ )
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program36); 

            match(input, Token.DOWN, null); 
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:11:12: (iff1+= ifStatement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IF) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:11:13: iff1+= ifStatement
            	    {
            	    pushFollow(FOLLOW_ifStatement_in_program41);
            	    iff1=ifStatement();

            	    state._fsp--;

            	    if (list_iff1==null) list_iff1=new ArrayList();
            	    list_iff1.add(iff1.getTemplate());


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


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 11:35: -> program(p1=$iff1)
            {
                retval.st = templateLib.getInstanceOf("program",
              new STAttrMap().put("p1", list_iff1));
            }


            }

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

    public static class ifStatement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "ifStatement"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:15:1: ifStatement : ^( IF (con200+= consequence )+ comp200= comparison ) -> ifPrint(c1=$con200c2=$comp200.text);
    public final AssignTreeTmplWalker.ifStatement_return ifStatement() throws RecognitionException {
        AssignTreeTmplWalker.ifStatement_return retval = new AssignTreeTmplWalker.ifStatement_return();
        retval.start = input.LT(1);

        List list_con200=null;
        AssignTreeTmplWalker.comparison_return comp200 = null;

        RuleReturnScope con200 = null;
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:16:2: ( ^( IF (con200+= consequence )+ comp200= comparison ) -> ifPrint(c1=$con200c2=$comp200.text))
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:17:2: ^( IF (con200+= consequence )+ comp200= comparison )
            {
            match(input,IF,FOLLOW_IF_in_ifStatement70); 

            match(input, Token.DOWN, null); 
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:17:7: (con200+= consequence )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=TRUE && LA2_0<=FALSE)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:17:8: con200+= consequence
            	    {
            	    pushFollow(FOLLOW_consequence_in_ifStatement75);
            	    con200=consequence();

            	    state._fsp--;

            	    if (list_con200==null) list_con200=new ArrayList();
            	    list_con200.add(con200.getTemplate());


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            pushFollow(FOLLOW_comparison_in_ifStatement81);
            comp200=comparison();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 17:51: -> ifPrint(c1=$con200c2=$comp200.text)
            {
                retval.st = templateLib.getInstanceOf("ifPrint",
              new STAttrMap().put("c1", list_con200).put("c2", (comp200!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(comp200.start),
              input.getTreeAdaptor().getTokenStopIndex(comp200.start))):null)));
            }


            }

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "consequence"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:20:1: consequence : ( ^( TRUE (as1+= assignment )+ ) -> trueBranch(bt=$as1) | ^( FALSE (as2+= assignment )+ ) -> falseBranch(bf=$as2));
    public final AssignTreeTmplWalker.consequence_return consequence() throws RecognitionException {
        AssignTreeTmplWalker.consequence_return retval = new AssignTreeTmplWalker.consequence_return();
        retval.start = input.LT(1);

        List list_as1=null;
        List list_as2=null;
        RuleReturnScope as1 = null;
        RuleReturnScope as2 = null;
        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:21:2: ( ^( TRUE (as1+= assignment )+ ) -> trueBranch(bt=$as1) | ^( FALSE (as2+= assignment )+ ) -> falseBranch(bf=$as2))
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==TRUE) ) {
                alt5=1;
            }
            else if ( (LA5_0==FALSE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:22:4: ^( TRUE (as1+= assignment )+ )
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_consequence113); 

                    match(input, Token.DOWN, null); 
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:22:12: (as1+= assignment )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==BECOMES) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:22:13: as1+= assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_consequence119);
                    	    as1=assignment();

                    	    state._fsp--;

                    	    if (list_as1==null) list_as1=new ArrayList();
                    	    list_as1.add(as1.getTemplate());


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


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 22:37: -> trueBranch(bt=$as1)
                    {
                        retval.st = templateLib.getInstanceOf("trueBranch",
                      new STAttrMap().put("bt", list_as1));
                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:23:6: ^( FALSE (as2+= assignment )+ )
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_consequence144); 

                    match(input, Token.DOWN, null); 
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:23:14: (as2+= assignment )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==BECOMES) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:23:15: as2+= assignment
                    	    {
                    	    pushFollow(FOLLOW_assignment_in_consequence149);
                    	    as2=assignment();

                    	    state._fsp--;

                    	    if (list_as2==null) list_as2=new ArrayList();
                    	    list_as2.add(as2.getTemplate());


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


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 23:39: -> falseBranch(bf=$as2)
                    {
                        retval.st = templateLib.getInstanceOf("falseBranch",
                      new STAttrMap().put("bf", list_as2));
                    }


                    }
                    break;

            }
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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "assignment"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:28:1: assignment : ( ^( BECOMES vv1= var vv2= var ) -> assignment(v1=$vv1.textv2=$vv2.text) | ^( BECOMES vv3= var s100= STRING ) -> assignment(v1=$vv3.textv2=$s100) | ^( BECOMES vv4= var v100= VALUE ) -> assignment(v1=$vv4.textv2=$v100));
    public final AssignTreeTmplWalker.assignment_return assignment() throws RecognitionException {
        AssignTreeTmplWalker.assignment_return retval = new AssignTreeTmplWalker.assignment_return();
        retval.start = input.LT(1);

        Object s100=null;
        Object v100=null;
        AssignTreeTmplWalker.var_return vv1 = null;

        AssignTreeTmplWalker.var_return vv2 = null;

        AssignTreeTmplWalker.var_return vv3 = null;

        AssignTreeTmplWalker.var_return vv4 = null;


        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:29:2: ( ^( BECOMES vv1= var vv2= var ) -> assignment(v1=$vv1.textv2=$vv2.text) | ^( BECOMES vv3= var s100= STRING ) -> assignment(v1=$vv3.textv2=$s100) | ^( BECOMES vv4= var v100= VALUE ) -> assignment(v1=$vv4.textv2=$v100))
            int alt6=3;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:31:4: ^( BECOMES vv1= var vv2= var )
                    {
                    match(input,BECOMES,FOLLOW_BECOMES_in_assignment187); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_var_in_assignment191);
                    vv1=var();

                    state._fsp--;

                    pushFollow(FOLLOW_var_in_assignment195);
                    vv2=var();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 31:33: -> assignment(v1=$vv1.textv2=$vv2.text)
                    {
                        retval.st = templateLib.getInstanceOf("assignment",
                      new STAttrMap().put("v1", (vv1!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(vv1.start),
                      input.getTreeAdaptor().getTokenStopIndex(vv1.start))):null)).put("v2", (vv2!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(vv2.start),
                      input.getTreeAdaptor().getTokenStopIndex(vv2.start))):null)));
                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:32:4: ^( BECOMES vv3= var s100= STRING )
                    {
                    match(input,BECOMES,FOLLOW_BECOMES_in_assignment217); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_var_in_assignment221);
                    vv3=var();

                    state._fsp--;

                    s100=(Object)match(input,STRING,FOLLOW_STRING_in_assignment225); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 32:42: -> assignment(v1=$vv3.textv2=$s100)
                    {
                        retval.st = templateLib.getInstanceOf("assignment",
                      new STAttrMap().put("v1", (vv3!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(vv3.start),
                      input.getTreeAdaptor().getTokenStopIndex(vv3.start))):null)).put("v2", s100));
                    }


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:33:4: ^( BECOMES vv4= var v100= VALUE )
                    {
                    match(input,BECOMES,FOLLOW_BECOMES_in_assignment252); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_var_in_assignment256);
                    vv4=var();

                    state._fsp--;

                    v100=(Object)match(input,VALUE,FOLLOW_VALUE_in_assignment260); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 33:42: -> assignment(v1=$vv4.textv2=$v100)
                    {
                        retval.st = templateLib.getInstanceOf("assignment",
                      new STAttrMap().put("v1", (vv4!=null?(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(vv4.start),
                      input.getTreeAdaptor().getTokenStopIndex(vv4.start))):null)).put("v2", v100));
                    }


                    }
                    break;

            }
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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "var"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:37:1: var : ^( VAR id1= IDENT id2= IDENT ) -> var(id1=$id1id2=$id2);
    public final AssignTreeTmplWalker.var_return var() throws RecognitionException {
        AssignTreeTmplWalker.var_return retval = new AssignTreeTmplWalker.var_return();
        retval.start = input.LT(1);

        Object id1=null;
        Object id2=null;

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:37:5: ( ^( VAR id1= IDENT id2= IDENT ) -> var(id1=$id1id2=$id2))
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:38:2: ^( VAR id1= IDENT id2= IDENT )
            {
            match(input,VAR,FOLLOW_VAR_in_var297); 

            match(input, Token.DOWN, null); 
            id1=(Object)match(input,IDENT,FOLLOW_IDENT_in_var301); 
            id2=(Object)match(input,IDENT,FOLLOW_IDENT_in_var305); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 38:29: -> var(id1=$id1id2=$id2)
            {
                retval.st = templateLib.getInstanceOf("var",
              new STAttrMap().put("id1", id1).put("id2", id2));
            }


            }

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "comparison"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:42:1: comparison : ^(cc1= comparator vv3= var vv4= var ) -> comparison(var1=$vv3.textc1=$cc1.textvar2=$vv4.text);
    public final AssignTreeTmplWalker.comparison_return comparison() throws RecognitionException {
        AssignTreeTmplWalker.comparison_return retval = new AssignTreeTmplWalker.comparison_return();
        retval.start = input.LT(1);

        AssignTreeTmplWalker.comparator_return cc1 = null;

        AssignTreeTmplWalker.var_return vv3 = null;

        AssignTreeTmplWalker.var_return vv4 = null;


        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:43:2: ( ^(cc1= comparator vv3= var vv4= var ) -> comparison(var1=$vv3.textc1=$cc1.textvar2=$vv4.text))
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:45:5: ^(cc1= comparator vv3= var vv4= var )
            {
            pushFollow(FOLLOW_comparator_in_comparison342);
            cc1=comparator();

            state._fsp--;


            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_var_in_comparison346);
            vv3=var();

            state._fsp--;

            pushFollow(FOLLOW_var_in_comparison350);
            vv4=var();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 45:39: -> comparison(var1=$vv3.textc1=$cc1.textvar2=$vv4.text)
            {
                retval.st = templateLib.getInstanceOf("comparison",
              new STAttrMap().put("var1", (vv3!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(vv3.start),
              input.getTreeAdaptor().getTokenStopIndex(vv3.start))):null)).put("c1", (cc1!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(cc1.start),
              input.getTreeAdaptor().getTokenStopIndex(cc1.start))):null)).put("var2", (vv4!=null?(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(vv4.start),
              input.getTreeAdaptor().getTokenStopIndex(vv4.start))):null)));
            }


            }

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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "comparator"
    // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:48:1: comparator : ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' );
    public final AssignTreeTmplWalker.comparator_return comparator() throws RecognitionException {
        AssignTreeTmplWalker.comparator_return retval = new AssignTreeTmplWalker.comparator_return();
        retval.start = input.LT(1);

        try {
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:49:2: ( '<>' | '==' | '!=' | '>' | '>=' | '<' | '<=' )
            // C:\\Documents and Settings\\<username>\\My Documents\\Workspaces\\eclipse\\antlrAssign\\grammars\\treegrammars\\AssignTreeTmplWalker.g:
            {
            if ( (input.LA(1)>=28 && input.LA(1)<=34) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

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


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\13\uffff";
    static final String DFA6_eofS =
        "\13\uffff";
    static final String DFA6_minS =
        "\1\14\1\2\1\22\1\2\2\5\1\3\1\17\3\uffff";
    static final String DFA6_maxS =
        "\1\14\1\2\1\22\1\2\2\5\1\3\1\22\3\uffff";
    static final String DFA6_acceptS =
        "\10\uffff\1\1\1\2\1\3";
    static final String DFA6_specialS =
        "\13\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\7",
            "\1\12\1\11\1\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "28:1: assignment : ( ^( BECOMES vv1= var vv2= var ) -> assignment(v1=$vv1.textv2=$vv2.text) | ^( BECOMES vv3= var s100= STRING ) -> assignment(v1=$vv3.textv2=$s100) | ^( BECOMES vv4= var v100= VALUE ) -> assignment(v1=$vv4.textv2=$v100));";
        }
    }
 

    public static final BitSet FOLLOW_PROGRAM_in_program36 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifStatement_in_program41 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_IF_in_ifStatement70 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_consequence_in_ifStatement75 = new BitSet(new long[]{0x00000007F0006000L});
    public static final BitSet FOLLOW_comparison_in_ifStatement81 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TRUE_in_consequence113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_consequence119 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_FALSE_in_consequence144 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_in_consequence149 = new BitSet(new long[]{0x0000000000001008L});
    public static final BitSet FOLLOW_BECOMES_in_assignment187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_assignment191 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_var_in_assignment195 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BECOMES_in_assignment217 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_assignment221 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STRING_in_assignment225 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BECOMES_in_assignment252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_assignment256 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_VALUE_in_assignment260 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VAR_in_var297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_var301 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_var305 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_comparator_in_comparison342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_var_in_comparison346 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_var_in_comparison350 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_comparator0 = new BitSet(new long[]{0x0000000000000002L});

}