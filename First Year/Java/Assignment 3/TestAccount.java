/* Richmond Arthur
ARTRIC001
15 August 2018
Program to create a mobile Account class supported by a Plan class */

import java.util.Scanner;
public class TestAccount
{
   public static void main(String [] args)
   {
      Plan one = new Plan("Expensive" , 10);
      Account Steve = new Account(111000, one);
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Choose one of the options and press return:");
      System.out.println("0. quit.");
      System.out.println("1. getBalance.");
      System.out.println("2. TopUp.");
      System.out.println("To call enter number.");
      int input = keyboard.nextInt();
      System.out.println("You chose option " + input);
      
      while (input != 0)
      {  
         if (input == 0)
         {
            break;
         }
         
         else if (input == 1)
         {
            System.out.println("Your Balance is " +Steve.getBalance());
         }
         
         else if (input == 2)
         {
            System.out.println("Enter a value:");
            int value = keyboard.nextInt();
            Steve.increment(value);
         }
         
         else
         {
            System.out.println("Enter call lenght: ");
            int lenght = keyboard.nextInt();
            if (Steve.getBalance() > 0)
            {
               System.out.println("Your Account balance is " + Steve.getBalance() + ". Enjoy your call");
               Steve.call(lenght);
            }
            else
            {
               System.out.println("Your Account Balance is 0. Please recharge to make a call.");
            }
         }
         System.out.println("Choose one of the options and press return:");
         System.out.println("0. quit.");
         System.out.println("1. getBalance.");
         System.out.println("2. TopUp.");
         System.out.println("To call enter number.");
         input = keyboard.nextInt();
         //System.out.println("You chose option " + input);
            
      }
      
   }
} 