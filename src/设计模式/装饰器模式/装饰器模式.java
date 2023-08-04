package 设计模式.装饰器模式;

/**
 * @Author dongboy
 * @what time    2023/2/12 21:01
 */
public class 装饰器模式 {

    // 测试装饰器模式
    public static void main(String[] args) {
        System.out.println("增加装饰器前：");
        Component component = new Man();
        component.drink();
        System.out.println("增加装饰器后：");
        component = new Coffee(component);
        component.drink();
    }

}

// 抽象组件
interface Component {

    void drink();

}

// 抽象装饰器
abstract class Decorator implements Component {

    Component component;

    // 构造方法强制子类传入一个Component参数
    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void drink() {
        this.component.drink();
    }

}

// 具体组件
class Man implements Component {

    @Override
    public void drink() {
        System.out.println("喝咖啡");
    }

}

// 具体装饰器
class Coffee extends Decorator {

    public Coffee(Component component) {
        super(component);
    }

    @Override
    public void drink() {
        super.drink();
        this.drinkWithSuger();
    }

    private void drinkWithSuger() {
        System.out.println("加糖");
    }

}
