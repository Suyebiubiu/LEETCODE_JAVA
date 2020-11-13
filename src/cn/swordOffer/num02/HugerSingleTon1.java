package cn.swordOffer.num02;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/13 18:23
 * 第二题：设计一个类，只能生成该类的一个实例
 */
public class HugerSingleTon1 {
    // 饿汉式，线程安全，耗费资源
    // 提前创建好单例对象，对象用private static final描述
    private static final HugerSingleTon1 instance = new HugerSingleTon1();

    // 重写构造方法，构造方法私有化
    private HugerSingleTon1() {
    }

    // 获取实例的方法，用static修饰
    public static HugerSingleTon1 getInstance() {
        return instance;
    }
}
