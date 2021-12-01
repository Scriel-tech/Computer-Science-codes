/* Richmond Arthur
ARTRIC001
30 July 2018
Program to check palindromic perfect numbers */

import java.util.Scanner;
import java.lang.Math;
public class PalinPerfect
{
   public static void main( String [] args)
   {  
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter the starting point N:");
      System.out.println("Enter the ending point M:");
      System.out.println("The palindromic perfect squares are as follows:");
      int min = keyboard.nextInt();
      int max = keyboard.nextInt();
      //System.out.println("You entered "+min+" and "+max);
      if (min != 0){
         for (int x=min; x<max; x+=1) {
         double check1 = x;
         double check = Math.sqrt(x);
         if (Math.floor(check)*Math.floor(check) == x){/* If the one decimal is not a zero it is not perfect number*/
             String normal = Integer.toString(x);
             int lenght= normal.length();
             String reverse = new StringBuilder(normal).reverse().toString();
                if ( normal.equals(reverse)){
                System.out.println(x);
             }
           }
         }
      } else {
           for (int x=min + 1; x<max; x+=1) {
            double check1 = x;
            double check = Math.sqrt(x);
            if (Math.floor(check)*Math.floor(check) == x){/* If the one decimal is not a zero it is not perfect number*/
                String normal = Integer.toString(x);
                int lenght= normal.length();
                String reverse = new StringBuilder(normal).reverse().toString();
                   if ( normal.equals(reverse)){
                   System.out.println(x);
                   }
                 }
               }
             }
      
   }
}
