package net.guide.StackAndQueue.sub01;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 10:24
 * 01题目：实现一个特殊的栈，在基本功能（push，pop）上，实现返回栈的最小元素的操作
 * 要求：pop，push，getMin时间复杂度为O(1),可以使用现成的栈结构
 * 解决思路：双栈
 */
public class MyGetMinStack01 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyGetMinStack01() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty() || newNum <= getMin()) stackMin.push(newNum);
        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) throw new RuntimeException("栈空");
        int value = stackData.pop();
        if (value == getMin()) stackMin.pop();
        return value;
    }

    public int getMin() {
        if (stackMin.isEmpty()) throw new RuntimeException("栈空");
        return stackMin.peek();
    }
}
