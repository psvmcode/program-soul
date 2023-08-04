package 设计模式.工厂模式.工厂方法模式;

/**
 * @Author dongboy
 * @what time    2023/2/4 14:34
 */
public class 工厂方法 {

    // 测试工厂方法模式
    public static void main(String[] args) {
        // 加法
        IFactory addFactory = new AddFactory();
        Operation operationAdd = addFactory.createOperation();
        operationAdd.setOne(1);
        operationAdd.setTwo(2);
        System.out.println(operationAdd.getResult());

        // 减法
        IFactory subFactory = new AddFactory();
        Operation operationSub = subFactory.createOperation();
        operationSub.setOne(1);
        operationSub.setTwo(2);
        System.out.println(operationSub.getResult());
    }

}

// 工厂接口
interface IFactory {

    Operation createOperation();

}

// 加法类工厂
class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new Add();
    }

}

// 减法类工厂
class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new Sub();
    }

}

// 计算类
abstract class Operation {

    private double one;

    private double two;

    abstract double getResult();

    public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(double two) {
        this.two = two;
    }

}

// 加法
class Add extends Operation {

    @Override
    double getResult() {
        return getOne() + getTwo();
    }

}

// 减法
class Sub extends Operation {

    @Override
    double getResult() {
        return getOne() - getTwo();
    }

}
