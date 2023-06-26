// Generated from C:/Users/leona/Desktop/LC2223/src/main/java\RegexParser.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RegexParserParser}.
 */
public interface RegexParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RegexParserParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RegexParserParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegexParserParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RegexParserParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEpsilon(RegexParserParser.EpsilonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEpsilon(RegexParserParser.EpsilonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConcat(RegexParserParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConcat(RegexParserParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(RegexParserParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(RegexParserParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Kleenestar}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterKleenestar(RegexParserParser.KleenestarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Kleenestar}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitKleenestar(RegexParserParser.KleenestarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code char}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterChar(RegexParserParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code char}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitChar(RegexParserParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Union}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnion(RegexParserParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Union}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnion(RegexParserParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kleenechar}
	 * labeled alternative in {@link RegexParserParser#kleene}.
	 * @param ctx the parse tree
	 */
	void enterKleenechar(RegexParserParser.KleenecharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kleenechar}
	 * labeled alternative in {@link RegexParserParser#kleene}.
	 * @param ctx the parse tree
	 */
	void exitKleenechar(RegexParserParser.KleenecharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kleeneparens}
	 * labeled alternative in {@link RegexParserParser#kleene}.
	 * @param ctx the parse tree
	 */
	void enterKleeneparens(RegexParserParser.KleeneparensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kleeneparens}
	 * labeled alternative in {@link RegexParserParser#kleene}.
	 * @param ctx the parse tree
	 */
	void exitKleeneparens(RegexParserParser.KleeneparensContext ctx);
	/**
	 * Enter a parse tree produced by {@link RegexParserParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(RegexParserParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegexParserParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(RegexParserParser.StringContext ctx);
}