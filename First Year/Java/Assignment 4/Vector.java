/* Richmond Arthur 
ARTRIC001
Progrsm to create a vector class
22 August 2018
*/

import java.text.DecimalFormat;

public class Vector
{
   private double horizontal;
   private double vertical;
   private double hypothenuse;
   
   public Vector(double horizontal, double vertical)
   {  
      this.horizontal = horizontal;
      this.vertical = vertical;
   }
   
   private double magnitude()
   {  
      hypothenuse = (horizontal * horizontal)+(vertical * vertical);
      hypothenuse = Math.sqrt(hypothenuse);
      hypothenuse = round(hypothenuse);
      return hypothenuse;

   }  
   
   private double round(double value)
   {
      DecimalFormat df = new DecimalFormat("#0.00"); 
      String val = df.format(value);
      double newValue = Double.parseDouble(val);
      return newValue;
   }

   
   public double getMagnitude()
   {
      hypothenuse = magnitude();
      return hypothenuse;
   }
   
   public Vector add(Vector other)
   {
      double newHorizontal = this.horizontal + other.horizontal;
      double Horizontal = round(newHorizontal);
      double newVertical = this.vertical + other.vertical;
      double Vertical = round(newVertical);
      Vector r3 = new Vector( Horizontal, Vertical);
      return r3;
   }
   
   public Vector multiply(double m) 
   {
      double Horizontal = round(this.horizontal * m);
      double Vertical = round(this.vertical * m);
      Vector r3 = new Vector(Horizontal , Vertical);  
      return r3;
   }
   
   public double dotProduct(Vector other)
   {
      double newHorizontal = this.horizontal * other.horizontal;
      double Horizontal = round(newHorizontal);
      double newVertical = this.vertical * other.vertical;
      double Vertical = round(newVertical);
      return (Horizontal + Vertical);
   }
   
   public String toString()
   {
      DecimalFormat df = new DecimalFormat("#0.00");
      return ("v = (" + df.format(horizontal) + ", " + df.format(vertical) + ")");
   }
   
   public boolean equals(Vector other)
   {
      return (this.horizontal == other.horizontal && this.vertical == other.vertical);
   }
}