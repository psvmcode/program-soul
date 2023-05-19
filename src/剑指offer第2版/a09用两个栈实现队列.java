package 剑指offer第2版;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.Vector;

/**
 * @Author dongboy
 * @what time    2023/1/25 18:23
 */
public class a09用两个栈实现队列 {
}

class CQueue {

    Deque<Integer> inStack; // 专门用于数据输入
    Deque<Integer> outStack; // 专门输出，顺便调整数据

    public CQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        // 如果输出栈为空，把输入栈的数据弹出并存在输入栈中，这样同时能保证先进先出的顺序
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
}

//// 太过暴力(回家等通知解法)
//class CQueue {
//
//    Stack<Integer> stack1; // 存储元素的栈，保持元素先进先出
//    Stack<Integer> stack2; // 赋值栈
//
//    public CQueue() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        stack2.push(value);
//        while (!stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//    }
//
//    public int deleteHead() {
//        if (stack1.isEmpty()) {
//            return -1;
//        }
//        return stack1.pop();
//    }
//}
