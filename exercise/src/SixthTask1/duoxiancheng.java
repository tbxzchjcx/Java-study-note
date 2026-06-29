package SixthTask1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class duoxiancheng 
{
    private static int ticketsLeft = 2000;
    private static final List<String> records = Collections.synchronizedList(new ArrayList<>());

    private synchronized static int getTicket() 
    {
        if (ticketsLeft > 0) 
        {
            return ticketsLeft--;
        }
        return -1;
    }

    static class TicketWindow extends Thread 
    {
        private String windowName;

        public TicketWindow(String windowName) 
        {
            this.windowName = windowName;
        }

        @Override
        public void run() 
        {
            while (true) 
            {
                int ticketNum = getTicket();
                if (ticketNum == -1) 
                {
                    break;
                }

                long time = System.nanoTime();
                String record = "[" + time + "] " + windowName + " 发出第 " + ticketNum + " 张票";
                records.add(record);

                try {
                    Thread.sleep((long) (Math.random() * 3));
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();  
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException 
    {
        Thread win1 = new TicketWindow("教一楼");
        Thread win2 = new TicketWindow("综合楼");
        Thread win3 = new TicketWindow("主南楼");

        win1.start();
        win2.start();
        win3.start();

        win1.join();
        win2.join();
        win3.join();

        Collections.sort(records, new Comparator<String>() 
        {
            @Override
            public int compare(String r1, String r2) 
            {
                long t1 = Long.parseLong(r1.substring(1, r1.indexOf("]")));
                long t2 = Long.parseLong(r2.substring(1, r2.indexOf("]")));
                return Long.compare(t1, t2);
            }
        });

        System.out.println("电影票分发记录(按时间顺序)");
        for (String record : records) 
        {
            System.out.println(record);
        }
        System.out.println("分发结束，共发出 " + records.size() + " 张票");
    }
}