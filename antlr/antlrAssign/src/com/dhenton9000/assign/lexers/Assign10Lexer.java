// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g 2011-03-20 07:21:31

  package com.dhenton9000.assign.lexers;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Assign10Lexer extends Lexer {
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

    public Assign10Lexer() {;} 
    public Assign10Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Assign10Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g"; }

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:11:7: ( 'END_USING' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:11:9: 'END_USING'
            {
            match("END_USING"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:12:7: ( '<>' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:12:9: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:13:7: ( '==' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:13:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:14:7: ( '!=' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:14:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:15:7: ( '>' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:15:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:16:7: ( '>=' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:16:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:17:7: ( '<' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:17:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:18:7: ( '<=' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:18:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:76:4: ( 'IF' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:76:6: 'IF'
            {
            match("IF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:77:6: ( 'THEN' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:77:8: 'THEN'
            {
            match("THEN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "ENDIF"
    public final void mENDIF() throws RecognitionException {
        try {
            int _type = ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:78:7: ( 'ENDIF' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:78:9: 'ENDIF'
            {
            match("ENDIF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDIF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:79:6: ( 'ELSE' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:79:8: 'ELSE'
            {
            match("ELSE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:80:5: ( '&&' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:80:7: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:81:4: ( '||' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:81:6: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "BECOMES"
    public final void mBECOMES() throws RecognitionException {
        try {
            int _type = BECOMES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:83:9: ( ':=' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:83:11: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BECOMES"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:84:6: ( 'TRUE' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:84:8: 'TRUE'
            {
            match("TRUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:85:7: ( 'FALSE' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:85:9: 'FALSE'
            {
            match("FALSE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "USING"
    public final void mUSING() throws RecognitionException {
        try {
            int _type = USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:86:7: ( 'USING' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:86:9: 'USING'
            {
            match("USING"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "USING"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:174:2: ( 'VAR' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:174:4: 'VAR'
            {
            match("VAR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "IMPLICIT_VAR"
    public final void mIMPLICIT_VAR() throws RecognitionException {
        try {
            int _type = IMPLICIT_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:176:2: ( 'IMPLICIT_VAR' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:176:4: 'IMPLICIT_VAR'
            {
            match("IMPLICIT_VAR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPLICIT_VAR"

    // $ANTLR start "DOT_OP"
    public final void mDOT_OP() throws RecognitionException {
        try {
            int _type = DOT_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:180:8: ( '.' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:180:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT_OP"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:182:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='/') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='/') ) {
                    alt4=1;
                }
                else if ( (LA4_1=='*') ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:182:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:182:14: (~ ( '\\n' | '\\r' ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:182:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:182:28: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:182:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:183:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:183:14: ( options {greedy=false; } : . )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='*') ) {
                            int LA3_1 = input.LA(2);

                            if ( (LA3_1=='/') ) {
                                alt3=2;
                            }
                            else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFF')) ) {
                                alt3=1;
                            }


                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<=')')||(LA3_0>='+' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:183:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match("*/"); 

                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:186:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:186:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:194:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:194:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:194:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:194:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:194:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:197:5: ( '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:197:8: '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:197:13: ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\\') ) {
                alt6=1;
            }
            else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:197:15: ESC_SEQ
                    {
                    mESC_SEQ(); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:197:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            int _type = ESC_SEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:202:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:202:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            {
            match('\\'); 
            if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:204:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:204:19: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:205:16: ( '0' .. '9' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:205:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:206:9: ( 'PROGRAM' )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:206:12: 'PROGRAM'
            {
            match("PROGRAM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "VALUE"
    public final void mVALUE() throws RecognitionException {
        try {
            int _type = VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:209:7: ( ( DIGIT )+ )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:209:9: ( DIGIT )+
            {
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:209:9: ( DIGIT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:209:9: DIGIT
            	    {
            	    mDIGIT(); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VALUE"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:210:7: ( LETTER ( LETTER | DIGIT )* )
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:210:9: LETTER ( LETTER | DIGIT )*
            {
            mLETTER(); 
            // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:210:16: ( LETTER | DIGIT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:8: ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | IF | THEN | ENDIF | ELSE | AND | OR | BECOMES | TRUE | FALSE | USING | VAR | IMPLICIT_VAR | DOT_OP | COMMENT | WS | STRING | CHAR | ESC_SEQ | PROGRAM | VALUE | IDENT )
        int alt9=29;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:10: T__27
                {
                mT__27(); 

                }
                break;
            case 2 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:16: T__28
                {
                mT__28(); 

                }
                break;
            case 3 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:22: T__29
                {
                mT__29(); 

                }
                break;
            case 4 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:28: T__30
                {
                mT__30(); 

                }
                break;
            case 5 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:34: T__31
                {
                mT__31(); 

                }
                break;
            case 6 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:40: T__32
                {
                mT__32(); 

                }
                break;
            case 7 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:46: T__33
                {
                mT__33(); 

                }
                break;
            case 8 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:52: T__34
                {
                mT__34(); 

                }
                break;
            case 9 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:58: IF
                {
                mIF(); 

                }
                break;
            case 10 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:61: THEN
                {
                mTHEN(); 

                }
                break;
            case 11 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:66: ENDIF
                {
                mENDIF(); 

                }
                break;
            case 12 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:72: ELSE
                {
                mELSE(); 

                }
                break;
            case 13 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:77: AND
                {
                mAND(); 

                }
                break;
            case 14 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:81: OR
                {
                mOR(); 

                }
                break;
            case 15 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:84: BECOMES
                {
                mBECOMES(); 

                }
                break;
            case 16 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:92: TRUE
                {
                mTRUE(); 

                }
                break;
            case 17 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:97: FALSE
                {
                mFALSE(); 

                }
                break;
            case 18 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:103: USING
                {
                mUSING(); 

                }
                break;
            case 19 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:109: VAR
                {
                mVAR(); 

                }
                break;
            case 20 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:113: IMPLICIT_VAR
                {
                mIMPLICIT_VAR(); 

                }
                break;
            case 21 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:126: DOT_OP
                {
                mDOT_OP(); 

                }
                break;
            case 22 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:133: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 23 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:141: WS
                {
                mWS(); 

                }
                break;
            case 24 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:144: STRING
                {
                mSTRING(); 

                }
                break;
            case 25 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:151: CHAR
                {
                mCHAR(); 

                }
                break;
            case 26 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:156: ESC_SEQ
                {
                mESC_SEQ(); 

                }
                break;
            case 27 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:164: PROGRAM
                {
                mPROGRAM(); 

                }
                break;
            case 28 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:172: VALUE
                {
                mVALUE(); 

                }
                break;
            case 29 :
                // C:\\Users\\Don\\workspace\\antlrAssign\\grammars\\Assign10.g:1:178: IDENT
                {
                mIDENT(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\26\1\33\2\uffff\1\35\2\26\3\uffff\3\26\6\uffff\1\26"+
        "\2\uffff\2\26\5\uffff\1\50\11\26\1\uffff\5\26\1\70\1\26\1\uffff"+
        "\1\26\1\73\1\26\1\75\1\76\2\26\1\uffff\1\26\1\102\1\uffff\1\26\2"+
        "\uffff\1\104\1\105\1\26\1\uffff\1\26\2\uffff\2\26\1\112\1\26\2\uffff";
    static final String DFA9_eofS =
        "\114\uffff";
    static final String DFA9_minS =
        "\1\11\1\114\1\75\2\uffff\1\75\1\106\1\110\3\uffff\1\101\1\123\1"+
        "\101\6\uffff\1\122\2\uffff\1\104\1\123\5\uffff\1\60\1\120\1\105"+
        "\1\125\1\114\1\111\1\122\1\117\1\111\1\105\1\uffff\1\114\1\116\1"+
        "\105\1\123\1\116\1\60\1\107\1\uffff\1\106\1\60\1\111\2\60\1\105"+
        "\1\107\1\uffff\1\122\1\60\1\uffff\1\103\2\uffff\2\60\1\101\1\uffff"+
        "\1\111\2\uffff\1\115\1\124\1\60\1\137\2\uffff";
    static final String DFA9_maxS =
        "\1\174\1\116\1\76\2\uffff\1\75\1\115\1\122\3\uffff\1\101\1\123"+
        "\1\101\6\uffff\1\122\2\uffff\1\104\1\123\5\uffff\1\172\1\120\1\105"+
        "\1\125\1\114\1\111\1\122\1\117\1\137\1\105\1\uffff\1\114\1\116\1"+
        "\105\1\123\1\116\1\172\1\107\1\uffff\1\106\1\172\1\111\2\172\1\105"+
        "\1\107\1\uffff\1\122\1\172\1\uffff\1\103\2\uffff\2\172\1\101\1\uffff"+
        "\1\111\2\uffff\1\115\1\124\1\172\1\137\2\uffff";
    static final String DFA9_acceptS =
        "\3\uffff\1\3\1\4\3\uffff\1\15\1\16\1\17\3\uffff\1\25\1\26\1\27"+
        "\1\30\1\31\1\32\1\uffff\1\34\1\35\2\uffff\1\2\1\10\1\7\1\6\1\5\12"+
        "\uffff\1\11\7\uffff\1\1\7\uffff\1\23\2\uffff\1\14\1\uffff\1\12\1"+
        "\20\3\uffff\1\13\1\uffff\1\21\1\22\4\uffff\1\33\1\24";
    static final String DFA9_specialS =
        "\114\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\20\2\uffff\1\20\22\uffff\1\20\1\4\1\21\3\uffff\1\10\1\22"+
            "\6\uffff\1\16\1\17\12\25\1\12\1\uffff\1\2\1\3\1\5\2\uffff\4"+
            "\26\1\1\1\13\2\26\1\6\6\26\1\24\3\26\1\7\1\14\1\15\4\26\1\uffff"+
            "\1\23\4\uffff\32\26\1\uffff\1\11",
            "\1\30\1\uffff\1\27",
            "\1\32\1\31",
            "",
            "",
            "\1\34",
            "\1\36\6\uffff\1\37",
            "\1\40\11\uffff\1\41",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\45",
            "",
            "",
            "\1\46",
            "\1\47",
            "",
            "",
            "",
            "",
            "",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\61\25\uffff\1\60",
            "\1\62",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\1\71",
            "",
            "\1\72",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\1\74",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\1\77",
            "\1\100",
            "",
            "\1\101",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "",
            "\1\103",
            "",
            "",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\1\106",
            "",
            "\1\107",
            "",
            "",
            "\1\110",
            "\1\111",
            "\12\26\7\uffff\32\26\6\uffff\32\26",
            "\1\113",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | IF | THEN | ENDIF | ELSE | AND | OR | BECOMES | TRUE | FALSE | USING | VAR | IMPLICIT_VAR | DOT_OP | COMMENT | WS | STRING | CHAR | ESC_SEQ | PROGRAM | VALUE | IDENT );";
        }
    }
 

}