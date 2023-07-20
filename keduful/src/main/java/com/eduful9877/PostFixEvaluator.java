package com.eduful9877;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Kelvin Eduful
 * ID: 10889877
 */

public class PostFixEvaluator {
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';

    private Stack<Integer> stack;

    /**
     * Sets up this evaluator by creating a new stack.
     */

    public PostFixEvaluator() {
        stack = new Stack<>();
    }

    /**
     * Evaluates the specified postfix expression. If an operand is
     * encountered, it is pushed onto the stack. If an operator is
     * encountered, two operands are popped, the operation is
     * evaluated, and the result is pushed to the stack.
     * @param expr string representation of a postfix expression
     * @return value of the given expression
     */

    public int evaluate(String expr) {
        int op1, op2, result = 0;
        String token;
        Scanner parser = new Scanner(expr);

        while(parser.hasNext()) {
            token = parser.next();
            if(isOperator(token)) {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push (result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return result;
    }

    /**
     * Determines if the specified token is an operator.
     * @param token the token to be evaluated
     * @return true if token is operator
     */
    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals ("-") ||
                token.equals("*") || token.equals("/"));
    }

    /**
     * Peforms integer evaluation on a single expression consisting of
     * the specified operator and operands.
     * @param operation operation to be performed
     * @param op1 the first operand
     * @param op2 the second operand
     * @return value of the expression
     */

    private int evaluateSingleOperator(char operation, int op1, int op2) {
        int result = 0;
        switch(operation){
            case ADD -> {
                result = op1 + op2;
                break;
            }
            case SUBTRACT -> {
                result = op1 - op2;
                break;
            }
            case MULTIPLY -> {
                result = op1 * op2;
                break;
            }
            case DIVIDE -> result = op1 / op2;

        }
        return result;
    }
}
