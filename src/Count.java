import java.io.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author dongboy
 * @what time    2022/12/4 20:18
 */
public class Count {

    public static void main(String[] args) throws Exception {
        String curPath1 = System.getProperty("user.dir") + "\\src\\hot100\\";
        File file1 = new File(curPath1);
        int count1 = file1.listFiles().length;
        String curPath2 = System.getProperty("user.dir") + "\\src\\剑指offer第2版\\";
        File file2 = new File(curPath2);
        int count2 = file2.listFiles().length;
        System.out.println("hot100写了" + count1);
        System.out.println("剑指offer写了" + count2);

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors(),
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10)
        );
        List<Future<List<String>>> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int cur = i;
            list.add(poolExecutor.submit(new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    List<String> temp = new ArrayList<>();
                    for (int j = cur; j < cur + 5; j++) {
                        temp.add(j + "hhh");
                    }
                    return temp;
                }
            }));
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i).get());
        }
        res.stream().forEach(e -> System.out.println(e));
        poolExecutor.shutdown();
        System.out.println("hhahha");
//        Runnable runnable = () -> {
//            for (int i = 0; i < 200000000; i++) {
//                num++;
//            }
//        };
//        Thread t1 = new Thread(runnable, "测试01线程");
//        Thread t2 = new Thread(runnable, "测试02线程");
//        t1.start();
//        t2.start();
//        System.out.println("主线程开始睡觉");
////        记录睡眠时间
//        long start = System.currentTimeMillis();
//        Thread.sleep(1000);
//
//        System.out.println("睡醒了, 一共睡了 : " + (System.currentTimeMillis() - start) + " 毫秒");
//        System.out.println("打印一下num 看看结果是多少: " + num);
//    }
//
//    public volatile static int num = 0;
    }
}

class One111 {

    public class SingleProducerMultiConsumerQueue {
        private BlockingQueue<Object> queue;
        private ConcurrentHashMap<String, AtomicInteger> consumerMap;
        private int capacity;

        public SingleProducerMultiConsumerQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new ArrayBlockingQueue<>(capacity);
            this.consumerMap = new ConcurrentHashMap<>();
        }

        public void registerConsumer(String consumerId) {
            consumerMap.put(consumerId, new AtomicInteger(0));
        }

        public void unregisterConsumer(String consumerId) {
            consumerMap.remove(consumerId);
        }

        public void produce(Object obj) throws InterruptedException {
            queue.put(obj);
        }

        public Object consume(String consumerId) throws InterruptedException {
            AtomicInteger index = consumerMap.get(consumerId);
            if (index == null) {
                throw new IllegalArgumentException("Consumer not registered");
            }
            Object obj = queue.take();
            int currentIndex = index.getAndIncrement();
            if (currentIndex == capacity - 1) {
                queue.remove(obj);
                index.set(0);
            }
            return obj;
        }
    }
}

class Two222 {
    public boolean canCalculate24(int[] arrrs) {
        if (arrrs == null || arrrs.length != 4) {
            return false;
        }
        return dfs(arrrs, 0, arrrs[0]);
    }

    private boolean dfs(int[] arrrs, int index, double output) {
        if (index == arrrs.length) {
            return Math.abs(output - 24) < 0.001;
        }
        for (int i = index + 1; i < arrrs.length; i++) {
            if (dfs(arrrs, i + 1, output + arrrs[i])) {
                return true;
            }
            if (dfs(arrrs, i + 1, output - arrrs[i])) {
                return true;
            }
            if (dfs(arrrs, i + 1, output * arrrs[i])) {
                return true;
            }
            if (dfs(arrrs, i + 1, output / arrrs[i])) {
                return true;
            }
        }
        return false;
    }

    // 任意张扑克牌，判断能不能算出目标数字x
    public boolean canCalculateX(int[] arrrs, int x) {
        if (arrrs == null || arrrs.length == 0) {
            return false;
        }
        return dfs(arrrs, 0, arrrs[0], x);
    }

    private boolean dfs(int[] arrrs, int index, double output, int x) {
        if (index == arrrs.length) {
            return Math.abs(output - x) < 0.001;
        }
        for (int i = index + 1; i < arrrs.length; i++) {
            if (dfs(arrrs, i + 1, output + arrrs[i], x)) {
                return true;
            }
            if (dfs(arrrs, i + 1, output - arrrs[i], x)) {
                return true;
            }
            if (dfs(arrrs, i + 1, output * arrrs[i], x)) {
                return true;
            }
            if (dfs(arrrs, i + 1, output / arrrs[i], x)) {
                return true;
            }
        }
        return false;
    }
}
