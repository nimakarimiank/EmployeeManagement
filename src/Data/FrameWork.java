package Data;
import java.sql.*;
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
    public static String GetInput(String message)   {
        System.out.println(message);
        String result;
        try {

            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            result = buffer.readLine();

            return result;
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
    public static  class DataBaseIntegration {
        private static final String hostName = "localhost";
        private static final String portNumber = "5432";
        private static final String dataBaseName = "employee";
        private static final String url = "jdbc:postgresql://"+hostName+":"+portNumber+"/"+dataBaseName;
        public static Connection Connect(String user, String passWord) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url,user,passWord);
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;

        }

    }
}

