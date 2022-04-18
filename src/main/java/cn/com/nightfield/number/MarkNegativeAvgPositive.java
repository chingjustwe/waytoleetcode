package cn.com.nightfield.number;

import java.util.Scanner;

/**
 * 描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算
 *
 * 数据范围： ，输入的整数都满足
 * 输入描述：
 * 本题有多组输入用例。
 *
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 * 输出描述：
 *
 * 输出负数的个数，和所有正整数的平均值。
 *
 * https://www.nowcoder.com/practice/6abde6ffcc354ea1a8333836bd6876b8?tpId=37&&tqId=21320&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/8
 **/
public class MarkNegativeAvgPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            int negativeCount = 0, positiveCount = 0, positiveSum = 0;
            while (count > 0) {
                int current = sc.nextInt();
                if (current > 0) {
                    positiveCount++;
                    positiveSum += current;
                }
                else if (current < 0) {
                    negativeCount++;
                }
                count--;
            }
            System.out.printf("%d %.1f%n", negativeCount, (float)positiveSum/positiveCount);
        }
    }
}
