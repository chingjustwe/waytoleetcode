package cn.com.nightfield.string;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/add-strings/
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 **/
public class AddStrings {
    public String solution(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1, promote = 0;
        StringBuilder builder = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0) {
            char c1 = idx1 < 0 ? '0' : num1.charAt(idx1);
            char c2 = idx2 < 0 ? '0' : num2.charAt(idx2);
            int n1 = c1 - '0', n2 = c2 - '0';
            int tempResult = n1 + n2 + promote;
            promote = tempResult / 10;
            builder.append(tempResult % 10);
            idx1--;
            idx2--;
        }
        if (promote > 0) {
            builder.append(promote);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        addStrings.solution("99", "999");
    }
}
