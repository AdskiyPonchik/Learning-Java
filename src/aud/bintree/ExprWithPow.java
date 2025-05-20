package aud.bintree;

import aud.example.expr.*; 
import aud.util.*;
import aud.queue.Queue;
import javax.swing.*;

//-----------------------------------------------------------------//

/**
 * ExpressionParser which is able the process `power to`.
 */

public class ExprWithPow extends ExpressionParser2 {
    // TODO: maybe overwrite some methods

    @Override
    protected ExpressionTree product(int level) {
        verbose(level, "<product>");


        Queue<ExpressionTree> expr = new Queue<ExpressionTree>();
        Queue<Integer> op = new Queue<Integer>();

        ExpressionTree tree = pow(level + 1);

        while (lookahead() == Tokenizer.TIMES || lookahead() == Tokenizer.DIVIDE) {
            op.enqueue(lookahead());
            nextToken();
            expr.enqueue(pow(level + 1));  // используем pow вместо factor
        }

        while (!op.is_empty()) {
            if (op.dequeue() == Tokenizer.TIMES)
                tree = new ExpressionTree(new Times(), tree, expr.dequeue());
            else
                tree = new ExpressionTree(new Divide(), tree, expr.dequeue());
        }

        return tree;
    }

    protected ExpressionTree pow(int level) {
        verbose(level, "<pow>");
        ExpressionTree tree = factor(level + 1);
        if (lookahead() == Tokenizer.POWER) {
            nextToken();
            ExpressionTree right = pow(level + 1);
            tree = new ExpressionTree(new Power(), tree, right);
        }

        return tree;
    }

    //----------------------------------------------------------------//
    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
        String input = (args.length > 0) ? args[0] : "3*2^(1+2)";

        ExprWithPow parser = new ExprWithPow();
        parser.setVerbose(true);

        ExpressionTree tree = parser.parse(input);

        System.out.println("Result: " + tree);
        System.out.println("Postorder: " + tree.postorder());
        System.out.println("Value: " + tree.getValue());

        JFrame frame = new JFrame("Some tree");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DotViewer viewer = new DotViewer(frame);
        viewer.display(tree.toDot());
        frame.setVisible(true);
    }
}