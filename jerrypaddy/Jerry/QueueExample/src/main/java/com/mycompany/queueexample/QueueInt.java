/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.queueexample;

/**
 *
 * @jerry405
 */
import java.util.*;
public interface QueueInt<T> {
    public void enqueue(T x);
    
    public T dequeue();
    
    public boolean isEmpty();
    
    public int size();
    
    public T first();
    
    public void printQueue();
    
    
    
}
