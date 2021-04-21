package cn.com.nightfield.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: zhochi
 * @create: 2020/12/2
 *
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 **/
public class GetLeastNumbers {
    public int[] solution(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
