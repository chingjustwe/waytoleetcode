package cn.com.nightfield.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: zhochi
 * @create: 2021/4/25
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 **/
public class MaxSlidingWindow {
    // priority queue
    public int[] solution(int[] nums, int k) {
        // boundary check

        int[] result = new int[nums.length - k + 1];
        Queue<Pair> heap = new PriorityQueue<>((n1, n2) -> n2.number - n1.number);
        for (int i = 0; i < k; i++) {
            heap.offer(new Pair(i, nums[i]));
        }
        result[0] = heap.peek().number;

        for (int i = k; i < nums.length; i++) {
            heap.offer(new Pair(i, nums[i]));
            while (heap.peek().index <= (i - k)) {
                heap.poll();
            }
            result[i - k + 1] = heap.peek().number;
        }

        return result;
    }
    private static class Pair {
        int index;
        int number;
        public Pair(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }

    // decreasing queue
    public int[] solution2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Pair> queue = new LinkedList<>();

        Pair temp;
        for (int i = 0; i < k; i++) {
            // ensure queue is increasing
            while ((temp = queue.peekFirst()) != null && temp.number < nums[i]) {
                queue.pollFirst();
            }
            queue.offerFirst(new Pair(i, nums[i]));
        }
        result[0] = queue.peekLast().number;

        for (int i = k; i < nums.length; i++) {
            // ensure queue is increasing
            while ((temp = queue.peekFirst()) != null && temp.number < nums[i]) {
                queue.pollFirst();
            }
            queue.offerFirst(new Pair(i, nums[i]));

            // remove out-of-range numbers
            if ((temp = queue.peekLast()) != null && temp.index <= i - k) {
                queue.pollLast();
            }

            result[i - k + 1] = queue.peekLast().number;;
        }

        return result;
    }
}
