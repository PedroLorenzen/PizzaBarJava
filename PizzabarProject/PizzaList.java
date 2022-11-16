import java.util.*;
import java.io.*;

public class PizzaList
{
   public Pizza list()
   {
      ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
      pizzaList.add(new Pizza("pizza", " humhum " , "[", -99 ,"]"));
      pizzaList.add(new Pizza("Vesuvio ", " tomatsauce , ost , skinke og oregano " , "[", 57 ,"]"));
      pizzaList.add(new Pizza("Amerikaner ", " tomatsauce, ost, oksefars og oregano ", "[", 53 ,"]"));
      pizzaList.add(new Pizza("Cacciatore ", " tomatsauce, ost, pepperoni og oregano ", "[", 57 ,"]"));
      pizzaList.add(new Pizza("Carbona ", " tomatsauce, ost, kodsauce, spaghetti, cocktailpolser og oregano ", "[", 63 ,"]"));
      pizzaList.add(new Pizza("Dennis ", " tomatsauce, ost, skinke, pepperoni, cocktailpolser og oregano ", "[", 65 ,"]"));
      pizzaList.add(new Pizza("Bertil ", " tomatsauce, ost, bacon og oregano ", "[", 57 ,"]"));
      pizzaList.add(new Pizza("Silvia ", " tomatsauce, ost pepperoni, rod peber, log, oliven og oregano ", "[", 61 ,"]"));
      pizzaList.add(new Pizza("Victoria ", " tomatsauce, ost skinke, ananas, champignon, log og oregano ", "[", 61 ,"]"));
      pizzaList.add(new Pizza("Toronfo ", " tomatsauce, ost, skinke, bacon, kebab, chili og oregano ", "[", 61 ,"]"));
      pizzaList.add(new Pizza("Capricciosa ", " tomatsauce, ost, skinke, champignon og oregano ", "[", 61 ,"]"));
      pizzaList.add(new Pizza("Hawai ", " tomatsauce, ost, skinke, ananas og oregano ", "[", 61 ,"]"));
      pizzaList.add(new Pizza("Le Blissola ", " tomatsauce, ost, skinke, rejer og oregano ", "[", 61 ,"]"));
      pizzaList.add(new Pizza("Venezia ", " tomatsauce, ost skinke, bacon og oregano ", "[", 61 ,"]"));
      pizzaList.add(new Pizza("Mafia ", " tomatsauce, ost, pepperoni, bacon, log og oregano ", "[", 61 ,"]"));
              
      Scanner s = new Scanner(System.in);
        
      System.out.println("*************************************************");
      System.out.print("Nummer på pizzaen: ");
      int x = s.nextInt();
// Her giver vi mulighed for at vælge hvilken pizza vi gerne vil have (nr. i rækken).     
      Pizza test = pizzaList.get(x);
// Her laver vi en variabel som kalder på pizzaList arraylisten som kan kalde på den nr. pizza man vil have. 
      return test;       
   }
   
}