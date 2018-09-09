
package smd.assignment;

/**
 *
 * @author Muhammad Faiq
 */
public class SmdAssignment 
{

    public static void main(String[] args) 
    {
       Building.Garage gr = new Building.Garage(); //Accessing static inner class so no need of buuliding object  
        
       Building bd = new Building();
       Building.Room rm = bd.new Room(); //need of building object because accessing non-static object
       
       rm.SetChairs();
       
       bd.show_purpose();
       bd.ShowHeight();
       bd.ShowWidth();
       bd.School_timetable();
       bd.Academy_timetable();
       bd.Election_Timetable();
       bd.takeValues();
      
      
       
     //  Building.updateRooms(0);
    }
    
}
