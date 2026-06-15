package duoxiancheng;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;

public class MovieTicketSystem {
	private static final AtomicInteger remainingTickets = new AtomicInteger(2000);
    private static final Object outputLock = new Object();
    private static final AtomicInteger distributedCount = new AtomicInteger(0);
    
    static class DistributionPoint implements Runnable {
        private final String location;
        
        public DistributionPoint(String location) {
            this.location = location;
        }
        
        @Override
        public void run() {
            while (true) {
                int ticketNumber = remainingTickets.decrementAndGet();
                
                if (ticketNumber < 0) {
                    // 没有票了，退出
                    break;
                }
                
                int currentDistributed = distributedCount.incrementAndGet();
                
                // 格式化输出：时间戳 - 地点 - 分发票号 - 剩余票数
                String output = String.format("[%s] %s: 分发票号%d (剩余%d张)", 
                    new Date(), location, 2000 - ticketNumber, ticketNumber);
                
                // 同步输出，确保时间顺序清晰
                synchronized (outputLock) {
                    System.out.println(output);
                    
                    // 每分发100张票显示一次统计
                    if (currentDistributed % 100 == 0 || ticketNumber == 0) {
                        System.out.println(">>> 状态更新: 已分发" + currentDistributed + 
                                         "张，剩余" + ticketNumber + "张 <<<");
                        System.out.println();
                    }
                }
                
                // 模拟发票处理时间
                try {
                    Thread.sleep((long)(Math.random() * 50)); // 0-50ms随机延迟
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("🎬 电影票分发系统启动 🎬");
        System.out.println("总票数: 2000张");
        System.out.println("分发点: 教一楼、综合楼、主南楼");
        System.out.println("开始时间: " + new Date());
        System.out.println("=".repeat(80));
        
        // 创建三个分发点线程
        Thread point1 = new Thread(new DistributionPoint("教一楼"), "教一楼发票点");
        Thread point2 = new Thread(new DistributionPoint("综合楼"), "综合楼发票点");
        Thread point3 = new Thread(new DistributionPoint("主南楼"), "主南楼发票点");
        
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        
        // 启动所有线程
        point1.start();
        point2.start();
        point3.start();
        
        // 等待所有线程完成
        point1.join();
        point2.join();
        point3.join();
        
        long endTime = System.currentTimeMillis();
        
        // 输出完成统计
        System.out.println("=".repeat(80));
        System.out.println("🎉 发票完成统计 🎉");
        System.out.println("结束时间: " + new Date());
        System.out.println("总耗时: " + (endTime - startTime) + " 毫秒");
        System.out.println("总分发数量: " + distributedCount.get() + " 张");
        System.out.println("剩余票数: " + remainingTickets.get() + " 张");
        
        if (remainingTickets.get() < 0) {
            System.out.println("⚠️ 注意: 由于并发处理，实际分发可能略超计划数量");
        }
        
        System.out.println("系统关闭时间: " + new Date());
    }
}
