package test;
class SelllllTicket implements Runnable
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
			System.out.println("发出"+(2001-tickets)+"张票剩余"+(tickets-1)+"张票");
			tickets--;
			return true;
		}
		return false;
	}
}
public class Task22 
{
	public static void main(String[] args)
	{
		SelllllTicket sellTicket=new SelllllTicket();
		Thread t1=new Thread(sellTicket,"主南");
		Thread t2=new Thread(sellTicket,"教一楼");
		Thread t3=new Thread(sellTicket,"综合楼");
		t1.start();
		t2.start();
		t3.start();
	}
}
