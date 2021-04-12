package net.guide.StackAndQueue.sub03_reverseStackByRecursion;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/4/7 15:53
 * 题目：利用递归函数逆序一个栈
 */
public class ReverseStackByRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    //将一个stack逆序，栈顶到栈底：321
    //拿到1，逆序32，拿到2，逆序3，拿到3，
    //push进3 ，push进去2，push进去1
    //最后顺序为：栈顶到栈底：123
    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int i = getAndRemoveLastElement(stack);//i =1
        reverseStack(stack);//i = 2;i=3;
        stack.push(i);
    }

    //移除并返回当前栈底元素
    //拿到3，拿到2，拿到1，return 1，push进去2，push进去3
    //最后的结果：栈顶到栈底：32
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int ans = stack.pop();
        if (stack.isEmpty()) return ans;
        else {
            int last = getAndRemoveLastElement(stack);
            stack.push(ans);
            return last;
        }
    }

}
