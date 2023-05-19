package 设计模式.策略模式;

/**
 * @Author dongboy
 * @what time    2023/4/11 21:17
 */
public class 策略模式常规写法 {
}

class Context {
    //抽象策略
    private Strategy strategy = null;

    // 构造函数设置具体策略
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //
    public void doAnything() {
        this.strategy.doSomething();
    }
}

interface Strategy {
    // 策略模式运算法则
    public void doSomething();
}

class ConcreteStrategy1 implements Strategy {

    @Override
    public void doSomething() {
        System.out.println("ConcreteStrategy1");
    }
}

class ConcreteStrategy2 implements Strategy {

    @Override
    public void doSomething() {
        System.out.println("ConcreteStrategy2");
    }
}

class TestForStrategy {
    public static void main(String[] args) {
        // 声明一个具体的策略
        Strategy strategy = new ConcreteStrategy1();
        // 声明上下文对象
        Context context = new Context(strategy);
        // 执行封装后的方法
        context.doAnything();
    }
}
