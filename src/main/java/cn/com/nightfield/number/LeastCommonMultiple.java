package cn.com.nightfield.number;

import java.util.Scanner;

/**
 * 描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 数据范围：
 * 输入描述：
 *
 * 输入两个正整数A和B。
 * 输出描述：
 *
 * 输出A和B的最小公倍数。
 *
 * https://www.nowcoder.com/practice/22948c2cad484e0291350abad86136c3?tpId=37&&tqId=21331&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int first = sc.nextInt(), second = sc.nextInt();
            System.out.println(first/gcd(first, second)*second);
        }
    }

    private static int gcd(int first, int second) {
        if (first > second) {// ensure first <= second
            first ^= second;
            second ^= first;
            first ^= second;
        }

        if (second % first == 0) {
            return first;
        }
        return gcd(second % first, first);
    }
}
