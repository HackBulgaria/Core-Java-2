package com.hackbulgaria.corejava.oop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.ArrayList;

public class Calculator {
    public static String trimInput(String input){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) !=' '){
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
        
    }
    
    static String calculating(String workingString){
        ArrayList<String> separatedString = new ArrayList<>();
        int Position=0;
        boolean flag=false;
        String Result= "";
        
       //vrashta report za greshki
        if(flag){                                                
            return(workingString);
        }
         
        while(Position<workingString.length()){    
            while(Position<workingString.length()){                       
              //proverka za povtarqshti se operatori
                if ((workingString.charAt(Position)=='-'             
                      || workingString.charAt(Position)=='+'
                      || workingString.charAt(Position)=='*'
                      || workingString.charAt(Position)=='/')
                      &&(Position==0
                      || workingString.charAt(Position-1)=='-'
                      || workingString.charAt(Position-1)=='+'
                      || workingString.charAt(Position-1)=='*'
                      || workingString.charAt(Position-1)=='/')){
                  flag=true;return("Error: two or more operators in a row");
              }

              separatedString.add(Character.toString(workingString.charAt(Position)));
              //sazdavame spisak v koito razdelqma vhoda
              if (workingString.charAt(Position)=='('){                 
                  int Br=1;
                  String Temp="";
                  while (((Position+1)<workingString.length())){
                      switch (workingString.charAt(Position+1)){
                          case '(':Br++;break;
                          case ')':Br--;break;
                      }
                      Position++;
                      if(Br!=0){
                          Temp+=workingString.charAt(Position);
                      }
                      else {break;}

                  }
                  if(Br!=0){
                      flag=true;return("Error: missing \")\"");
                  }
                  separatedString.set(separatedString.size()-1, calculating(Temp));
              }
              //opredelqne na chislata
              else if (Character.isDigit(workingString.charAt(Position))){    
                  while (((Position+1)<workingString.length())&&(Character.isDigit(workingString.charAt(Position+1))
                          || workingString.charAt(Position+1)=='.') ){
                      separatedString.set(separatedString.size()-1,
                              separatedString.get(separatedString.size()-1)+workingString.charAt(Position+1));
                      Position++;
                  }
                  try {
                      Double.valueOf(separatedString.get(separatedString.size()-1));}
                  catch(Exception e){
                      flag=true;return("Error: multiple points");
                  }
              }
               
              //opredelqna na funkciite
              else if (Character.isAlphabetic(workingString.charAt(Position))){  
                  while (((Position+1)<workingString.length())
                          &&(Character.isAlphabetic(workingString.charAt(Position+1))) ){
                      separatedString.set(separatedString.size()-1,
                              separatedString.get(separatedString.size()-1)+workingString.charAt(Position+1));
                      Position++;
                  }
                  switch (separatedString.get(separatedString.size()-1)){
                      case "sqrt":break;
                      case "pow":break;
                      case "log":break;
                      default: {
                          flag=true;return("Error: unknown function \""+separatedString.get(separatedString.size()-1)+"\"");
                      }
                  }
                  //opredelqna na parametrite na funkciite
                  if ((Position+1)==workingString.length()||workingString.charAt(Position+1)!='(')   
                  {
                      flag=true;return("Error: missing \"(\" after "+"\""+separatedString.get(separatedString.size()-1)+"\" "+ "function");
                  }

                  ArrayList<String> Temp = new ArrayList<>();
                  int BrStack=1;
                  Temp.add("");
                  while (((Position+2)<workingString.length())){
                      switch (workingString.charAt(Position+2)){
                          case '(':BrStack++;break;
                          case ')':BrStack--;break;
                          case ',': if (BrStack==1){Temp.add("");Position++;continue;}break;
                      }
                      Position++;
                      if(BrStack!=0){Temp.set(Temp.size()-1,Temp.get(Temp.size()-1)+Character.toString(workingString.charAt(Position+1)));}
                      else {break;}
                  }
                  if(BrStack!=0){
                      flag=true;return("Error: missing \")\"");}
                  Position++;

                  double FuncArr[]=new double[Temp.size()];
                  for (int i=0;i<Temp.size();i++){

                      Temp.set(i, Calculator.calculating(Temp.get(i)));
                      if (Temp.get(i).length()==0){
                          flag=true;return("Error: missing expression");}
                      FuncArr[i]=Double.valueOf(Temp.get(i));
                  }
                  //Presmqtane na funciite
                  switch (separatedString.get(separatedString.size()-1)){     
                      case "sqrt":if (FuncArr.length==1) {
                      double a=FuncArr[0]; separatedString.set(separatedString.size()-1,Double.toString(Math.sqrt(a)));}
                      else {flag=true;return("Error: \"sqrt\" function needs only one argument");}break;
                      case "log":separatedString.set(separatedString.size()-1,Float.toString((float)Math.log(FuncArr[1]))) ;break;
                      case "pow":if (FuncArr.length==2) {
                          separatedString.set(separatedString.size()-1,Double.toString(Math.pow(FuncArr[0],FuncArr[1])));}
                      else {flag=true;return("Error: \"pow\" function needs only two arguments");}break;
                  }
              }
              Position++;
          }

          ArrayList<String> ResultArr = new ArrayList<>();

          ArrayList<String> Stack = new ArrayList<>();
          int i=0;
          //Prevrashtane na izraza v obraten polski zapis
          while (i<separatedString.size()){               
              if (separatedString.get(i).length()==1&&(separatedString.get(i).charAt(0)=='+'||
                      separatedString.get(i).charAt(0)=='-'||separatedString.get(i).charAt(0)=='/'||
                      separatedString.get(i).charAt(0)=='*')){
                  if(Stack.size()==0){
                      Stack.add(separatedString.get(i));
                  }else {
                      if ((separatedString.get(i).charAt(0) == '+' || separatedString.get(i).charAt(0) == '-') && 
                          (Stack.get(Stack.size() - 1).charAt(0) == '*' || Stack.get(Stack.size() - 1).charAt(0) == '/')) {
                          Stack.add(separatedString.get(i));
                      } else {
                          Stack.add(separatedString.get(i));
                          Stack.add(separatedString.get(i+1));
                          i++;
                          while (Stack.size() > 0) {
                              ResultArr.add(Stack.get(Stack.size()-1));
                              Stack.remove(Stack.size() - 1);
                          }
                      }
                  }
              }
              else{
                  ResultArr.add(separatedString.get(i));
              }
              i++;
          }
          while (Stack.size() > 0) {
              ResultArr.add(Stack.get(Stack.size()-1));
              Stack.remove(Stack.size() - 1);
          }
          i=0;
          //Presmqtane na obratniq polski zapis
          while (ResultArr.size()>1){       
              if (ResultArr.get(i).length()==1&&(ResultArr.get(i).charAt(0)=='+'||ResultArr.get(i).charAt(0)=='-'||ResultArr.get(i).charAt(0)=='/'||ResultArr.get(i).charAt(0)=='*')){

                  switch (ResultArr.get(i).charAt(0)){
                      case '+':ResultArr.set(i-2,Double.toString(Double.valueOf(ResultArr.get(i-2))+Double.valueOf(ResultArr.get(i-1))));ResultArr.remove(i);ResultArr.remove(i-1);break;
                      case '-':ResultArr.set(i-2,Double.toString(Double.valueOf(ResultArr.get(i-2))-Double.valueOf(ResultArr.get(i-1))));ResultArr.remove(i);ResultArr.remove(i-1);break;
                      case '*':ResultArr.set(i-2,Double.toString(Double.valueOf(ResultArr.get(i-2))*Double.valueOf(ResultArr.get(i-1))));ResultArr.remove(i);ResultArr.remove(i-1);break;
                      case '/':ResultArr.set(i-2,Double.toString(Double.valueOf(ResultArr.get(i-2))/Double.valueOf(ResultArr.get(i-1))));ResultArr.remove(i);ResultArr.remove(i-1);break;
                  }
                  i=0;
              }
              i++;
          }       
          for (String aResultArr : ResultArr) {
              Result += aResultArr;
          }

          if (Double.valueOf(Result)==Math.floor(Double.valueOf(Result))){
              Result=Integer.toString(Math.round(Float.valueOf(Result)));
          }
       }
        return Result;
      }

    public static void main(String[] args)throws Exception  {
        System.out.println("Type an expression to calculate: \n");
        while (true){
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String stringForProcessing =read.readLine(); //Input a string to work with it
            String output= Calculator.calculating(trimInput(stringForProcessing)); //Calculating
            System.out.println(output);//Output 
        }
    }
}