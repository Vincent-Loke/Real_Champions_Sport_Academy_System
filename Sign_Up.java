package Assignment;
/***********************************************************/
/*            Developer Name:  Loke Weng Khay              */
/*                Class Name: Sign_Up.java                  */
/*           Function: Allow user to sign up               */
/***********************************************************/
public class Sign_Up extends Person 
{
    /*Function: Main Constructor*/
    Sign_Up()
    {
        AskUserInformation();
        Address address = new Address(hnumber,street, city,postalCode,state);
        new Person(getName(),getUsername(),getPassword(),"Student",getSportName(),address);
    }
}