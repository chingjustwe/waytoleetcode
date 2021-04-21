package cn.com.nightfield.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zhochi
 * @create: 2020/11/16
 *
 * https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * 思路：
 * 经过两次入栈，出栈操作，数据就变成了FIFO
 * 1. 定义两个栈，一个用来做入栈操作(inStack)，另一个专门用来做出栈操作(outStack)
 * 2. 对于push的操作，直接inStack入栈
 * 3. 对于peek或pop的操作，直接outStack出栈。
 * 4. 注意，为了保证FIFO的顺序，当且仅当outStack为空时，需要将inStack中的数据全部弹过来
 **/
public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        for (int i = 1; i <= 5; i++) {
            myQueue.push(i);
        }
        System.out.println(myQueue.peek());// 1
        System.out.println(myQueue.pop());// 1
        System.out.println(myQueue.pop());// 2
        System.out.println(myQueue.pop());// 3
        System.out.println(myQueue.pop());// 4
        myQueue.push(6);
        System.out.println(myQueue.peek());// 5
        System.out.println(myQueue.pop());// 5
        System.out.println(myQueue.pop());// 6
    }
}
