package net.guide.StackAndQueue.sub05_sortStackByStack;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 17:10
 * 题目：利用另外一个栈将栈进行排序
 */
public class SortStackByStack {
    //将一个stack栈从栈顶到栈底从大到小排序
    public static void sortStack1(Stack<Integer> stack) {
        //借助一个辅助函数
        Stack<Integer> help = new Stack<>();//希望从上到下，递增
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    //将一个stack栈从栈顶到栈底从小到大排序
    public static void sortStack2(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();//辅助栈，希望从上到下，递减
        while (!stack.isEmpty()) {//待排序栈非空的话
            int cur = stack.pop();//弹出栈顶元素
            while (!help.isEmpty() && cur < help.peek()) {//辅助栈非空，并且辅助栈顶元素大于待排序栈弹出的栈顶元素
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(10);
        stack.push(2);
        sortStack2(stack);
//        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
