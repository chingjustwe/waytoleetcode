package cn.com.nightfield.array;

/**
 * @author: zhochi
 * @create: 2021/4/28
 *
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 *
 **/
public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = max;
            if (current > max) {
                max = current;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        ReplaceElementsWithGreatestElementOnRightSide replaceElementsWithGreatestElementOnRightSide = new ReplaceElementsWithGreatestElementOnRightSide();
        int[] result = replaceElementsWithGreatestElementOnRightSide.solution(new int[]{17,18,5,4,6,1});
        for (int r : result) {
            System.out.println(r);
        }
    }
}
