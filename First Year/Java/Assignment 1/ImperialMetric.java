/* A program to convert inches and feets to metres
Richmond Arthur
ARTRIC001
27 July 2018 */

import java.util.Scanner;
public class ImperialMetric
{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner( System.in);
        String doubleComma= "\"";
        System.out.println("Enter the minimum number of feet (not less than 0):");
        int min = keyboard.nextInt();
        System.out.println("Enter the maximum number of feet (not more than 30):");
        int max = keyboard.nextInt();
        String straightArrow = "|";
        System.out.printf("%4s", straightArrow);
        for (int i=0; i<12 ; i+=1) {/* line 16 to 21 the first line of output indicates inches*/
           String input = Integer.toString(i) + doubleComma;
           System.out.printf("%6s",input);
           }
        System.out.println();
        for (int feet=min; feet<max+1; feet+=1) {/* This loop does the rest of the output. This first loop does columns*/
           String nextInput = Integer.toString(feet) + "\'";
           System.out.printf("%-3s"+"|",nextInput);
           for (double inches=0; inches<12; inches+=1) {/* This loop does the rows*/
              double newInches= (feet*12) + inches;
              double metres= (newInches*2.54)/100.0;
              System.out.printf("%6.3f",metres);
              }
           System.out.println();       
           }
    }
}
