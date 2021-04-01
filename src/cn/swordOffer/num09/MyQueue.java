package cn.swordOffer.num09;

import java.util.Stack;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/8 19:40
 */
public class MyQueue {
    //两个栈，一个出栈，一个入栈
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        //如果第二个栈非空，直接弹出栈顶元素
        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        } else {//如果第二个栈为空
            //第二个栈为空，并且第一个栈也是空的
            if (stackIn.isEmpty()) return -1;
            //第二个栈为空，第一个栈非空
            while (!stackIn.isEmpty()) {
                //将第一个栈中元素挨个放到第二个栈中
                stackOut.push(stackIn.pop());
            }
            //将第一个栈中元素压到第二栈结束
            //这个时候第二个栈中已经有元素了
            //可以直接弹出
            return stackOut.pop();
        }
    }
}
