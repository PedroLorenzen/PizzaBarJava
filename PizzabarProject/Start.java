import java.util.*;
import java.io.*;

public class Start
{

public static int callMenu()
   {
      Scanner user = new Scanner (System.in);
      int menu = 1;
      boolean sentinel;
         
      do
      {
         try
         {
            System.out.println(" ______________________________________________");
            System.out.println("|                                              |");
            System.out.println("| [0] Afslut og Arkiver fil                    |");
            System.out.println("| [1] Menu                                     |");
            System.out.println("| [2] Ny bestilling                            |");
            System.out.println("| [3] Aktive bestillinger                      |");
            System.out.println("| [4] Arkiver afhentet bestilling              |");
            System.out.println("| [5] Dagens afhentede bestillinger            |");
            System.out.println("|______________________________________________|");
            System.out.println();
            menu = user.nextInt();
      
            if (menu == 0 || menu == 1 || menu == 2 || menu == 3 || menu == 4 || menu == 5)
            {
                sentinel = false;
            }
            else
            {
              sentinel = true;
              System.out.println();
              System.out.println("*************************************************");
              System.out.println("            Forkert nummer, indtast nyt ");
              System.out.println("*************************************************");
              System.out.println();
            } 
         }
         catch (InputMismatchException e)
         {
            System.out.println();
            System.out.println("******************************************************************");
            System.out.println("Du skrev ikke et tal, prøv igen med et tal fra 0-5 ");
            System.out.println("******************************************************************");
            System.out.println();
            sentinel = true;
            user.next();
         }
      } while (sentinel == true);
      return menu;
   }
}