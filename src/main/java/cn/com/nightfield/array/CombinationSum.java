package cn.com.nightfield.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhochi
 * @create: 2021/5/20
 *
 * https://leetcode-cn.com/problems/combination-sum
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 *
 **/
public class CombinationSum {
    int[] candidates;
    int target;
    List<List<Integer>> result;

    public List<List<Integer>> solution(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.result = new ArrayList<>();
        traceBack(0, new ArrayList<>(), 0);
        return result;
    }

    private List<Integer> traceBack(int prevSum, List<Integer> prevList, int currentIndex) {
        int currentSum = prevSum + candidates[currentIndex];
        if (currentSum == target) {
            result.add(prevList);
            return new ArrayList<>();
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            if (currentSum > target) {
                break;
            }
            prevList.add(candidates[currentIndex]);
            traceBack(currentSum, prevList, currentIndex);
        }
        return prevList;
    }
}
