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
public class Searching extends Main {
    public int binarySearchForString(ArrayList arr,String searchKey) {        
        int highest = arr.size() - 1;
        int lowest = 0;
        while(lowest <= highest) {
            int mid = (highest + lowest) / 2;
            int res = searchKey.compareTo(arr.get(mid).toString());
            if (res == 0){
                return mid;
            }
            else if (res > 0){
                lowest = mid + 1;
                
            }
            else if (res < 0){
                highest = mid - 1;
            }
        }
        return -1;
    }
    public int linearSearchForString(ArrayList arr, String searchKey) {
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i).equals(searchKey))
                return i;
        }
        return -1;
    }
}
