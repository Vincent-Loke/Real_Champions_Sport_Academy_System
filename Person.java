package Assignment;
/******************************************************************/
/*            Developer Name:  Loke Weng Khay                     */
/*                Class Name: Person.java                         */
/*   Class Function: Allow Other Class to inherit its functions   */
/******************************************************************/
import java.io.*;
import java.util.*;
import java.text.*;

public class Person
{
    Scanner input = new Scanner(System.in);
    private String newName;
    private String newUsername;
    private String newPassword;
    private String sportName;
    private String dateJoin;
    private boolean vrf=false,vrf1=false,vrf2=false,sport=false;
    private Address address;
    
    private String typeOfUser;
    private int hourlyRate;
    private String SCC;
    private String SCN;
    protected String sportCode;
    private String ID;
    
    protected String hnumber;
    protected String street;
    protected String city;
    protected String state;
    protected String postalCode;
    private String PN;
    
    /*Basic Constructor */ 
    Person()
    {}
    
    /*Pre-defined Overloading Constructor */ 
    Person(String newName,String newUsername,String newPassword
            ,String typeOfUser,String sportName, Address address)
    {
        this.newName=newName;
        this.newUsername=newUsername;
        this.newPassword=newPassword;
        this.sportName=sportName;
        this.address = address;
        this.typeOfUser=typeOfUser;
        addStudent(getName(),getUsername(),getPassword(),address.toString(),"Student",
                getSportName());  
    }
    
    /*Pre-defined Overloading Constructor */ 
    Person(String newName,String dateJoin,int hourlyRate,String PN,String typeOfUser,
            Address address,String SCC,String SCN,String sportCode,String sportName)
    {
        this.newName=newName;
        this.typeOfUser=typeOfUser;
        this.address = address;
        this.dateJoin=dateJoin;
        this.hourlyRate=hourlyRate;
        this.SCC=SCC;
        this.SCN=SCN;
        this.sportName=sportName;
        this.PN=PN;
        this.sportCode=sportCode;
        addCoach(getName(),getDateJoin(),getHourlyRate(),getPN(),typeOfUser,
                address.toString(),getSCC(),getSCN(),getSportCode(),getSportName());
    }
    /*Fucntion: set data */
    public void setInformation(String newName,String newUsername,String newPassword,String typeOfUser, Address address,String dateJoin,
           int hourlyRate,String SCC,String SCN,String sportCode,String sportName,String PN)
    {
        this.newName=newName;
        this.newUsername=newUsername;
        this.newPassword=newPassword;
        this.typeOfUser=typeOfUser;
        this.address = address;
        this.dateJoin=dateJoin;
        this.hourlyRate=hourlyRate;
        this.SCC=SCC;
        this.SCN=SCN;
        this.sportName=sportName;
        this.sportCode=sportCode;
        this.PN=PN;
    }
    
    /*Fuction: Return Name*/
    public String getName()
    {
        return newName;
    }
    
    /*Fuction: Return Username*/
    public String getUsername()
    {
        return newUsername;
    }
    
    /*Fuction: Return Password*/
    public String getPassword()
    {
        return newPassword;
    }
    
    /*Fuction: Return Date Joined*/
    public String getDateJoin()
    {
        return dateJoin;
    }
    
    /*Fuction: Return Hourly Pay*/
    public int getHourlyRate()
    {
        return hourlyRate;
    }
    
    /*Fuction: Return Sport Center Code*/
    public String getSCC()
    {
        return SCC;
    }
    
    /*Fuction: Return Sport Center Name*/
    public String getSCN()
    {
        return SCN;
    }
    
    /*Fuction: Return Sport Name*/
    public String getSportName()
    {
        return sportName;
    }
    
    /*Fuction: Return Sport Code*/
    public String getSportCode()
    {
        return sportCode;
    }
    
    /*Fuction: Return Phone umber*/
    public String getPN()
    {
        return PN;
    }
    
    /*Function: to add new coach to the text file */
    public void addCoach(String name2,String dateJoin,int hourPay,String PN,String typeOfUser2,String address,String SCC,String SCN,String sportCode2, String sport)
    {
        String[] line= new String[1000];
        ID = getID(typeOfUser);
        
        try(FileWriter fw = new FileWriter(typeOfUser.concat(".txt"), true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter textFilePen = new PrintWriter(bw))
        {
            textFilePen.println("ID: " + ID);
            textFilePen.println("Name: " + name2);
            textFilePen.println("Date Join: " + dateJoin);
            textFilePen.println("Date Terminated: -");
            textFilePen.println("Hourly Rate: RM " + hourPay);
            textFilePen.println("Phone: " + PN);
            textFilePen.println("Address: " + address);
            textFilePen.println("Sport Centre Code: " + SCC);
            textFilePen.println("Sport Center Name: " + SCN);
            textFilePen.println("Sport Code: " + sportCode2);
            textFilePen.println("Sport Name: " + sport);
            textFilePen.println("Rating: 0");
            textFilePen.println("");
        }
        catch (IOException e)   
        {
            System.out.println("Error Occured");
        }
    }
    
    /*Function: to add new student to the text file */
    public void addStudent(String name2,String username2,String password2,String address,String typeOfUser, String sport)
    {
        String[] line= new String[1000];
        ID = getID(typeOfUser);
       
        try(FileWriter fw = new FileWriter(typeOfUser.concat(".txt"), true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter textFilePen = new PrintWriter(bw))
        {
            textFilePen.println("ID: " + ID);
            textFilePen.println("Name: " + name2);
            textFilePen.println("Username: " + username2);
            textFilePen.println("Password: " + password2);
            textFilePen.println("Address: " + address);
            textFilePen.println("User Access: " + typeOfUser);
            textFilePen.println("Sport Name: " + sport);
            textFilePen.println("Sport Schedule:");
            textFilePen.println("end");
            textFilePen.println("");
        }
        catch (IOException e)   
        {
            System.out.println("Error Occured");
        }
    }

    /*Function: Generate unique ID for new user*/ 
    public String getID(String typeOfID)
    {
        String[] line= new String[5];
        int count=0;
        line=readFile("ID");
        if(typeOfID.equals("Student") || typeOfID.equals("Admin") || typeOfID.equals("Coach")  )
        {
            String userId = line[0];
            String replacedString = userId.replaceAll("ID: ","");
            int i= Integer.parseInt(replacedString);
            i++;
            
            String newId = String.format("%05d",i).substring(0,5);
            
            try(FileWriter fw = new FileWriter(("ID.txt"),false);
            BufferedWriter writer = new BufferedWriter(fw);
            PrintWriter textFilePen = new PrintWriter(writer))
            {
                textFilePen.println("ID: " + newId);
                textFilePen.println(line[1]); 
            }
            catch (IOException e)   
            {
                System.out.println("Error Ooccured");
            }
            return newId;
        }
        else if(typeOfID.equals("Sport"))
        {
            String userId = line[1];
            String replacedString = userId.replaceAll("Sport ID: ","");
            int i= Integer.parseInt(replacedString);
            i++;
            
            String newId = String.format("%05d",i).substring(0,5);
            
            try(FileWriter fw = new FileWriter(("ID.txt"),false);
            BufferedWriter writer = new BufferedWriter(fw);
            PrintWriter textFilePen = new PrintWriter(writer))
            {
                
                textFilePen.println(line[0]);
                textFilePen.println("Sport ID: " + newId); 
            }
            catch (IOException e)   
            {
                System.out.println("Error Ooccured");
            }
            return (newId + "S");
        }
        else
        {
            System.out.println("Error Occured");
        } 
        return null;
    }
    public int location;
    
    /*Function: check whether the sport exist in the system*/
    public boolean checkSport(String sportName)
    {
        String[] line= new String[1000];
        int count=0;
        line=readFile("Sport");
        while(line[count] != null)
        {
            if(line[count].equals("Sport Name: " + sportName))
            {
                sportCode=line[count-1]; 
                sportCode=sportCode.replaceAll("Sport ID: ","");
                location = count-1;
                return true;
            }
            count++; 
        }
        return false; 
    }
    
    /*Function: To get information for new coaches*/
    public void CoachInformation()
    {
        boolean passwordConfirmation=false;
        System.out.println("Coach Information:\nEnter Full Name");
        newName = input.nextLine();
        
        boolean datevrf1=false;
        DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        while(datevrf1!=true)
        {
            System.out.println("Enter Join Date: dd/mm/yyyy");
            dateJoin = input.nextLine();
            datevrf1 = true;
            try 
            {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date dateJoin2 = formatter.parse(dateJoin);
                formatter.setLenient(false);
                formatter.parse(dateJoin.trim());
            } 
            catch (ParseException e) 
            {
                System.out.println("Incorrect Format/Date");
                datevrf1 = false;
            }  
        } 
        boolean pay=false;
        while(pay!=true)
        {
            
            System.out.printf("Please enter hourly pay rate\nRM ");
            hourlyRate = input.nextInt();
            if(hourlyRate<=500 && hourlyRate>0)
            {
                pay=true;
            }
            else
            {
                System.out.println("Hourly Pay Rate is between RM100 to RM500 only");
            }
        }
        input.nextLine();
        System.out.printf("Enter phone number\n");
        PN=input.nextLine();
        System.out.printf("Enter house number\nNo. ");
        hnumber=input.nextLine();
        System.out.println("Enter street");
        street=input.nextLine();
        System.out.println("Enter City");
        city=input.nextLine();
        System.out.println("Enter Postal Code");
        postalCode=input.nextLine();
        System.out.println("Enter State");
        state=input.nextLine();
        System.out.println("Enter Sport Centre Code");
        SCC=input.nextLine();
        System.out.println("Enter Sport Center Name");
        SCN=input.nextLine();
        while(sport!=true)
        {
            System.out.println("Enter Sport Name");
            sportName=input.nextLine();
            boolean sportVrf;
            sportVrf = checkSport(sportName);
            if(sportVrf == false)
            {
                System.out.println("No sport name exist");
            }
            else
            {
                sport=true;
            }
        }
      
        Address address1 = new Address(hnumber,street, city,postalCode,state);
        Person p1=new Person(getName(),getDateJoin(),getHourlyRate(),getPN(),"Coach",address1,getSCC(),getSCN(),getSportCode(),getSportName());
    }
    
    /*Function: To display all avaliable sport in the system*/
    public void displayAllSports()
    {
        String[] line;
        String[] sportNames = new String[1000];
        line=readFile("Sport");
        int count=0,count2=0;
        while(line[count]!=null)
        {
            if(line[count].length()>10)
            {
                String substr = line[count].substring(0,10);
                if(substr.equals("Sport Name"))
                {
                    sportNames[count2]=line[count].replaceAll("Sport Name: ","");
                    count2++;
                }
            }
            count++;
        }
        count2=0;
        System.out.println("All available sports");
        System.out.println("-------------------");
        System.out.println("|    Sport Name   |");
        System.out.println("-------------------");
        while(sportNames[count2]!=null)
        {
            System.out.printf("|" + sportNames[count2]);
            int spaces=sportNames[count2].length();
            int x=0;
            while(x<17-spaces)
            {
                System.out.printf(" ");
                x++;
            }
            System.out.println("|");
            System.out.println("-------------------");
            count2++;
        }
    }
    
    /*Function:: to add new student to the system*/
    public void AskUserInformation()
    {
        boolean vrf3 = false,sport1 = false;
        boolean vrf4 = false,vrf5 = false,user=false;
        boolean passwordConfirmation=false;
        System.out.println("Student Information:\nEnter Full Name");
        newName = input.nextLine();
        while(vrf5 !=true)
        {
            System.out.println("Enter Username:");
            newUsername = input.nextLine();
            vrf3 =  checkUsernameDuplication(newUsername,"Admin");
            vrf4 =  checkUsernameDuplication(newUsername,"Student");
            
            if(vrf3 == false)
            {
                System.out.println("\nUsername not available");
            }
            else if(vrf4 == false)
            {
                System.out.println("\nUsername not available");
            }
            else
            {
                vrf5=true;
            }
        }
        while(passwordConfirmation!=true)
        {
            System.out.println("Enter Password:");
            newPassword = input.nextLine();
            System.out.println("Re-Enter Password again");
            String passwordRe_enter = input.nextLine();
            if(newPassword.equals(passwordRe_enter))
            {
                passwordConfirmation=true;
            }
            else
            {
                System.out.print("Password not match\nPlease ");
            }
        }
        while(sport1!=true)
        {
            System.out.println("Enter Sport Name");
            sportName=input.nextLine();
            boolean sportVrf;
            sportVrf = checkSport(sportName);
            if(sportVrf == false)
            {
                System.out.println("No sport name exist");
            }
            else
            {
                sport1=true;
            }
        }
        System.out.printf("Enter house number\nNo. ");
        hnumber=input.nextLine();
        System.out.println("Enter street");
        street=input.nextLine();
        System.out.println("Enter City");
        city=input.nextLine();
        System.out.println("Enter Postal Code");
        postalCode=input.nextLine();
        System.out.println("Enter State");
        state=input.nextLine();
    }
    
    /*Function: To check for username duplication*/
    public boolean checkUsernameDuplication(String username,String filename)
    {
        String[] line= new String[1000];
        int count=0;
        line=readFile(filename);
        
        while(line[count] != null)
        {
            if(line[count].equals("Username: " + username))
            {
                return false;
            }
            count++; 
        }
        return true;       
    }
    
    /*Function: To read text file and store it into the memory for later use*/
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
