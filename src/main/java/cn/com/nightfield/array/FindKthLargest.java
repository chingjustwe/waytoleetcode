package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/23
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 **/
public class FindKthLargest {
    public int solution(int[] nums, int k) {
        int length = nums.length;
        for (int i = (length >> 1); i >= 0; i--) {
            heapify(nums, i, length);
        }

        for (int i = length - 1; i > nums.length - k - 1; i--) {
            swap(nums, 0, i);
            length--;
            heapify(nums, 0, length);
        }

        return nums[nums.length - k];
    }

    private void heapify(int[] nums, int i, int size) {
        int left = i * 2 + 1, right = i * 2 + 2, max = i;
        if (left < size && nums[left] > nums[max]) {
            max = left;
        }
        if (right < size && nums[right] > nums[max]) {
            max = right;
        }
        if (max != i) {
            swap(nums, i, max);
            heapify(nums, max, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.solution(new int[]{1}, 1));
    }
}
