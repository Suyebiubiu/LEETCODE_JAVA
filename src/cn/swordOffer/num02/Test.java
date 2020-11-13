package cn.swordOffer.num02;

/**
 * @author GONG
 * @version 1.0
 * @date 2020/11/13 19:06
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("方法一：饿汉式：直接实例化一个对象");
        HugerSingleTon1 instance1 = HugerSingleTon1.getInstance();
        HugerSingleTon1 instance2 = HugerSingleTon1.getInstance();
        System.out.println(instance1.equals(instance2));

        System.out.println("方法二：饿汉式：在静态方法中实例化一个对象");
        HugerSingleTon2 instance3 = HugerSingleTon2.getInstance();
        HugerSingleTon2 instance4 = HugerSingleTon2.getInstance();
        System.out.println(instance3.equals(instance4));

        System.out.println("方法三：懒汉式：在getInstance方法中判断是否为空，属于线程不安全的");
        SlugSingleTon3 instance5 = SlugSingleTon3.getInstance();
        SlugSingleTon3 instance6 = SlugSingleTon3.getInstance();
        System.out.println(instance5.equals(instance6));

        System.out.println("方法四：懒汉式：给方法加synchronized锁");
        SlugSingleTon4 instance7 = SlugSingleTon4.getInstance();
        SlugSingleTon4 instance8 = SlugSingleTon4.getInstance();
        System.out.println(instance7.equals(instance8));

        System.out.println("方法五：懒汉式：双重检查锁，线程安全，省时间，不必刚上来就上锁");
        SlugSingleTon5 instance9 = SlugSingleTon5.getInstance();
        SlugSingleTon5 instance10 = SlugSingleTon5.getInstance();
        System.out.println(instance9.equals(instance10));

        System.out.println("方法六：懒汉式：使用静态内部类形式实现");
        SlugSingleTon6 instance11 = SlugSingleTon6.getInstance();
        SlugSingleTon6 instance12 = SlugSingleTon6.getInstance();
        System.out.println(instance11.equals(instance12));

        System.out.println("方法七：懒汉式：使用枚举类实现单例模式");
        SlugSingleTon7 instance13 = SlugSingleTon7.getInstance();
        SlugSingleTon7 instance14 = SlugSingleTon7.getInstance();
        System.out.println(instance13.equals(instance14));
    }
}
