package 集合源码;

import java.io.Serializable;
import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/12/14 14:27
 */
// 实现Serializable接口的所有子类都是可序列化的---序列化就是把对象的数据写入到文件---反序列化就是把文件中的对象的数据读取出来
// 实现Cloneable接口的所有子类都是可以复制的，被克隆对象所在的类必须实现Cloneable接口，而且必须重写clone方法
// 实现RandomAccess接口的所有子类都是支持快速随机访问的，以便于随机访问列表或者顺序访问列表时提供良好的性能
// 继承AbstractList父类，能调用父类AbstractList的方法
public class ArrayList<E>
        extends AbstractList<E>
        implements Serializable, Cloneable, RandomAccess, List<E> {

    // ArrayList从容量为空到添加第一个元素时的默认容量大小
    private static final int DEFAULT_CAPACITY = 10;

    // 真正存储数据的容器，并不是填满了元素，而是预留了一部分空间
    transient Object[] elementData;

    // 用于默认的空容量数组，长度为0
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    // 用于有参构造参数值为0时创建数组，长度为0
    private static final Object[] EMPTY_ELEMENTDATA = {};

    // 成员变量，当前ArrayList元素个数
    private int size;

    // 数组最大值，类似整型最大值
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    // 空参构造
    public ArrayList() {
        // 给空参数组赋值，容量为0
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // 有参构造
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            // 如果值大于0，则创建一个数组，数组长度为参数值
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            // 如果值等于0，创建一个空数组
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            // 如果值小于0，程序抛出非法参数异常
            throw new IllegalArgumentException("非法参数异常:" + initialCapacity);
        }
    }

    // 有参构造
    public ArrayList(Collection<? extends E> c) {
        // 将构造方法中的参数转成数组
        elementData = c.toArray();
        // size = elementData.length是将新数组的长度赋值给size
        if ((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class) {
                // 数组的创建和拷贝
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            } else {
                // 如果数组的长度为0，就把空数组的地址赋值给集合元素的数组
                this.elementData = EMPTY_ELEMENTDATA;
            }
        }
    }

    // add方法，仅仅添加元素
    public boolean add(E e) {
        // 确保数组容量可用
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    // 确保数组容量可用
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // 如果添加元素前数组容量为空，则在默认容量10和添加当前元素后的大小中取最大值作为数组的容量
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 为了确保当前设置的容量可用
        ensureExplicitCapacity(minCapacity);
    }

    // 确保数组容量可用后的扩容核心代码
    private void ensureExplicitCapacity(int minCapacity) {
        // 记录集合修改的次数(add或者remove)
        modCount++;
        // 不是每一次都扩容，只有容量不够的时候才扩容
        if (minCapacity - elementData.length > 0) {
            // 新容量减旧容量长度一定大于0，grow扩容核心代码
            grow(minCapacity);
        }
    }

    // ArrayList添加元素时扩容的核心代码
    private void grow(int minCapacity) {
        // 旧数组容量
        int oldCapacity = elementData.length;
        // 新数组容量是旧数组容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            // 如果新数组容量比当前添加元素后的值还小，就更新新数组容量
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            // 如果添加当前元素后的容量比最大数组容量还大，就
            newCapacity = hugeCapacity(minCapacity);
        }
        // 数组完成扩容
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 添加元素时，如果添加后的大小大于数组最大大小，则进行扩充
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    // 添加方法，在指定位置添加索引
    public void add(int index, E element) {
        // 判断要插入的索引位置是否合法
        rangeCheckForAdd(index);
        // 判断添加元素后的容量是否有效
        ensureCapacityInternal(size + 1);
        // 校验完成后，作一次数组元素的拷贝
        // 把elementData从index开始拷贝，拷贝到elementData中下标为index+1的位置，长度为size-index
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        // 把下标index位置的值赋值为element
        elementData[index] = element;
        // 实际元素个数自增
        size++;
    }

    // 判断当前index索引是否合法
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            // 报错索引越界异常
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    // 索引月结异常的异常输出信息
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    // 将一个集合的元素添加到ArrayList
    public boolean addAll(Collection<? extends E> c) {
        // 把集合转为数组
        Object[] a = c.toArray();
        int numNew = a.length;
        // 校验添加集合元素后的容量是否合法/扩容
        ensureCapacityInternal(size + numNew);
        // 把a数组从0开始拷贝，拷贝到elementData中下标为size的位置，长度为numNew，也就是全部拷贝
        System.arraycopy(a, 0, elementData, size, numNew);
        // 拷贝成功后，改变size容量
        size += numNew;
        // 要添加的集合有数据就返回true代表添加成功，否则返回失败
        return numNew != 0;
    }

    // 将一个集合的元素添加到ArrayList的指定位置
    public boolean addAll(int index, Collection<? extends E> c) {
        // 校验索引的有效性
        rangeCheckForAdd(index);
        // 把集合转为数组
        Object[] a = c.toArray();
        // 记录集合的长度
        int numNew = a.length;
        // 校验添加集合元素后的容量是否合法并扩容
        ensureCapacityInternal(size + numNew);
        // 要移动元素的个数
        int numMoved = size - index;
        // 判断需要移动的个数是否大于0
        if (numMoved > 0) {
            // 把elementData上从index开始的元素移动到elementData上index+numNew下标开始的元素，移动个数为numMoved
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
        }
        // 把a数组中下标从0开始的元素，移动到elementData中下标从index开始的元素，长度为numNew
        System.arraycopy(a, 0, elementData, index, numNew);
        // 拷贝成功后，改变size容量
        size += numNew;
        // 要添加的集合有数据就返回true代表添加成功，否则返回失败
        return numNew != 0;
    }

    // 根据索引修改集合的元素
    public E set(int index, E element) {
        // 校验索引是否越界
        rangeCheck(index);
        // 根据索引取出元素-->被替换的元素
        E oldValue = elementData(index);
        // 把element存入到elementData中
        elementData[index] = element;
        // 返回被替换的元素
        return oldValue;
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    // 校验索引
    private void rangeCheck(int index) {
        if (index >= size) {
            // 报错索引越界异常
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    // 根据索引获取元素
    public E get(int index) {
        // 校验索引
        rangeCheck(index);
        // 根据索引获取数组中的元素
        return elementData(index);
    }

    // ArrayList删除元素的方法
    public boolean remove(Object o) {
        // 判断要删除的元素是否为null
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                // 遍历集合的元素，和要删除的元素比较，如果相等则调用方法删除
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    // 真正删除元素的方法
    private void fastRemove(int index) {
        // 集合修改次数自增
        modCount++;
        // 计算集合要移动元素的个数
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // 移动的核心代码:把elementData数组中下标从index + 1开始的元素，移动到elementData中下标从index开始的元素，长度为numMoved
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        // 让删除的元素设为null，为了尽快被垃圾回收机制回收
        elementData[--size] = null;
    }

    // 获取的方法迭代器
    public Iterator<E> iterator() {
        return new Itr();
    }

    // ArrayList集合的内部类-->迭代器的源码
    private class Itr implements Iterator<E> {
        // 光标，默认值0
        int cursor;
        // 记录 -1
        int lastRet = -1;
        // 将集合实际修改次数赋值给预期修稿次数
        int expectedModCount = modCount;

        // 判断集合是否有元素
        public boolean hasNext() {
            // 光标是否不等于集合的实际元素个数
            return cursor != size;
        }

        public E next() {
            // 校验预期修改次数和实际修改次数是否一样(有无并发修改异常)
            checkForComodification();
            // 将光标赋值给i
            int i = cursor;
            if (i > size) {
                // 如果光标大于集合的size说明没有元素，抛出无元素异常
                throw new NoSuchElementException();
            }
            // 把集合存储数据数组的地址赋值给该方法的局部变量
            Object[] elementData = ArrayList.this.elementData;
            // 进行判断，如果条件满足，就会产生并发修改异常
            if (i > elementData.length) {
                throw new ConcurrentModificationException();
            }
            // 光标自增
            cursor = i + 1;
            // 从数组中取出元素并返回，同时赋值i给lastRet
            return (E) elementData[lastRet = i];
        }

        // 校验预期修改次数和实际修改次数是否一样(有无并发修改异常)
        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        // 迭代器自带的remove方法
        public void remove() {
            // 判断是否是非法状态
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            // 校验是否存在并发修改异常
            checkForComodification();
            try {
                // 实际调用ArrayList的remove方法删除上一个下标的元素
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                // 把实际修改集合次数赋值给预期修改次数，所以不会产生并发修改异常
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    // 清空集合所有数据
    public void clear() {
        // 修改次数自增
        modCount++;
        for (int i = 0; i < size; i++) {
            // 把集合底层数组上每个元素设为null，让垃圾回收器尽早的回收
            elementData[i] = null;
        }
        // 集合实际元素个数设为0
        size = 0;
    }

    // 判断集合是否包含指定元素
    public boolean contains(Object o) {
        // 调用indexOf方法
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        // 判断要找的元素是否为null，找到了返回该元素第一次出现的索引
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        // 没找到返回-1
        return -1;
    }

    // 判断集合是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 将集合转数组的方法
    public Object[] toArray() {
        // 调用数组工具类的方法
        return Arrays.copyOf(elementData, size);
    }

    public int size() {
        return size;
    }

}
