/* Richmond Arthur
ARTRIC001
9 August 2018
Program to test Meteorology*/

import java.util.Scanner;
public class Meteorology
{
   public static void main(String [] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Meteorology Program");
      System.out.println("Make a selection and press return:");
      System.out.println("1. Record a temperature reading.");
      System.out.println("2. Record a pressure reading.");
      System.out.println("3. Record a humidity reading. ");
      System.out.println("4. Print maximum values. ");
      System.out.println("5. Print minimum values. ");
      System.out.println("6. Print average values.");
      System.out.println("7. Quit. ");
      
      int input = keyboard.nextInt();
      int value;
      Collator x = new Collator("Temperature");
      Collator y = new Collator("Pressure");
      Collator z = new Collator("Humidity");

      while(input != 7){
               
               if(input == 1)
               {
                  System.out.println("Enter value: ");
                  value = keyboard.nextInt();
                  x.recordReading(value);
                 // System.out.println(x.maximum());
               }else if(input == 2)
               {
                    System.out.println("Enter value: ");
                    value = keyboard.nextInt();
                    y.recordReading(value);
               }else if(input == 3)
               {
                    System.out.println("Enter value: ");
                    value = keyboard.nextInt();
                    z.recordReading(value);
               }else if(input == 4)
               {
                  if (x.maximum() != 0)
                  {
                        System.out.println("Maximum temperature: " + x.maximum());
                  }else{
                        System.out.println("Maximum temperature: -");
                  
                  }if (y.maximum() != 0){
                        System.out.println("Maximum pressure: " + y.maximum());
                  }else{
                        System.out.println("Maximum pressure: -");
                             
                  }if (z.maximum() != 0){
                        System.out.println("Maximum humidity: " + z.maximum());
                  }else{
                        System.out.println("Maximum humidity: -");
                  
                  }
                        
                        
              }else if(input == 5)
              {
                  if (x.minimum() != 0)
                  {
                        System.out.println("Minimum temperature: " + x.minimum());
                  }else                  {
                       System.out.println("Minimum temperature: -");
                  }
                  
                  if (y.minimum() != 0){
                        System.out.println("Minimum pressure: " + y.minimum());
                  }else {
                       System.out.println("Minimum pressure: -");

                  }if (z.minimum() != 0){
                        System.out.println("Minimum humidity: " + z.minimum());
                  
                  }else {
                       System.out.println("Minimum humidity: -");
                  }
                  
               
             
              }else if(input == 6)
                    {
                          if (x.average() != 0)
                        {
                              System.out.println("Average temperature: " + x.average());
                         }else
                        {
                             System.out.println("Average temperature: -");
     
                          
                        }if (y.average() != 0){
                              System.out.println("Average pressure: " + y.average());
                        }else{
                             System.out.println("Average pressure: -");

                        }if (z.average() != 0){
                              System.out.println("Average humidity: " + z.average());
                        }else{
                             System.out.println("Average humidity: -");
                        }
                        
              
                   }
         
         System.out.println("Make a selection and press return:");
         System.out.println("1. Record a temperature reading.");
         System.out.println("2. Record a pressure reading.");
         System.out.println("3. Record a humidity reading. ");
         System.out.println("4. Print maximum values. ");
         System.out.println("5. Print minimum values. ");
         System.out.println("6. Print average values.");
         System.out.println("7. Quit. ");         
         input = keyboard.nextInt();

        }
   }
}



            