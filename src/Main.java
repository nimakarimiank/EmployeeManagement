import Data.CRUD;
import Data.Employee;
import Data.FrameWork;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main  {
    public static void main(String[] args)  {
        CRUD crd = new CRUD();
        List<Employee> employeeList = crd.Read();
        //sort by age
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList());
        //sort by national ID
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
        //
        for (var elem:
                employeeList) {
            System.out.println(elem.getFirstName());
        }



    }
    public static void Filter(){

    }


}

