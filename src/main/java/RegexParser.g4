/**
 * Define a grammar called Hello
 */
grammar RegexParser;

start:   expr (',' string)+;

expr :'(' expr ')'                  # parens
    |   kleene                      # Kleenestar
    |   expr expr                   # Concat
    |   expr '+' expr               # Union
    |   CHAR                        # char
    |   EPSILON                     # epsilon
    ;


kleene : (CHAR'*')              # kleenechar
       | '(' expr ')' '*'       # kleeneparens;


string: CHAR+;



CHAR:   [a-zA-Z0-9] ;
EPSILON :   'epsilon' ;       // match epsilon
WS  :   [ \t\n]+ -> skip ; // toss out whitespace
