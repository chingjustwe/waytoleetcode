package cn.com.nightfield.bit;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * https://www.nowcoder.com/practice/440f16e490a0404786865e99c6ad91c9?tpId=37&&tqId=21238&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class NumOfBitOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            int result = numOfOne(input);
            System.out.println(result);
        }
    }

    private static int numOfOne(int input) {
        int count = 0;
        while (input > 0) {
            if ((input & 1) == 1) {
                count++;
            }
            input >>>= 1;
        }
        return count;
    }
}
