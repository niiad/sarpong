package kobiri;
import java.util.Scanner;
import java.util.Stack;

/**
 * Represents an integer evaluator of postfix expressions. Assumes
 * the operands are constants.*
 * @author Java Foundations
 * @version 4.0
 */
public class PostfixExpression {
    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';
    private Stack<Integer> stack;
    /**
     * Sets up this evalutor by creating a new stack.
     */
    public PostfixEvaluator()
    {
        stack = new Stack<Integer>();
    }

    /**
     * Determines if the specified token is an operator.
     * @param token the token to be evaluated
     * @return true if token is operator
     */
    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/"));

    }

/**
 * Peforms integer evaluation on a single expression consisting of
 * the specified operator and operands.
 * @param operation operation to be performed
 * @param op1 the first operand
 * * @param op2 the second operand
 *  * @return value of the expression
 *  */

private int evaluateSingleOperator(char operation, int op1, int op2)
{
    int result = 0;
    switch (operation)
    {
        case ADD:
            result = op1 + op2;
            break;
        case SUBTRACT:
            result = op1 - op2;
            break;
        case MULTIPLY:
            result = op1 * op2;
            break;
        case DIVIDE:
            result = op1 / op2;
    }
    return result;
}
















    public static void main(String[] args) {
        String expression, again;
        int result;
        Scanner in = new Scanner(System.in);
        do
        {
            PostfixEvaluator evaluator = new PostfixEvaluator();
            System.out.println("Enter a valid post-fix expression one token " +
                    "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an integer or an operator (+,-,*,/)");
            expression = in.nextLine();
            result = evaluator.evaluate(expression);
            System.out.println();
            System.out.println("That expression equals " + result);
            System.out.print("Evaluate another expression [Y/N] ");
            again = in.nextLine();
            System.out.println();
        }
        while (again.equalsIgnoreCase("y"));
    }
}
