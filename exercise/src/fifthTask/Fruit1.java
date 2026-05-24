package fifthTask;
class Fruit 
{
 String name;
 double price;

 Fruit(String name, double price) 
 {
     this.name = name;
     this.price = price;
 }
}
class Orange extends Fruit 
{
 String origin;
 int shelfLife;
 Orange(String name, double price, String origin, int shelfLife) 
 {
     super(name, price);
     this.origin = origin;
     this.shelfLife = shelfLife;
 }
}
class Grape extends Fruit 
{
 String origin;
 int shelfLife;
 Grape(String name, double price, String origin, int shelfLife) 
 {
     super(name, price);
     this.origin = origin;
     this.shelfLife = shelfLife;
 }
}
class FruitShop {
 private Fruit[] fruits = new Fruit[100]; 
 private double[] stock = new double[100];  
 private int size = 0;                     
 public void addStock(Fruit fruit, double weight) 
 {
     int index = findIndex(fruit.name);
     if (index == -1) 
     {
         fruits[size] = fruit;
         stock[size] = weight;
         size++;
     } 
     else 
     {
         stock[index] += weight;
     }
 }
 public void sell(String name, double weight) 
 {
     int index = findIndex(name);
     if (index == -1) 
     {
         System.out.println("没有这种水果");
         return;
     }
     if (stock[index] < weight) 
     {
         System.out.println("库存不足");
         return;
     }
     double pay = fruits[index].price * weight;
     stock[index] -= weight;
     System.out.println("支付价格：" + pay + "元");
 }
 private int findIndex(String name) 
 {
     for (int i = 0; i < size; i++) 
     {
         if (fruits[i].name.equals(name)) 
         {
             return i;
         }
     }
     return -1;
 }
}

public class Fruit1 
{
	public static void main(String[] args) 
	{
	     FruitShop shop = new FruitShop();
	     shop.addStock(new Orange("橙子", 5.0, "江西", 30), 20);
	     shop.addStock(new Grape("葡萄", 8.0, "新疆", 7), 10);
	     shop.sell("葡萄", 1);
	 }
}
