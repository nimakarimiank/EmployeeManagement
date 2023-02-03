import java.io.*;
import java.util.function.Function;

public class Main  {
   public static Function<Integer,String> function= (Integer x)-> Integer.toString(x);
    public static void main(String[] args)   {
//        System.out.println("Welcome to The Employee Management App\nEnter Your Security Code:\n");
//        new Menu();
        String tmp = function.apply(15);
        System.out.println(tmp);
    }


}

