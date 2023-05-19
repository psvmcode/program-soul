package 设计模式.原型模式;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2023/1/28 14:50
 */
public class Demo {
    public static void testNew(int size) {
        Set<User> set = new HashSet<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            User t = new User();
            set.add(t);
        }
        long end = System.currentTimeMillis();
        System.out.println(set.size());
        System.out.println("new的方式创建耗时：" + (end - start));
    }

    public static void testClone(int size) throws CloneNotSupportedException {
        Set<User> set = new HashSet<>();
        long start = System.currentTimeMillis();
        User t = new User();
        for (int i = 0; i < size; i++) {
            User temp = (User) t.clone();
            set.add(temp);
        }
        long end = System.currentTimeMillis();
        System.out.println(set.size());
        System.out.println("clone的方式创建耗时：" + (end - start));
    }


    public static void main(String[] args) throws Exception {
        testNew(1000);
        testClone(1000);
    }
}

/**
 * 测试普通new方式创建对象和clone方式创建对象的效率差异！
 * 如果需要短时间创建大量对象，并且new的过程比较耗时。则可以考虑使用原型模式！
 */
class User implements Cloneable {  //用户
    public User() {
        try {
            Thread.sleep(0);  //模拟创建对象耗时的过程!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();  //直接调用object对象的clone()方法！
        return obj;
    }
}
