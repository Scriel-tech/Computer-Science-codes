/* Richmond Arthur
ARTRIC001
30 July 2018
Test1*/

import java.util.Scanner;
public class TestF
{
   public static void main(String[] args)
   {
   
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter the height: ");
      int input = keyboard.nextInt();
      int x,y,z,a;
      int c=0;
      int d=input-3;
      for(x=1; x<=input;x++)
      {
         System.out.print("*");
      }
      System.out.println();
      for(a=input-1; a>=1; a--)
      {
         for (y=0;y<=c ;y++ )
         {
             System.out.print(" "); 
         }
         System.out.print("*");
         for (z=d; z>=1; z-=1)
         {
             System.out.print(" ");
         }
         d-=1;
         if (a!=1){
         System.out.println("*");
         }
         c+=1;
      }
   } 
}