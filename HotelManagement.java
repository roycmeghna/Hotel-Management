import java.util.*;
import java.io.*;
import java.lang.*;


public class HotelManagement
{
    
    
    String ch;                      //String variable to hold the choice for Booking Rooms of another type
    char choice;                    //String variable to hold the choice of Room Type
    double billamt1 =0.0,billamt2= 0.0,billamt3 =0.0,ba1=0.0,ba2 =0.0,ba3=0.0,lamt = 7500, damt = 6500, samt = 5200; 
                                    // Real variables to hold the bill value
    static String name, addr;       //String variable to hold the name and address of the customer
    static int phno;                //Integer variable to hold the phone number of the customer
    static int d,n,c,rcount ;  //d-to hold number of days, n to hold the number of rooms, c - counter variable, rcount - to hold total number of rooms.
                      
    int[] booked = new int[200];    //integer array to hold the room numbers that are booked.
    
    //lrooms - integer array to hold 'L' type room numbers
   int lrooms[] = {301,302,303,304,305,306,307,308,309,310,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,
               337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360};
     //drooms - integer array to hold 'D' type room numbers              
    int drooms[] = {201,202,203,204,205,206,207,208,209,210,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,
               237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260, 261,262,263,264,265,266,267,268,269,270};
    //srooms - integer array to hold 'S' type room numbers
    int srooms[] = {101,102,103,104,105,106,107,108,109,110,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,
               137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160, 161,162,163,164,165,166,167,168,169,170};
               
    
    
    public static void main()
    {
        
        HotelManagement hm = new HotelManagement();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to The Atria Bangalore");
        System.out.println("********************************");
        System.out.println("One of the leading Business Hotels in Bangalore ,is strategically located in the heart of the city at XXXXX,");
        System.out.println("which is just 5 kms away from the corporate hub. It is also accessible from the airport in just 30 min and ");
        System.out.println("just 10 min from the city Railway station");
        System.out.println();
        System.out.println("The amenities offered at the Atria");
        hm.facilities('a');                 //Function call - to display the amenities in the hotel
        System.out.println();
        
        System.out.println("Enter your name");
        name = sc.nextLine();
        
        System.out.println("Enter your address");
        addr = sc.nextLine();
        
        System.out.println("Enter your contact number");
        phno= sc.nextInt();
        System.out.println();
        
        System.out.println("Accomodation at The Atria Bangalore");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        hm.accomodation();          // Function call - to display the different types of accomodation
    }
    
    public void display()               //function to display about the accomodation offered
    {
        System.out.println("The Atria Hotel Bangalore eatures a sprawling split-level atrium lobby surrounded by 200 ");
        System.out.println("centrally air-conditioned rooms, suties and theme suites. Two scenic elevators are also available to take you up");
        System.out.println("to your room. The contemporary design and aesthetic interiors meet the needs of the present day business and leisure traveller.");
        System.out.println("With both savvy business and leisure travellers in mind, The Atria Hotel offers high standards of hospitality and");
        System.out.println("great hotel services at a reasonable price.");
        System.out.println();
        
    }
    
    public void accomodation()
    {
    
        HotelManagement obj = new HotelManagement();
        
        Scanner sc = new Scanner(System.in);
        display();      //Function call - to display about the accomodation offered at the hotel.
        
        
        do
        {
            System.out.println("You can choose from the following options");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("L: Lifestyle Room");
            System.out.println("D: Deluxe Room");
            System.out.println("S: Standard Rooms");
            System.out.println();
            
            choice = sc.next().charAt(0);
            
            switch(choice)
            {
                case 'L':ba1 = obj.LifeStyle();             //Function call - to process the booking of 'L' type rooms.
                        System.out.println("\n");
                        break;
                case 'D':ba2 = obj.Deluxe();            //Function call - to process the booking of 'D' type rooms.
                        System.out.println("\n");
                        break;
                case 'S':ba3 = obj.Standard();         //Function call - to process the booking of 'S' type rooms.
                       System.out.println("\n");
                       break;
                default:System.out.println("You have entered a wrong choice.");
                        System.out.println("Enter the correct choice from the above list");
                        System.out.println("Thank you");
                        break;
              }
                
            System.out.println("Do you wish to book another Room?");
            System.out.println("Enter 'Yes' or 'Y' for yes and 'No' or 'N' for a No");
            ch = sc.next();
            if(ch.equalsIgnoreCase("N")|| ch.equalsIgnoreCase("No"))
            {
                System.out.println("Processing your bill......Please wait!");
                System.out.println();
                obj.Billing(ba1,ba2,ba3);       // Function call to process the total bill amt along with the room numbers.
                
                System.out.println("Thank you for choosing The Atria Bangalore");
                System.out.println("Have a Pleasant Stay!!! :)");
     
            }
        } while(ch.equalsIgnoreCase("Yes")|| ch.equalsIgnoreCase( "Y") );             //do-while loop to loop back n book another room if required.
   } 
   /* End of Function Accomodation*/


    
        // Function for lifestyle rooms
        
        public double LifeStyle()
        {
     
        Boolean flag = false;         //Boolean variable to hold a true value if the room gets booked.
        char ch;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("LifeStyle Room");
        System.out.println("***************");
        System.out.println(" Every meticulous traveler has found the 310 Sq ft of sheer elegance a real oasis of comfort.");
        System.out.println("Relax with surround sound large sized plasma televisions and a sleek workspace and lush upholstery");
        System.out.println(" A good stay is much a part of travel, and Lifestyle rooms at Atria reinforce this.");
        System.out.println();
        System.out.println("The In-Room facilities provided are:");
        facilities();               //Overloaded function call to display the facilities offered with Lifestyle type rooms
        System.out.println();
        System.out.println("The cost per day (Bed and Breakfast) is: Rs." +lamt);
        System.out.println("*****Additional tax applicable*****");
        System.out.println();
        
        System.out.println("How many Rooms do you want to book? ");
        n = sc.nextInt();                       // variable to hold the number of rooms 
        System.out.println("Enter the number of days you want to stay");
        d = sc.nextInt();                       // variable to hold the number of days of stay.
        
        do
        {
          c = n+rcount;                 //Counter that increments the j value to the next level of entry 
        // Enter the room numbers into the array booked[]
        System.out.println("Enter a room number between 301 and 360.");
        for(int j=rcount;j<c;j++)
        {
              booked[j] = sc.nextInt();  
              rcount++;
         }
      
        System.out.println("Please wait... While we check for the availability of the rooms");
        
            //Checking the availability of rooms in the original array lrooms[] for the room numbers in array booked[]
                for(int i =0;i<lrooms.length;i++)
                {
                    for(int j =0;j<c;j++)
                    {
                        if(lrooms[i]==booked[j] && lrooms[i] !=0)   
                        {
                                flag = true;
                          }                           
                      }
                 }
            if(flag == true)
            {
                System.out.println("Room available!Should we confirm your booking?");
                System.out.println("Enter 'Y' or 'y' for yes and 'N' or 'n' for No");
                ch = sc.next().charAt(0);
                if(ch == 'Y' || ch == 'y')
                  {
                      System.out.println("Booking confirmed!Thank you for choosing The Atria Bangalore");
                      
                       //Clear the rooms numbers in the original array if the room gets booked.  
                          for(int i=0;i<lrooms.length;i++)
                          {
                              for(int j=0;j<rcount;j++)
                              {       
                                    if(lrooms[i] == booked[j])                               
                                         lrooms[i] =0;
                                       
                                    }
                                }                              
                         //Once the room gets booked, calculate the bill amt 
                         //the original bill amt is added to the new billamt of the same room type
                         billamt1 = billamt1 + ((lamt * d * n )+ ((lamt * d * n) *0.14));
                                 
                    }
                    
                else
                {
                    System.out.println("Booking cancelled.Thank You!");
                    //Clear the array booked[] with the number of rooms that are not confirmed.
                    for(int j=0;j<rcount;j++)
                     {
                         for(int k=rcount;k<c;k++)
                         {
                             if(booked[k] == booked[j])
                                    booked[j]=0;
                          }
                    }
                     rcount = rcount - n;       //decrement the room count by n times, since 'n' number of rooms not confirmed.
                    }
             }
            else
                {
                    System.out.println("Room Not available! Kindly enter another room number "); 
                    rcount = rcount -n;     /* If wrong room number entered or room not available, 
                                             decrement the room count by 'n' times.*/
                   }
                   
            }while(flag == false);          // Loop to re-enter the room numbers if its not available
             
        
        System.out.println("The number of rooms booked is:  " +rcount);
       return billamt1;             //Return the billamt1 back to the function accomodation()
    }/* End of Function LifeStyle */
    

 //Function for deluxe type rooms
    public double Deluxe()
    {
     
        Boolean flag = false;             //Boolean variable to hold a true value if the room gets booked.
        char ch;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Deluxe Room");
        System.out.println("**************");
        System.out.println(" It is a 295 Sq ft of a very private area crafted to meet every need");
        System.out.println(" and give a personal feel. The understated luxury, the finishing touches,");
        System.out.println("the wooden flooring only goes to make your business trip a real pleasure.");
        System.out.println();
        System.out.println("The In-Room facilities provided are:");
        facilities("");     //Overloaded function call to display the facilities offered with Deluxe type rooms
        System.out.println();
        System.out.println("The cost per day (Bed and Breakfast) is: Rs." +damt);
        System.out.println("*****Additional tax applicable*****");
        System.out.println();
        System.out.println("How many Rooms do you want to book? ");
        n = sc.nextInt();           // variable to hold the number of rooms 
        System.out.println("Enter the number of days you want to stay");
        d = sc.nextInt();           //variable to hold the number of days of stay
       
        do
        {
            c = n+rcount;           //Counter that increments the j value to the next level of entry
        //Enter the room numbers into the array booked[]
        System.out.println("Enter a room number between 201 and 270.");
        for(int j=rcount;j<c;j++)
        {
              booked[j] = sc.nextInt();  
                rcount++;
         }
       
        System.out.println("Please wait... While we check for the availability of the rooms");
        System.out.println();
        
            //Checking the availability of rooms in the original array drooms[] for the room numbers in array booked[]
                for(int i =0;i<drooms.length;i++)
                {
                    for(int j =0;j<c;j++)
                    {
                    if(drooms[i]==booked[j] && drooms[i] !=0)
                        flag = true;
                }
            }
            if(flag == true)
            {
                System.out.println("Room available!Should we confirm your booking?");
                System.out.println("Enter 'Y' or 'y' for yes and 'N' or 'n' for No");
                ch = sc.next().charAt(0);
                if(ch == 'Y' || ch == 'y')
                  {
                      System.out.println("Booking confirmed!Thank you for choosing The Atria Bangalore");
                      
                          //Clear the room numbers in the original array if the room gets booked.
                          for(int i=0;i<drooms.length;i++)
                          {
                              for(int j=0;j<rcount;j++)
                              {
                                    if(booked[j] == drooms[i])
                                        drooms[i] =0;
                                    }
                                }
                          //Once the room gets booked, calculate the bill amt 
                         //the original bill amt is added to the new billamt of the same room type
                         billamt2 = billamt2 + ((damt * d * n )+ ((damt * d * n) *0.14));;
                    }
                    
                else
                {
                    System.out.println("Booking cancelled.Thank You!");
                  //Clear the array booked[] with the number of rooms that are not confirmed.
                    for(int j=0;j<rcount;j++)
                     {
                         for(int k=rcount;k<c;k++)
                         {
                             if(booked[k] == booked[j])
                                    booked[j]=0;
                          }
                    }
                     rcount = rcount - n;           //decrement the room count by n times, since 'n' number of rooms not confirmed.
                  }
             }
            else
                {
                    System.out.println("Room Not available! Kindly enter another room number ");
                   rcount = rcount - n;     /* If wrong room number entered or room not available, 
                                             decrement the room count by 'n' times.*/
                }
                   
            }while(flag == false);           // Loop to re-enter the room numbers if its not available
             
        
        System.out.println("The number of rooms booked is:  " +rcount);
        return billamt2;         //Return the billamt2 back to the function accomodation()
     }   /* End of Function Deluxe */

        
   //Function for Standard type rooms
    public double Standard()
    {
     
        Boolean flag = false;               //Boolean variable to hold a true value if the room gets booked.
        char ch;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Standard Room");
        System.out.println("**************");
        System.out.println(" Our Standard rooms are quite spacious with the area of 295 Sq. Ft and ");
        System.out.println("still hold the old world charm with carpeted floor.");
        System.out.println();
        System.out.println("The In-Room facilities provided are:");
        facilities("");         //Overloaded function call to display the facilities offered with Deluxe type rooms
        System.out.println();
        System.out.println("The cost per day (Bed and Breakfast) is: Rs." +samt);
        System.out.println("*****Additional tax applicable*****");
        System.out.println();
        System.out.println("How many Rooms do you want to book? ");
        n = sc.nextInt();               // variable to hold the number of rooms 
        System.out.println("Enter the number of days you want to stay");    
        d = sc.nextInt();               // variable to hold the number of days of stay.
       
        do
        {
            c = n+rcount;               //Counter that increments the j value to the next level of entry
        
          //Enter the room numbers into the array booked[]
          System.out.println("Enter a room number between 101 and 170.");
          for(int j=rcount;j<c;j++)
          {
              booked[j] = sc.nextInt();  
                rcount++;
           }
       
          System.out.println("Please wait... While we check for the availability of the rooms");
          //Checking the availability of rooms in the original array drooms[] for the room numbers in array booked[]
                for(int i =0;i<srooms.length;i++)
                {
                    for(int j =0;j<c;j++)
                    {
                    if(srooms[i]==booked[j] && srooms[i] !=0)
                        flag = true;
                }
            }
            if(flag == true)
            {
                System.out.println("Room available!Should we confirm your booking?");
                System.out.println("Enter 'Y' or 'y' for yes and 'N' or 'n' for No");
                ch = sc.next().charAt(0);
                if(ch == 'Y' || ch == 'y')
                  {
                      System.out.println("Booking confirmed!Thank you for choosing The Atria Bangalore");
                      
                    //Clear the room numbers in the original array if the room gets booked.
                          for(int i=0;i<srooms.length;i++)
                          {
                              for(int j=0;j<rcount;j++)
                              {
                                    
                                    if(booked[j] == srooms[i])
                                        srooms[i] =0;
                                    }
                                }
                          //Once the room gets booked, calculate the bill amt 
                         //the original bill amt is added to the new billamt of the same room type
                         billamt3 = billamt3 + ((samt * d * n )+ ((samt * d * n) *0.14));
                    }
                  
                else
                 {
                     System.out.println("Booking Cancelled.Thank You!");
                     //Clear the array booked[] with the number of rooms that are not confirmed.
                     for(int j=0;j<rcount;j++)
                     {
                         for(int k=rcount;k<c;k++)
                         {
                             if(booked[k] == booked[j])
                                    booked[j]=0;
                          }
                    }
                     rcount = rcount - n; //decrement the room count by n times, since 'n' number of rooms not confirmed.
             }
            }
            else
                {
                    System.out.println("Room Not available! Kindly enter another room number ");
                   rcount = rcount - n;         /* If wrong room number entered or room not available, 
                                             decrement the room count by 'n' times.*/
                }
                   
            }while(flag == false);           // Loop to re-enter the room numbers if its not available
             
        
        System.out.println("The number of rooms booked is:  " +rcount);
        return billamt3;                    //Return the billamt3 back to the function accomodation()
      }
              /* End of Function Standard */
      
        
      //Function to display the amenities at the hotel

     public void facilities(char c)
    {
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("24 hour check-in/check-out");
      System.out.println("24 hour front desk");
      System.out.println("24 hour room service");
      System.out.println("Authentic & Specialty Restaurant");
      System.out.println("Doctor on call");
      System.out.println("Laundry/Dry Cleaning Service");
      System.out.println("Travel Desk");
      System.out.println("Gift and Fitness Center");
      System.out.println();
    }
  //Function overloading - displays the facilities of Lifestyle type rooms
  public void facilities()
  {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Complimentary Welcome drink with a fruit basket");
    System.out.println("Free access to the fitness center for 2 sessions");
    System.out.println("Direct Dial Phone");
    System.out.println("Daily choice of complimentary newspapers");
    System.out.println("Wireless Internet Service");
    System.out.println("Multi-channel entertainment");
    System.out.println("Electronic safe");
    System.out.println("Coffee Maker");
    System.out.println("hair Drier");
    System.out.println("Free breakfast");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~");
  }

  //Function overloading - displays facilities of Deluxe rooms
    public void facilities(String[] args)               
   {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Complimentary Welcome drink");
    System.out.println("Direct Dial Phone");
    System.out.println("Multi-channel entertainment");
    System.out.println("Electronic safe");
    System.out.println("Free breakfast");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   }
   //Function overloading- displays facilities of standard rooms
    public void facilities(String s)       
   {
     System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
     System.out.println("Direct Dial Phone");
     System.out.println("Multi-channel entertainment");
     System.out.println("Electronic safe");
     System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   }

    //Function to calculate the bill, by taking the individual billamount of different categories of rooms as parameters.
    public void Billing(double b1,double b2,double b3)
  {    
      String rtype ="";
    System.out.println("\t\t\t\tBill details\t\t");
    System.out.println("*********************************************************************");
    System.out.println("Name                : \t " +name);
    System.out.println("Address             : \t " +addr);
    System.out.println("Phone Number        : \t " +phno);
    System.out.println("Duration of stay    : \t "+ d + " days  " + (d-1) + " nights");
    System.out.println("Total Number of rooms booked:  " +rcount);
    System.out.println("You have booked the following rooms");
    System.out.println("Sl.No\t\t Room type\t\t\t\t   Room No. ");
    
    for(int j=0;j<rcount;j++)
    {
        if(booked[j]>=301 && booked[j]<=360) 
        {
            System.out.println(+(j+1)+"\t\t LifeStyle room(Bed 'n' Breakfast)\t\t" +booked[j]);
            System.out.println();
          }
        else if(booked[j]>=201 && booked[j]<=270)
         {
            System.out.println(+(j+1)+"\t\t Deluxe room(Bed 'n' Breakfast)\t\t\t" +booked[j]);
                    System.out.println();
          }  
        else if(booked[j]>=101 && booked[j]<=170)
        {
            System.out.println(+(j+1)+"\t\t Standard Room\t\t\t\t\t" +booked[j]);
                    System.out.println();
          }
             
      }
       
    System.out.println("The total bill amount with 14% Service tax + VAT added is :  " +(b1+b2+b3));
    System.out.println();
    System.out.println("**********************************************************************");
  } //End of function Billing



} // End of class 'HotelManagement'
    
