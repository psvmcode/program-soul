package 设计模式.工厂模式.简单工厂模式;

/**
 * @Author dongboy
 * @what time    2023/2/4 13:06
 */
public class 简单工厂模式 {

    // 调用简单工厂方法
    public static void main(String[] args) {
        Operation operation1 = OperationFactory.createOperation("add");
        operation1.setOne(1);
        operation1.setTwo(2);
        double resultAdd = operation1.getResult();
        System.out.println(resultAdd);

        Operation operation2 = OperationFactory.createOperation("sub");
        operation2.setOne(1);
        operation2.setTwo(2);
        double resultSub = operation2.getResult();
        System.out.println(resultSub);
    }

}

// 工厂方法
class OperationFactory {

    public static Operation createOperation(String str) {
        Operation operation = null;
        switch (str) {
            case "add":
                operation = new Add();
                break;
            case "sub":
                operation = new Sub();
                break;
            default:
                throw new UnsupportedOperationException("不支持当前操作");
        }
        return operation;
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

