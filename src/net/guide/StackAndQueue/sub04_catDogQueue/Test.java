package net.guide.StackAndQueue.sub04_catDogQueue;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/9 8:54
 */
public class Test {
    public static void main(String[] args) {
        CatDogQueue queue = new CatDogQueue();
        queue.add(new Cat("cat", "cat01"));
        queue.add(new Cat("cat", "cat02"));
        queue.add(new Cat("cat", "cat03"));
        queue.add(new Cat("cat", "cat04"));
        queue.add(new Dog("dog", "dog01"));
        queue.add(new Dog("dog", "dog02"));
        queue.add(new Dog("dog", "dog03"));
        queue.add(new Dog("dog", "dog04"));
        System.out.println(queue.isCatAndDogEmpty());
        System.out.println(queue.isDogQueueEmpty());
        System.out.println(queue.isCatAndDogEmpty());
        System.out.println(queue.pollCat());
    }
}
