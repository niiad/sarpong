/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.queueexample;

/**
 *
 * jerry405
 */
import java.util.*;
public class QueueExample<T> implements QueueInt<T> {
    ArrayList<T> arr = new ArrayList();
    
    
 
    

    public static void main(String[] args) {
        QueueExample<String> myQueue = new QueueExample<>();
        myQueue.enqueue("Team");
        myQueue.enqueue("Jerry");
        String first = myQueue.first();
        String queueRemove = myQueue.dequeue();
        myQueue.printQueue();
    }

    @Override
    public void enqueue(T x) {
        arr.add(x);
        
    }

    @Override
    public T dequeue() {
        T x = (T) arr.get(0);
        arr.remove(0);
        return x ;
    }
    @Override
    public boolean isEmpty() {
        if (arr.isEmpty())
        return true;
        else
            return false;
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public T first() {
        T x = (T) arr.get(0);
        return x;
    }

    @Override
    public void printQueue() {
        System.out.println(arr);
    }

    

    
}
