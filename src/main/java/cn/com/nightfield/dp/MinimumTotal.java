package cn.com.nightfield.dp;

import java.util.List;

/**
 * @author: zhochi
 * @create: 2021/4/23
 *
 * https://leetcode-cn.com/problems/triangle/submissions/
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 **/
public class MinimumTotal {
    public int solution(List<List<Integer>> triangle) {
        int length = triangle.size();
        // initialize as length + 1 to in case overflow
        int[] dp = new int[length + 1];
        // bottom to top
        for (int i = length - 1; i >= 0; i--) {
            List<Integer> ints = triangle.get(i);
            for (int j = 0; j < ints.size(); j++) {
                dp[j] = ints.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
