package test6;

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
class Rect extends Shape
{
	double length;
	double width;
	public double getArea()
	{
		return length*width;
	}
}
public class homework4 
{
	public static void main(String args[])
	{
		Rect r=new Rect();
		r.length=4;
		r.width=3;
		Circle c=new Circle();
		c.r=2;
		Shape[] a=new Shape[2];
		a[0]=r;
		a[1]=c;
		for(int i=0;i<2;i++)
		{
			double temp=a[i].getArea();
			System.out.println("第"+(i+1)+"个图形的面积为:"+temp);
		}
		 String StrA = "blcuBeijingHainanXionganblcublcu!";
	     String StrB = "blcu";
	     int count = 0;   
	     int lenA = StrA.length();
	     int lenB = StrB.length();   
	     for (int i = 0; i <= lenA - lenB; i++) 
	     {
	         boolean isMatch = true;   
	         for (int j = 0; j < lenB; j++) 
	         {
	             if (StrA.charAt(i + j) != StrB.charAt(j)) 
	             {
	                    isMatch = false;
	                    break;
	             }
	          }
	            if (isMatch) 
	            {
	                count++;
	            }
	        }
	        System.out.println("字符串'" + StrB + "'在字符串中出现了" + count + "次");
        
	}
}
