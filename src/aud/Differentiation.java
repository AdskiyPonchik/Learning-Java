package aud;
import aud.*;
import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;

//-----------------------------------------------------------------//
/**Class which is able the compute the derivative of a given
 `ExpressionTree` with respect to a user specified variable.*/
public class Differentiation {
    //----------------------------------------------------------------//
    public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
       AtomicExpression expr = t.getData();
        if (expr instanceof Number) {
            return new ExpressionTree(new Number(0));
        }

        if (expr instanceof Symbol) {
            Symbol symbol = (Symbol) expr;
            return new ExpressionTree(new Number(symbol.toString().equals(var) ? 1 : 0));
        }

        if (expr instanceof Plus) {
            return new ExpressionTree(new Plus(),
                    differentiate(t.getLeft(), var),
                    differentiate(t.getRight(), var));
        }

        if (expr instanceof Minus) {
            return new ExpressionTree(new Minus(),
                    differentiate(t.getLeft(), var),
                    differentiate(t.getRight(), var));
        }

        if (expr instanceof Times) {
            // (u * v)' = u' * v + u * v'
            ExpressionTree u = (ExpressionTree) t.getLeft();
            ExpressionTree v = (ExpressionTree) t.getRight();
            ExpressionTree uPrime = differentiate(u, var);
            ExpressionTree vPrime = differentiate(v, var);

            ExpressionTree leftTerm = new ExpressionTree(new Times(), uPrime, v);
            ExpressionTree rightTerm = new ExpressionTree(new Times(), u, vPrime);
            return new ExpressionTree(new Plus(), leftTerm, rightTerm);
        }

        if (expr instanceof Divide) {
            // (u / v)' = (u' * v - u * v') / (v * v)
            ExpressionTree u = (ExpressionTree) t.getLeft();
            ExpressionTree v = (ExpressionTree) t.getRight();
            ExpressionTree uPrime = differentiate(u, var);
            ExpressionTree vPrime = differentiate(v, var);

            ExpressionTree numerator = new ExpressionTree(new Minus(),
                    new ExpressionTree(new Times(), uPrime, v),
                    new ExpressionTree(new Times(), u, vPrime));
            ExpressionTree denominator = new ExpressionTree(new Times(), v, v);
            return new ExpressionTree(new Divide(), numerator, denominator);
        }

        if (expr instanceof UnaryMinus) {
            return new ExpressionTree(new UnaryMinus(), differentiate(t.getLeft(), var), null);
        }

        throw new UnsupportedOperationException("Unsupported operator: " + expr.getClass());
    }

    //----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
        ExpressionParser parser = new ExpressionParser();
        ExpressionTree tree = parser.parse("x+x*y");
        ExpressionTree derivative = differentiate(tree, "y");
        System.out.println("Original: " + tree);
        System.out.println("Derivative: " + derivative);
    }
}