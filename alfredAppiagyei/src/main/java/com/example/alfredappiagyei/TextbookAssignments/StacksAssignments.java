//stacks

//Using a stack to evaluate a postfix expression
import java.util.Stack;
import java.util.Scanner
package jsjf;
import jsjf.exceptions.*;
import java.util.Arrays;



public class PostfixTester
{

    public static void main(String[] args)
    {
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


public class PostfixEvaluator
{
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

    public int evaluate(String expr)
    {
        int op1, op2, result = 0;
        String token;
        Scanner parser = new Scanner(expr);
        while (parser.hasNext())
        {
            token = parser.next();
            if (isOperator(token))
            {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(new Integer(result));
            }
            else
                stack.push(new Integer(Integer.parseInt(token)));
        }
        return result;
    }
    private boolean isOperator(String token)
    {
        return ( token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") );
    }



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
}


  //  Implementing a Stack: With Arrays
/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;
    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity)
    {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    stack = (T[]) ( new Object[initialCapacity]);
    public void push(T element)
    {
        if (size() == stack.length)
            expandCapacity();
        stack[top] = element;
        top++;
    }