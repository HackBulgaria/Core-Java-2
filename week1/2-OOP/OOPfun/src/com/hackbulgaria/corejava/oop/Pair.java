package com.hackbulgaria.corejava.oop;

public final class Pair {
    
    private final Object objOne=null;
    private final Object objTwo=null;
    
    

    public Object getObjOne() {
        return objOne;
    }



    public Object getObjTwo() {
        return objTwo;
    }

    public String toString(){
        return objOne+"  "+objTwo+"are our pair of objects!";
    }
    
    
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this.getObjOne().equals(((Pair) obj).getObjOne()) && this.getObjTwo().equals(((Pair) obj).getObjTwo()))
            return true;
        else 
            return false;
       
    }


    public static void main(String[] args) {


    }

}
