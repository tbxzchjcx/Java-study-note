package test;

class SellTicket implements Runnable
{
	private int tickets=2000;
	public void run()
	{
		while(sell())
		{
			
		}
	}
	public synchronized boolean sell()
	{
		if(tickets>0)
		{
			System.out.printf("发出第%d张票，剩余%d张票\n",2001-tickets,tickets-1);
			tickets--;
			return true;
		}
		return false;
	}
}
public class Task2 
{
	public static void main(String[] args)
	{
		SellTicket s=new SellTicket();
		Thread t1=new Thread(s,"jiaoyilou");
		Thread t2=new Thread(s,"zhunan");
		Thread t3=new Thread(s,"zonghelou");
		t1.start();
		t2.start();
		t3.start();
	}
}
