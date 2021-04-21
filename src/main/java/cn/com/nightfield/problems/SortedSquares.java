package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 **/
public class SortedSquares {
    public int[] solution(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        // two pointers
        int left = 0, right = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (-nums[left] > nums[right]) {
                result[i] = nums[left] * nums[left];
                left++;
            }
            else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;

    }
}
