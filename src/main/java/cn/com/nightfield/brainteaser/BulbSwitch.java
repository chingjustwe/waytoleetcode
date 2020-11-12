package cn.com.nightfield.brainteaser;

/**
 * @author: zhochi
 * @create: 2020/11/12
 *
 * https://leetcode-cn.com/problems/bulb-switcher
 * 初始时有 n 个灯泡关闭。
 * 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
 * 第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。
 * 找出 n 轮后有多少个亮着的灯泡。
 *
 * 思路：
 * 1. 第i个位置的灯泡是开还是关，取决于当前灯泡被操作了多少次
 * 2. 第i个灯泡被操作了多少次，取决于i的因数的个数，如果因数个数为偶数个，则暗；如果因数个数为奇数个，则亮
 * 3. 完全平方数的因数个数为奇数个。如4的因数是(1,4,2)，9的因数是(1,9,3)...
 * 4. n轮之后有多少灯泡亮着，其实就是求小于n的范围内，完全平方数的个数，一个循环即可得到
 **/
public class BulbSwitch {
    public int solution(int n) {
        int result = 0;
        while (result * result <= n) {
            result++;
        }
        return result - 1;
    }
}
