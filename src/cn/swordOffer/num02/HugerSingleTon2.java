package cn.swordOffer.num02;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/13 18:23
 * 第二题：设计一个类，只能生成该类的一个实例
 */
public class HugerSingleTon2 {
    // 饿汉式：在静态代码块实例对象
    // 提前声明一个对象，但是不进行实例化操作 private static修饰
    private static HugerSingleTon2 myInstance;

    // 在静态代码中实例化对象
    static {
        myInstance = new HugerSingleTon2();
    }

    // 重写构造方法，构造方法私有化
    private HugerSingleTon2() {
    }

    // 获取实例的方法，用static修饰
    public static HugerSingleTon2 getInstance() {
        return myInstance;
    }
}
