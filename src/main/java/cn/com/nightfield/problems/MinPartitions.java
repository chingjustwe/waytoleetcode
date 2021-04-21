package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/1/15
 *
 * https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
 *
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 *
 **/
public class MinPartitions {
    public int solution(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            int ithChar = Integer.valueOf(String.valueOf(n.charAt(i)));
            if (ithChar > max) {
                max = ithChar;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MinPartitions minPartitions = new MinPartitions();
        System.out.println(minPartitions.solution("32"));
        System.out.println(minPartitions.solution("82734"));
        System.out.println(minPartitions.solution("27346209830709182346"));
    }
}
