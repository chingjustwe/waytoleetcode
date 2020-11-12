package cn.com.nightfield;

/**
 * @author: zhochi
 * @create: 2020/11/9
 *
 * https://leetcode-cn.com/problems/container-with-most-water
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * 思路：
 * 双指针法，left指针从前往后遍历，right指针从后往前遍历，计算过程中两个指针扫过的面积中最大的那个。
 **/
public class MaxArea {
    public int solution(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left <= right) {
            int currentArea = (height[left] > height[right] ? height[right] : height[left]) * (right - left);
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,8,6,2,5,4,8,3,7};
        int[] arr2 = new int[]{1,1};
        int[] arr3 = new int[]{4,3,2,1,4};
        int[] arr4 = new int[]{1,2,1};

        MaxArea maxArea = new MaxArea();
        assert maxArea.solution(arr1) == 49;
        assert maxArea.solution(arr2) == 1;
        assert maxArea.solution(arr3) == 16;
        assert maxArea.solution(arr4) == 2;
    }
}
