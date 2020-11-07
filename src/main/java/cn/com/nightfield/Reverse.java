package cn.com.nightfield;

import java.util.Random;

/**
 * @author: zhochi
 * @create: 2020/11/7
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 思路：
 * 基本解法很简单，对数字不断地除以10，得到末位，然后添加到新数字上去，有两点需要注意：
 * 1. 正数和负数的情况处理方式不同，所以这里统一先用正数的方式去处理，最后返回结果时带上符号
 * 2. 为了处理int溢出的情况，先将int转化为long，如果最后结果比Integer.MAX_VALUE大，说明溢出了，直接返回0
 **/
public class Reverse {
    public int reverse(int x) {
        long l = x;// cast to long to handle overflow
        int sign = l < 0 ? -1 : 1;
        if (l < 0) {
            // change to positive
            l = Math.abs(l);
        }
        long result = l % 10l;
        while ((l = l / 10) > 0) {
            result = result * 10 + l % 10;
        }
        // overflow
        if (result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)result * sign;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int i = new Random().nextInt();
        System.out.println(i);
        System.out.println(reverse.reverse(i));
    }
}
