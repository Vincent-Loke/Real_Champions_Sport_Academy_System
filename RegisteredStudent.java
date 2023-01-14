
package Assignment;
/******************************************************************/
/*            Developer Name:  Loke Weng Khay                     */
/*            Class Name: RegisteredStudent.java                  */
/*Class Function: Allow Registered Student to manage their account*/
/******************************************************************/

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;


public class RegisteredStudent extends Admin
{
    Login log4 = new Login();
    Scanner input5= new Scanner(System.in);
    public static int count2=0;
    public String sportName;
    @Override
    
    /*Function: to display all options for the registered student*/
    public void display()
    {
        boolean crtinput  = false;
        String userAction;
        if(count2==0)
        {
            System.out.println("\nWelcome, " + log4.name);
        }
        System.out.println("\nWhat would you like to do today?");
        System.out.println("1. View Coach");
        System.out.println("2. View Self-Record");
        System.out.println("3. View Sport Schedule");
        System.out.println("4. Add Sport Schedule");
        System.out.println("5. Rate and Comment Coach");
        System.out.printf("6. Exit\nYour Selection: ");
        String studentInput = input5.nextLine();
        System.out.println();
        while(crtinput!=true)
        {
            if(studentInput.equals("1") || studentInput.compareToIgnoreCase("View Coach")==0 || studentInput.compareToIgnoreCase("Coach")==0)
            {
                int location=getLocation();
                viewCoach();
                crtinput=true;
                count2++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("\nWould you like to continue to use the system?(Yes/No)");
                    String toContinue=input5.nextLine();
                    if(toContinue.compareToIgnoreCase("Yes")==0)
                    {
                        display();
                    }
                    else if(toContinue.compareToIgnoreCase("No")==0)
                    {
                        System.exit(0);
                    }   
                    else
                    {
                        System.out.println("Invalid input");
                    }
                }
            }
            else if(studentInput.equals("2") || studentInput.compareToIgnoreCase("View Self-Record")==0 || studentInput.compareToIgnoreCase("View Self Record")==0)
            {
                int location=getLocation();
                displaySportschedule("Student",location);
                crtinput=true;
                count2++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("\nWould you like to continue to use the system?(Yes/No)");
                    String toContinue=input5.nextLine();
                    if(toContinue.compareToIgnoreCase("Yes")==0)
                    {
                        display();
                    }
                    else if(toContinue.compareToIgnoreCase("No")==0)
                    {
                        System.exit(0);
                    }   
                    else
                    {
                        System.out.println("Invalid input");
                    }
                }
            }
            else if(studentInput.equals("3") || studentInput.compareToIgnoreCase("View Sport Schedule")==0 || studentInput.compareToIgnoreCase("Sport Schedule")==0)
            {
                int location=getLocation();
                sportSchedule(location,sportName);
                crtinput=true;
                count2++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("\nWould you like to continue to use the system?(Yes/No)");
                    String toContinue=input5.nextLine();
                    if(toContinue.compareToIgnoreCase("Yes")==0)
                    {
                        display();
                    }
                    else if(toContinue.compareToIgnoreCase("No")==0)
                    {
                        System.exit(0);
                    }   
                    else
                    {
                        System.out.println("Invalid input");
                    }
                }
            }
            else if(studentInput.equals("4") || studentInput.compareToIgnoreCase("Add Sport Schedule")==0 || studentInput.compareToIgnoreCase("Add Sport Schedule")==0)
            {
                addStudentSportSchedule();
                crtinput=true;
                count2++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("\nWould you like to continue to use the system?(Yes/No)");
                    String toContinue=input5.nextLine();
                    if(toContinue.compareToIgnoreCase("Yes")==0)
                    {
                        display();
                    }
                    else if(toContinue.compareToIgnoreCase("No")==0)
                    {
                        System.exit(0);
                    }   
                    else
                    {
                        System.out.println("Invalid input");
                    }
                }
            }
            else if(studentInput.equals("5") || studentInput.compareToIgnoreCase("Rate and Comment Coach")==0 || studentInput.compareToIgnoreCase("Rate Coach")==0|| studentInput.compareToIgnoreCase("Comment Coach")==0|| studentInput.compareToIgnoreCase("Rate")==0)
            {
                int location=getLocation();
                rateCoach();
                crtinput=true;
                count2++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("\nWould you like to continue to use the system?(Yes/No)");
                    String toContinue=input5.nextLine();
                    if(toContinue.compareToIgnoreCase("Yes")==0)
                    {
                        display();
                    }
                    else if(toContinue.compareToIgnoreCase("No")==0)
                    {
                        System.exit(0);
                    }   
                    else
                    {
                        System.out.println("Invalid input");
                    }
                }
            }
            else if(studentInput.equals("6") || studentInput.compareToIgnoreCase("Exit")==0)
            {
                crtinput=true;
                System.exit(0);
            }
            else
            {
                System.out.println("Wrong input\nEnter again: ");
                studentInput=input5.nextLine();
            }  
        } 
    }
    
    /*Function:View all coaches that teaches based on students sport */
    public void viewCoach()
    {
        String[] line;
        int count=0;
        line=readFile("Coach");
        int count3=0;
        String[] ID = new String[1000];
        String[] names = new String[1000];
        
        
        while(line[count]!=null)
        {
            if(line[count].equals(sportName))
            {
                ID[count3]=line[count-10].replaceAll("ID: ","");
                names[count3]=line[count-9].replaceAll("Name: ","");
                count3++;
            }     
            count++;
        }
        System.out.println("                   Coaches");
        System.out.println("-------------------------------------------------");
        System.out.println("| ID  |         Name             |  Sport Name  |");
        System.out.println("-------------------------------------------------");
        count=0;
        
        while(names[count]!=null)
        {
            
            System.out.printf("|" + ID[count] + "|" + names[count] );
            int spaces=names[count].length();
            int x=0;
            while(x<26-spaces)
            {
                System.out.printf(" ");
                x++;
            }
            System.out.printf("|");
            sportName=sportName.replaceAll("Sport Name: ","");
            System.out.printf(sportName);
            int y=0;
            int spaces2=sportName.length();
            while(y<14-spaces2)
            {
                System.out.printf(" ");
                y++;
            }
            System.out.println("|");
            System.out.println("-------------------------------------------------");
            count++;
        }
    }
    
    /*Function: get location of the data in the text file*/
    public int getLocation()
    {
        String[] line;
        int count=0;
        line=readFile("Student");
        while(line[count]!=null)
        {
            if(line[count].equals("Name: " + log4.name))
            {
                sportName=line[count+5];
                return count-1;
            }
            count++;
        }
        return -1;
    }
    
    /*Function: View student sport schedule*/ 
    public void sportSchedule(int location,String sportName2)
    {
        String[] line;
        int count=0;
        line=readFile("Sport");
        System.out.println();
        while(line[count]!=null)
        {
            if(line[count].equals(sportName2))
            {
                int count2=count;
                if(line[count2+2].equals("end"))
                {
                    System.out.println("No record found");
                    break;
                }
                while(!"end".equals(line[count2]))
                {
                    System.out.println(line[count2]);
                    count2++;
                }
            }
            count++;
        }
    }
    
    /*Function: Allow student to rate coaches based on sport selected by student*/
    public void rateCoach()
    {
        String[] line;
        int count=0;
        line=readFile("Coach");
        int count3=0;
        String[] ID = new String[1000];
        String[] names = new String[1000];
        
        
        
        while(line[count]!=null)
        {
            if(line[count].equals(sportName))
            {
                ID[count3]=line[count-10].replaceAll("ID: ","");
                names[count3]=line[count-9].replaceAll("Name: ","");
                count3++;
            }     
            count++;
        }
        System.out.println("                   Coach Rating                  ");
        System.out.println("-------------------------------------------------");
        System.out.println("| ID  |         Name             |  Sport Name  |");
        System.out.println("-------------------------------------------------");
        count=0;
        
        while(names[count]!=null)
        {
            
            System.out.printf("|" + ID[count] + "|" + names[count] );
            int spaces=names[count].length();
            int x=0;
            while(x<26-spaces)
            {
                System.out.printf(" ");
                x++;
            }
            System.out.printf("|");
            sportName=sportName.replaceAll("Sport Name: ","");
            System.out.printf(sportName);
            int y=0;
            int spaces2=sportName.length();
            while(y<14-spaces2)
            {
                System.out.printf(" ");
                y++;
            }
            System.out.println("|");
            System.out.println("-------------------------------------------------");
            count++;
        }
       
        System.out.println("\nEnter coach full name to rate:");
        String rate = input.nextLine();
        int i=0;
        boolean answered=false;
        String coachName;
        while(answered!=true)
        {
            while(names[i]!=null)
            {
                if(rate.compareToIgnoreCase(names[i])==0)
                {
                    String id2=ID[i];
                    coachName=names[i];
                    boolean crtRating=false;
                    System.out.println("Please enter rating: (0-5)");
                    int rating = input.nextInt();
                    while(crtRating!=true)
                    {
                       
                        if(rating>0 && rating<6)
                        {
                            crtRating=true;
                        }
                        else
                        {
                            System.out.println("Enter an appropriate rating");
                            rating = input.nextInt();
                        }
                    }
                    input.nextLine();
                    System.out.println("Any Comments");
                    String comments = input.nextLine();
                    answered=true;
                    try 
                    {
                        FileWriter myWriter = new FileWriter("Rating.txt",true);
                        
                            myWriter.write("ID: " + id2);
                            myWriter.write('\n');
                            myWriter.write("Name: " + coachName);
                            myWriter.write('\n');
                            myWriter.write("Rating: " + rating);
                            myWriter.write('\n');
                            myWriter.write("Comments: " + comments);
                            myWriter.write('\n');
                            myWriter.write('\n');
                            
                        
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    }    
                    catch(IOException e)
                    {
                        System.out.println("An error occurred.");
                    }
                    String[] line2;
                    line2=readFile("Rating");
                    int totalRating=0,rating3;
                    String rating2;
                    count=0;
                    int numOfRating=0;
                    while(line2[count]!=null)
                    {
                        if(line2[count].equals("ID: " + id2))
                        {
                            rating2 = line2[count+2].replaceAll("Rating: ","");
                            rating3 = Integer.parseInt(rating2);
                            totalRating = totalRating + rating3;
                            numOfRating++;
                        }
                        count++;
                    }
                    totalRating=totalRating/numOfRating;
                    count=0;
                    String[] line3;
                    line3=readFile("Coach");
                    while(line3[count]!=null)
                    {
                        if(line3[count].equals("Name: " + coachName))
                        {
                            makeChanges("Coach",count+10,"Rating: " + totalRating);
                        }
                        count++;
                    }
                }
                i++;
            }   
            if(answered==false)
            {
                System.out.println("User not found");
                System.out.println("Enter agian the coach you would like to rate:");
                rate = input.nextLine();
            }
        }
    }
    public String dateTime;
    
    /*Function: add new sport schedule based on student registered sport*/ 
    public void addStudentSportSchedule()
    {
        String typeOfUser="Student";
        boolean sportSchedule=false;
        boolean datevrf1=false,timevrf1=false,timevrf2=false;
        DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        System.out.printf("Avaliable time for:"); 
        int location=getLocation();
        sportSchedule(location,sportName);
        System.out.println();
        boolean schedule=false;
        while(schedule!=true)
        {     
            datevrf1=false;
            timevrf1=false;
            while(datevrf1!=true)
            {
                System.out.println("Enter Date for " + sportName +": dd/mm/yyyy");
                date = input.nextLine();
           
                datevrf1 = true;
                try 
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateJoin2 = formatter.parse(date);
                    formatter.setLenient(false);
                    formatter.parse(date.trim());
                } 
                catch (ParseException e) 
                {
                    System.out.println("Incorrect Format/Date");
                    datevrf1 = false;
                }  
            } 
            while(timevrf1!=true)
            {
                timevrf1=true;
                System.out.println("Enter start time for the class: hh:ss (24-hours)");
                startTime = input.nextLine();
                try 
                {
                    LocalTime.parse(startTime);
                } 
                catch (DateTimeParseException | NullPointerException e) 
                {
                    System.out.println("Invalid time string");
                    timevrf1 = false;
                }
            }
            while(timevrf2!=true)
            {
                timevrf2=true;
                System.out.println("Enter end time for the class: hh:ss (24-hours)");
                endTime = input.nextLine();
                try 
                {
                    LocalTime.parse(endTime);
                } 
                catch (DateTimeParseException | NullPointerException e) 
                {
                    System.out.println("Invalid time string");
                    timevrf2 = false;
                }
            }
            dateTime = date + " " + startTime + " - " + endTime;
            boolean schedule2 = checkSportSchedule(dateTime);
            if(schedule2==true)
            {
                schedule=true;
            }
            else if(schedule2==false)
            {
                System.out.println("\nEnter the date and time that are avaliable only");
            }
        }
        System.out.println("Added Schedule: " + dateTime);   
        
        String[] line;
        int count=0;
        line=readFile(typeOfUser);
        int count2;
        count=0;
        boolean endFound=false;
        while(line[count] != null)
        {
            if(line[count].equals("Name: " + log4.name))
            {
                count2=count;
                while(endFound!=true)
                {
                    if(line[count2].equals("end"))
                    {
                        endFound=true;
                        addToStudentTextFile(count2,dateTime);
                    }
                    count2++;
                } 
                break;
            }
            
            count++; 
        }
    }
    
    /*Function: Add new schedule to student database*/
    public void addToStudentTextFile(int location,String dateTime)
    {
        System.out.println(dateTime);
        
        int count3=0,count=0;
        String[] line;
        String[] line2= new String[1000];
        line=readFile("Student");
        count=0;
        while(line[count]!=null)
        {
            if(count3==location)
            {
                line2[count]=dateTime;
                ++count;
            }
            line2[count]=line[count3];
            count++;
            count3++;
        }
        count=0;   
        try 
        {
            FileWriter myWriter = new FileWriter("Student.txt");
            while(line2[count] != null)
            {
                myWriter.write(line2[count]);
                myWriter.write('\n');
                count++;
            }
            myWriter.write('\n');
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch(IOException e)
        {
            System.out.println("An error occurred.");
        }
    }
    
    /*Function: Check weather the sport schedule exist in the system*/ 
    public boolean checkSportSchedule(String dateAndTime)
    {
        String[] line;
        line=readFile("Sport");
        int count=0;
        while(line[count]!=null)
        {
            if(line[count].equals(dateAndTime))
            {
                return true;
            }
            count++;
        }
        return false;
    }
}

