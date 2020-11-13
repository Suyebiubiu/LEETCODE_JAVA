package cn.swordOffer.num02;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/13 18:23
 * 第二题：设计一个类，只能生成该类的一个实例
 */
public class SlugSingleTon7 {
    // 懒汉式：使用枚举类实现
    // 重写构造方法，构造方法私有化
    private SlugSingleTon7() {
    }

    // 静态内部类方式，在SingleTonHolder类中创建实例对象，并且用private和static修饰
    private static class SingleTonHolder {
        private static SlugSingleTon7 instance = new SlugSingleTon7();
    }

    // 用static修饰
    public static SlugSingleTon7 getInstance() {
        return SingleTon.INSTANCE.getInstance();
    }

    private enum SingleTon {
        INSTANCE;
        private SlugSingleTon7 myInstance;

        //jvm保证方法只被调用一次
        SingleTon() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("枚举类构造函数运行");
            myInstance = new SlugSingleTon7();
        }

        public SlugSingleTon7 getInstance() {
            return myInstance;
        }
    }
}
