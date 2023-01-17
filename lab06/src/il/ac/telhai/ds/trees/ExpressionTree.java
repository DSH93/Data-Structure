package il.ac.telhai.ds.trees;

import java.io.IOException;
import java.io.StreamTokenizer;

public class ExpressionTree extends FullBinaryTree<String> {


    /*
     * Read the stream tokenizer until EOF and construct
     *  the expression tree corresponding to it.
     * The input contains a prefix expression.
     */

    public ExpressionTree(String key, FullBinaryTree<String> left, FullBinaryTree<String> right) {
        super(key, left, right);
    }

    public ExpressionTree(String key) {
        super(key);
    }

    public static ExpressionTree createTree(StreamTokenizer tokenizer) throws IOException {
        int c = tokenizer.nextToken();

        if (c == StreamTokenizer.TT_EOF) return null;

        if (c == StreamTokenizer.TT_NUMBER) {
            return new ExpressionTree((int) tokenizer.nval + "");
        }


        return new ExpressionTree((char) c + "", createTree(tokenizer), createTree(tokenizer));
    }

    /*
     * Returns the infix expression corresponding to the current tree (*)
     */

    public String infix() {
        return inOrder(" ", " ");
    }

    /*
     * Returns the prefix expression corresponding to the current tree (*)
     */

    public String prefix() {
        return preOrder();
    }


    /*
     * Evaluates the expression corresponding to the current tree
     * and returns its value
     */

    public double evaluate() {
        return evaluate(this);
    }

    @Override
    public String inOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder res = new StringBuilder();

        if (isLeaf()) {
            return getValue();
        }
        res.append("(");
        res.append(getLeft().inOrder(separationBeforeVal, separationAfterVal));
        res.append(separationBeforeVal);
        res.append(getValue());
        res.append(separationAfterVal);
        res.append(getRight().inOrder(separationBeforeVal, separationAfterVal));
        res.append(")");

        return res.toString();
    }

    /*
     * Evaluates the expression corresponding to the current tree
     * and returns its value
     */

    private double evaluate(BinaryTreeI<String> tree) {

        switch (tree.getValue()) {

            case "+":
                return evaluate(tree.getLeft()) + evaluate(tree.getRight());
            case "-":
                return evaluate(tree.getLeft()) - evaluate(tree.getRight());
            case "*":
                return evaluate(tree.getLeft()) * evaluate(tree.getRight());
            case "/":
                return evaluate(tree.getLeft()) / evaluate(tree.getRight());
            default:
                return Double.parseDouble(tree.getValue());
        }
    }

}