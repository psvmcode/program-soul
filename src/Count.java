import java.io.*;

/**
 * @Author dongboy
 * @what time    2022/12/4 20:18
 */
public class Count {

    public static void main(String[] args) throws Exception {
        String curPath1 = System.getProperty("user.dir") + "\\src\\hot100\\";
        File file1 = new File(curPath1);
        int count1 = file1.listFiles().length;
        String curPath2 = System.getProperty("user.dir") + "\\src\\剑指offer第2版\\";
        File file2 = new File(curPath2);
        int count2 = file2.listFiles().length;
        System.out.println("hot100写了" + count1);
        System.out.println("剑指offer写了" + count2);
    }

}
