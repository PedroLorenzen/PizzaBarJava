import java.time.*; 
import java.util.*;
import java.io.*;
import java.text.*;
  
public class LokalTid 
{ 
   public LocalTime tid()throws ParseException
   {    

      Scanner s = new Scanner(System.in);
      LocalTime time = LocalTime.now(); 

      System.out.print("Hvor lang før de henter pizzaen: ");

      int x = s.nextInt();

      System.out.println("*************************************************");

      LocalTime value = time.plusMinutes(x);
      
      return value;

   } 
} 
