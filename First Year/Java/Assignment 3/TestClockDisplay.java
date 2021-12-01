
/**
 * Write a description of class TestClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
//
public class TestClockDisplay
{
    private TestClockDisplay() { }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose from the following options:");
        System.out.println("0. quit.");
        System.out.println("1. new ClockDisplay(hours, minutes).");
        System.out.println("2. setTime(hours, minutes).");
        System.out.println("3. tick().");
        System.out.println("4. getDisplayValue().");
        
        ClockDisplay clockDisplay = null;
        
        int selection = scanner.nextInt();
        while  (selection!=0) {
            if (selection==1 || selection==2) {
                System.out.println("Enter hours:");
                int hours = scanner.nextInt();
                System.out.println("Enter minutes:");
                int minutes = scanner.nextInt();
                if (selection==1) {
                    clockDisplay = new ClockDisplay(hours, minutes);
                }
                else {
                    clockDisplay.setTime(hours, minutes);
                }
            }
            else if (selection==3) {
                System.out.println("Advancing time.");
                clockDisplay.tick();
            }
            else if (selection==4) {
                System.out.println(clockDisplay.getDisplayValue());
            }
            else {
                System.out.println("That selection was not recognised.");
            }
            
            System.out.println("Choose from the following options:");
            System.out.println("0. quit.");
            System.out.println("1. new ClockDisplay(hours, minutes).");
            System.out.println("2. setTime(hours, minutes).");
            System.out.println("3. tick().");
            System.out.println("4. getDisplayValue().");
            
                        
            selection = scanner.nextInt();
        }    
    }

}
