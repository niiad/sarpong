/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main;

/**
 *
 * @author User
 
 */
import java.util.*;
public class Main {
    public ArrayList inputElements(){  //User inputs the elements of the array
        Scanner sc = new Scanner(System.in);
        ArrayList arr = new ArrayList();
        String ArrElement;    
        int i;
        String stopElement = "exit";
        System.out.println("Enter your numbers");
        
        sam: for (i = 0; ; i++){
            ArrElement = sc.nextLine();
            if (ArrElement.equals(stopElement)){
                break sam;
            }
            else{
                arr.add(i, ArrElement);
            } 
        }
        System.out.println("\n");
        System.out.println("This is your array:");
        System.out.println(arr); 
        return arr;
    }

    public static void main(String[] args) {
        String stopElement = "exit";
        String help = "help";
        Help me = new Help();
        me.printHelp();      //Program starts by printing the manual
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("To begin, we need an array!");
        System.out.println("Please, enter the elements of your array:");
        Main test = new Main();
        ArrayList var = test.inputElements();
        System.out.println("\n");
        System.out.println("Please, what do you want to do?");
        System.out.println("Do you want to search or sort?");
        System.out.println("Please, select an option:");
        System.out.println("\n");
        System.out.println("Press \"1\" if you want to search for an element in your array");
        System.out.println("Press \"2\" if you want to sort the elements in your array");
        Scanner firstChoice = new Scanner(System.in);
        String first_Choice = firstChoice.next();
        String option1 = "1";
        String option2 = "2";
        if (first_Choice.equals(option1)){
            System.out.println("\n");
            System.out.println("What searching algorithm do you want to use?");
            System.out.println("Please, select an option:");
            System.out.println("\n");
            System.out.println("Press \"1\" to select Binary Search");
            System.out.println("Press \"2\" to select Linear Search");
            String second_Choice = firstChoice.next();
            if (second_Choice.equals(option1)){
                System.out.println("\n");
                Searching search = new Searching();
                System.out.println("Please, enter your search key element");
                Scanner scanner = new Scanner(System.in);
                String key = scanner.next();
                int index = search.binarySearchForString(var , key);
                System.out.println("\n");
                if (index == -1){
                    System.out.println("Element cannot be found");
                }
                else{
                    System.out.println("Element can be found at index " + index );
                
                }
            
            }
            else if (second_Choice.equals(stopElement)){
                System.out.println("\n");
                System.out.println("Press \"1\" if you want search for an element in your array");
                System.out.println("Press \"2\" if you want to sort the elements in your array");
            }
            else if (second_Choice.equals(option2)){
                System.out.println("Please, enter your search key element");
                Scanner scanner = new Scanner(System.in);
                Searching search2 = new Searching();
                String key_1 = scanner.next();
                int index1 = search2.linearSearchForString(var , key_1);
                System.out.println("\n");
                if (index1 == -1){
                    System.out.println("Element cannot be found");
                }
                else{
                    System.out.println("Element can be found at index " + index1 );
                
                }
            }
            else if (second_Choice.equals(help)){
                me.printHelp();
            }
        
        }
        else if (first_Choice.equals(option2)){
            System.out.println("What sorting algorithm do you want to use?");
            System.out.println("Please, select an option:");
            System.out.println("1: Selection Sort");
            System.out.println("2: Insertion Sort");
            System.out.println("3: Bubble Sort");
            System.out.println("4: Quick Sort");
            System.out.println("5: Merge Sort");
            String one = "1";
            String two = "2";
            String three = "3";
            String four = "4";
            String five = "5";
            Scanner secondChoice = new Scanner(System.in); 
            String second_Choice1 = secondChoice.next();
            if (second_Choice1.equals(one)){
               System.out.println("\n");
               System.out.println("Performing Selection Sort..............");
               System.out.println("\n");
               Sorting selection = new Sorting();
               selection.selectionSortForString(var);
            }
            else if (second_Choice1.equals(two)){
               System.out.println("\n");
               Sorting insertion = new Sorting();
               insertion.insertionSortForString(var);
            }
            else if (second_Choice1.equals(five)){
                System.out.println("\n");
                Sorting merge_Sort = new Sorting();
                merge_Sort.mergesort(var, 0, var.size() - 1);
                System.out.println(var);
            }
            else if (second_Choice1.equals(three)){
                System.out.println("\n");
                Sorting bubble_Sort = new Sorting();
                bubble_Sort.bubbleSortForString(var);
            }
            else if (second_Choice1.equals(four)){
                System.out.println("\n");
                Sorting quick_sort = new Sorting(); 
                quick_sort.quicksort(var, 0, var.size() - 1);
                System.out.println(var);
            }
        }
    }
}
