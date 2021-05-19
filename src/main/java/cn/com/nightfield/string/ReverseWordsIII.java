package cn.com.nightfield.string;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 **/
public class ReverseWordsIII {
    public String solution(String s) {
        /*Deque<Character> stack = new LinkedList<>();
        String[] segs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < segs.length; i++) {
            for (int j = 0; j < segs[i].length(); j++) {
                stack.push(segs[i].charAt(j));
            }
            sb.setLength(0);
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            segs[i] = sb.toString();
        }

        return String.join(" ", segs);*/

        String[] segs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < segs.length; i++) {
            char[] arr = segs[i].toCharArray();

            for (int left = 0, right = segs[i].length() - 1; left < right; left++, right--) {
                if (arr[left] == arr[right]) {
                    continue;
                }

                arr[left] ^= arr[right];
                arr[right] ^= arr[left];
                arr[left] ^= arr[right];
            }

            sb.append(arr);
            if (i < segs.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsIII reverseWordsIII = new ReverseWordsIII();
        reverseWordsIII.solution("");
    }
}
