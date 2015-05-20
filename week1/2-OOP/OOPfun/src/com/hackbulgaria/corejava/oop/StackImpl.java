package com.hackbulgaria.corejava.oop;

import java.util.ArrayList;

public class StackImpl implements Stack{
    private Object[] stack; 
    private int size;
    private ArrayList<Object> duplicates=new ArrayList<Object>();
    
   
    public StackImpl(int maxSize){
        if (maxSize <= 0)
            throw new IllegalArgumentException(
                       "Stack's capacity must be positive");
        this.stack=new Object[maxSize];
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
        return false;
    }

    @Override
    public void push(Object item) {
        if (size == stack.length)
            throw new IllegalArgumentException("Stack's underlying storage is overflow");
      
      if(!duplicates.contains(item)){
      
          duplicates.add(item);
          stack[size++] = item;  
      }
      else{
          System.out.println("This number is already in the stack!!!  Try with another number...");
      }
        
    }

    @Override
    public Object pop() {
        if(size==0){
            throw new IllegalArgumentException("Stack is empty");
        }
        
        duplicates.remove(stack[size-1]);
        Object temp = stack[size-1];
        stack[--size]=null;
       
        return temp;
    }

    @Override
    public Object peek() {
        if(size==-1){
            throw new IllegalArgumentException("Stack is empty");
        }
        
        return stack[size];
    }

    @Override
    public int lenght() {
        return size;
    }

    @Override
    public void clear() {
        for(int index= 0; index<=size;index++){
            stack[index]=null;
        }
        size=-1;
        
    }
    public static void main(String[] args){
        StackImpl steak=new StackImpl(27);
        System.out.println(steak.isEmpty());
        steak.push(1);
        steak.push(2);
        steak.push(3);
        steak.push(4);
        System.out.println(steak.lenght());
      System.out.println(steak.pop());
      System.out.println(steak.pop());
      System.out.println(steak.pop());
      System.out.println(steak.pop());
      System.out.println(steak.lenght());
      System.out.println(steak.isEmpty());
    }

}
