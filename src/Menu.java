import Data.CRUD;
import Data.FrameWork;

public class Menu {
    private boolean LoginFlag=false;
    private CRUD context;
    Menu(){
         // Do it After Login Sends True Flag
        Initiate();
    }
    public void Initiate(){
        System.out.println("Already have an account?:\n" +
                "1- Login 2-Sign-Up\n");
        int tmp = -1;
        tmp = FrameWork.toInt(FrameWork.GetInput());
        switch (tmp){
            case 1: Login();
            case 2: SignUp();
        }


    }

    private void SignUp() {
    }

    private void Login() {
        System.out.println("Enter Your Security Code:\n");
        boolean  result;
        result = checkSecurityCode();
        if (result){
            System.out.println("Access Granted!");
            LoginFlag = true;
            if (LoginFlag){
                context = new CRUD();

            }
            //Login
            menu();

        }
        else {
            /*Exit Prompt*/
            System.out.println("do you want to sign up?\n1-yes 2-no 3-Exit");
            int tmp = FrameWork.toInt(FrameWork.GetInput());
            switch (tmp){
                case 1:{SignUp();}
                case 2:{
                    System.out.println("Security code is not right\n");
                    Initiate();}
                case 3:{
                    break;
                }
            }
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
                    4- Get Employee List
                    5- EXIT""");
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
                    menu();

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
                    menu();
                }
                else {
                    System.out.println("Adding Employee FAILED!\n Wanna Try Again?\n 1- Yes 2- No:\n");


                }

            }
            case 3: {
                boolean res;
                res = context.Update(FrameWork.toInt(FrameWork.GetInput()));
                if (res){
                    System.out.println("Adding Employee");
                    System.out.println("Employee Added Successfully!");
                    menu();
                }
                else {
                    System.out.println("Adding Employee FAILED!\n Wanna Try Again?\n 1- Yes 2- No:\n");


                }

            }

            case 4: {

                context.Read();
                menu();

            }
            case 5:{
                break;
            }
            /*Cases*/

        }

    }


}
