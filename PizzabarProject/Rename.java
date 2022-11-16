import java.util.*;
import java.text.*;
import java.io.*;


public class Rename
{
   public void change()
   {
      File file = new File("GemteBestillinger.txt");
      Date date = new Date();
      SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
      StringBuilder str = new StringBuilder();
      str.append(ft.format(date));
      String st ="" + str + ".txt";
      boolean b = file.renameTo(new File(st));
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