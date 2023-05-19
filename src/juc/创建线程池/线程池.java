package juc.创建线程池;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author dongboy
 * @what time    2023/1/12 23:33
 */
public class 线程池 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 获取当前cup内核
        int work_num = Runtime.getRuntime().availableProcessors();
        // 自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                // 核心线程数
                work_num,
                // 最大线程数
                work_num * 2,
                // 闲置可存活时间
                0,
                // 时间单位
                TimeUnit.SECONDS,
                // 任务队列
                new ArrayBlockingQueue<>(20)
        );
        // 假设需要一个集合的查询任务进行轮询
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        // 用于存放返回的结果
        Future<List<String>>[] futures = new Future[list.size()];
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            // 获取当前查询条件
            int cur = i;
            // 获取当前查询条件
            futures[i] = threadPoolExecutor.submit(new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    // 对每个查询前加一个字符串dongboy
                    List<String> temp = new ArrayList<>();
                    for (int j = cur; j < cur + 10; j++) {
                        temp.add("dongboy" + j);
                        Thread.sleep(1);
                    }
                    return temp;
                }
            });
        }
        // 用于返回的查询结果
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i, futures[i].get());
        }
        long end = System.currentTimeMillis();
        System.out.println("线程池执行时间为：" + (end - start));
        futures = null;
        System.out.println("总返回结果集" + map.size());
        for (Integer data : map.keySet()) {
            System.out.println("当前是第" + data + "个结果集，大小为" + map.get(data).size());
            System.out.println(map.get(data));
        }
        threadPoolExecutor.shutdown();
    }


}
