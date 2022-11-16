import java.io.*;
import java.util.*;

public class Arkivering
{
   
   public static void removeRecord(String filepath, int deleteLine)
   {
      
      String tempFile = "temp.txt";
      File oldFile = new File(filepath);
      File newFile = new File(tempFile);
      
      int line = 0;
      String currentLine;
      
      try
      {
         FileWriter fw = new FileWriter(tempFile,true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         
         FileReader fr = new FileReader(filepath);
         BufferedReader br = new BufferedReader(fr); 
         
         while((currentLine = br.readLine()) != null)
         {
            line++;
            
            if(deleteLine != line)
            {
               pw.println(currentLine);
            }
         }
         
         pw.flush();
         pw.close();
         fr.close();
         br.close();
         bw.close();
         fw.close();
         
         oldFile.delete();
         File dump = new File(filepath);
         newFile.renameTo(dump);
      
      }
      catch(Exception e)
      {
         System.out.println(e);
      }
   
   }  
      
} 

