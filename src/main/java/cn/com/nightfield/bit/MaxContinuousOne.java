package cn.com.nightfield.bit;

import java.util.Scanner;

/**
 * 描述
 *
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 本题含有多组样例输入。
 * 数据范围：数据组数：，
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 *
 * 输入一个int类型数字
 * 输出描述：
 *
 * 输出转成二进制之后连续1的个数
 *
 * https://www.nowcoder.com/practice/4b1658fd8ffb4217bc3b7e85a38cfaf2?tpId=37&&tqId=21309&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class MaxContinuousOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt(), max = 0, count = 0;
            while (input != 0) {
                if ((input & 1) == 1) { // continuous 1
                    count++;
                }
                else { // meet 0, reset context
                    count = 0;
                }

                if (count > max) {
                    max = count;
                }
                input >>>= 1;
            }

            System.out.println(max);
        }
    }
}
