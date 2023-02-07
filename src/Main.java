import Data.CRUD;
import Data.FrameWork;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main  {
    public static Function<Integer,String> function= (Integer x)-> Integer.toString(x);
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to The Employee Management App\nEnter Your Security Code:\n");
        new Menu();






    }


}

