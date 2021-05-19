package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/23
 *
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 **/
public class MaximalSquare {
    public int solution(char[][] matrix) {
        int width, height, max = 0;
        if (matrix == null || (width = matrix.length) == 0 || (height = matrix[0].length) == 0) {
            return 0;
        }

        int[][] dp = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    }
                }
                else {
                    // dp[i][j] = 0;
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max * max;
    }
}
