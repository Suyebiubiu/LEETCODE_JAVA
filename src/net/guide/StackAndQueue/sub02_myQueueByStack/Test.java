package net.guide.StackAndQueue.sub02_myQueueByStack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 15:45
 */
public class Test {
    public static void main(String[] args) {
        MyQueueBy2Stack queue1 = new MyQueueBy2Stack();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        int poll = queue1.poll();
        System.out.println(poll);
        int peek = queue1.peek();
        System.out.println(peek);
    }
}
