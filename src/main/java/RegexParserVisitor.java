// Generated from C:/Users/leona/Desktop/LC2223/src/main/java\RegexParser.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegexParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegexParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RegexParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RegexParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpsilon(RegexParserParser.EpsilonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(RegexParserParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(RegexParserParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Kleenestar}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKleenestar(RegexParserParser.KleenestarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code char}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(RegexParserParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Union}
	 * labeled alternative in {@link RegexParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(RegexParserParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code kleenechar}
	 * labeled alternative in {@link RegexParserParser#kleene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKleenechar(RegexParserParser.KleenecharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code kleeneparens}
	 * labeled alternative in {@link RegexParserParser#kleene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKleeneparens(RegexParserParser.KleeneparensContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegexParserParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(RegexParserParser.StringContext ctx);
}