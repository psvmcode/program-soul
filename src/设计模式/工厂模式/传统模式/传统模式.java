package 设计模式.工厂模式.传统模式;

/**
 * @Author dongboy
 * @what time    2023/2/4 12:57
 */
public class 传统模式 {

    // 调用传统工厂模式
    public static void main(String[] args) {
        Add add = new Add();
        add.setOne(1);
        add.setTwo(2);
        double resultAdd = add.getResult();
        System.out.println(resultAdd);

        Sub sub = new Sub();
        sub.setOne(1);
        sub.setOne(2);
        double resultSub = sub.getResult();
        System.out.println(resultSub);
        // 这里创建了重复的类，其实创建重复类的工作可以交给统一的类管理
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


