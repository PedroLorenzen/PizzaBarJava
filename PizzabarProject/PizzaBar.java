import java.util.*;
import java.io.*;
import java.awt.Desktop;
import java.time.*;

public class PizzaBar
{    
   public static void main (String[] args)throws Exception
   {
      
      String inputToken = "";
      String fileName = "";
      String order = "humhum";
      
      int menu = 1;

      boolean sentinel;
      boolean fileExists = false;
      
      Scanner user = new Scanner (System.in);
      Scanner stringAnalyze = new Scanner(inputToken);
      Scanner readFile = new Scanner(new File("AktiveBestillinger.txt"));
      File fAktiv = new File("AktiveBestillinger.txt");        
      File fPizza = new File("pizzaer.txt");
      File fGemte = new File("GemteBestillinger.txt");
      
      FileWriter gemte = new FileWriter("GemteBestillinger.txt");
      FileWriter aktive = new FileWriter("AktiveBestillinger.txt");
      PrintStream writeFileGemte = new PrintStream(new FileOutputStream("GemteBestillinger.txt", true)); 
      BufferedWriter bw = new BufferedWriter(aktive);

      PizzaList l = new PizzaList();
      LokalTid u = new LokalTid();
      Arkivering m = new Arkivering();
      Rename c = new Rename();
      Desktop desktop = Desktop.getDesktop();

   do
   {     
      menu = Start.callMenu();

      if (menu == 0)
      {
         System.out.println("Progammet lukker og gemmer nu betalte bestillinger for i dag");
         c.change();
         break;
      }
      else if (menu == 1)
      {
         if (fPizza.exists()) 
         {
            try
            {
               desktop.open(fPizza);
            }
            catch (Exception e)
            {
               System.out.println("**********************Error**********************");
               System.out.println("                File doesn't open");
               System.out.println("*************************************************");
            }
         }            
         else 
         {
            System.out.println("**********************Error**********************");
            System.out.println("                File doesn't exist");
            System.out.println("*************************************************");
         }
      }
      else if (menu == 2)
      {             
         PrintStream writeFileAktive = new PrintStream(new FileOutputStream("AktiveBestillinger.txt",true));
         Pizza p = l.list();
         LocalTime lt = u.tid();
         writeFileAktive.printf("%.5s",lt);
         writeFileAktive.println(" " + p);
         try {
               FileReader fr = new FileReader(fAktiv);
               BufferedReader br = new BufferedReader(fr);
                  
               List<String> list=new ArrayList<String>();
               String string;
               while((string = br.readLine()) != null)
               {
                  list.add(string);
               }
               br.close();
               Collections.sort(list);
              FileWriter fileSort = new FileWriter(fAktiv);
               BufferedWriter bufferSort = new BufferedWriter(fileSort);
               for(String s: list)
               {
                  bufferSort.write(s);
                  bufferSort.write("\n");
               }
               bufferSort.close();
               System.out.println("\n Filen er sorteret");

           } 
           catch (Exception e) 
           {
               System.out.print("Der var en fejl med sorteringen \n");
               System.out.println(e);
           }
         bw.newLine();
         System.out.println();
         System.out.println("*************************************************");
         System.out.println("               Bestilling modtaget! ");
         System.out.println("*************************************************");
         System.out.println();
         writeFileAktive.close();
         
      }
      else if (menu == 3)
      {
         if (fAktiv.exists()) 
         {
            try
            {
               desktop.open(fAktiv);
            }
            catch (Exception e)
            {
               System.out.println("**********************Error**********************");
               System.out.println("                File doesn't open");
               System.out.println("*************************************************");
            }
         }            
         else 
         {
            System.out.println("**********************Error**********************");
            System.out.println("                File doesn't exist");
            System.out.println("*************************************************");
         }
      }
      else if (menu == 4)
      {
         inputToken = readFile.nextLine();
         writeFileGemte.println(inputToken);
         System.out.println();
         System.out.println("*************************************************");
         System.out.println("            Bestilling er arkiveret.");
         System.out.println("*************************************************");
         System.out.println();
         
             
         m.removeRecord("AktiveBestillinger.txt",1);
      }
      else if (menu == 5)
      {
         if (fGemte.exists()) 
            {
               try
               {
                  desktop.open(fGemte);
               }
               catch (Exception e)
               {
                  System.out.println("**********************Error**********************");
                  System.out.println("                File doesn't open");
                  System.out.println("*************************************************");
               }
            }            
            else 
            {
               System.out.println("**********************Error**********************");
               System.out.println("                File doesn't exist");
               System.out.println("*************************************************");
            }

      }
   }while (menu != 0);
   
   }
}