package cn.swordOffer.num02;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/13 18:23
 * 第二题：设计一个类，只能生成该类的一个实例
 */
public class SlugSingleTon3 {
    // 懒汉式：非线程安全的方式
    // 提前声明一个对象，但是不进行实例化操作 private static修饰
    private static SlugSingleTon3 myInstance;

    // 重写构造方法，构造方法私有化
    private SlugSingleTon3() {
    }

    // 获取实例的方法，用static修饰，判断实例是否为空，为空创建一个实例，非空的话直接输出
    public static SlugSingleTon3 getInstance() {
        if (myInstance == null) {
            myInstance = new SlugSingleTon3();
        }
        return myInstance;
    }
}
