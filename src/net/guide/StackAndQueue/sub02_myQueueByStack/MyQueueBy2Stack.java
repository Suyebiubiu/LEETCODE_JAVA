package net.guide.StackAndQueue.sub02_myQueueByStack;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 11:26
 * 题目：用双栈实现队列，实现poll，add，peek
 */
public class MyQueueBy2Stack {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueueBy2Stack() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void in2Out() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
    public int poll() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) throw new RuntimeException("队列空");
        in2Out();
        return stackOut.pop();
    }
    public void offer(int newNum) {
        stackIn.push(newNum);
        in2Out();
    }
    public int peek() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) throw new RuntimeException("队列空");
        in2Out();
        return stackOut.peek();
    }
}
