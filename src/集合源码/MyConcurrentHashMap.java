//package 集合源码;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @Author dongboy
// * @what time    2023/1/23 20:07
// */
//public class MyConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
//
//    static final int HASH_BITS = Integer.MAX_VALUE;
//
//    transient volatile Node<K, V>[] table;
//
//    private transient volatile int sizeCtl;
//
//    @Override
//    public V put(K key, V value) {
//        return putVal(key, value, false);
//    }
//
//    final V putVal(K key, V value, boolean onlyIfAbsent) {
//        // 校验传入的key value是否为空，key和value不允许为空
//        if (key == null || value == null) {
//            throw new NullPointerException();
//        }
//        // 通过key算出hash值
//        int hash = spread(key.hashCode());
//        // 声明标识
//        int bitCount = 0;
//        // 死循环，生命tab数组，table为当前ConcurrentHashMap的数组
//        for (Node<K, V>[] tab = table; ; ) {
//            Node<K, V> f;
//            int n, i, fh;
//            // 如果数组为null或者数组长度为0
//            if (tab == null || (n = tab.length) == 0) {
//                // 初始化数组
//                tab = initTable();
//                // 如果数组已经初始化，则将数据插入ConcurrentHashMap中
//                // tabAt是获取数组中对应索引位置的数据table[i]
//                // casTabAt是以CAS的方式将数组中i位置的数据从null修改为新创建的节点
//                // i = 数组长度 和 hash值进行&运算
//            } else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
//                // 当前索引没有数据，将数据插入到这个位置，采用CAS方式插入，插入成功返回true，插入失败返回false
//                if (casTabAt(tab, i, null, new Node<K, V>(hash, key, value, null))) {
//                    break;
//                }
//            }
//        }
//    }
//
//    static final int spread(int h) {
//        return (h ^ (h >>> 16)) & HASH_BITS;
//    }
//
//    private static final sun.misc.Unsafe U;
//
//    @SuppressWarnings("unchecked")
//    static final <K, V> Node<K, V> tabAt(Node<K, V>[] tab, int i) {
//        return (Node<K, V>) U.getObjectVolatile(tab, ((long) i << ASHIFT) + ABASE);
//    }
//
//    private final Node<K, V>[] initTable() {
//        Node<K, V>[] tab;
//        int sc;
//        while ((tab = table) == null || tab.length == 0) {
//            if ((sc = sizeCtl) < 0)
//                Thread.yield(); // lost initialization race; just spin
//            else if (U.compareAndSwapInt(this, SIZECTL, sc, -1)) {
//                try {
//                    if ((tab = table) == null || tab.length == 0) {
//                        int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
//                        @SuppressWarnings("unchecked")
//                        Node<K, V>[] nt = (Node<K, V>[]) new Node<?, ?>[n];
//                        table = tab = nt;
//                        sc = n - (n >>> 2);
//                    }
//                } finally {
//                    sizeCtl = sc;
//                }
//                break;
//            }
//        }
//        return tab;
//    }
//
//    static class Node<K, V> implements Map.Entry<K, V> {
//        final int hash;
//        final K key;
//        volatile V val;
//        volatile Node<K, V> next;
//
//        Node(int hash, K key, V val, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.val = val;
//            this.next = next;
//        }
//
//        public final K getKey() {
//            return key;
//        }
//
//        public final V getValue() {
//            return val;
//        }
//
//        public final int hashCode() {
//            return key.hashCode() ^ val.hashCode();
//        }
//
//        public final String toString() {
//            return key + "=" + val;
//        }
//
//        public final V setValue(V value) {
//            throw new UnsupportedOperationException();
//        }
//
//        public final boolean equals(Object o) {
//            Object k, v, u;
//            Map.Entry<?, ?> e;
//            return ((o instanceof Map.Entry) &&
//                    (k = (e = (Map.Entry<?, ?>) o).getKey()) != null &&
//                    (v = e.getValue()) != null &&
//                    (k == key || k.equals(key)) &&
//                    (v == (u = val) || v.equals(u)));
//        }
//
//        /**
//         * Virtualized support for map.get(); overridden in subclasses.
//         */
//        Node<K, V> find(int h, Object k) {
//            Node<K, V> e = this;
//            if (k != null) {
//                do {
//                    K ek;
//                    if (e.hash == h &&
//                            ((ek = e.key) == k || (ek != null && k.equals(ek))))
//                        return e;
//                } while ((e = e.next) != null);
//            }
//            return null;
//        }
//    }
//}
