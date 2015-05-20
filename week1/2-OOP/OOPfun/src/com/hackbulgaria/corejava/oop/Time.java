package com.hackbulgaria.corejava.oop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Time {
    //private String currentTime;
    //private String currentDate;
    private int hour;
    private int minutes;
    private int sec;
    private int day;
    private int month;
    private int year;
    
   
    
    public int getHour() {
        return hour;
    }



    public void setHour(int hour) {
        if (hour>=0 && hour<=23){
        this.hour = hour;
        }
        else 
            throw new IllegalArgumentException("Invalid hour");
    }



    public int getMinutes() {
        return minutes;
    }



    public void setMinutes(int minutes) {
        if(minutes>=0 && minutes<=59){
        this.minutes = minutes;
        }
        else
            throw new IllegalArgumentException("Invalid minutes");
    }



    public int getSec() {
        return sec;
    }



    public void setSec(int sec) {
        if(sec>=0 && sec<=59){
            this.sec = sec;  
        }
        else 
            throw new IllegalArgumentException("Invalid sec");          
    }



    public int getDay() {
        return day;
    }



    public void setDay(int day) {
        if((year%4==0 && year%100!=0 || year%4==0 && year%100==0 && year%400!=0) && month == 2){
            if(day>0 && day<=29){
            this.day = day;
            }
            else throw new IllegalArgumentException("Fabruari has only 29 days!!");
        }
        else if((!(year%4==0 && year%100!=0 || year%4==0 && year%100==0 && year%400!=0)) && month == 2){
            if(day>0 && day<=28){
                this.day = day;
                }
                else throw new IllegalArgumentException("Fabruari has only 28 days!!");
        }
       if(month==4 || month==6 || month==9 || month==11){
        if( day>=1 && day<=30){
        this.day = day;
        }
        else
            throw new IllegalArgumentException("Invalid day");
       }
       if( day>=1 && day<=31){
           this.day = day;
           }
           else
               throw new IllegalArgumentException("Invalid day");
    }



    public int getMonth() {
        return month;
    }



    public void setMonth(int month) {
        switch (month) {
            case 1:
                this.month = month;
                break;
            case 2:
                this.month = month;
                break;
            case 3:
                this.month = month;
                break;
            case 4:
                this.month = month;
                break;
            case 5:
                this.month = month;
                break;
            case 6:
                this.month = month;
                break;
            case 7:
                this.month = month;
                break;
            case 8:
                this.month = month;
                break;
            case 9:
                this.month = month;
                break;
            case 10:
                this.month = month;
                break;
            case 11:
                this.month = month;
                break;
            case 12:
                this.month = month;
                break;

            default:
                throw new IllegalArgumentException("Invalid month");
        }
      
    }



    public int getYear() {
        return year;
    }



    public void setYear(int year) {
       
        this.year = year;
    }
    
    public Time(){
        
    }
    public Time(int hour, int min, int sec, int day, int month, int year){
       this.setHour(hour);
       this.setMinutes(min);
       this.setSec(sec);
       this.setDay(day);
       this.setMonth(month);
       this.setYear(year);
    }
    
    public String toString(){
        return this.getHour()+":"+this.getMinutes()+":"+this.getSec()+"  "+this.getDay()+"."+this.getMonth()+"."+this.getYear();
     }
    
    public static String now(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    

    public static void main(String[] args) {
        Time myTime= new Time(15,25,47,31,2,2015);
        System.out.println(myTime.toString());
        System.out.println(now());
        
    }

}
