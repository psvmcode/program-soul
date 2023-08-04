package juc.线程通信;

/**
 * @Author dongboy
 * @what time    2023/1/28 15:52
 */
public class 线程间的通信方式 {

    public static void main(String[] args) {
        Bread bread = new Bread();
        Producter producter = new Producter(bread);
        Consume consume = new Consume(bread);
        Thread t1 = new Thread(producter, "生产者");
        Thread t2 = new Thread(consume, "消费者");
        t1.start();
        t2.start();
    }

}

// 面包
class Bread {

    // 面包编号
    private int id;

    // 面包数量
    private int num;

    // 生产面包的方法
    public synchronized void product() {
        if (num != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 开始生产面包
        num = num + 1;
        // 赋予编号
        id = id + 1;
        System.out.println(Thread.currentThread().getName() + "生产了一个编号为" + id + "的面包");
        notify();
    }

    // 消费面包
    public synchronized void consume() {
        if (num == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 面包消费完，面包数量减1
        num = num - 1;
        System.out.println(Thread.currentThread().getName() + "买了一个编号为" + id + "的面包");
    }

    public Bread(int id, int num) {
        this.id = id;
        this.num = num;
    }

    public Bread() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}

// 生产者
class Producter extends Thread {

    // 获取当前面包
    private Bread bread;

    public Producter() {
    }

    public Producter(Bread bread) {
        this.bread = bread;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {
        // 生产面包
        product();
    }

    private void product() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 生产面包
            bread.product();
        }
    }

}

class Consume extends Thread {

    // 面包
    private Bread bread;

    public Consume() {
    }

    public Consume(Bread bread) {
        this.bread = bread;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {
        consume();
    }

    private void consume() {
        // 与生产者保持一致，本系统默认循环生产20个面包（生产几个，消费几个）
        for (int i = 0; i < 20; i++) {
            try {
                //沉睡0.3秒（演示效果需要，可以不加）
                Thread.currentThread().sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //调用面包类里的生产面包的方法
            bread.consume();
        }
    }

}
