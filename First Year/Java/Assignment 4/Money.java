/* Richmond Arthur
ARTRIC001
17 August 2018
Program to create a currency class for performing various methods;
*/

public class Money
{
   private Currency currency;
   private long minorUnitAmount;
   
   public Money(String amount, Currency currency)
   {  
      this.currency = currency;
      long minor = currency.parse(amount);
      minorUnitAmount = minor;
   }
   
   public Money(long minorUnitAmount, Currency currency)
   {
      this.currency = currency;
      this.minorUnitAmount = minorUnitAmount;
   }
   
   public long longAmount()
   {
      return minorUnitAmount;
   }
   
   public Currency currency()
   {
      return this.currency;
   }
   
   public Money add(Money other)
   {
      Money r3;
      if (this.currency == other.currency)
      {  
         long newAmount = this.minorUnitAmount + other.minorUnitAmount;
         r3 = new Money(newAmount, currency);
         return r3;
      }
      else
      {
         r3 = null;
         return r3;
      }
   }
   
   public Money subtract(Money other)
   {
      Money r3;
      if (this.currency == other.currency())
      {
         long newAmount = this.minorUnitAmount - other.minorUnitAmount;
         r3 = new Money(newAmount, currency);
         return r3;
      }
      else
      {
         r3 = null;
         return r3;
      }
   }
   
   public String toString()
   {
      return currency.format(minorUnitAmount);
   }
   
    public boolean equal(Money other)
   {  
      return (this.currency == other.currency &&  this.minorUnitAmount == other.minorUnitAmount);
   }
}