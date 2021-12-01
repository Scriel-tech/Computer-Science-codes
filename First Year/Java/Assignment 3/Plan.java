/* Richmond Arthur
ARTRIC001
15 August 2018
Program to create a mobile Account class supported by a Plan class
The Plan class is simply the mobile plan the user is on*/

public class Plan
{
   private String name;
   private int callRate;
   
   public Plan(String name, int callRate)
   {
      this.name = name;
      this.callRate = callRate;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public int getCallRate()
   {
      return this.callRate;
   }
   
}
