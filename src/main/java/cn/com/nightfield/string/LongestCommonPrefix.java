package cn.com.nightfield.string;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 **/
public class LongestCommonPrefix {
    public String solution(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if ("".equals(prefix))
                return "";
            prefix = findCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    private String findCommonPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i))
                sb.append(s1.charAt(i));
            else
                break;
        }
        return sb.toString();
    }
}
