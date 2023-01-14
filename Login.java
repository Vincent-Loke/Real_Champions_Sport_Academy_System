package Assignment;
/***********************************************************/
/*           Developer Name: Loke Weng Khay                */
/*              Class Name: Login.java                     */
/*           Function: Login class functions               */
/***********************************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Login 
{
    private static String enteredUsername;
    private static String enteredPassword;
    protected String reasonOfVisit="Login";
    boolean verification=false;
    boolean adminVrf=false;
    boolean studentVrf=false;
    int counts=0;
    boolean vrf2 = false;
    public static String name;
    protected String userAccessPosition;
    Scanner input2 = new Scanner(System.in);
    
    /************************************************/
    /* Developer Name: Loke Weng Khay               */
    /* Function: Execute all other function in order*/
    /************************************************/
    public void LoginAll()
    {
        while(vrf2 != true)
        {
            System.out.println("Enter username");
            enteredUsername = input2.nextLine();
            System.out.println("Enter password");
            enteredPassword = input2.nextLine();
            vrf2 = LoginExecution(getUsername(),getPassword());
        }
        if(userAccessPosition.equals("Admin"))
        {
            Admin admin = new Admin();
            admin.display();
        }
        else if(studentVrf == true)
        {
            RegisteredStudent student = new RegisteredStudent();
            student.display();
        }
        else
        {
               
        }
    }
    
    /* Function: To set data*/
    public void setLogin(String uname, String pwd)
    {
        this.enteredUsername=uname;
        this.enteredPassword=pwd;
    }
    
    /* Function: To return username*/
    public static String getUsername()
    {
        return enteredUsername;
    }
    
    /* Function: To return password*/
    public static String getPassword()
    {
        return enteredPassword;
    }
    

    /* Function: To validate user information*/
    public boolean LoginExecution(String username, String password)
    {
        while(verification == false)
        {
            adminVrf=credentials("Admin",username,password);
            studentVrf=credentials("Student",username,password);
            if(adminVrf==true)
            {
                verification = true;
                return true;        
            }
            else if(studentVrf == true)
            {
                verification = true;
                return true;
            }
            else
            {
                System.out.println("Incorrect Username/Password\n");
                return false;
            }
        }
        return false;
    }
    
    /* Function: To verify user information*/       
    public boolean credentials(String filename,String username1,String password1)
    {
        String[] line= new String[1000];
        int count=0;
        line=readFile(filename);
        
        while(line[count] != null)
        {
            if(line[count].equals("Username: " + getUsername()))
            {
                if(line[count+1].equals("Password: " + getPassword()))
                {
                    name = line[count-1];
                    name = name.replaceAll("Name: ","");
                    userAccessPosition = line[count+2];
                    userAccessPosition = userAccessPosition.replaceAll("User Access: ","");
                    return true;      
                }     
            }
            count++; 
        }
        return false;
    }
    
    /* Function: To read data form text file and store it in the memory for later use*/
    public String[] readFile(String filename)
    {
        String[] line=new String[1000];
        int count=0;
        try
        {
            FileReader reader = new FileReader(filename.concat(".txt"));
            BufferedReader buffer = new BufferedReader(reader);
            boolean flag=false;
            while(flag==false)
            {
                 line[count]=buffer.readLine();
                 if(line[count]==null)
                 {
                    buffer.close();
                    reader.close();
                    break;
                }
                count++;
            }
            reader.close();
        }
        catch (IOException e)
        {
            System.out.print("File not found");
        }
        return line;
    }
}
