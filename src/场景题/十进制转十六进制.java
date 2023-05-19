package 场景题;

/**
 * @Author dongboy
 * @what time    2023/2/3 15:56
 */
public class 十进制转十六进制 {

    public static String tenToSixth(int num) {
        if (num == 0) {
            return "0";
        }
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder res = new StringBuilder();
        int temp;
        while (num > 0) {
            temp = num & 15;
            res.insert(0, chars[temp]);
            num >>>= 4;
        }
        return res.toString();
    }

}
