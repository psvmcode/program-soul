package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/5 14:43
 */
public class a16数值的整数次方 {

//    // 大力出奇迹，用API(回家等通知)
//    public double myPow(double x, int n) {
//        return Math.pow(x, n);
//    }

//    // 太过于暴力了
//    public double myPow(double x, int n) {
//        if (x == 1 || n == 0) {
//            return 1;
//        }
//        if (x == -1) {
//            return n % 2 == 0 ? 1 : -1;
//        }
//        if (n == Integer.MIN_VALUE) {
//            return 0;
//        }
//        boolean flag = true;
//        if (n < 0) {
//            flag = false;
//            n = -n;
//        }
//        double res = 1;
//        while (n != 0) {
//            n--;
//            res *= x;
//        }
//        return flag ? res : 1 / res;
//    }

    // 快速幂解法
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        boolean flag = true;
        if (n < 0) {
            flag = false;
            n = -n;
        }
        double res = quickPow(x, n);
        return flag ? res : 1 / res;
    }

    public double quickPow(double x, int n) {
        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            n >>= 1;
        }
        return res;
    }


}
