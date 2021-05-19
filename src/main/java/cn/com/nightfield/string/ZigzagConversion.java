package cn.com.nightfield.string;

/**
 * @author: zhochi
 * @create: 2021/4/28
 *
 * https://leetcode-cn.com/problems/zigzag-conversion
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数
 *
 **/
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        // boundary check
        if (numRows == 1) {
            return s;
        }

        int totalStep = numRows * 2 - 2, length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            // there are two steps on each phase
            int step1 = totalStep - i * 2, step2 = i * 2, current = i;
            while (current < length) {
                if (step1 != 0) {
                    sb.append(s.charAt(current));
                    current += step1;
                }
                if (step2 != 0 && current < length) {
                    sb.append(s.charAt(current));
                    current += step2;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));
    }
}
