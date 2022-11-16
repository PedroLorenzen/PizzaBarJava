import java.util.*;
import java.text.*;
import java.io.*;


public class Rename
{
   public void change()
   {
      File file = new File("GemteBestillinger.txt");
      Date date = new Date();
// Her vælger vi class Date som har forskellige subclasses, f.eks. SimpleDateFormat. 
      SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
      StringBuilder str = new StringBuilder();
// Her laver vi en ny String. 
      str.append(ft.format(date));
// StringBuilder skriver datoen men formateret til dage, måneder, år.
      String st ="" + str + ".txt";
// Her laver vi så en String som får den valgte dato. 
      boolean b = file.renameTo(new File(st));
// hvis filen bliver omdøbt så printer systemet nedenstående, ellers det nedenunder. Man kan også bare lave en sentinel. 
      if (b == true)
      {
         System.out.println("");
         System.out.println("******************************************************");
         System.out.println("Afhentede bestillinger for i dag  er gemt med navnet | " + str + " |");
         System.out.println("******************************************************");

      }
      else
      {
         System.out.println("**********************Error**********************");
         System.out.println("                Fil ikke fundet");
         System.out.println("*************************************************");
      }
   }
}