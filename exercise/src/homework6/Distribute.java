/**
 * 电影票售票系统主类
 * 模拟三个窗口同时发售2000张电影票的场景
 */
package homework6;

public class Distribute {
    public static void main(String[] args) {
        // 创建售票任务对象（三个窗口共享同一个任务）
        SellTicket sellTicket = new SellTicket();

        // 创建三个线程，模拟三个售票窗口
        // 参数1：要执行的任务（Runnable）
        // 参数2：线程名称（窗口名称）
        Thread t1 = new Thread(sellTicket, "教一楼");
        Thread t2 = new Thread(sellTicket, "综合楼");
        Thread t3 = new Thread(sellTicket, "主南楼");

        // 启动三个线程，开始售票
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 售票任务类
 * 实现 Runnable 接口，表示这是一个可被线程执行的任务
 */
class SellTicket implements Runnable {
    // 共享资源：剩余票数（三个窗口共用这2000张票）
    private int tickets = 2000;

    /**
     * 线程执行的入口方法
     * 当线程启动时，自动调用此方法
     */
    public void run() {
        // 循环售票：只要sell()返回true（还有票），就继续卖
        while (sell()) {
            // 售票成功，继续循环
        }
        // sell()返回false时，说明票已售罄，线程结束
    }

    /**
     * 售票方法（核心）
     * synchronized关键字：保证多线程环境下的线程安全
     * 同一时间只有一个窗口能执行此方法，防止超卖
     * 
     * @return true 售票成功，false 票已售罄
     */
    public synchronized boolean sell() {
        // 检查是否还有剩余票数
        if (tickets > 0) {
            // 输出售票信息：窗口名称 + 当前售出票号 + 剩余票数
            // Thread.currentThread().getName() 获取当前执行线程的名称（窗口名）
            // (2001 - tickets)：计算当前售出的是第几张票（从1开始）
            // (tickets - 1)：售票后的剩余票数（因为还没执行tickets--）
            System.out.println(Thread.currentThread().getName() + "发出第" + (2001 - tickets) + "张票，剩余" + (tickets - 1) + "张");
            // 票数减1（核心操作：修改共享资源）
            tickets--;
            return true;  // 售票成功
        }
        return false;  // 票已售罄
    }
}