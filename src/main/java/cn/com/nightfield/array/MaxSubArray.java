package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 **/
public class MaxSubArray {
    public int solution(int[] nums) {
        int max = nums[0], preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            max = Math.max(max, preSum);
        }
        return max;
    }
}
