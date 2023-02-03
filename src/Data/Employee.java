package Data;
public class Employee {
    private int id;
    private int age;
    private boolean Gender;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String nationalId;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isGender() {
        if (Gender) {
            return "Woman";
        } else {
            return "Man";
        }
    }

    public void setGender(boolean gender) {
        this.Gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {

        return emailAddress;


    }

    public void setEmailAddress(String emailAddress) {
        if (FrameWork.checkEmailRegex(emailAddress)) {
            this.emailAddress = emailAddress;
        }
        else {
            System.out.println("Email Address is invalid!" +
                    "do you want to try again?\n 1-Yes 2-No:\n");
            int tmp = -1;
            switch (tmp) {
                case 1: {
                    tmp = FrameWork.toInt(FrameWork.GetInput());

                }
                case 2: {
                    //Temporary
                    this.emailAddress = null;
                    //Temporary
                }
            }
        }
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {

        if (FrameWork.isNumber(nationalId)) {
            this.nationalId = nationalId;
        } else {
            //Temporary
            this.nationalId = null;
            //Temporary

        }
    }


}
