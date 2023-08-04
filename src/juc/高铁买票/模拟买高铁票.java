package juc.高铁买票;

import java.math.BigDecimal;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author dongboy
 * @what time    2023/1/13 18:28
 */
public interface 模拟买高铁票 {
}

class Ticket {

    // 起始站
    private String start;

    // 终点站
    private String end;

    // 票价，用BigDecimal防止后续需要计算，能保证精度
    private BigDecimal price;

    public Ticket() {

    }

    public Ticket(String start, String end, BigDecimal price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", price=" + price +
                '}';
    }

}

// 单例系统，双重校验锁
class TicketSystem {

    private volatile static TicketSystem system = new TicketSystem();

    // 存储所有车票，其中CopyOnWriteArrayList保证线程安全读写
    private CopyOnWriteArrayList<Ticket> list = new CopyOnWriteArrayList<>();

    // 给车票赋值，类加载前就给list车票集合赋值
    {
        for (int i = 0; i < 100; i++) {
            list.add(new Ticket("北京" + i, "深圳" + i, new BigDecimal(i * 200 + 100)));
        }
    }

    private TicketSystem() {

    }

    // 双重锁校验生成系统对象
    public static TicketSystem getSystem() {
        if (system == null) {
            synchronized (TicketSystem.class) {
                if (system == null) {
                    system = new TicketSystem();
                }
            }
        }
        return system;
    }

    // 买票方法
    public Ticket sellTicket() {
        try {
            return list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            // 发生异常说明票卖完了
            return null;
        }
    }

}

// 当前窗口
class Window extends Thread {

    //当前窗口名称
    private String winName;

    public Window(String winName) {
        this.winName = winName;
    }

    public String getWinName() {
        return winName;
    }

    public void setWinName(String winName) {
        this.winName = winName;
    }

    @Override
    public void run() {
        this.sellTicket();
    }

    // 卖票
    public void sellTicket() {
        // 获取买票系统
        TicketSystem system = TicketSystem.getSystem();
        while (true) {
            Ticket ticket = system.sellTicket();
            if (ticket != null) {
                System.out.println("从" + this.winName + "售出一张票" + ticket);
            } else {
                System.out.println(this.winName + "票卖光了");
                break;
            }
        }
    }

}

class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Window window = new Window("北京" + i + "站");
            window.start();
        }
    }

}

