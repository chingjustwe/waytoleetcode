package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/24
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 **/
public class LengthOfLIS {
    public int solution(int[] nums) {
        // boundary check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length, max = 1;
        // LIS ends with index 'i'
        int[] dp = new int[length];
        dp[0] = 1;

        for (int i = 1; i < length; i++) {
            int preMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    preMax = Math.max(preMax, dp[j]);
                }
            }
            dp[i] = preMax + 1;
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
