package cn.com.nightfield.string;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/multiply-strings/
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 **/
public class MultiplyStrings {
    public String solution(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int length1 = num1.length(), length2 = num2.length();
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int[] result = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            int n1 = arr1[i] - '0', base1 = length1 - i - 1;
            for (int j = length2 - 1; j >= 0; j--) {
                int n2 = arr2[j] - '0', base2 = length2 - j - 1;
                int temp = n1 * n2;
                addIntoResult(result, temp, base1 + base2);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[0] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    private void addIntoResult(int[] result, int temp, int rightOffset) {
        int index = result.length - rightOffset - 1;
        int finalResult = result[index] + temp, one = finalResult % 10, promote = finalResult / 10;
        result[index] = one;
        if (promote > 0) {
            addIntoResult(result, promote, ++rightOffset);
        }
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.solution("123", "456"));
    }
}
