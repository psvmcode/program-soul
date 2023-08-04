package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/5 14:32
 */
public class a15二进制中1的个数 {

//    // 调用Java自带的api(回家等通知)
//    public int hammingWeight(int n) {
//        String s = Integer.toBinaryString(n);
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '1') {
//                res++;
//            }
//        }
//        return res;
//    }

    // 调用Java自带的api(回家等通知)
//    public int hammingWeight(int n) {
//        return Integer.bitCount(n);
//    }

    // 二进制解题
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) { // 这里一定是n != 0 而不是 n > 0
            n = n & (n - 1);
            res++;
        }
        return res;
    }

}
