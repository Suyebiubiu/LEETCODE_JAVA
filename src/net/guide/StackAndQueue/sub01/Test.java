package net.guide.StackAndQueue.sub01;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 10:59
 */
public class Test {
    public static void main(String[] args) {
        MyGetMinStack02 stack02 = new MyGetMinStack02();
        stack02.push(1);
        stack02.push(2);
        stack02.push(3);
        stack02.push(4);
        int pop = stack02.pop();
        System.out.println(pop);
        int min = stack02.getMin();
        System.out.println(min);
    }
}
