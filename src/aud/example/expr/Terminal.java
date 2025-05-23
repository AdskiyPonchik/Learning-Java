package aud.example.expr;

import java.lang.Number;

/** Node represents a terminal {@code AtomicExpression}.<p>

    Terminals are leaves in the expression tree, i.e., numbers or
    symbols.

    @see ExpressionTree
    @see Number
    @see Symbol
 */
public abstract class Terminal extends AtomicExpression {
}
