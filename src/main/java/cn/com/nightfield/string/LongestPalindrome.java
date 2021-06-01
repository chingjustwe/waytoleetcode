package cn.com.nightfield.string;

import java.util.Random;

/**
 * @author: zhochi
 * @create: 2020/11/7
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 思路：
 * 先找到回文字符串的两个中间对称标志，如aa和aba，分别计算由此展开的最大长度
 *
 **/
public class LongestPalindrome {
    public String solution(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int maxLength = 1, strLength = s.length(), tempLength, strStartIndex = 0;
        for (int i = 0; i < strLength; i++) {
            if (i + 2 < strLength && s.charAt(i) == s.charAt(i + 2)) {
                tempLength = findPalindrome3(s, i + 1);
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                    strStartIndex = i + 1 - (maxLength / 2);
                }
            }
            if (i + 1 < strLength && s.charAt(i) == s.charAt(i + 1)) {
                tempLength = findPalindrome2(s, i);
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                    strStartIndex = i + 1 - (maxLength / 2);
                }
            }
        }
        return s.substring(strStartIndex, strStartIndex + maxLength);
    }

    private int findPalindrome3(String s, int middleIndex) {
        int strLength = s.length(), maxLength = 3;
        for (int i = middleIndex - 2, j = middleIndex + 2; i >= 0 && j < strLength; i--, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                maxLength += 2;
            }
            else
                break;
        }
        return maxLength;
    }

    private int findPalindrome2(String s, int middleIndex) {
        int strLength = s.length(), maxLength = 2;
        for (int i = middleIndex - 1, j = middleIndex + 2; i >= 0 && j < strLength; i--, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                maxLength += 2;
            }
            else
                break;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<16;i++){
            int number=random.nextInt(5) + 97;
            sb.append((char) number);
        }

        String s = sb.toString();
        s = "bbbbbba";
        System.out.println(s);
        System.out.println(longestPalindrome.solution(s));
    }
}
