package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/28
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 **/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        if (m == 0) {

        }
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            int first = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int second = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            if (first > second) {
                nums1[i + j + 1] = first;
                i--;
            }
            else {
                nums1[i + j + 1] = second;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{}, 0, new int[]{1}, 1);
    }
}
