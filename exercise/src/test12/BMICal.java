package test12;

public class BMICal {
	public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    
    // 判断BMI等级的方法
    public static String getBMICategory(double bmi) {
        if (bmi < 18.5) 
        {
            return "过轻";
        }
        else if (bmi < 23) 
        {
            return "正常";
        } 
        else if (bmi < 25)
        {
            return "偏胖";
        }
        else if (bmi < 30)
        {
            return "肥胖";
        }
        else if (bmi < 40)
        {
            return "重度肥胖";
        }
        else {
            return "极度肥胖";
        }
    }
}
