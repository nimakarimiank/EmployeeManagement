package Data;
import Data.Employee;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class CRUD {

    private Optional<Employee> employee;
    int Age,NationalId;
    boolean Gender;
    String FirstName,LastName,EmailAddress;
    Connection context = null;

    public boolean Create () {
        int res = 0;
        System.out.println("Enter Following Args to Add to table:\n");
        Age= Optional.of(FrameWork.toInt(FrameWork.GetInput("Age:\n"))).stream().filter(p->p>=18&&p<=100).reduce(0,Integer::sum);
        FirstName= Optional.of(FrameWork.GetInput("FirstName:\n")).stream().reduce("",(p,s)->p=s.toString());
        LastName=  Optional.of(FrameWork.GetInput("LastName:\n")).stream().reduce("",(p,s)->p=s.toString());
        Gender = Optional.of(FrameWork.toInt(FrameWork.GetInput("1 for Female 0 for Male"))).stream().map(p->p==1?true:false).reduce(false,(r,p)->{
            return r= p.booleanValue();
        });
        EmailAddress= Optional.of(FrameWork.GetInput("EmailAddress:\n")).stream().reduce("",(p,s)->p=s.toString());
        NationalId= Optional.of(FrameWork.toInt(FrameWork.GetInput("NationalId:\n"))).stream().map(p->p).reduce(0,Integer::sum);
        try {

            context = FrameWork.DataBaseIntegration.Connect("postgres", "nimakarimian76");
            Statement statement = context.createStatement();
            {
                String sql =
                        "INSERT INTO public.\"Employee\"(age,\"firstName\",\"lastName\",gender,\"emailAddress\",\"nationalId\") VALUES " +
                                "("+Age+",'"+FirstName+"','"+LastName+"',"+Gender+",'"+EmailAddress+"',"+NationalId+");";
                res=  statement.executeUpdate(sql);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (!context.isClosed()){

                    context.close();

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (res==1) return true;
        else return false;
    }

    public boolean Delete(int _nationalId){
        int res = 0;

        try {
            //opening Connection
            context = FrameWork.DataBaseIntegration.Connect("postgres", "nimakarimian76");
            Statement stm = context.createStatement();
            {
                String sql = "  DELETE FROM public.\"Employee\" WHERE nationalId="+_nationalId+";";

                res = stm.executeUpdate(sql);
            }

        }
        catch (Exception exception){}
        finally {
            try {
                if (!context.isClosed()){

                    context.close();

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (res==1) return true;
        else return false;

    }
    public boolean Delete(){
        int res = 0;
        int id = FrameWork.toInt(FrameWork.GetInput());
        try {
            //opening Connection
            context = FrameWork.DataBaseIntegration.Connect("postgres", "nimakarimian76");
            Statement stm = context.createStatement();
            {
                String sql = "  DELETE FROM public.\"Employee\" WHERE id="+id+";";

                res = stm.executeUpdate(sql);
            }

        }
        catch (Exception exception){}
        finally {
            //close Connection
        }
        return false;

    }
    public void Read (){
        ResultSet set = null;
        try {
            //opening Connection
            context = FrameWork.DataBaseIntegration.Connect("postgres", "nimakarimian76");
            Statement stm = context.createStatement();
            {
                String sql ="SELECT age, \"firstName\", \"lastName\", gender, \"emailAddress\", \"nationalId\"\n" +
                        "\tFROM public.\"Employee\";";
                set= stm.executeQuery(sql);
                while (set.next()){ System.out.println("Selected User is:\nAge="+set.getInt("age")+"\tFirstName="+set.getString("firstName") +"\tLastName="+
                        set.getString("lastName") +"\tGender="+set.getBoolean("gender") +"\tEmailAddress="+set.getString("emailAddress") +"\tNationalId="+
                        set.getInt("nationalId") +"\t");}
            }
        }
        catch (Exception exception){}
        finally {
            //close Connection
            try {
                if (!context.isClosed()){

                    context.close();

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
    public void Read (int _nationalId){
        ResultSet set = null;
        try {
            //opening Connection
            context = FrameWork.DataBaseIntegration.Connect("postgres", "nimakarimian76");
            Statement stm = context.createStatement();
            {
                String sql ="SELECT age, \"firstName\", \"lastName\", gender, \"emailAddress\", \"nationalId\"\n" +
                        "\tFROM public.\"Employee\" WHERE nationalId="+_nationalId+";";
                set= stm.executeQuery(sql);
                while (set.next()){ System.out.println("Selected User is:\nAge="+set.getInt("age")+"\tFirstName="+set.getString("firstName") +"\tLastName="+
                        set.getString("lastName") +"\tGender="+set.getBoolean("gender") +"\tEmailAddress="+set.getString("emailAddress") +"\tNationalId="+
                        set.getInt("nationalId") +"\t");}

            }
        }
        catch (Exception exception){}
        finally {
            //close Connection
            try {
                if (!context.isClosed()){

                    context.close();

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
    public boolean Update (int id){
        ResultSet set= null;
        int res = 0 ;
        System.out.println("Enter Following Args to Add to table:\n");
        Age= Optional.of(FrameWork.toInt(FrameWork.GetInput("Age:\n"))).stream().filter(p->p>=18&&p<=100).reduce(0,Integer::sum);
        FirstName= Optional.of(FrameWork.GetInput("FirstName:\n")).stream().reduce("",(p,s)->p=s.toString());
        LastName=  Optional.of(FrameWork.GetInput("LastName:\n")).stream().reduce("",(p,s)->p=s.toString());
        Gender = Optional.of(FrameWork.toInt(FrameWork.GetInput("1 for Female 0 for Male"))).stream().map(p->p==1?true:false).reduce(false,(r,p)->{
            return r= p.booleanValue();
        });
        EmailAddress= Optional.of(FrameWork.GetInput("EmailAddress:\n")).stream().reduce("",(p,s)->p=s.toString());
        NationalId= Optional.of(FrameWork.toInt(FrameWork.GetInput("NationalId:\n"))).stream().map(p->p).reduce(0,Integer::sum);

        try {
            //opening Connection
            context = FrameWork.DataBaseIntegration.Connect("postgres", "nimakarimian76");
            Statement getStatement = context.createStatement();
            {
                //Update Info
                String sql =" UPDATE public.\"Employee\" SET age="+Age+", \"firstName\"='"+FirstName+"', \"lastName\"='"+LastName+"', gender ="+Gender+"," +
                        " \"emailAddress\"='"+ EmailAddress+"', \"nationalId\"='"+NationalId+"'  WHERE id="+id+";";

                getStatement.executeUpdate(sql);

            }

        }
        catch (Exception exception){ exception.getMessage();}
        finally {
            //close Connection
            try {
                if (!context.isClosed()){

                    context.close();

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (res==1) return true;
        else return false;

    }

}
