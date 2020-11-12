package cn.com.nightfield;

import java.util.Random;

/**
 * @author: zhochi
 * @create: 2020/11/8
 *
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。

 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 思路：
 * 1. 先判断符号位，是+还是-
 * 2. 找到符号位之后，一直往后匹配数字，直到遇到非法字符，结束
 * 3. 先用long类型存放结果，用来判断是否有溢出
 **/
public class MyAtoi {
    public int solution(String s) {
        int minChar = '0', maxChar = '9', negativeChar = '-', positiveChar = '+', spaceChar = ' ', sign = 0;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sign == 0) {
                if (c == negativeChar) {
                    sign = -1;
                } else if (c == positiveChar) {
                    sign = 1;
                } else if (c == spaceChar) {
                    continue;
                } else if (minChar <= c && maxChar >= c) {
                    sign = 1;
                    int value = Integer.valueOf(String.valueOf(c));
                    result = result * 10 + value;
                } else {
                    break;
                }
            }
            else if (minChar <= c && maxChar >= c) {
                int value = Integer.valueOf(String.valueOf(c));
                result = result * 10 + value;
            }
            else {
                // invalid characters
                break;
            }

            // overflow check
            if (sign == -1 && Integer.MIN_VALUE > -result) {
                return Integer.MIN_VALUE;
            }
            if (sign == 1 && Integer.MAX_VALUE < result) {
                return Integer.MAX_VALUE;
            }
        }

        result = result * sign;
        return Math.toIntExact(result);
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<16;i++){
            int number=random.nextInt(15) + 45;
            sb.append((char) number);
        }

        String s = sb.toString();
        System.out.println(s);
        System.out.println(myAtoi.solution(s));
    }
}
