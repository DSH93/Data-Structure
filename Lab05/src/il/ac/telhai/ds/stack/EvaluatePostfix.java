package il.ac.telhai.ds.stack;

import java.lang.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

import static java.io.StreamTokenizer.*;

public class EvaluatePostfix {

    private static final StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));
    private static final Stack<Double> myStack = new DLinkedListStack<>();

    public static void main(String[] args) throws IOException {
        tokenizer.slashSlashComments(false);
        tokenizer.ordinaryChar('/');
        tokenizer.nextToken();
        int token = tokenizer.ttype;


        while (tokenizer.ttype != TT_EOF) {

            if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                if (tokenizer.sval.equals("quit")) break;
                else {
                    System.err.println(tokenizer);
                    System.err.println(myStack);
                    System.exit(1);
                }

            } else {
                char c = (char) tokenizer.ttype;
                if (c != '+' && c != '-' && c != '*' && c != '/') {
                    myStack.push(tokenizer.nval);
                } else {
                    double x = myStack.pop();
                    if (myStack.isEmpty()) {
                        System.err.println(tokenizer);
                        System.err.println(myStack);
                        System.exit(1);
                    }
                    double y = myStack.pop();
                    myStack.push(calc(c, x, y));
                }

            }
            tokenizer.nextToken();
        }
        if (myStack.isEmpty()) {
            System.err.println(tokenizer);
            System.err.println(myStack);
            System.exit(1);

        } else {
            double d = myStack.pop();
            if (!myStack.isEmpty()) {
                System.err.println(tokenizer);
                System.err.println(myStack);
                System.exit(1);
            }
            System.out.println(d);


        }
    }


    public static double calc(char operator, double x, double y) {
        double result = 0;
        switch (operator) {
            case '+':
                result = x + y;
                break;

            case '-':
                result = y - x;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
        }
        return result;
    }

}
