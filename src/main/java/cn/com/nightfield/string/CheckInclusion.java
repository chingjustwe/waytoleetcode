package cn.com.nightfield.string;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 **/
public class CheckInclusion {
    public boolean solution(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length(), diffCount = 0;
        if (length1 > length2) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < length1; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                diffCount++;
            }
        }
        if (diffCount == 0) {
            return true;
        }

        int left = 0, right = length1;

        for (; right < length2; left++, right++) {
            char c1 = s2.charAt(left), c2 = s2.charAt(right);
            if (c1 == c2) {
                continue;
            }

            if (++arr[c1 - 'a'] == 0) {
                diffCount--;
            } else if (arr[c1 - 'a'] == 1) {
                diffCount++;
            }

            if (--arr[c2 - 'a'] == 0) {
                diffCount--;
            } else if (arr[c2 - 'a'] == -1) {
                diffCount++;
            }

            if (diffCount == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        checkInclusion.solution("ab", "eidbaooo");
    }
}
