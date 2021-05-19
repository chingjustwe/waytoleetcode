package cn.com.nightfield.dp;

/**
 * @author: zhochi
 * @create: 2021/4/25
 **/
public class EditDistance {
    public int solution(String word1, String word2) {
        // boundary check
        if ((word1 == null && word2 == null) || word1.equals(word2)) {
            return 0;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int length1 = word1.length(), length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                int dp1 = dp[i][j - 1];
                int dp2 = dp[i - 1][j];
                int dp3 = dp[i - 1][j - 1];
                dp[i][j] = Math.min(Math.min(dp1, dp2), dp3) + 1;
            }
        }

        return dp[length1][length2];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        editDistance.solution("a", "ab");
    }
}
