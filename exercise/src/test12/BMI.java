package test12;
import java.util.Scanner;
public class BMI {
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        
        System.out.println("请输入身高(m):");
        double height = sc.nextDouble();
        
        System.out.println("请输入体重(kg):");
        double weight = sc.nextDouble();
        
        // 使用 BMICalculator 类的方法
        double ans = BMICal.calculateBMI(weight, height);
        String category = BMICal.getBMICategory(ans);
        
        System.out.printf("您的BMI指数为：%.1f\n", ans);
        System.out.println("身体状况：" + category);
        

    }
}