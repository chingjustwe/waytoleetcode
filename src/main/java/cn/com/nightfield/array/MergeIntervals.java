package cn.com.nightfield.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 **/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        List<int[]> result = new LinkedList<>();
        // sort by first element
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // loop through intervals
        for (int i = 1; i < intervals.length; i++) {
            // intersect
            if (intervals[i - 1][1] >= intervals[i][0]) {
                // merge two intervals
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
            else {
                result.add(intervals[i - 1]);
            }
        }
        result.add(intervals[intervals.length - 1]);

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervls = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(intervls);
    }

}
