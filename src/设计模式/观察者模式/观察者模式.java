package 设计模式.观察者模式;

import hot100.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/2/5 16:24
 */
public class 观察者模式 {

    // 测试观察者模式
    public static void main(String[] args) {
        // 创建被观察者
        ConcreteSubject subject = new ConcreteSubject();
        // 定义观察者
        Observer observer = new ConcreteObserver();
        // 观察者观察被观察者
        subject.registerObserver(observer);
        subject.doSomething();
    }

}

// 抽象观察者
interface Observer {

    // 更新方法
    void update();

}

// 具体观察者
class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("收到信息，进行处理");
    }

}

// 被观察者
abstract class Subject {

    // 定义一个被观察者数组
    private List<Observer> observerList = new ArrayList<>();

    // 注册观察者
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    // 移除观察者
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    // 通知观察者
    public void notifyObserver() {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update();
        }
    }

}

// 具体被观察者
class ConcreteSubject extends Subject {

    // 具体业务
    public void doSomething() {
        super.notifyObserver();
    }

}
