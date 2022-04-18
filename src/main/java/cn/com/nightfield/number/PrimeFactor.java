package cn.com.nightfield.number;

import java.util.Scanner;

/**
 * 描述
 *
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 数据范围：
 * 输入描述：
 *
 * 输入一个整数
 * 输出描述：
 *
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&&tqId=21229&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long number = sc.nextLong();
            int boundary = (int) Math.sqrt(number);
            for (int i = 2; i <= boundary; i++) {
                while (number % i == 0) { // can be divided
                    System.out.print(i + " ");
                    number /= i;
                }
            }
            if (number != 1) {
                System.out.print(number);
            }
        }
    }
}
