package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/22
 *
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 **/
public class FindLengthOfLCIS {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length, result = 1, max = 1;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                result++;
                if (result > max) {
                    max = result;
                }
            }
            else
                result = 1;
        }
        return max;
    }
}
