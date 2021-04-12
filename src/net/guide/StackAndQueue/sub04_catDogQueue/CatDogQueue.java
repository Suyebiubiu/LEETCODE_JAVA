package net.guide.StackAndQueue.sub04_catDogQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 16:52
 */
public class CatDogQueue {
    private Queue<PetPlus> dogQueue;
    private Queue<PetPlus> catQueue;
    private long count;

    public CatDogQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("cat")) catQueue.add(new PetPlus(pet, count++));
        else if (pet.getPetType().equals("dog")) dogQueue.offer(new PetPlus(pet, count++));
        else throw new RuntimeException("这个动物不是狗，也不是猫");
    }

    public boolean isCatQueueEmpty() {
        return catQueue.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatAndDogEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public Cat pollCat() {
        if (!catQueue.isEmpty()) return (Cat) catQueue.poll().getPet();
        else throw new RuntimeException("猫队列为空");
    }

    public Dog pollDog() {
        if (!dogQueue.isEmpty()) return (Dog) dogQueue.poll().getPet();
        else throw new RuntimeException("狗队列为空");
    }
}
