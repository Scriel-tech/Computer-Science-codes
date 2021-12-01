/*Program to convert time between 24 and 12 hour formats
Richmond Arthur
ARTRIC001
26 July 2018*/

import java.util.Scanner;

public class TimeConvertor
{
   public static void main(String[] args)
   {
      Scanner keyboard= new Scanner(System.in);
      System.out.println("Enter a time ([h]h:mm [am|pm]):");
      String time = keyboard.nextLine();
      int lenght=time.length(); /* The lenght of the input*/
      if (time.indexOf('m')!= -1){ /* This is to check if the input is in 12 hour format*/
          if (time.indexOf('a')!=-1){ /* This is to check if the input is am or pm*/
              String newTime = time.substring(0,lenght-2);
              if (time.indexOf(":") == 2 ){/* /problem with the time 12:00 am */
                  if (Integer.parseInt(time.substring(0,2)) != 12) {
                     System.out.println(newTime);
                } else {
                     System.out.println("00" + time.substring(2,lenght-2));
                     }
             } else {
                   System.out.println("0"+newTime);
                   }
         } else {
            if (Integer.parseInt(time.substring(0 , time.indexOf(":")))  == 12){
                 int newHour =Integer.parseInt( time.substring(0,time.indexOf(":"))); /* Changing a string to an integer type*/
               String newTime= time.substring(2,lenght-2);
               newTime=Integer.toString(newHour)+ newTime; /* Changing a string type to onteger type*/   
               System.out.println(newTime);     
            } else {
               int newHour =Integer.parseInt( time.substring(0,time.indexOf(":"))); /* Changing a string to an integer type*/
               newHour+=12 ;
               String newTime= time.substring(2,lenght-2);
               newTime=Integer.toString(newHour)+ newTime; /* Changing a string type to onteger type*/  
               System.out.println(newTime);
               }
              }
     } else { /* If the time is not in 12 hour format*/
               int hourindx = time.indexOf(":");
               int hour = Integer.parseInt( time.substring(0,hourindx));/* This is to check the value of the hour*/
               if (hour <=12) {
                   if (hour == 0) {
                        System.out.println("12:" + time.substring(hourindx+1 , hourindx+3) + " am");
                 } else {
                        System.out.println(time.substring(1) + " am");
                   }
             } else {
                   hour-=12;
                   String newTime =Integer.toString(hour) + time.substring(2) + " pm" ;
                   System.out.println(newTime);
                  }
       }    
   }
}
