package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/22
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 **/
public class TrappingRainWater {
    public int solution(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int left = 1, right = height.length - 2;
        int lMax = height[0], rMax = height[height.length - 1];
        int result = 0;

        while (left <= right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                result += lMax - height[left];
                left++;
            }
            else {
                result += rMax - height[right];
                right--;
            }
        }

        return result;
    }
}
