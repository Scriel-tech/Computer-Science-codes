/* Richmond Arthur
ARTRIC001
17 August 2018
Program to create a currency class for performing various methods;
*/

public class Currency
{
   private String symbol;
   private String code;
   private int minorPerMajor;
   
   public Currency(String symbol, String code, int minorPerMajor)
   {
      this.symbol = symbol;
      this.code = code;
      this.minorPerMajor = minorPerMajor;
   }
   
   public String symbol()
   {
      return symbol;
   }
   
   public String code()
   {
      return code;
   }
   
   public int minorPerMajor()
   {
      return minorPerMajor;
   }
   
   public String format(long amount)
   {
      String num = symbol;
      double test =(double) amount/100;
      num = num + String.format("%1.2f",test);
      return num;
   }
   
   public long parse(String amount)
   {
      int len = amount.length();
      double x = Double.parseDouble(amount.substring(1,len));
      long y = (long) ( x* minorPerMajor);
      return y;
   }
}