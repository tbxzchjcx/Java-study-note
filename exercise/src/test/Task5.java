package test;
class fruit
{
	String name;
	double price;
	fruit(String n,double p)
	{
		this.name=n;
		this.price=p;
	}
}
class orange extends fruit
{
	String origin;
	double Life;
	public orange(String name,double price,String o,double L)
	{
		super(name,price);
		this.origin=o;
		this.Life=L;
	}
}
class grape extends fruit
{
	String origin;
	double Life;
	grape(String name,double price,String o,double L)
	{
		super(name,price);
		this.origin=o;
		this.Life=L;
	}
}
class fruitshop
{
	double[] Stock=new double[100];
	fruit[] fruit=new fruit[100];
	public int size=0;
	public int findindex(String name)
	{
		for(int i=0;i<size;i++)
		{
			if(fruit[i].name.equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	public void addStock(fruit f,double weight)
	{
		int q=findindex(f.name);
		if(q==-1)
		{
			fruit[size]=f;
			Stock[size]=weight;
			size++;
		}
		else
		{
			Stock[q]+=weight;
		}
	}
	public void sell(String name,double weight)
	{
		int q=findindex(name);
		if(q==-1)
		{
			System.out.println("没有在这种水果");
		}
		else
		{
			if(weight>Stock[q])
			{
				System.out.println("库存不足");
			}
			else
			{
				Stock[q]-=weight;
				System.out.println(weight*fruit[q].price);
			}
		}
	}
}
public class Task5 
{
	public static void main(String[] args)
	{
		fruitshop shop=new fruitshop();
		shop.addStock(new orange("橙子",5.0,"江西",6.0),10.0);
		shop.addStock(new grape("葡萄",6.0,"新疆",10.0),100.0);
		shop.sell("葡萄",20);
	}
}
