public class Pizza
{
   String name = "humhum";
   String ingredients = "dadler";
   String pynt = "dalder";
   int price = -99;
   String pynt2 = "dadler";
   
   public Pizza(String n, String i, String k, int p,  String k2)
   {
      name = n;
      ingredients = i;
      pynt = k;
      price = p;
      pynt2 = k2;
   }
   
   public String toString()
   {
      return name + "" + ingredients + "" + pynt + price + pynt2;
   }
        
}      