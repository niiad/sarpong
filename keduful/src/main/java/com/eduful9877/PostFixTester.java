package com.eduful9877;

import java.util.Scanner;

public class PostFixTester {
    /**
     * Reads and evaluates multiple postfix expressions.
     */
    public static void main(String[] args) {
        String expression, again;
        int result;

        Scanner in = new Scanner(System.in);

        do {
            PostFixEvaluator evaluator = new PostFixEvaluator();
            System.out.println ("Enter a valid post-fix expression one token" +
                    "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");

            System.out.println ("Each token must be an integer or an operator (+,-,*,/)" );
            expression = in.nextLine();
            result = evaluator.evaluate(expression);
            System.out.println();
            System.out.println("That expression equals " + result);
            System.out.print("Evaluate another expression [Y/N] ");
            again = in.nextLine();
            System.out.println();
        } while(again.equalsIgnoreCase("y"));
    }
}
