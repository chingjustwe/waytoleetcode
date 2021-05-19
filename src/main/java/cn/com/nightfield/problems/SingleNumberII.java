package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/single-number-ii/
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 **/
public class SingleNumberII {
    public int solution(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }

        return result;
    }
}
