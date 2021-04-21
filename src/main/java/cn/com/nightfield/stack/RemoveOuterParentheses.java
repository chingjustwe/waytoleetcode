package cn.com.nightfield.stack;

import java.util.Stack;

/**
 * @author: zhochi
 * @create: 2020/11/14
 *
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 * 思路：
 * 从左到右一个配对的过程。当左括号和右括号数量相等的时候，即找到了"有效括号字符串"，可以执行去除外括号的操作。
 * 用栈可以很清楚地描述问题，当然直接给括号计数可以有更好的执行性能。
 **/
public class RemoveOuterParentheses {
    public String solution(String S) {
        int beginIndex = 0;
        char leftBracket = '(', rightBracket = ')';
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (currentChar == leftBracket) {
                stack.push(currentChar);
            }
            else if (currentChar == rightBracket) {
                stack.pop();
            }

            if (stack.isEmpty() && i > beginIndex) {
                result.append(S, beginIndex + 1, i);//remove outer brackets;
                beginIndex = i + 1;
            }
        }

        return result.toString();
    }
}
