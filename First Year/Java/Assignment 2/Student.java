/* Richmond Arthur
ARTRIC001
2 August 2018
Program to create a simple Student class to Store and retrieve info*/

public class Student
{
   private String firstName;
   private String middleName;
   private String lastName;
   
   public void setNames(String first,String middle,String last)
   {
       firstName = first;
       middleName = middle;
       lastName = last;
   }
   
   public String getFullName()
   {
       String fullName = firstName + " " + middleName.charAt(0) + ". " + lastName;
       return fullName;
   }
}
