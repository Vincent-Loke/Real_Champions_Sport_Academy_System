package Assignment;
/******************************************************************/
/*            Developer Name:  Loke Weng Khay                     */
/*                Class Name: Execution.java                      */
/*           Class Function: Main Execution Class                 */
/******************************************************************/

import java.util.*;
public class Execution 
{
    public static void main(String []args)
    {
        Scanner input1 = new Scanner(System.in);
        String Activity;
        boolean correctResponse = false;
       
        System.out.printf("Welcome to Real Champion Sport Academy\n\nWhat would you like to do?\n1. Login \n2. Sign up\n3. Veiw Sport\n4. Veiw Sport Schedule\n5. Exit\n\nYou selection: ");
       
        while(correctResponse != true)
        {
            Activity = input1.nextLine();
            if(Activity.equals("1") || Activity.compareToIgnoreCase("Login")==0 || Activity.compareToIgnoreCase("Log in")==0 )
            {
                System.out.println("You selected: Login\n");
                Login log = new Login();
                log.LoginAll();
                correctResponse=true;
            }
            else if (Activity.equals("2")|| Activity.compareToIgnoreCase("Sign Up")==0|| Activity.compareToIgnoreCase("Signup")==0)
            {
                System.out.println("You selected: Sign Up\n");
                new Sign_Up();
                correctResponse=true;
            }
            else if (Activity.equals("3")|| Activity.compareToIgnoreCase("View Sport")==0 || Activity.compareToIgnoreCase("Sport")==0)
            {
                System.out.println("You selected: View Sport\n");
                Person ds = new Person();
                ds.displayAllSports();
                correctResponse=true;
            }
            else if (Activity.equals("4")|| Activity.compareToIgnoreCase("View Sport Schedule")==0 || Activity.compareToIgnoreCase("Sport Schedule")==0)
            {
                System.out.println("You selected: View Sport Schedule\n");
                System.out.println("Enter the sport you would want to view the sport schedule ");
                String sport = input1.nextLine();
                Person ds = new Person();
                RegisteredStudent std = new RegisteredStudent();
                boolean ans = ds.checkSport(sport);
                if(ans==true)
                {
                    std.sportSchedule(ds.location,"Sport Name: " + sport);
                }
                else
                {
                    System.out.println("Invalid sport name");
                }
                correctResponse=true;
            }
            else if (Activity.equals("5")|| Activity.compareToIgnoreCase("Exit")==0)
            {
                System.out.println("You selected: Exit\n");
                System.exit(0);
            }
            else
            {
                System.out.println("Please enter the correct response");
            }
        }
    }
}
