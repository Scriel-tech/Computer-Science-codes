/* Richmond Arthur
ARTRIC001
12 August 2018
Program to create class counterDisplay */

public class CounterDisplay
{
   private int value;
   private int limit;
   
   public CounterDisplay(int pLimit)
   {
      limit = pLimit;
      value = 0;
   }
   
   public void setValue(int pValue)
   {
      value = pValue;
   }
   
   public int getValue()
   {
      return value;
   }
   
   public void increment()
   {
      if (value + 1 == limit)
      {
         value = 0;
      }else{
         value +=1;
      }
         
   }
   
   public String getDisplayValue()
   {
      String ret;
      if (value < 10)
      {
         ret = "0" + value;
      }else{
         ret = Integer.toString(value);
      }
      return ret;
   }
   
}
      