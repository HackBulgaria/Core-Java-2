package com.hackbulgaria.corejava.oop;

public class StackLinkedList {

   private DoublyLinkedListInt storage= new DoublyLinkedListInt();
   private int size=0;
    
    StackLinkedList(){
        
    }

    public boolean isEmpty() {
        if(size==0)
            return true;
        else
        return false;
    }



    
    public void push(int item) {
        storage.add(item);
        size++;
        
    }



   
    public Object pop() {
        int temp=storage.getTail();
        storage.remove();
        size--;
        return temp;
    }



  
    public Object peek() {
        return storage.getTail();
    }



    
    public int lenght() {
        return size;
    }



    
    public void clear() {
        while(!storage.isEmpty()){
            storage.remove();
            size--;
        }
        
        
        
    }

    public static void main(String[] args) {
        StackLinkedList sll=new StackLinkedList();
        System.out.println(sll.isEmpty());
        sll.push(1);
        sll.push(11);
        sll.push(13);
        sll.push(15);
        sll.push(19);
        System.out.println(sll.isEmpty());
        System.out.println(sll.lenght());
        System.out.println(sll.peek());
        System.out.println(sll.pop());
        System.out.println(sll.pop());

    }
  

}
