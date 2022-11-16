import java.time.*; 
import java.util.*;
import java.io.*;
import java.text.*;
  
public class LokalTid 
{ 
   public LocalTime tid()throws ParseException
   {    

      Scanner s = new Scanner(System.in);
// henter class Scanner. 
      LocalTime time = LocalTime.now(); 
// Giver os den likale tid nu. 
      System.out.print("Hvor lang før de henter pizzaen: ");

      int x = s.nextInt();
// Læser hvad man skriver i terminalen.  
      System.out.println("*************************************************");

      LocalTime value = time.plusMinutes(x);
// ligger tiden nu sammen med det tal man skriver - som så analyseres som minutter.       
      return value;

   } 
} 
