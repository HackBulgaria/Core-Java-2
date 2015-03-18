package com.hackbulgaria.corejava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.Thread.State;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class Utils {
    public static String reverseMe(String argument) {
        return new StringBuilder(argument).reverse().toString();
    }

    public static boolean isPalindrome(String argument) {
        return argument.equals(reverseMe(argument));
    }

    public static boolean isPalindrome(long number) {
        return isPalindrome(String.valueOf(number));
    }

    public static void killMeIfIGetStuck() {
        final Thread threadToKill = Thread.currentThread();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if (threadToKill.getState().equals(State.RUNNABLE) && "binarySearch".equals(threadToKill.getStackTrace()[0].getMethodName())) {

                        // every time you do this Barekov gets another vote!
                        threadToKill.stop();
                    }
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    

    public static Class<?> eval(Code code, String fileName) {
        File root = new File(isWindows()? "C:\\" : "/tmp/java-fun/");
        File sourceFile = new File(root, fileName + ".java");
        root.mkdirs();
        
        try {
            FileUtils.write(sourceFile, code.wrappedCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        javaCompiler.run(null, null, null, sourceFile.getPath());
        
        URLClassLoader urlClassLoader = null;
        try {
            urlClassLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        try {
            return Class.forName(fileName, true, urlClassLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static class Code {
        private String wrappedCode;

        public Code(String code){
            this.wrappedCode = "public class Eval { static { " + code + " } } "; 
        }

        @Override
        public String toString() {
            return wrappedCode + super.toString();
        }
    }
}
