package 场景题;

/**
 * @Author dongboy
 * @what time    2023/2/3 15:55
 */
public class 不用临时变量交换abc {

    public static void main(String[] args) {
        int a = 111;
        int b = 222;
        System.out.println("交换之前是：" + a + "   " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("交换之后是：" + a + "   " + b);
    }

}
