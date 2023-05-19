package 设计模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author dongboy
 * @what time    2023/1/31 14:57
 */
public class JDK动态代理 {

    // 测试JDK动态代理
    public static void main(String[] args) {
        EatService eatService = (EatService) JDKProxyFactory.getProxy(new EatServiceImpl());
        eatService.eat("四菜一汤");
    }

}

// 定义吃饭的接口
interface EatService {
    String eat(String food);
}

// 定义吃饭接口的实现类
class EatServiceImpl implements EatService {

    @Override
    public String eat(String food) {
        System.out.println("吃的食物是：" + food);
        return food;
    }
}

// 定义JDK动态代理类
class MyInvocationHandler implements InvocationHandler {

    // 代理类的对象
    private final Object target;

    public MyInvocationHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用方法前添加自己的操作
        System.out.println("before method " + method.getName());
        Object invoke = method.invoke(target, args);
        // 调用后添加自己的操作
        System.out.println("after method " + method.getName());
        return invoke;
    }
}

// 获取代理类的工厂类
class JDKProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(), // 代理需要实现的接口，课指定多个
                new MyInvocationHandler(target) // 代理类对象的自定义InvocationHandler
        );
    }
}