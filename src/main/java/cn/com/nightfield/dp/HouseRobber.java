package cn.com.nightfield.dp;

/**
 * @author: zhochi
 * @create: 2021/4/25
 *
 * https://leetcode-cn.com/problems/house-robber
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 **/
public class HouseRobber {
    public int solution(int[] nums) {
        // boundary check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;
        // element in dp: the max profit
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            // current max-profit depends on pre two dp result
            int steelProfit = dp[0] + nums[i];
            int notSteelProfit = dp[1];
            // update dp
            dp[0] = dp[1];
            dp[1] = Math.max(steelProfit, notSteelProfit);
        }
        return dp[1];
    }
}
