/* Richmond Arthur 
ARTRIC001
07 August 2018
Program to conduct tests on Collator*/

public class TestCollator
{   
   public static void main(String [] args)
   {   
       Collator trash =new Collator("French");
       
       //Test 1: setLabel
       System.out.println("Test 1");
       trash.label("Ding");
       if (trash.label().equals("Ding"))
       {
          System.out.println("Pass");
       }else{
          System.out.println("Fail");
       }   
       
       //Test 2: recordReading  
       System.out.println("Test 2");
       trash.recordReading(0);
       if (trash.numberOfReadings() == 1)
       {
          System.out.println("Pass");
       }else{
          System.out.println("Fail");
       }
       
       //Test 3: stringLabel
       System.out.println("Test 3");
       
       if(trash.label().equals("French"))
       {
           System.out.println("Pass");
       }else{
           System.out.println("Fail");
       }
       
       //Test 4: Int Maximum
       System.out.println("Test 4");
       if(trash.maximum()== 0)
       {
           System.out.println("Pass");
       }else{
           System.out.println("Fail");
       }
       
       //Test 5: Int minimum
       System.out.println("Test 5");
       if(trash.minimum() == 0)
       {
           System.out.println("Pass");
       }else{
           System.out.println("Fail");
       }
       
       //Test 6:Int Average
       System.out.println("Test 6");
       if(trash.average()== 0)
       {
           System.out.println("Pass");
       }else{
           System.out.println("Fail");
       }
       
   }
}
