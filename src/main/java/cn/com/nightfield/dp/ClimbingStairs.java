package cn.com.nightfield.dp;

/**
 * @author: zhochi
 * @create: 2021/5/19
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 **/
public class ClimbingStairs {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        return climb(n, dp);
    }

    private int climb(int n, int[] dp) {
        if (n <= 2) {
            dp[n] = n;
            return n;
        }
        // in case duplicate
        if (dp[n] != 0) {
            return dp[n];
        }

        // transform
        // it can be divided to smaller problem
        dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
        return dp[n];
    }
}
