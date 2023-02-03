package Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class FrameWork {


    public static String GetInput()   {
        String readLine;
        try {

            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            readLine = buffer.readLine();

            return readLine;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int toInt(String tmp){
        if (isNumber(tmp)){
            return Integer.parseInt(tmp);
        }
        return -200;
    }
    public static boolean isNumber(String tmp){
        try{

            if (tmp.matches("[0-9]+")) {
                //Throw Custom Exception
                return true;
            }
            else {throw new NumberFormatException();}


        }
        catch (NumberFormatException numberFormatException){
            System.out.println("There Shouldn't be any String in there");
            return false;
        }
    }
    public static boolean checkEmailRegex(String str) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (str == regexPattern) return true;
        else return false;
    }

}

