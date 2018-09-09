package smd.assignment;

/**
 *
 * @author Muhammad Faiq
 */
public abstract class GeneralGuidelines 
{
      int Garage;
      final int height = 50;
      final int width = 100;
      int arr[] = new int[1];
////////  non abstract methods //////////     
     void show_purpose()
    {
        System.out.println("Below are the general guidelines and specifications of building approved by Planning department" + '\n');
        //// Unchecked exception ////
        try
        {
          arr[10] = 0;  
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
         System.out.println("**** ARRAY OUT OF BOUNDS ECEPTION  *****" + '\n');   
        }
        try
        {
            int num = 5/0;
        }
        catch(ArithmeticException e)
        {
           System.out.println("***** ARITHMETIC EXCEPTION *****" + '\n');         
        }
    }
     public final void ShowHeight()
     {
         System.out.println("Height of the building is: " + height + "ft. " + '\n');
     }
     public final void ShowWidth()
     {
         System.out.println("Width of the building is: " + width + "ft. " + '\n');
     }
    
      
///////   abstract method     //////////     
     abstract void garageStatus(int Status);
    

}
