/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author User
 */
import java.util.*;
public class Sorting extends Main {
    
    

    public void selectionSortForString(ArrayList arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            // Find the minimum element in unsorted array
            int min_element = i;
            String minString = arr.get(i).toString();
            for (int j = i + 1; j < arr.size(); j++){
                if (arr.get(j).toString().compareTo(minString)<0) {
                    minString = arr.get(j).toString();
                    min_element = j;
                }
            }
            // Swap the found minimum element with the first
                if(min_element != i) {
                    String temp = arr.get(min_element).toString();
                    String temp2 = arr.get(i).toString();
                    arr.add(i, temp);
                    arr.remove(i + 1);
                    arr.add(min_element, temp2);
                    arr.remove(min_element + 1);
                }
        }
                   
                System.out.println(arr);
            
    }
    public void insertionSortForString(ArrayList arr) {
        for (int i = 0; i <= arr.size() ; i++) {
            for (int j = i + 1; j > 0;j--) {
                String temp = arr.get(j).toString();
                String temp2 = arr.get(j - 1).toString();
                arr.add(j-1, temp); 
                arr.remove(j);
                arr.add(j, temp2);
                arr.remove(j + 1);
            }
          
        }
        System.out.println(arr);
    }
    public void merge(ArrayList myArr, int left, int mid, int right){
        // sizes of the subarrays
        int sizeOne = mid - left + 1;
        int sizeTwo = right - mid;
 
        /* Create temp arrays */
        String LeftArr[] = new String[sizeOne];
        String RightArr[] = new String[sizeTwo];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < sizeOne; i++){
            LeftArr[i] = myArr.get(left + i).toString();
        }
        for (int j = 0; j < sizeTwo; j++){
            RightArr[j] = myArr.get(mid + 1 + j).toString();
        }
        int i = 0;
        int j = 0;

        int k = left;
        while (i < sizeOne && j < sizeTwo) {
            if (LeftArr[i].compareTo(RightArr[j]) < 0 || LeftArr[i].equals(RightArr[j])) {
                myArr.set(k, LeftArr[i]);
                i++;
            }
            else {
                myArr.set(k, RightArr[j]);
                j++;
            }
            k++;
        }
 
        while (i < sizeOne) {
            myArr.set(k, LeftArr[i]);
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < sizeTwo) {
            myArr.set(k, RightArr[j]);
            j++;
            k++;
        }
    }
    
    void mergesort(ArrayList arr, int left, int right){
        if (left < right) {
            int mid = left + (right - left)/2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        
    }
    public void bubbleSortForString(ArrayList arr) {
        String temp;
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < arr.size()-i-1; j++){
                if (arr.get(j).toString().compareTo((arr.get(j + 1)).toString())>0)
                {
                    temp = arr.get(j).toString();
                    String temp2 = arr.get(j + 1).toString();
                    arr.add(j + 1, temp);
                    arr.remove(j + 2);
                    arr.add(j, temp2);
                    arr.remove(j + 1);
                }
            }
        }
        System.out.println(arr);
    
    }
    public int partition(ArrayList arr, int low, int high) {
        int p =low, j;
        for(j = low + 1; j <= high; j++){
            if(arr.get(j).toString().compareTo(arr.get(low).toString()) < 0){
                swap(arr, ++p, j);
            }
        }
        swap(arr, low, p);
        return p;
    }
    public void swap(ArrayList arr, int low, int pivot){
                    String temp = arr.get(low).toString();
                    String temp2 = arr.get(pivot).toString();
                    arr.add(pivot, temp);
                    arr.remove(pivot + 1);
                    arr.add(low, temp2);
                    arr.remove(pivot);
        
    }
    public void quicksort(ArrayList arr, int low, int high){
        if (low < high) {
            int p = partition(arr, low, high);
            quicksort(arr, low, p-1);
            quicksort(arr, p+1, high);
        }
    }
}
