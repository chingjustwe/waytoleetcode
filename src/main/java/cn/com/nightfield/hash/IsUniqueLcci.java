package cn.com.nightfield.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 *
 * 限制：
 *
 *     0 <= len(s) <= 100
 *     如果你不使用额外的数据结构，会很加分。
 *
 * https://leetcode-cn.com/problems/is-unique-lcci/
 *
 * @author: zhochi
 * @create: 2022/3/3
 **/
public class IsUniqueLcci {
    public boolean isUnique(String astr) {
        /*
        // using array as a status cache
        char[] charArr = new char[256];
        for (char c : astr.toCharArray()) {
            if (charArr[(int)c] != 0) {
                return false;
            }
            else {
                charArr[(int)c] = 1;
            }
        }
        return true;
        */

        // set to hold duplicate chars
        Set<Character> characterSet = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (characterSet.contains(c)) {
                return false;
            }
            else {
                characterSet.add(c);
            }
        }
        return true;
    }
}
