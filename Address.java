
package Assignment;
/******************************************************************/
/*            Developer Name:  Loke Weng Khay                     */
/*                Class Name: Address.java                        */
/*    Class Function: To store and return address when called     */
/******************************************************************/
import java.util.*;


public class Address 
{
    Scanner input = new Scanner(System.in);
    private String hnumber;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    
    /* Function: Main Constructor              */
    Address(String hNumber,String street, String city, String postalCode,String state)
    {
        this.hnumber=hNumber;
        this.street=street;
        this.city=city;
        this.postalCode=postalCode;
        this.state=state;   
    }

    /* Function: Return String when object is called */
    public String toString()
    {
        return "No. " + hnumber + ", " + street + ", " + city + ", " + postalCode + ", " + state;
    }
    
}
