/* Richmond Arthur
ARTRIC001
15 August 2018
Program to create a mobile Account class supported by a Plan class */

public class Account
{
   private int number;
   private Plan plan;
   private int balance;
   
   public Account(int number, Plan p)
   {
      this.number = number;
      this.balance = 0;
      plan = p;
   }
   
   public int getBalance()
   {
      return this.balance;
      // if you have to show them other things such as plan name and call rate ...
   }
   
   public void increment(int amount)
   {
   // Ask Aslam if we allow user to increment as they please
      balance += amount;
   }
   public void call(int no)
   {
      decrement(no);
   }
   
   private void decrement(int callTime)
   {
      int decrease = callTime * plan.getCallRate();
      balance -= decrease;
   }
}