package cn.com.nightfield.dp;

/**
 * @author: zhochi
 * @create: 2021/4/25
 *
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *     例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 **/
public class LongestCommonSubsequence {
    public int solution(String text1, String text2) {
        // no special boundary check

        int length1 = text1.length(), length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        // base case init
        for (int i = 0; i < length1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < length2; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // common length ++
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    // pick the larger predp
                    int predp1 = dp[i - 1][j];
                    int predp2 = dp[i][j - 1];
                    dp[i][j] = Math.max(predp1, predp2);
                }
            }
        }

        return dp[length1][length2];
    }
}
