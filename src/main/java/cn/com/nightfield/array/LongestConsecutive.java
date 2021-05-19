package cn.com.nightfield.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhochi
 * @create: 2021/4/22
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 **/
public class LongestConsecutive {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // cache all number
        Set<Integer> cache = new HashSet<>();
        // memo, in case of duplicate search
        Set<Integer> processed = new HashSet<>();
        for (int num : nums) {
            cache.add(num);
        }

        int result, max = 1, left, right;
        for (int num : nums) {
            if (processed.contains(num)) {
                continue;
            }
            processed.add(num);

            result = 1;
            left = num - 1;
            right = num + 1;
            while (cache.contains(left)) {
                result++;
                processed.add(left);
                left--;
            }
            while (cache.contains(right)) {
                result++;
                processed.add(right);
                right++;
            }

            if (result > max) {
                max = result;
            }
        }

        return max;
    }
}
