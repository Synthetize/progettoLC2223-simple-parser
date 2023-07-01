import java.util.ArrayList;

public class ParserBaseVisitor extends RegexParserBaseVisitor<NFAThompson>{
    NFAThompson nfa = new NFAThompson();


    @Override
    public NFAThompson visitStart(RegexParserParser.StartContext ctx) {
        nfa = visit(ctx.expr());
        System.out.println("Final" + nfa);
        stringValidation validator = new stringValidation(ctx.getText(), nfa);
        validator.validation();
        return nfa;
    }

    @Override
    public NFAThompson visitConcat(RegexParserParser.ConcatContext ctx) {
        //System.out.println("--------CONCAT----------");
       // System.out.println(ctx.getText());
        ArrayList <NFAThompson> thompsonGraphs = new ArrayList<>();
        //add result of each expr to thompsonGraphs
        for( RegexParserParser.ExprContext exp : ctx.expr()){
            thompsonGraphs.add(visit(exp));
        }
        //nfa.concat(thompsonGraphs);
//        System.out.println("Char/Eps Thompson Graphs");
//        for(NFAThompson graph : thompsonGraphs){
//            System.out.println(graph);
//        };
       // System.out.println("Concat Thompson Graph");
        NFAThompson concatGraph = nfa.concat(thompsonGraphs);
        System.out.println("Concat" + concatGraph);
        //System.out.println(concatGraph);
        return concatGraph;
    }

    @Override
    public NFAThompson visitUnion(RegexParserParser.UnionContext ctx) {
       // System.out.println("--------UNION----------");
        ArrayList <NFAThompson> thompsonGraphs = new ArrayList<>();
        for( RegexParserParser.ExprContext exp : ctx.expr()){
            thompsonGraphs.add(visit(exp));
        }
        NFAThompson unionThompson = nfa.union(thompsonGraphs);
        System.out.println("uNION" + unionThompson);
       // System.out.println(unionThompson);

        return unionThompson;
    }


    @Override
    public NFAThompson visitParens(RegexParserParser.ParensContext ctx) {
        NFAThompson thompsonGraphs = visit(ctx.expr());
        System.out.println("PARENTS" + thompsonGraphs);
        return thompsonGraphs;
    }

    @Override
    public NFAThompson visitKleenechar(RegexParserParser.KleenecharContext ctx) {
       // System.out.println("--------KLEENE----------");
        NFAThompson charThompson = nfa.charEpsilon(ctx.CHAR().toString());
        //System.out.println(charThompson);
        NFAThompson thompsonGraphs = nfa.kleene(charThompson);
        System.out.println("Keleene CHAR: " + thompsonGraphs);
        //System.out.println(thompsonGraphs);
        return thompsonGraphs;
    }

    @Override
    public NFAThompson visitKleeneparens(RegexParserParser.KleeneparensContext ctx) {
       // System.out.println("--------KLEENEPARENTS----------");
        NFAThompson thompsonGraphs = nfa.kleene(visit(ctx.expr()));
        //System.out.println(thompsonGraphs);
      //  System.out.println(thompsonGraphs);
        System.out.println("KleeneParents: " + thompsonGraphs);
        return thompsonGraphs;
    }

    @Override
    public NFAThompson visitChar(RegexParserParser.CharContext ctx) {
       // System.out.println("--------CHAR----------");
        NFAThompson charThompson = nfa.charEpsilon(ctx.getText());
      System.out.println("CHAR: " + charThompson);
        return charThompson;
    }




    @Override
    public NFAThompson visitEpsilon(RegexParserParser.EpsilonContext ctx) {
      //  System.out.println("--------CHAR----------");
        return nfa.charEpsilon(ctx.getText());
    }
}