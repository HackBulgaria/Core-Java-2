package com.hackbulgaria.corejava.oop;

public interface Stack {
    
    boolean isEmpty();
    void push(Object item);
    Object pop();
    Object peek();
    int lenght();
    void clear();    
}
