package com.hackbulgaria.corejava.oop;



public class DoublyLinkedListInt implements DoublyLinkedLIst {
    
    private class Node {
        private int value;
        private Node next;
        private Node prev;
        
        public Node(int data){
            this.prev=null;
            this.value=data;
            this.next=null;
            
        }
        public Node(Node prev,int val, Node next){
            this.prev=prev;
            this.value=val;
            this.next=next;
            
        }
        public Object getData(){
            return this.value;
        }
    }
   
    private int size;        
    private Node head;     
    private Node tail;
    public DoublyLinkedListInt(){
        this.head=null;
        this.size=0;
    }
    

    @Override
    public void add(int item) {
        if(head==null){
            head= new Node(null,item,null);
        }
        else{
            Node current= head;
            while(current.next != null){
               current=current.next; 
            }
         Node newNode= new Node(current,item,null);
         current.next=newNode;
        }
        size++;
    }

    @Override
    public int get(int elementIndex) {
        if (head==null) return -1;
        if(elementIndex<1 && elementIndex>size) return -1;
        Node current= head;
        int i=1;
        while(i<elementIndex){
            current=current.next;
            i++;
        }
        return current.value;
    }

    @Override
    public int getHead() {
        if (head==null) return -1;
        else {
            Node current= head;
            while(current.prev!=null){
                current=current.prev;
            }
            return current.value; 
        }
       
    }

    @Override
    public int getTail() {
        if (head==null) return -1;
        
        Node current= head;
        int i=1;
        while(i<size){
            current=current.next;
            i++;
        }
        return current.value;
            
    }

    @Override
    public void remove() {
              
       if(head==null) return;
       if(head.next==null){
         head=null;
         size--;
         return;
       }
       Node current=head;
       while(current.next.next!=null){
           current=current.next;
       }
       current.next=null;
       size--;
       
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size==0;
    }
    public static void main(String[] args) {
       DoublyLinkedListInt dll= new DoublyLinkedListInt();
       dll.add(74);
       dll.add(101);
       dll.add(88);
       dll.add(103);
       
       dll.add(8);
       dll.remove();
       System.out.println(dll.size());
       System.out.println(dll.getTail());
       System.out.println(dll.getHead());
       System.out.println(dll.get(3));
       

    }
}
