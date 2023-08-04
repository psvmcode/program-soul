package hot100;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author dongboy
 * @what time    2023/1/13 12:01
 */
public class a146LRU缓存 {

}

//// 回家等通知解法
//class LRUCache {
//
//    // 保存key和value
//    int[] nums;
//    // 最久未使用的下标
//    Deque<Integer> deque;
//    // 总元素
//    int sum;
//    int total;
//
//    public LRUCache(int capacity) {
//        nums = new int[100001];
//        Arrays.fill(nums, -1);
//        deque = new ArrayDeque<>();
//        sum = 0;
//        total = capacity;
//    }
//
//    public int get(int key) {
//        if (nums[key] == -1) {
//            return -1;
//        }
//        // 说明有这个key且用了key
//        updataCache(key);
//        return nums[key];
//    }
//
//    public void put(int key, int value) {
//        if (nums[key] != -1) {
//            nums[key] = value;
//        } else {
//            sum++;
//            // 如果加进来的容量超过total
//            if (sum > total) {
//                // 删除最近没用过的
//                if (!deque.isEmpty()) {
//                    nums[deque.pollFirst()] = -1;
//                }
//                sum--;
//            }
//            nums[key] = value;
//        }
//        updataCache(key);
//    }
//
//    // 更新缓存
//    public void updataCache(int key) {
//        // 说明有这个key且用了key
//        if (deque.contains(key)) {
//            deque.remove(key);
//        }
//        deque.offerLast(key);
//    }
//
//}

//class LRUCache extends LinkedHashMap<Integer, Integer> {
//
//    // 初始化容量
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        // true表示按照访问顺序
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    // 自定义条件触发删除元素
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        // 当实际容量超过指定容量时删除元素
//        return size() > capacity;
//    }
//
//}

class LRUCache {

    // 双向链表
    class MyLinkedNode {
        int key;
        int value;

        MyLinkedNode pre;
        MyLinkedNode next;

        MyLinkedNode() {
        }

        MyLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // key存储key，value存储在map中的节点
    private HashMap<Integer, MyLinkedNode> map = new HashMap<>();
    // 当前实际容量
    private int size;
    // 当前理论容量
    private int capacity;
    // 虚拟头尾节点
    private MyLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new MyLinkedNode();
        this.tail = new MyLinkedNode();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        MyLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 如果存在key，则移动到头部
        moveToHead(node);
        return node.value;
    }

    // 把指定的节点移动到头部
    private void moveToHead(MyLinkedNode node) {
        // 先删除节点
        removeNode(node);
        // 向头部添加节点
        addToHead(node);
    }

    // 删除指定的节点
    private void removeNode(MyLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 向头部添加节点
    private void addToHead(MyLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        MyLinkedNode node = map.get(key);
        if (node == null) {
            // 如果key不存在，就新建一个添加到头节点
            MyLinkedNode curNode = new MyLinkedNode(key, value);
            // 添加到map
            map.put(key, curNode);
            // 添加到双链表头部
            addToHead(curNode);
            // 实际元素数量自增
            size++;
            if (size > capacity) {
                // 超出容量，删除链表结尾的节点
                MyLinkedNode tail = removeTail();
                // 删除map中对应的key
                map.remove(tail.key);
                size--;
            }
        } else {
            // key存在，先更新value
            node.value = value;
            // 再把当前节点移动到头部
            moveToHead(node);
        }
    }

    // 删除链表尾节点的值
    private MyLinkedNode removeTail() {
        MyLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

}
