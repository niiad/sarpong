package com.eduful9877;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  MazeTester determines if a maze can be traversed.
 * @author Kelvin Eduful
 * id = 10889877
 */
public class MazeTester {
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scanner.nextLine();

        Maze labyrinth = new Maze(filename);
        System.out.println(labyrinth);

        MazeSolver solver = new MazeSolver(labyrinth);

        if (solver.traverse())
            System.out.println("The maze was successfully traversed");
        else
            System.out.println("There is no possible path");
    }
}
