package test11;
import java.util.Scanner;
class BMIcal {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入身高(m):");
		double height=sc.nextDouble();
		System.out.println("请输入体重(kg):");
		double weight=sc.nextDouble();
		double ans=weight/(height*height);
		if(ans<18.5)
		{
			System.out.println("过轻");
		}
		else if(ans>=18.5&&ans<=22.9)
		{
			System.out.println("正常");
		}
		else if(ans>=23&&ans<=24.9)
		{
			System.out.println("偏胖");
		}
		else if(ans>=25&&ans<=29.9)
		{
			System.out.println("肥胖");
		}
		else if(ans>=30&&ans<40)
		{
			System.out.println("重度肥胖");
		}
		else 
		{
			System.out.println("极度肥胖");
		}
	}

}
