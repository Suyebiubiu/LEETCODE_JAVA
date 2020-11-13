package cn.swordOffer.num02;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/13 18:23
 * 第二题：设计一个类，只能生成该类的一个实例
 */
public class SlugSingleTon6 {
    // 懒汉式：静态内部类方式，非常推荐，线程安全
    // 重写构造方法，构造方法私有化
    private SlugSingleTon6() {
    }

    // 静态内部类方式，在SingleTonHolder类中创建实例对象，并且用private和static修饰
    private static class SingleTonHolder {
        private static SlugSingleTon6 instance = new SlugSingleTon6();
    }

    // 用static修饰
    public static SlugSingleTon6 getInstance() {
        return SingleTonHolder.instance;
    }
}
