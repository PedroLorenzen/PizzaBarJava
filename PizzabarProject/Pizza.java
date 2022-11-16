public class Pizza
{
   String name = "humhum";
   String ingredients = "dadler";
   String pynt = "dalder";
   int price = -99;
   String pynt2 = "dadler";
   
   public Pizza(String n, String i, String k, int p,  String k2)
// Her laver vi en metode med parametre (parametre = placeholders indtil metoden kaldes og bruges et andet sted)
   {
      name = n;
      ingredients = i;
      pynt = k;
      price = p;
      pynt2 = k2;
   }
   
   public String toString()
// Her laver vi en metode som gør at man kan bruge Pizza metoden, som vi bruger i PizzaList. 
   {
      return name + "" + ingredients + "" + pynt + price + pynt2;
   }
        
}      