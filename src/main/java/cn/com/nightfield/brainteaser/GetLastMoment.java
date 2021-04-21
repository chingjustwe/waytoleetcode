package cn.com.nightfield.brainteaser;

/**
 * @author: zhochi
 * @create: 2020/11/14
 *
 * https://leetcode-cn.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 * 有一块木板，长度为 n 个 单位 。一些蚂蚁在木板上移动，每只蚂蚁都以 每秒一个单位 的速度移动。其中，一部分蚂蚁向 左 移动，其他蚂蚁向 右 移动。
 * 当两只向 不同 方向移动的蚂蚁在某个点相遇时，它们会同时改变移动方向并继续移动。假设更改方向不会花费任何额外时间。
 * 而当蚂蚁在某一时刻 t 到达木板的一端时，它立即从木板上掉下来。
 * 给你一个整数 n 和两个整数数组 left 以及 right 。两个数组分别标识向左或者向右移动的蚂蚁在 t = 0 时的位置。请你返回最后一只蚂蚁从木板上掉下来的时刻。
 *
 * 思路：
 * 其实题目描述的"蚂蚁碰头会朝反方向走"，就是相当于蚂蚁穿过了另一只蚂蚁，其实最终只需要求离终点最远的蚂蚁掉下来的时间
 **/
public class GetLastMoment {
    public int solution(int n, int[] left, int[] right) {
        int maxLeft = 0;
        for (int l : left) {
            if (l > maxLeft) {
                maxLeft = l;
            }
        }

        int maxRight = 0;
        for (int r : right) {
            if ((n - r) > maxRight) {
                maxRight = n - r;
            }
        }

        return maxLeft > maxRight ? maxLeft : maxRight;
    }
}
