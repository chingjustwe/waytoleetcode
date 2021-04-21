package cn.com.nightfield.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *     无空格字符构成一个 单词 。
 *     输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *     如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 **/
public class ReverseWords {
    public String solution(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        Deque<String> stack = new LinkedList<>();
        for (String word : words) {
            stack.push(word);
        }

        if (stack.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder(stack.pop());
        while (!stack.isEmpty()) {
            sb.append(" " + stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.solution("  hello world!  "));
    }
}
