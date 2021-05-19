package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/23
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 **/
public class SearchInRotatedSortedArray {

    public int solution(int[] nums, int target) {
        int length = nums.length, left = 0, right = length - 1, middle;
        while (left <= right) {
            // in case overflow
            middle = left + ((right - left) >> 1);
            if (nums[middle] == target) {
                return middle;
            }
            else if (nums[middle] > target) {
                // 有序
                if (nums[left] <= nums[middle] && nums[left] > target) {
                    left = middle + 1;
                }
                else {
                    right = middle - 1;
                }
            }
            // nums[middle] < target
            else {
                // 有序
                if (nums[right] >= nums[middle] && nums[right] < target) {
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.solution(new int[]{3,1}, 1));
    }
}
