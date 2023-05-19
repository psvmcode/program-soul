package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/5 15:09
 */
public class a17打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int sum = 1;
        while (n > 0) {
            sum *= 10;
            n--;
        }
        int[] res = new int[sum - 1];
        for (int i = 1; i < sum; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
