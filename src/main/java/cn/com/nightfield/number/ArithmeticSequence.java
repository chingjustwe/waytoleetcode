package cn.com.nightfield.number;

import java.util.Scanner;

/**
 * 描述
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 *
 * 输出求等差数列前n项和
 * 本题有多组输入
 *
 * 数据范围：
 * 输入描述：
 *
 * 输入一个正整数n。
 * 输出描述：
 *
 * 输出一个相加后的整数。
 *
 * https://www.nowcoder.com/practice/f792cb014ed0474fb8f53389e7d9c07f?tpId=37&&tqId=21323&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/7
 **/
public class ArithmeticSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int length = sc.nextInt();
            int first = 2, last = 3 * length - 1;
            System.out.println((first + last) * length / 2);
        }
        sc.close();
    }
}
