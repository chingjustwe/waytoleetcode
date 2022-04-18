package cn.com.nightfield.number;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围：
 * 输入描述：
 *
 * 输入一个int型整数
 * 输出描述：
 *
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * https://www.nowcoder.com/practice/253986e66d114d378ae8de2e6c4577c1?tpId=37&&tqId=21232&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class NoneRepeatNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            Set<Integer> numSet = new HashSet<>(); // set to record existed numbers
            int currentNum, result = 0;
            while (number > 0) {
                currentNum = number % 10;
                number /= 10;

                // check num duplicate
                if (numSet.contains(currentNum)) {
                    continue; // skip current round
                }

                numSet.add(currentNum); // upadte set
                result = result * 10 + currentNum;
            }

            System.out.println(result);
        }
    }
}
