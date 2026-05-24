package Student;

public class StudentTest 
{
	String name;
	String ID;
	int JavaScore;
	public StudentTest(String n,String id,int score)
	{
		this.name=n;
		this.ID=id;
		this.JavaScore=score;
	}
	public StudentTest()
	{
		this.name="";
		this.ID="";
		this.JavaScore=0;
	}
	public StudentTest(String n,String id)
	{
		this.name=n;
		this.ID=id;
	}
	public String GetName()
	{
		 return this.name;
	}
	public String GetId()
	{
		return this.ID;
	}
	public int GetScore()
	{
		return this.JavaScore;
	}
	public void updateName(String n1)
	{
			this.name=n1;
	}
	public void updateId(String i1)
	{
		this.ID=i1;
	}
	public void updateScore(int s1)
	{
		this.JavaScore=s1;
	}
	public static void main(String[] args)
	{
		StudentTest s1=new StudentTest("张三","001",100);
		StudentTest s2=new StudentTest("李四","002");
		StudentTest s3=new StudentTest();
		double sum=s1.JavaScore+s2.JavaScore+s3.JavaScore;
		double avg=sum/3;
		System.out.println(avg);
	}
}
