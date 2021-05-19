package cn.com.nightfield.brainteaser;

import java.util.Random;

/**
 * @author: zhochi
 * @create: 2021/4/24
 *
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7
 *
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * 不要使用系统的 Math.random() 方法。
 *
 **/
public class ImplementRand10UsingRand7 {
    public int rand10() {
        int result = rand49();
        while (result >= 44 || result < 4) {
            result = rand49();
        }

        return result / 4;
    }

    private int rand49() {
        return (rand7() - 1) * 7 + rand7();
    }

    private int rand7() {
        return (new Random()).nextInt(7) + 1;
    }


}
