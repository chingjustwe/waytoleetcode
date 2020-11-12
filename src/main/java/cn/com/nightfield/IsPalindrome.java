package cn.com.nightfield;

import java.util.Random;

/**
 * @author: zhochi
 * @create: 2020/11/8
 *
 * https://leetcode-cn.com/problems/palindrome-number/
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 思路：
 * 将数字反转之后，判断是否与原数字相等
 **/
public class IsPalindrome {
    public boolean solution(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int originalX = x, reverseX = x % 10;
        while ((x /= 10) > 0) {
            reverseX = reverseX * 10 + x % 10;
        }

        return originalX == reverseX;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

        System.out.println("121:" + isPalindrome.solution(121));
        System.out.println("-121" + isPalindrome.solution(-121));
        System.out.println("10" + isPalindrome.solution(10));
    }
}
