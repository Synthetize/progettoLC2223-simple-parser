import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromString("(ab)*,a,cb,fh,da");

        RegexParserLexer lexer = new RegexParserLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        RegexParserParser parser = new RegexParserParser(tokens);

        ParseTree tree = parser.start();

        ParserBaseVisitor visitor = new ParserBaseVisitor();
        //visitor.visit(tree);
        System.out.println(visitor.visit(tree));

    }
}


