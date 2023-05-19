package 场景题;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/3/1 14:32
 */
public class 大数中判断指定数是否存在 {
    public class BitMap {
        // 数据容器
        private byte[] byteBits;
        // 最大值
        private int maxValue;
        // 容量
        private int capacity;

        public BitMap(int maxValue) {
            this.maxValue = maxValue;
            // 计算需要多少个byte
            this.capacity = (maxValue / 8) + 1;
            byteBits = new byte[capacity];
        }

        public void add(int num) {
            // 数组中的下标
            int index = num / 8;
            // 下标元素的位置
            int position = num % 8;
            // 求出一个比特位中对应的位置
            byte tempBit = (byte) (1 << position);
            // 进行或运算，同时能去重
            byteBits[index] = (byte) (byteBits[index] | tempBit);
        }

        public boolean contains(int num) {
            // 计算出数组下标
            int index = num / 8;
            // 计算出下标元素的位置
            int position = num % 8;
            byte tempBit = (byte) (1 << position);
            return (byteBits[index] & tempBit) != 0;
        }

    }
}
