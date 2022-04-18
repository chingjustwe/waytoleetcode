package cn.com.nightfield.dp;

/**
 * @author: zhochi
 * @create: 2021/8/11
 *
 * https://leetcode-cn.com/problems/arithmetic-slices
 *
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *     例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 * 思路：
 * 一次遍历，每次新增的数列数量dp[i]=dp[i-1]+1或是0，统计所有的dp[i]。
 *
 **/
public class NumberOfArithmeticSlices {
    public int solution(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int result = 0, adder = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                result += ++adder;
            }
            else {
                adder = 0;
            }
        }

        return result;
    }
}