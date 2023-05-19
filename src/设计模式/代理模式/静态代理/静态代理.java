package 设计模式.代理模式.静态代理;

/**
 * @Author dongboy
 * @what time    2023/1/31 14:49
 */
public class 静态代理 {

    public static void main(String[] args) {
        // 测试静态代理
        EatService eatService = new EatServiceImpl();
        EatProxy eatProxy = new EatProxy(eatService);
        eatProxy.eat("四菜一汤");
    }

}

// 定义吃饭的接口
interface EatService {
    String eat(String food);
}

// 实现吃饭的接口
class EatServiceImpl implements EatService {

    @Override
    public String eat(String food) {
        System.out.println("吃的食物是：" + food);
        return food;
    }
}

// 创建代理类并实现吃饭
class EatProxy implements EatService {

    private final EatService eatService;

    public EatProxy(EatService eatService) {
        this.eatService = eatService;
    }

    @Override
    public String eat(String food) {
        // 调用前添加自己的操作
        System.out.println("吃饭前洗手");
        System.out.println("吃的食物是：" + food);
        // 调用后添加自己的操作
        System.out.println("吃饭后喝水");
        return food;
    }
}
