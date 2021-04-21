package cn.com.nightfield.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zhochi
 * @create: 2021/4/17
 *
 * https://leetcode-cn.com/problems/validate-stack-sequences
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 **/
public class ValidateStackSequences {
    public boolean solution(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int pushIndex = 0;
        for (int popItem : popped) {
            while (stack.isEmpty() || (pushIndex < pushed.length && stack.peek() != popItem)) {
                stack.push(pushed[pushIndex]);
                pushIndex++;
            }

            if (stack.pop() != popItem) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        validateStackSequences.solution(pushed, popped);
    }
}
