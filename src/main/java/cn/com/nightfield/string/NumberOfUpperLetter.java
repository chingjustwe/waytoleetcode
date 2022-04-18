package cn.com.nightfield.string;

import java.util.Scanner;

/**
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 * 数据范围：字符串长度：
 * 字符串中可能包含空格或其他字符
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 *
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 * 输出描述：
 *
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 *
 * https://www.nowcoder.com/practice/434414efe5ea48e5b06ebf2b35434a9c?tpId=37&&tqId=21307&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/8
 **/
public class NumberOfUpperLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            int result = 0;
            for (char c : line.toCharArray()) {
                if ('A' <= c && 'Z' >= c) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
