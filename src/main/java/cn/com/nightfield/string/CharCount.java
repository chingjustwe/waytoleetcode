package cn.com.nightfield.string;

import java.util.*;

/**
 * 描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 *
 * 数据范围：
 * 输入描述：
 *
 * 输入一行没有空格的字符串。
 * 输出描述：
 *
 * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 *
 * https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&&tqId=21233&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class CharCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            int length = input.length();
            // set to hold each distinct chars
            Set<Character> charSet = new HashSet<>(length);
            for (int i = 0; i < length; i++) {
                charSet.add(input.charAt(i));
            }

            // size of the set is the distinct char count
            System.out.println(charSet.size());
        }
    }
}
