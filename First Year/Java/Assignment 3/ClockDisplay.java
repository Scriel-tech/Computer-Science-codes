/*Richmond Arthur
ARTRIC001
12 AUG 2018
Program to make class Clock Display 
This exercise concerns constructing the display component of a digital clock that uses the 24 hour
system */

public class ClockDisplay
{
   private CounterDisplay Hours;
   private CounterDisplay Minutes;
   
   
   public ClockDisplay(int pHours, int pMinutes)
   {  
      Hours = new CounterDisplay(24);
      Minutes = new CounterDisplay(60);
      Hours.setValue(pHours);
      Minutes.setValue(pMinutes);
   }
   
   public void setTime(int pHours, int pMinutes)
   {
      Hours.setValue(pHours);
      Minutes.setValue(pMinutes);
   }
   
   public void tick()
   {
      Minutes.increment();
      if (Minutes.getValue() == 0)
      {
         Hours.increment();
      }
      
   }
   
   public String getDisplayValue()
   {
     String a = Hours.getDisplayValue()+ ":" + Minutes.getDisplayValue();
   return  a;          
   }
   
   
   
}
