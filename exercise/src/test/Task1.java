package test;
abstract class Shape
{
	public abstract double getArea();
}
class Circle extends Shape
{
	double r;
	public double getArea()
	{
		return 3.14*r*r;
	}
}
class Cube extends Shape
{
	double length;
	double width;
	public double getArea()
	{
		return length*width;
	}
}
public class Task1 
{
	public static void main(String[] args)
	{
		Circle c=new Circle();
		c.r=2;
		Cube u=new Cube();
		u.length=3;
		u.width=2;
		Shape[] s=new Shape[2];
		s[0]=c;
		s[1]=u;
		for(int i=0;i<2;i++)
		{
			System.out.println("第"+i+"个图形的面积为"+s[i].getArea());
		}
		String StrA = "blcuBeijingHainanXionganblcublcu!";
		String StrB = "blcu";
		int count=0;
		int LA = StrA.length();
		int LB=StrB.length();
		for(int i=0;i<=LA-LB;i++)
		{
			boolean ismatch=true;
			for(int j=0;j<LB;j++)
			{
				if(StrA.charAt(i+j)!=StrB.charAt(j))
				{
					ismatch=false;
					break;
				}
			}
			if(ismatch==true)
			{
				count++;
			}
		}
		System.out.println("blcu出现次数为："+count);
	}
}
