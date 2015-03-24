package com.hackbulgaria.corejava;

public class FaultyProblem9 {

    public static String reduce_file_path(String str){
        StringBuilder new_path = new StringBuilder();
        String[] paths = str.split("/");
        
        for(int i=0;i<paths.length;i++){
            if(paths[i].equals("..")){
                if(i!=0){
                    paths[i-1] = "";
                    paths[i] = "";
                }
            }
            
            if(paths[i].equals(".") || paths[i].equals(" "))
                paths[i] = "";
        }
        
        for (String word: paths){
            if(!word.equals("")){
                new_path.append("/" + word);
            }
        }

        if(new_path.length()==0)
            return "/";

        return new_path.toString();
    }  

}
