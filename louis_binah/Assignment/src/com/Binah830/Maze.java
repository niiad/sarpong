package com.Binah830.StackAssignments;
import java.util.*;
import java.io.*;
// ID - 10899830

public class Maze {
    private static final int TRIED = 2;
    private static final int PATH = 3;
    private int numberRows, numberColumns;
    private int[][] grid;
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();
        grid = new int[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++)
            for (int j = 0; j < numberColumns; j++)
                grid[i][j] = scan.nextInt();
    }
    public void tryPosition(int row, int col)
    {
        grid[row][col] = TRIED;
    }
    public int getRows()
    {
        return grid.length;
    }
    public int getColumns()
    {
        return grid[0].length;
    }
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
    }
    public boolean validPosition(int row, int column)
    {
        boolean result = false;
        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[row].length)
            //  check if cell is not blocked and not previously tried
            if (grid[row][column] == 1)
                result = true;
        return result;
    }
    public String toString()
    {
        String result = "\n";
        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }
        return result;
    }



}
