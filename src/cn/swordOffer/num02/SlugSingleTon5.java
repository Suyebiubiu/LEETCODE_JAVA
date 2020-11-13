package cn.swordOffer.num02;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/13 18:23
 * 第二题：设计一个类，只能生成该类的一个实例
 */
public class SlugSingleTon5 {
    // 懒汉式：线程安全的方式，先检查再上锁，并且双重检查锁（同步代码块）
    // 提前声明一个对象，但是不进行实例化操作 private static修饰
    private static SlugSingleTon5 myInstance;

    // 重写构造方法，构造方法私有化
    private SlugSingleTon5() {
    }

    // 给方法加synchronized锁，并且用static修饰，判断实例是否为空，为空创建一个实例，非空的话直接输出
    public synchronized static SlugSingleTon5 getInstance() {
        if (myInstance == null) {
            synchronized (SlugSingleTon5.class) {
                if (myInstance == null) {
                    myInstance = new SlugSingleTon5();
                }
            }
        }
        return myInstance;
    }
}
