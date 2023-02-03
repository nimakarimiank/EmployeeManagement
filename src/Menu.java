import Data.CRUD;
import Data.FrameWork;

public class Menu {
    private final CRUD context;
    Menu(){
        context = new CRUD();
        Initiate();
    }
    public void Initiate(){
        System.out.println("Enter Your Security Code:\n");
        //Login()
        //SignUp()

        boolean  result;
        result = checkSecurityCode();
        if (result){
            System.out.println("Access Granted!");
            //Login
            menu();

        }
        else {
            /*Exit Prompt*/

            /*Exit Prompt*/

            /*Retry*/
            System.out.println("Security code is not right\n");
            Initiate();
            /*Retry*/

        }
    }
    private boolean checkSecurityCode(){
        String tmp =FrameWork.GetInput(); //is it good or bad ? "this" I mean.
        int securityCode = 1234; // Should Get From Db
        int userSecurityCode = FrameWork.toInt(tmp);
        return securityCode == userSecurityCode;




    }

    private void menu(){
        int tmp=-1;
        /*Menu*/
        System.out.println("""
                1- Add Employee
                2- Remove Employee
                3- Edit Employee
                4- Search Employee
                5- Get Employee List
                6- EXIT""");
        while (tmp<0){
            System.out.println("Enter Prompt:");
            tmp = FrameWork.toInt(FrameWork.GetInput());
        }

        /*Menu*/
        switch (tmp){
            /*Cases*/

            case 1: {

                boolean res;
                res = context.Create();
                if (res){
                    System.out.println("Adding Employee");
                    System.out.println("Employee Added Successfully!");

                }
                else {
                    System.out.println("Adding Employee FAILED!\n Wanna Try Again?\n 1- Yes 2- No:\n");


                }
            }
            case 2: {
                boolean res;
                res = context.Delete();
                if (res){
                    System.out.println("Adding Employee");
                    System.out.println("Employee Added Successfully!");

                }
                else {
                    System.out.println("Adding Employee FAILED!\n Wanna Try Again?\n 1- Yes 2- No:\n");


                }

            }
            case 3: {
                boolean res;
                res = context.Update();
                if (res){
                    System.out.println("Adding Employee");
                    System.out.println("Employee Added Successfully!");

                }
                else {
                    System.out.println("Adding Employee FAILED!\n Wanna Try Again?\n 1- Yes 2- No:\n");


                }

            }
            case 4: {

                boolean res;
                res = context.Search();
                if (res){
                    System.out.println("Adding Employee");
                    System.out.println("Employee Added Successfully!");

                }
                else {
                    System.out.println("Adding Employee FAILED!\n Wanna Try Again?\n 1- Yes 2- No:\n");


                }

            }
            case 5: {
                boolean res;
                res = context.Read();
                if (res){
                    System.out.println("Adding Employee");
                    System.out.println("Employee Added Successfully!");

                }
                else {
                    System.out.println("Adding Employee FAILED!\n Wanna Try Again?\n 1- Yes 2- No:\n");


                }

            }
            case 6:{
                break;
            }
            default:{
                menu();
            }
            /*Cases*/

        }

    }


}
