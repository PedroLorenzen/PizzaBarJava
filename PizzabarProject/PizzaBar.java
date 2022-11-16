import java.util.*;
import java.io.*;
import java.awt.Desktop;
import java.time.*;

public class PizzaBar
{    
   public static void main (String[] args)throws Exception
// throws Exception fanger og viser alle problemer som opstår når den kører, men lader programmet køre med fejlende. 
   {
      
      String inputToken = "";
      String fileName = "";
      String order = "humhum";
      
      int menu = 1;

      boolean sentinel;
// Sentinel er en måde at lave en boolean som kontrollerer et loop. Så det er en form for vogter om loopet. 
// Man behøver ikke bruge if sentinel = false; Man kan også skrive: if !sentinel. 
      boolean fileExists = false;
      
      Scanner user = new Scanner (System.in);
// Her laver vi en ny scanner som læser hvad vi skriver i consollen. 
      Scanner stringAnalyze = new Scanner(inputToken);
// InputToken??      
      Scanner readFile = new Scanner(new File("AktiveBestillinger.txt"));
// Her laver vi en scanner der skal lede efter en valgt fil.
      File fAktiv = new File("AktiveBestillinger.txt");        
      File fPizza = new File("pizzaer.txt");
      File fGemte = new File("GemteBestillinger.txt");
// Her vælger vi at lave 3 variabler som indeholder hver sin fil, så filerne let kan kaldes. 
      
      FileWriter gemte = new FileWriter("GemteBestillinger.txt");
      FileWriter aktive = new FileWriter("AktiveBestillinger.txt");
// Her vælger vi at lave en variabel til class FileWriter som, hvis boolean true vil append/skrive i en fil. 
// Append betyder at man skriver i slutningen af dokumentet, efter det der allerede er skrevet, og ikke overrider noget.
      PrintStream writeFileGemte = new PrintStream(new FileOutputStream("GemteBestillinger.txt", true)); 
// PrintStream giver os en class som gør at vi kan printe info. 
// FileOutPutStream vælger vi at printe til en fil og arbejder sammen med PrintStream (navn på String/fil, boolean append).
// Begge er subclasses til class OutputStream.
      BufferedWriter bw = new BufferedWriter(aktive);
// Bufferedwriter er god hvis du skal læse/skrive flere linjer, da dataen fylder mindre i systemet vs. filewriter. 
// Bufferedwriter skal kun bruges hvis der arbejdes med flere linjer ad gangen (sortering o.a.) ellers så brug filewriter. 

      PizzaList l = new PizzaList();
// Kalder class Pizzalist og laver en ny instans af denne class. PizzaList() en constructor, så vi konstruerer et nyt objekt.
      LokalTid u = new LokalTid();
      Arkivering m = new Arkivering();
      Rename c = new Rename();
      Desktop desktop = Desktop.getDesktop();
// Desktop er en class som hentes og kan bruges til at åbne filer/applikationer på pc'en. 
// Her konstruerer vi en instans med metoden getDesktop som henter den lokale pc, så man kan arbejde med den.

   do
   {     
      menu = Start.callMenu();
// Her kalder vi vores class Start og metoden callMenu som kører vores menu. 

      if (menu == 0)
      {
         System.out.println("Progammet lukker og gemmer nu betalte bestillinger for i dag");
         c.change();
// En constrctor højere oppe har lavet ny instans med navnet c der kalder Rename class og metoden change.
         break;
// stopper loopet. Bedst at bruge en boolean her af en art. 
      }
      else if (menu == 1)
      {
         if (fPizza.exists()) 
         {
            try
            {
               desktop.open(fPizza);
 // Her åbner vi fPizza fil, man kan også skrive: if (Desktop.isDesktopSupported()){try...};
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
// PrintStream giver os en class som gør at vi kan printe info. 
// FileOutPutStream vælger vi at printe til en fil og arbejder sammen med PrintStream (navn på String/fil, boolean append).
// Begge er subclasses til class OutputStream.
         Pizza p = l.list();
// l kommer fra PizzaList class, list er metoden. Her laver vi en ny variabel ud fra instanten vi lavede højere oppe.  
         LocalTime lt = u.tid();
// u kommer fra class LokalTid og tid er metoden. 
         writeFileAktive.printf("%.5s",lt);
// printf() er er en metode som formaterer det som man skriver. Det starter altid med % og så kommandoen/teksten. 
// "%.5s" betyder at man kun tager de 5 første tegn i vores string. lt bruger vores metode. 
         writeFileAktive.println(" " + p);
// p kommer fra l.list()
         try {
               FileReader fr = new FileReader(fAktiv);
// FileReader åbner filen og indlæser den i vores software. 
               BufferedReader br = new BufferedReader(fr);
// Buffer er en måde at gemme info kortvarigt i hukommelsen i stedet for harddisken, så det går meget hurtigere. 
// Læser informationen på den fil som FileReader åbner. 
                  
               List<String> list=new ArrayList<String>();
// Her laver vi en ny arraylist.
               String string;
// Her laver vi en ny String variabel. 
               while((string = br.readLine()) != null)
// Så længe BufferedReader har en linje med String at læse så fortsætter loopet.
               {
                  list.add(string);
// Her tilføjer vi den linje vi læser i bufferedreader til vores arrayList.
               }
               br.close();
// Her lukker vi bufferedReader, så den ikke konstant kører i baggrunden. Så frigiver vi hukommelse til systemet. 
               Collections.sort(list);
// Her sorterer vi listen. 
              FileWriter fileSort = new FileWriter(fAktiv);
// Herefter vil vi gerne skrive til filen. 
               BufferedWriter bufferSort = new BufferedWriter(fileSort);
// Buffered writer fungerer kun i kombination med fileWriter.
               for(String s: list)
// En anden måde at skrive (int s = 0; s < list.size(); s++) {bufferSort.write(list.get(s))}
// https://beginnersbook.com/2013/12/how-to-loop-arraylist-in-java/
               {
                  bufferSort.write(s);
                  bufferSort.write("\n");
// Her skriver vi så en linje ad gangen efterfulgt af en næste linje indtil loopet er færdigt. 
               }
               bufferSort.close();
               System.out.println("\n Filen er sorteret");
// Så lukker vi bufferSort så den ikke fylder i hukommelsen og ellers vil loopet ikke køre og informationen vil forsvinde.

           } 
           catch (Exception e) 
           {
               System.out.print("Der var en fejl med sorteringen \n");
               System.out.println(e);
           }
         bw.newLine();
 // Laver en ny linje så der ikke skrives på samme linje.
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
// kalder desktop instansen og metoden open til filen fAktiv. 
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
// Forbinder variablen inputToken med scanneret (readFile) med metoden nextLine, som scanner hver linje.
         writeFileGemte.println(inputToken);
// PrintStream med navnet writeFileGemte printer til et nyt dokument ud fra hvad inputToken scanner. 
         System.out.println();
         System.out.println("*************************************************");
         System.out.println("            Bestilling er arkiveret.");
         System.out.println("*************************************************");
         System.out.println();
         
             
         //writeFileGemte.println(); Ikke nødvendig, laver blot mellemrum mellem bestillingerne        
         m.removeRecord("AktiveBestillinger.txt",1);
// Her slettes den linje fra aktive bestillinger som lige er blevet kopieret over til gemte bestillinger. 
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