package cn.com.nightfield.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zhochi
 * @create: 2021/4/20
 *
 * https://leetcode-cn.com/problems/min-stack/
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) —— 将元素 x 推入栈中。
 *     pop() —— 删除栈顶的元素。
 *     top() —— 获取栈顶元素。
 *     getMin() —— 检索栈中的最小元素。
 *
 **/
public class MinStack {
    private Deque<Long> stack;
    private long minValue;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minValue = val;
            stack.push(0l);
            return;
        }

        stack.push(val - minValue);

        if (val < minValue) {
            minValue = val;
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            long gap = stack.pop();
            if (gap < 0) {
                minValue = minValue - gap;
            }
        }
    }

    public int top() {
        long gap = stack.peek();
        if (gap < 0) {
            return (int) minValue;
        }
        else {
            return (int) (gap + minValue);
        }
    }

    public int getMin() {
        return (int) minValue;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
