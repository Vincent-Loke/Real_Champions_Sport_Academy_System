package Assignment;

/******************************************************************/
/*            Developer Name:  Loke Weng Khay                     */
/*                Class Name: Admin.java                          */
/*         Class Function: Allow Admin to manage the system       */
/******************************************************************/

import java.io.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Admin extends Person
{
    /*Declaration of variable*/
    Login log3 = new Login();
    Scanner input4= new Scanner(System.in);
    private String date1,date2,time1,time2;
    public static int count=0;
    
    /* Function: Display all action can be done by admin*/
    public void display()
    {
        boolean crtinput  = false;
        String userAction;
        if(count==0)
        {
            System.out.println("\n\nWelcome, " + log3.name);
        }
        System.out.println("\nWhat would you like to do today");
        System.out.println("1. Add Record");
        System.out.println("2. Display All Records");
        System.out.println("3. Search Specific Record");
        System.out.println("4. Sort and Display Record");
        System.out.println("5. Modify Existing Record");
        System.out.println("6. Exit");
        System.out.printf("Your Selection: ");
        userAction=input4.nextLine();
        String toContinue;
        
        while(crtinput!=true)
        {
            if(userAction.equals("1") || userAction.compareToIgnoreCase("Add Record")==0)
            {
                addRecord();
                crtinput=true;
                count++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("Would you like to continue to use the system?(Yes/No)");
                    toContinue=input.nextLine();
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
            else if(userAction.equals("2") || userAction.compareToIgnoreCase("Display All Records")==0 || userAction.compareToIgnoreCase("Display Records")==0)
            {
                displayRecords();
                crtinput=true;
                count++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("Would you like to continue to use the system?(Yes/No)");
                    toContinue=input.nextLine();
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
            else if(userAction.equals("3") || userAction.compareToIgnoreCase("Search Specific Record")==0 || userAction.compareToIgnoreCase("Search Record")==0 || userAction.compareToIgnoreCase("Search")==0)
            {
                SearchRecords();
                crtinput=true;
                count++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("Would you like to continue to use the system?(Yes/No)");
                    toContinue=input.nextLine();
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
            else if(userAction.equals("4") || userAction.compareToIgnoreCase("Sort Record")==0)
            {
                sortAndDisplay();
                crtinput=true;
                
                count++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("Would you like to continue to use the system?(Yes/No)");
                    toContinue=input.nextLine();
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
            else if(userAction.equals("5") || userAction.compareToIgnoreCase("Modify Record")==0)
            {
                ModifyRecords();
                crtinput=true;
                count++;
                boolean crtinput3=false;
                while(crtinput3!=true)
                {
                    System.out.println("Would you like to continue to use the system?(Yes/No)");
                    toContinue=input.nextLine();
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
            else if(userAction.equals("6") || userAction.compareToIgnoreCase("Exit")==0)
            {
                crtinput=true;
                System.exit(0);
            }
            else
            {
                System.out.println("Wrong input\nEnter again: ");
                userAction=input4.nextLine();
            }  
        } 
    }
    
    /* Function: Display all add record option in admin */
    public void addRecord()
    {
        String toAdd;
        boolean input = false;
        System.out.println("\nWhat record would you like to add?");
        System.out.println("1. Coach");
        System.out.println("2. Student");
        System.out.println("3. Sport");
        System.out.println("4. Sport Schedule");
        System.out.printf("Your Selection: ");
        toAdd = input4.nextLine();
        System.out.println();
        while(input != true)
        {
            if(toAdd.equals("1") || toAdd.compareToIgnoreCase("Coach")==0)
            {
                CoachInformation();
                input = true;
            }
            else if(toAdd.equals("2") || toAdd.compareToIgnoreCase("Student")==0)
            {
                new Sign_Up();
                input=true;
            }
            else if(toAdd.equals("3") || toAdd.compareToIgnoreCase("Sport")==0)
            {
                addSport();
                input=true;
            }
            else if(toAdd.equals("4") || toAdd.compareToIgnoreCase("Sport Schedule")==0)
            {
                addSportSchedule();
                input=true;
            }
            else
            {
                System.out.println("Wrong input\nEnter again: ");
                toAdd = input4.nextLine();
                
            }
        }
    }
    
    /* Function: Add sport to the system */
    public void addSport()
    {
        String ID;
        String sportName;
        String typeOfUser="Sport";
        boolean sport=true;
        System.out.println("Enter new sport");
        sportName=input.nextLine();
        while(sport!=false)
        {
            sport = checkSport(sportName);
            if(sport==true)
            {
                System.out.println("Sport name is already in the database");
                System.out.println("Enter a new sport");
                sportName=input.nextLine();
            }
            else if(sport==false)
            {
                sport=false;
            }
            else
            {
                System.out.println("Error Occurred");
            }
        }
        String[] line= new String[1000];
        ID = getID(typeOfUser);
       
        try(FileWriter fw = new FileWriter(typeOfUser.concat(".txt"), true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter textFilePen = new PrintWriter(bw))
        {
            textFilePen.println("Sport ID: " + ID);
            textFilePen.println("Sport Name: " + sportName);
            textFilePen.println("Sport Schedule:");
            textFilePen.println("end");
            textFilePen.println("");
        }
        catch (IOException e)   
        {
            System.out.println("Error Occured");
        }
    }
    public String date,startTime,endTime;
    
    /* Function: Add sport schedule to existing sport to the system */
    public void addSportSchedule()
    {
     
        String sportName;
        String typeOfUser="Sport";
        boolean sportSchedule=false;
        System.out.println("Enter sport name");
        sportName=input.nextLine();
        while(sportSchedule!=true)
        {
            sportSchedule = checkSport(sportName);
            if(sportSchedule==false)
            {
                System.out.println("Sport name does not exist in the database");
                System.out.println("Enter sport name");
                sportName=input.nextLine();
            }
            else if(sportSchedule==true)
            {
                sportSchedule=true;
            }
            else
            {
                System.out.println("Error Occurred");
            }
        }
        
        boolean datevrf1=false,timevrf1=false,timevrf2=false;
        DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        while(datevrf1!=true)
        {
            System.out.println("Enter Date for " + sportName +" class: dd/mm/yyyy");
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
        String dateTime = date + " " + startTime + " - " + endTime;  
        
        String[] line= new String[1000];
        int count=0;
        line=readFile(typeOfUser);
        int count2;
        count=0;
        boolean endFound=false;
        while(line[count] != null)
        {
            if(line[count].equals("Sport Name: " + sportName))
            {
                count2=count;
                while(endFound!=true)
                {
                    if(line[count2].equals("end"))
                    {
                        endFound=true;
                        addToTextFile(count2,dateTime);
                    }
                    count2++;
                } 
                break;
            }
            
            count++; 
        }
    }
    
    /* Function: Add new data to the text file */
    public void addToTextFile(int endLocation,String date)
    {
        String[] line2= new String[1000];
        
        int count3=0,count=0;
        String[] line= new String[1000];
        line=readFile("Sport");
        count=0;
        while(line[count]!=null)
        {
            if(count3==endLocation)
            {
                line2[count]=date;
                ++count;
            }
            line2[count]=line[count3];
            count++;
            count3++;
        }
        count=0;   
        try 
        {
            FileWriter myWriter = new FileWriter("Sport.txt");
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
    
    /* Function: Display all option to view all records in the system */
    public void displayRecords()
    {
        String toView;
        boolean input2=false;
        System.out.println("What records would you like to display\n1. Coach\n2. Sport\n3. Registered Student");
        System.out.printf("Your Selection: ");
        toView=input4.nextLine();
        System.out.println();
        while(input2 != true)
        {
            if(toView.equals("1") || toView.compareToIgnoreCase("Coach")==0)
            {
                displayRecords("Coach");
                input2 = true;
            }
            else if(toView.equals("2") || toView.compareToIgnoreCase("Sport")==0)
            {
                displayRecords("Sport");
                input2=true;
            }
            else if(toView.equals("3") || toView.compareToIgnoreCase("Student")==0)
            {
                displayRecords("Student");
                input2=true;
            }
            else
            {
                System.out.println("Please enter the right response");
                toView=input4.nextLine();
            }
        }
    }
    
    /* Function: Display all records in the system based on the user request */
    public void displayRecords(String filename)
    {
        String[] line= new String[1000];
        int count=0;
        line=readFile(filename);
        System.out.println();
        while(line[count]!=null)
        {
            System.out.println(line[count]);
            count++;       
        }
        System.out.println();
    }
    
    /* Function: Display all option to search for a user in the system*/
    public void SearchRecords()
    {
        String searchMethod;
        System.out.println("Who would you like to search:\n1. Coach\n2. Student\n3. Sport ");
        System.out.printf("Your Selection: ");
        searchMethod=input.nextLine();
        System.out.println();
        boolean input2=false;
        while(input2!=true)
        {
            if(searchMethod.equals("1") || searchMethod.compareToIgnoreCase("Coach")==0)
            {
                
                String coachSearchMethod;
                System.out.println("Search by:\n1. Coach ID\n2. Performance Rating");
                System.out.printf("Your Selection:");
                coachSearchMethod=input.nextLine();
                System.out.println();
                if(coachSearchMethod.equals("1") || coachSearchMethod.compareToIgnoreCase("Coach ID")==0)
                {
                    input2=true;
                    System.out.println("Enter Coach ID: ");
                    String coachID=input.nextLine();
                    coachID="ID: " + coachID;
                    searchUser(coachID,"Coach",true);
                    System.out.println();
                }
                else if(coachSearchMethod.equals("2") || coachSearchMethod.compareToIgnoreCase("Performance Rating")==0)
                {
                    
                    boolean ratingvrf=false;
                    while(ratingvrf!=true)
                    {
                        System.out.println("Enter Performance Rating (0-5)");
                        int rating = input.nextInt();
                        input.nextLine();
                        if(rating>=0 && rating<=5)
                        {
                            input2=true;
                            ratingvrf=true;
                            String rating2="Rating: " + rating;
                            searchUser(rating2,"Coach",true);
                            System.out.println();
                        }
                        else
                        {
                            System.out.println("Invalid Input\n");
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid Response\nEnter agian\n");
                }
            }
            else if(searchMethod.equals("2") || searchMethod.compareToIgnoreCase("Student")==0)
            {
                input2=true;
                String stuID;
                System.out.println("Enter Student ID");
                stuID=input.nextLine();
                stuID="ID: " + stuID;
                searchUser(stuID,"Student",true);
                System.out.println();
            }
            else if(searchMethod.equals("3") || searchMethod.compareToIgnoreCase("Sport")==0)
            {
                input2=true;
                String sportID;
                System.out.println("Enter Sport ID");
                sportID=input.nextLine();
                sportID="Sport ID: " + sportID;
                searchUser(sportID,"Sport",true);
                System.out.println();
            }
            else
            {
                System.out.println("Please enter the right response");
                searchMethod=input.nextLine();
                System.out.println();
            }
        }
    }
    
    /* Function: Display all option to sort and display record in the system*/
    public void sortAndDisplay()
    {
        String selection;
        System.out.printf("\nSort and Display:\n1. Coach in ascending order\n2. Coach Hour Pay in ascending order\n3. Coach Performance Rating in ascending order\nYour Selction: ");
        selection=input.nextLine();
        System.out.println();
        if(selection.equals("1") || selection.compareToIgnoreCase("Coach in ascending order")==0)
        {
            viewCoach(false,false);
        }
        else if(selection.equals("2") || selection.compareToIgnoreCase("Coach Hour Pay in ascending order")==0)
        {
            viewCoach(true,false);
        }
        else if(selection.equals("3") || selection.compareToIgnoreCase("Coach Performance Rating in ascending order")==0)
        {
            viewCoach(false,true);
        }
    }
    
    /* Function: Sort and display all coach based on user request*/
    public void viewCoach(boolean isHourRate,boolean isRating)
    {
        String[] line = new String[1000];
        int count=0;
        line=readFile("Coach");
        String[] names = new String[1000];
        int[] hourlyRate = new int[1000]; 
        int[] rating = new int[1000];
        count=0;
        int count2=0;
        if(isHourRate==false && isRating==false)
        {
            while(line[count]!=null)
            {
                if(line[count].length()>4)
                {
                    String sbs = line[count].substring(0,4); 
                    if(sbs.equals("Name"))
                    {
                        names[count2]=line[count].replaceAll("Name: ","");
                        count2++;
                    }
                }
                count++;
            }
            count=0;
            while(names[count]!=null)
            {
                count++; 
            }
            Arrays.sort(names,0,count);
            System.out.println("----------------------------------");
            System.out.println("| ID  |         Name             |");
            System.out.println("----------------------------------");
            count=0;
            while(names[count]!=null)
            {
                String id= getCoachID("Name: " + names[count]);
                System.out.printf("|" + id + "|" + names[count] );
                int spaces=names[count].length();
                int x=0;
                while(x<26-spaces)
                {
                    System.out.printf(" ");
                    x++;
                }
                System.out.println("|");
                System.out.println("----------------------------------");
                count++;
            }
        }
        else if(isHourRate==true && isRating==false)
        {
            while(line[count]!=null)
            {
                if(line[count].length()>11)
                {
                    String sbs = line[count].substring(0,11); 
                    if(sbs.equals("Hourly Rate"))
                    {
                        names[count2]=line[count-3].replaceAll("Name: ","");
                        String stringhourlyRate = line[count].replaceAll("Hourly Rate: RM ","");
                        hourlyRate[count2]=Integer.parseInt(stringhourlyRate);
                        count2++;
                    }
                }
                count++;
            }
            count2=0;
            while(names[count2]!=null)
            {
                count2++;
            }
            int tempHourRate;
            String tempNames;
            for (int i = 0; i < count2; i++) 
            {
                for (int j = i + 1; j < count2; j++) 
                {
                    if(hourlyRate[i] > hourlyRate[j]) 
                    {
                        tempHourRate = hourlyRate[i];
                        tempNames=names[i];

                        hourlyRate[i] = hourlyRate[j];
                        names[i] = names[j];

                        hourlyRate[j] = tempHourRate;
                        names[j] = tempNames;
                    }
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println("| ID  |         Name             |Hourly Rate(RM)|");
            System.out.println("--------------------------------------------------");
            count=0;
            while(names[count]!=null)
            {
                String id= getCoachID("Name: " + names[count]);
                System.out.printf("|" + id + "|" + names[count] );
                int spaces=names[count].length();
                int x=0;
                while(x<26-spaces)
                {
                    System.out.printf(" ");
                    x++;
                }
                System.out.println("|      " + hourlyRate[count] + "      |");
                System.out.println("--------------------------------------------------");
                count++;
            }
        }
        else if(isHourRate==false && isRating==true)
        {
            while(line[count]!=null)
            {
                if(line[count].length()>6)
                {
                    String sbs = line[count].substring(0,6); 
                    if(sbs.equals("Rating"))
                    {
                        names[count2]=line[count-10].replaceAll("Name: ","");
                        String stringRating = line[count].replaceAll("Rating: ","");
                        rating[count2]=Integer.parseInt(stringRating);
                        count2++;
                    }
                }
                count++;
            }
            int tempRating;
            String tempNames2;
            for (int i = 0; i < count2; i++) 
            {
                for (int j = i + 1; j < count2; j++) 
                {
                    if(rating[i] > rating[j]) 
                    {
                        tempRating = rating[i];
                        tempNames2=names[i];

                        rating[i] = rating[j];
                        names[i] = names[j];

                        rating[j] = tempRating;
                        names[j] = tempNames2;
                    }
                }
            }
            System.out.println("-----------------------------------------");
            System.out.println("| ID  |         Name             |Rating|");
            System.out.println("-----------------------------------------");
            count=0;
            while(names[count]!=null)
            {
                String id= getCoachID("Name: " + names[count]);
                System.out.printf("|" + id + "|" + names[count] );
                int spaces=names[count].length();
                int x=0;
                while(x<26-spaces)
                {
                    System.out.printf(" ");
                    x++;
                }
                System.out.println("|  " + rating[count] + "   |");
                System.out.println("-----------------------------------------");
                count++;
            }
        }
    }
    
    /* Function: Search coach ID to get location in text file*/
    public String getCoachID(String name)
    {
        String ID;
        String[] line = new String[1000];
        int count=0;
        line=readFile("Coach");
        while(line[count]!=null)
        {
            if(line[count].equals(name))
            {
                ID=line[count-1];
                ID=ID.replaceAll("ID: ","");
                return ID;
            }
            count++;
        }
        return null;
    }
    
    /* Function: Display all modification options to the user*/
    public void ModifyRecords()
    {
        String toModify;
        System.out.println("Who would you like to modify\n1. Coach\n2. Sport\n3. Registered Student");
        System.out.printf("Your Selection: ");
        toModify=input4.nextLine();
        System.out.println();
        boolean input3=false;
        while(input3 != true)
        {
            if(toModify.equals("1") || toModify.compareToIgnoreCase("Coach")==0)
            {
                displayModifyOptions("Coach");
                input3 = true;
            }
            else if(toModify.equals("2") || toModify.compareToIgnoreCase("Sport")==0)
            {
                displayModifyOptions("Sport");
                input3=true;
            }
            else if(toModify.equals("3") || toModify.compareToIgnoreCase("Student")==0)
            {
                displayModifyOptions("Student");
                input3=true;
            }
            else
            {
                System.out.println("Please enter the right response");
                toModify=input4.nextLine();
            }
        }
    }
    
    /* Function: Display what user want to modify to existing data in the system*/
    public void displayModifyOptions(String typeOfUserModify)
    {
        String searchMethod;
        String ID2;
        String Username;
        String fullname;
        int location;
        boolean crtinput=false;
        if(typeOfUserModify.equals("Coach"))
        {
            while(crtinput!=true)
            {
                System.out.println("Please select on how you want to find the user: \n1. ID\n2. Fullname");
                System.out.printf("Your Selection: ");
                searchMethod = input4.nextLine();
                System.out.println();
                if(searchMethod.equals("1") || searchMethod.compareToIgnoreCase("ID")==0)
                {
                    System.out.println("Enter ID: ");
                    ID2 = input4.nextLine();
                    String stg = "ID: " + ID2;  
                    location=searchUser(stg,typeOfUserModify,false);
                    if(location == -1)
                    {
                        System.out.println("User not found");
                    }
                    else
                    {
                        realModification(location,typeOfUserModify);
                    }
                    crtinput=true;
                }
                else if(searchMethod.equals("2") || searchMethod.compareToIgnoreCase("Fullname")==0)
                {
                    System.out.println("Enter Fullname: ");
                    fullname = input4.nextLine();
                    String stg = "Name: " + fullname; 
                    location=searchUser(stg,typeOfUserModify,false); 
                    if(location == -1)
                    {
                        System.out.println("User not found");
                    }
                    else
                    { 
                        realModification(location-1,typeOfUserModify);
                    }
                    crtinput=true;
                } 
                else
                {
                    System.out.println("Wrong input");
                }
            }
        } 
        else if(typeOfUserModify.equals("Student"))
        {
            while(crtinput!=true)
            {
                System.out.println("Please select on how you want to find the user: \n1. ID\n2. Username\n3. Fullname");
                System.out.printf("Your Selection:");
                searchMethod = input4.nextLine();
                System.out.println();
                if(searchMethod.equals("1") || searchMethod.compareToIgnoreCase("ID")==0)
                {
                    System.out.println("Enter ID: ");
                    ID2 = input4.nextLine();
                    String stg = "ID: " + ID2;  
                    location=searchUser(stg,typeOfUserModify,false);
                    if(location == -1)
                    {
                        System.out.println("User not found");
                    }
                    else
                    {
                        realModification(location,typeOfUserModify);
                    }
                    crtinput=true;
                }
                else if(searchMethod.equals("2") || searchMethod.compareToIgnoreCase("Username")==0)
                {   
                    System.out.println("Enter Username: ");
                    Username = input4.nextLine();
                    String stg = "Username: " + Username;   
                    location=searchUser(stg,typeOfUserModify,false); 
                    if(location == -1)
                    {
                        System.out.println("User not found");
                    }
                    else
                    {
                        realModification(location-2,typeOfUserModify);
                    }
                    crtinput=true;
                    }
                else if(searchMethod.equals("3") || searchMethod.compareToIgnoreCase("Fullname")==0)
                {
                    System.out.println("Enter Fullname: ");
                    fullname = input4.nextLine();
                    String stg = "Name: " + fullname; 
                    location=searchUser(stg,typeOfUserModify,false); 
                    if(location == -1)
                    {
                        System.out.println("User not found");
                    }
                    else
                    {
                       realModification(location-1,typeOfUserModify);
                    }
                    crtinput=true;
                } 
                else
                {
                    System.out.println("Wrong input");
                }
            }
        }
        else if(typeOfUserModify.equals("Sport"))
        {
            while(crtinput!=true)
            {
                System.out.println("Please select on how you want to find the sport: \n1. Sport ID\n2. Sport Name");
                System.out.printf("Your Selection: ");
                searchMethod = input4.nextLine();
                System.out.println();
                if(searchMethod.equals("1") || searchMethod.compareToIgnoreCase("ID")==0)
                {
                    System.out.println("Enter Sport ID: ");
                    ID2 = input4.nextLine();
                    String stg = "Sport ID: " + ID2;  
                    location=searchUser(stg,typeOfUserModify,false);
                    if(location == -1)
                    {
                        System.out.println("User not found");
                    }
                    else
                    {
                        realModification(location,typeOfUserModify);
                    }
                    crtinput=true;
                }
                else if(searchMethod.equals("2") || searchMethod.compareToIgnoreCase("Fullname")==0)
                {
                    System.out.println("Enter Sport Name: ");
                    fullname = input4.nextLine();
                    String stg = "Sport Name: " + fullname; 
                    location=searchUser(stg,typeOfUserModify,false); 
                    if(location == -1)
                    {
                        System.out.println("User not found");
                    }
                    else
                    {
                        realModification(location-1,typeOfUserModify);
                    }
                    crtinput=true;
                }
                else
                {
                    System.out.println("Wrong input");
                }
            }
        }       
    }
    
    /* Function: Search for user in the system */
    public int searchUser(String stg,String filename,boolean displayPermission)
    {
        String[] line = new String[1000];
        int count=0;
        line=readFile(filename);
        System.out.println();
        if(displayPermission==true)
        {
            int j=0;
            count=0;
            boolean found=false;
            while(line[count] != null)
            {
                if(line[count].equals(stg))
                {
                    
                    found=true;
                    if(filename.equals("Coach"))
                    {
                        
                        String isRating = stg.substring(0,6);
                        if(isRating.equals("Rating"))
                        {
                            count=0;
                            
                            while(line[count]!=null)
                            {
                                j=0;
                                
                                if(line[count].equals(stg))
                                {
                                    int count2=count;
                                    
                                    while(j<13)
                                    {
                                        System.out.println(line[count2-11]);
                                        count2++;
                                        j++;
                                    }
                                }
                                count++;
                            }
                        }
                        else
                        {
                            while(j<13)
                            {
                                System.out.println(line[count]);
                                count++;
                                j++;
                            }
                        }
                    }
                    else if(filename.equals("Student"))
                    {
                        while(!"end".equals(line[count]))
                        {
                            System.out.println(line[count]);
                            count++;
                            j++;
                        }
                    }
                    else if(filename.equals("Sport"))
                    {
                        while(!"end".equals(line[count]))
                        {
                            System.out.println(line[count]);
                            count++;
                            j++;
                        }
                    }
                }
                
                count++; 
            }
            if(found==false)
            {
                System.out.println("User/Sport not found");
            }
            return 0;
        }
        else if(displayPermission==false)
        {
            int i=0;
            count=0;
            while(line[count] != null)
            {
                if(line[count].equals(stg))
                {
                    System.out.println("User Found");
                    return count;
                }
                count++; 
            }
        }
        return -1;
    }
    
    /* Function: Modify the record in the text file */
    public void realModification(int location,String UserType)
    {
        String modify1;
        String modify2,modify3;
        boolean crtinput4=false;
        while(crtinput4!=true)
        {
        System.out.println("What would you like to modify");
        if("Student".equals(UserType))
        {
            System.out.println("1. Name");
            System.out.println("2. Username"); 
            System.out.println("3. Password");
            System.out.println("4. Address");
            System.out.println("5. Sport Name");
            System.out.println("6. Sport Schedule");
            System.out.printf("Your Selection: ");
            modify1=input.nextLine();
            System.out.println();
            if(modify1.equals("1") || modify1.compareToIgnoreCase("Name")==0 )
            {
                crtinput4=true;
                System.out.println("Enter Name");
                modify2=input.nextLine();
                modify3="Name: " + modify2; 
                makeChanges("Student",location+1,modify3);
            }
            else if(modify1.equals("2") || modify1.compareToIgnoreCase("Username")==0)
            {
                crtinput4=true;
                System.out.println("Enter Username");
                modify2=input.nextLine();
                modify3="Username: " + modify2; 
                makeChanges("Student",location+2,modify3);
            }
            else if(modify1.equals("3") || modify1.compareToIgnoreCase("Password")==0)
            {
                crtinput4=true;
                System.out.println("Enter Password");
                modify2=input.nextLine();
                
                modify3="Password: " + modify2;
                makeChanges("Student",location+3,modify3);
            }
            else if(modify1.equals("4") || modify1.compareToIgnoreCase("Address")==0)
            {
                crtinput4=true;
                String hnumber,street,city,state,postalCode;
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
                modify3="Address: " + hnumber +", "+ street +", "+ city + ", "+ postalCode+", "+ state;
                makeChanges("Student",location+4,modify3);
            }
            else if(modify1.equals("5") || modify1.compareToIgnoreCase("Sport Name")==0)
            {
                crtinput4=true;
                System.out.println("Enter Sport Name");
                modify2=input.nextLine();
                boolean askAgain=false;
                while(askAgain!=true)
                {
                boolean sportFound = checkSport(modify2);
                if(sportFound!=true)
                {
                    System.out.println("Sport not found");
                    System.out.println("Enter Sport Name");
                    modify2=input.nextLine();
                }
                else if(sportFound==true)
                {
                    askAgain=true;
                    modify3="Sport Name: " + modify2;
                    makeChanges("Student",location+6,modify3);
                }
                else
                {
                    askAgain=true;
                    System.out.println("Error Occured");
                }
                }
                
            }
            else if(modify1.equals("6") || modify1.compareToIgnoreCase("Sport Schedule")==0 || modify1.compareToIgnoreCase("Schedule")==0)
            {
                crtinput4=true;
                int valid = displaySportschedule("Student",location);
                if(valid!=-1)
                {
                    changeSportSchedule("Student",location);
                }
            }
            else
        {
            System.out.println("Enter an valid response");
        }
        }
        else if("Coach".equals(UserType))
        {
            System.out.println("1. Name");
            System.out.println("2. Date Joined");
            System.out.println("3. Date Terminated");
            System.out.println("4. Hourly Rate");
            System.out.println("5. Phone Number");
            System.out.println("6. Address");
            System.out.println("7. Sport Centre Code");
            System.out.println("8. Sport Center Name");
            System.out.println("9. Sport Name");
            System.out.printf("Your Selection: ");
            modify1=input.nextLine();
            System.out.println();
            if(modify1.equals("1") || modify1.compareToIgnoreCase("Name")==0 )
            {
                crtinput4=true;
                System.out.println("Enter Name");
                modify2=input.nextLine();
                modify3="Name: " + modify2; 
                makeChanges("Coach",location+1,modify3);
            }
            else if(modify1.equals("2") || modify1.compareToIgnoreCase("Date Joined")==0 )
            {
                crtinput4=true;
                boolean datevrf1=false;
                DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                sdf.setLenient(false);
                while(datevrf1!=true)
                {
                    System.out.println("Enter Date Joined: dd/mm/yyyy");
                    modify2 = input.nextLine();
                    datevrf1 = true;
                    try 
                    {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date dateJoin2 = formatter.parse(modify2);
                        formatter.setLenient(false);
                        formatter.parse(modify2.trim());
                        if(datevrf1 == true)
                        {
                            modify3="Date Joined: " + modify2;
                            makeChanges("Coach",location+2,modify3);
                        }
                    } 
                    catch (ParseException e) 
                    {
                        System.out.println("Incorrect Format/Date");
                        datevrf1 = false;
                    }  
                } 
            }
            else if(modify1.equals("3") || modify1.compareToIgnoreCase("Date Terminated")==0 )
            {
                crtinput4=true;
                boolean datevrf1=false;
                DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                while(datevrf1!=true)
                {
                    System.out.println("Enter Date Terminated: dd/mm/yyyy");
                    modify2 = input.nextLine();
                    datevrf1 = true;
                    try 
                    {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date dateJoin2 = formatter.parse(modify2);
                        formatter.setLenient(false);
                        formatter.parse(modify2.trim());
                        if(datevrf1 == true)
                        {
                            modify3="Date Terminated: " + modify2;
                            makeChanges("Coach",location+3,modify3);
                        }
                    } 
                    catch (ParseException e) 
                    {
                        System.out.println("Incorrect Format/Date");
                        datevrf1 = false;
                    }  
                }  
            }
            else if(modify1.equals("4") || modify1.compareToIgnoreCase("Hourly Rate")==0 )
            {
                crtinput4=true;
                boolean vrfinput = false;
                while(vrfinput!=true)
                {
                    System.out.println("Enter Hourly Rate");
                    modify2=input.nextLine();
                    int a=Integer.parseInt(modify2); 
                    if(a>0 & a<=500)
                    {
                        vrfinput=true;
                        modify3="Hourly Rate: RM " + modify2; 
                        makeChanges("Coach",location+4,modify3);
                    }
                    else
                    {
                        System.out.println("Invalid Range\nRange: RM100 - RM500\n");
                    }
                }
            }
            else if(modify1.equals("5") || modify1.compareToIgnoreCase("Phone Number")==0 )
            {
                crtinput4=true;
                System.out.println("Enter Phone Number");
                modify2=input.nextLine();
                modify3="Phone: " + modify2;
                makeChanges("Coach",location+5,modify3);
            }
            else if(modify1.equals("6") || modify1.compareToIgnoreCase("Address")==0 )
            {
                crtinput4=true;
                String hnumber,street,city,state,postalCode;
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
                modify3="Address: " + hnumber +", "+ street +", "+ city +", "+ postalCode+", "+ state;
                makeChanges("Coach",location+6,modify3);
            }
            else if(modify1.equals("7") || modify1.compareToIgnoreCase("Sport Centre Code: xxxxxCC")==0 )
            {
                crtinput4=true;
                System.out.println("Enter Sport Centre Code");
                modify2=input.nextLine();
                modify3="Sport Centre Code: " + modify2;
                makeChanges("Coach",location+7,modify3);
            }
            else if(modify1.equals("8") || modify1.compareToIgnoreCase("Sport Centre Name")==0 )
            {
                crtinput4=true;
                System.out.println("Enter Sport Centre Name");
                modify2=input.nextLine();
                modify3="Sport Centre Name: " + modify2;
                makeChanges("Coach",location+8,modify3);
            }
            else if(modify1.equals("9") || modify1.compareToIgnoreCase("Sport Name")==0 )
            {
                crtinput4=true;
                System.out.println("Enter Sport Name");
                modify2=input.nextLine();
                boolean askAgain=false;
                while(askAgain!=true)
                {
                boolean sportFound = checkSport(modify2);
                if(sportFound!=true)
                {
                    System.out.println("Sport not found");
                    System.out.println("Enter Sport Name");
                    modify2=input.nextLine();
                }
                else if(sportFound==true)
                {
                    askAgain=true;
                    modify3="Sport Name: " + modify2;
                    makeChanges("Coach",location+9,"Sport Code: " + sportCode);
                    makeChanges("Coach",location+10,modify3);
                }
                else
                {
                    askAgain=true;
                    System.out.println("Error Occured");
                }
                }
            }
            else
        {
            System.out.println("Enter an valid response");
        }
        }
        else if("Sport".equals(UserType))
        {
            System.out.println("1. Sport Name");
            System.out.println("2. Sport Schedule");
            System.out.printf("Your Selection: ");
            modify1=input.nextLine();
            if(modify1.equals("1") || modify1.compareToIgnoreCase("Sport Name")==0 )
            {
                crtinput4=true;
                System.out.println("Enter Sport Name");
                modify2=input.nextLine();
                 modify3="Sport Name: " + modify2;
                makeChanges("Sport",location+1,modify3);
            }
            else if(modify1.equals("2") || modify1.compareToIgnoreCase("Sport Schedule")==0 )
            {
                crtinput4=true;
                int valid = displaySportschedule("Sport",location);
                if(valid!=-1)
                {
                    changeSportSchedule("Sport",location);
                }
            }
            else
        {
            System.out.println("Enter an valid response");
        }
        }
    }
    }
    public void makeChanges(String filename2,int location2,String newData)
    {
        String[] line=new String[1000];
        int count=0;
        line=readFile(filename2);
        while(line[count]!=null)
        {
            if(count==location2)
            {
                line[count]=newData;
            }
            count++;
        }
        count=0;
        try 
        {
            FileWriter myWriter = new FileWriter(filename2.concat(".txt"));
            while(line[count] != null)
            {
                myWriter.write(line[count]);
                myWriter.write('\n');
                count++;
            }
            myWriter.close();
            System.out.println("File have been updated");
        } 
        catch(IOException e)
        {
            System.out.println("An error occurred.");
        }
    }
    
    /* Function: Display all sport schedule record */
    public int displaySportschedule(String filename3,int location)
    {
        String[] line=new String[1000];
        int count=0;
        try
        {
            FileReader reader = new FileReader(filename3.concat(".txt"));
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
            System.out.print("Error occured");
        }
        count=0;
        String[] sportSchedule=new String[1000]; 
        if(filename3.equals("Student"))
        {
            System.out.println();
            while(line[count]!=null)
            {
                int count2=location+7;
                int count3=0;
                if(line[count2+1].equals("end"))
                {
                   System.out.println("No existing record found");
                   return -1;
                }
                else
                {
                    while(!"end".equals(line[count2]))
                    {
                        sportSchedule[count3]=line[count2];
                        count2++;
                        count3++;
                    }    
                }
                
                count++;
            }
            count=0;
            while(sportSchedule[count]!=null)
            {
                System.out.println(sportSchedule[count]);
                count++;
            }
        }
        else if(filename3.equals("Sport"))
        {
            System.out.println();
            while(line[count]!=null)
            {
                int count2=location+2;
                int count3=0;
                if(line[count2+1].equals("end"))
                {
                   System.out.println("No existing record found");
                   return -1;
                }
                else
                {
                    while(!"end".equals(line[count2]))
                    {
                        sportSchedule[count3]=line[count2];
                        count2++;
                        count3++;
                    }    
                }
                
                count++;
            }
            count=0;
            while(sportSchedule[count]!=null)
            {
                System.out.println(sportSchedule[count]);
                count++;
            }
        }
        return 0;
    }
    
    /****************************************************/
    /* Developer Name: Loke Weng Khay                   */
    /* Function: Change sport schedule in the text file */
    /****************************************************/
    public void changeSportSchedule(String filename3,int location)
    {
        boolean datevrf1=false,timevrf1=false,datevrf2=false,timevrf2=false,timevrf3=false,timevrf4=false;
        DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        while(datevrf1!=true)
        {
            System.out.println("Enter Date you want to modify: dd/mm/yyyy");
            date1 = input.nextLine();
           
            datevrf1 = true;
            try 
            {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date dateJoin2 = formatter.parse(date1);
                formatter.setLenient(false);
                formatter.parse(date1.trim());
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
            System.out.println("Enter start time you want to modify: hh:ss (24-hours)");
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
            System.out.println("Enter end time you want to modify: hh:ss (24-hours)");
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
        String dateTime = date1 + " " + startTime + " - " + endTime; 
        String[] line=new String[1000];
        int count=0;
        try
        {
            FileReader reader = new FileReader(filename3.concat(".txt"));
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
            System.out.print("Error occured");
        }
        count=location;
            while(!"end".equals(line[count]))
            {
                if(line[count].equals(dateTime))
                {
                    sdf.setLenient(false);
                    while(datevrf2!=true)
                    {
                        System.out.println("Enter a new date: dd/mm/yyyy");
                        date2 = input.nextLine();
           
                        datevrf2 = true;
                        try 
                        {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            Date dateJoin2 = formatter.parse(date2);
                            formatter.setLenient(false);
                            formatter.parse(date2.trim());
                        } 
                        catch (ParseException e) 
                        {
                            System.out.println("Incorrect Format/Date");
                            datevrf2 = false;
                        }        
                    } 
                    while(timevrf3!=true)
                    {
                        timevrf3=true;
                        System.out.println("Enter new start time: hh:ss (24-hours)");
                        startTime = input.nextLine();
                        try 
                        {
                            LocalTime.parse(startTime);
                        } 
                        catch (DateTimeParseException | NullPointerException e) 
                        {
                            System.out.println("Invalid time string");
                            timevrf3 = false;
                        }
                    }
                    while(timevrf4!=true)
                    {
                        timevrf4=true;
                        System.out.println("Enter new end time: hh:ss (24-hours)");
                        endTime = input.nextLine();
                        try 
                        {
                            LocalTime.parse(endTime);
                        } 
                        catch (DateTimeParseException | NullPointerException e) 
                        {
                            System.out.println("Invalid time string");
                            timevrf4 = false;
                        }
                    }
                    String dateTime2 = date2 + " " + startTime + " - " + endTime;
                    line[count]=dateTime2;
                    count=0;
                    try 
                    {
                        FileWriter myWriter = new FileWriter(filename3.concat(".txt"));
                        while(line[count] != null)
                        {
                            myWriter.write(line[count]);
                            myWriter.write('\n');
                            count++;
                        }
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    }    
                    catch(IOException e)
                    {
                        System.out.println("An error occurred.");
                    }
                    break;
                }
                count++;
            }
    }
}