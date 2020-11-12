package cn.com.nightfield.brainteaser;

/**
 * @author: zhochi
 * @create: 2020/11/11
 *
 * https://leetcode-cn.com/problems/moving-stones-until-consecutive/submissions/
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 *
 * 思路：
 * 先找到a,b,c三个数的大小顺序。
 * 最大移动次数很简单，就是一次移动一格，所以中间空几格，就是几次
 * 最小移动次数，可以一次移动多格，直接移到相邻的位置。有一个特殊情况，如果两个石子空一格，那无论如何只需要另外的一颗石子移动一次就可以搞定。
 **/
public class NumMovesStones {
    public int[] solution(int a, int b, int c) {
        int temp = 0;
        if (a > b) {
            temp = a; a = b; b = temp;
        }
        if (b > c) {
            temp = b; b = c; c = temp;
        }
        if (a > b) {
            temp = a; a = b; b = temp;
        }
        int distanceLeft = b - a - 1, distanceRight = c - b - 1;
        int max = distanceLeft + distanceRight;
        int min = distanceLeft == 1 || distanceRight == 1 ? 1 : Math.min(1, distanceLeft) + Math.min(1, distanceRight);
        return new int[]{min, max};
    }
}
