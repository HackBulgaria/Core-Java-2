package exceptions.example;

public class Test2 
{
    public static void throwIt () 
    {
        System.out.print("-throw it-");
        throw new RuntimeException();
    }
    public static void main(String [] args) 
    {
        try 
        {
            System.out.print("-hello-");
            throwIt();
        }
        catch (Exception re ) 
        {
            System.out.print("-caught-");
        }
        finally 
        {
            System.out.print("-finally-");
        }
        System.out.println("-after-");
    }
}
