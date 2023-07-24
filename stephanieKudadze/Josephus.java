package Lists;

import java.util.*;
/**
 * Demonstrates the use of an indexed list to solve the Josephus problem.
 */
public class Josephus
{

    public static void main(String[] args)
    {
        int numPeople, skip, targetIndex;
        List<String> list = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        // get the initial number of soldiers
        System.out.print("Enter the number of soldiers: ");
        numPeople = in.nextInt();
        in.nextLine();
        // get the number of soldiers to skip
        System.out.print("Enter the number of soldiers to skip: ");
        skip = in.nextInt();
        // load the initial list of soldiers
        for (int count = 1; count <= numPeople; count++) {
            list.add("Soldier " + count);
        }
        targetIndex = skip;
        System.out.println("The order is: ");
        // Treating the list as circular, remove every nth element
        // until the list is empty
        while (!list.isEmpty())
        {
            System.out.println(list.remove(targetIndex));
            if (list.size() > 0)
                targetIndex = (targetIndex + skip) % list.size();
        }
    }
}

