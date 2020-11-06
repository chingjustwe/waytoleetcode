package cn.com.nightfield;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: zhochi
 * @create: 2020/11/6
 *
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 2) {
            throw new RuntimeException("Illegal input param.");
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new RuntimeException("Did not find matched elements.");
    }

    // verify
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        Random random = new Random();
        int[] nums = new int[16];
        for (int i = 0; i < 16; i++) {
            // set to a huge bound incase duplicate
            nums[i] = random.nextInt(100000);
        }
        System.out.println("array: " + Arrays.toString(nums));

        // incase index duplicate
        int index1 = random.nextInt(8);
        int index2 = random.nextInt(8) + 8;
        int target = nums[index1] + nums[index2];
        System.out.println("target: " + target);

        System.out.println("index1: " + index1 + ", index2: " + index2);

        int[] result = twoSum.twoSum(nums, target);

        System.out.println("index1: " + result[0] + ", index2: " + result[1]);

        assert index1 == result[0];
        assert index2 == result[1];
    }
}
