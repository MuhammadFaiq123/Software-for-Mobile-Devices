package smd.assignment;
import java.util.Scanner;
/**
 *
 * @author Muhammad Faiq
 */

public class Building extends GeneralGuidelines implements SchoolInterface,AcademyInterface,ElectionCentreInterface
{
    static int rooms;
 
    Scanner input = new Scanner(System.in);
    
    
////////// Overridding methods from interfaces  /////////////    
     public void Election_Timetable() 
    {
      System.out.println("Builidng will get a stauts of Election centre only when notified by Election commission" + '\n'); 
    }
    
     public void School_timetable()
    {
     System.out.println("Timings of school will be :" + '\n' + "8:00 a.m  to  2:00 p.m" + '\n');   
     
    }
    
     public void Academy_timetable()
    {
         System.out.println("Timings of Academy will be :" + '\n' + "4:00 p.m  to  9:00 p.m" + '\n');
    }
     
     public void takeValues()
    {
        int temp;
      
       System.out.println("Enter the number of rooms = ");
       temp = input.nextInt();
       
       updateRooms(temp);
       
       System.out.println("Enter 1 if you want to allote space to garage. " + '\n' + "Enter 0 if you don't want to allot space to garage" + '\n');
       temp = input.nextInt();
       
       garageStatus(temp);
    }
     
     public static void updateRooms(int new_rooms)
     {
         rooms = new_rooms;
         
     }

     
     
////// overridding abstract method from generalGuidelines class ///////      
     public void garageStatus(int Status)
     {
         
         Garage = Status;
     }
    
/////////    Inner non-static class //////////////////// 
     public class Room 
     {
         int width;
         int height;
         int chairs;
         Room()
         {
           width = 5;
           height = 5;
         }
         void SetChairs()
         {
             System.out.println("Enter number of chairs you want in each room:");
             chairs = input.nextInt();
         }
     }
     
     
////////     Inner static class    ////////////////////
     public static class Garage
     {
          int capacity;
          Garage()
         {
            capacity = 2; //for 2 cars
         }
     }
}
