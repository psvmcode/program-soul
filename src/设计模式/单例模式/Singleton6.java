package 设计模式.单例模式;

/**
 * @Author dongboy
 * @what time    2022/12/30 22:33
 */
// 什么是单例模式：简单来说，创建对象的时候创建的始终是一个对象
// 保证了被全局使用的类不被频繁的创建与销毁，节省资源
// 要点一：保证全局只有一个类的实例，因此类的构造方法要私有化
// 要点二：单例类只能自己创建自己的实例，因为构造器私有，想要实例化只能自己创建
// 要点三：提供自己唯一的类给其他类，写一个公共方法返回单例类的唯一实例
public class Singleton6 {
    // 静态内部类(线程安全且效率高)
    // 当单例类被加载时，单例对象不一定被初始化，因为静态内部类没有被主动使用
    // 只有通过显示调用getInstance时才会显示加载静态内部类，从而实例化单例类
    private static class SingletonHolder {
        private static final Singleton6 instance = new Singleton6();
    }

    private Singleton6() {
    }

    public static final Singleton6 getInstance() {
        return SingletonHolder.instance;
    }
}
