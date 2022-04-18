package cn.com.nightfield.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围： ，输入的数据有可能包含大小写字母、数字和空格
 * 输入描述：
 *
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出描述：
 *
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&&tqId=21225&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/2
 **/
public class CountOfCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sample = sc.nextLine();
        String target = sc.next();

        int gapBetweenUpperAndLower = 'a' - 'A';
        char targetChar = target.toCharArray()[0];
        if (targetChar >= 'a' && targetChar <= 'z') {// convert lower case to upper case
            targetChar -= gapBetweenUpperAndLower;
        }

        Map<Character, Integer> charMap = new HashMap<>(sample.length());
        for (char c : sample.toCharArray()) {
            if (c >= 'a' && c <= 'z') {// convert lower case to upper case
                c -= gapBetweenUpperAndLower;
            }
            int count = charMap.getOrDefault(c, 0);
            charMap.put(c, ++count);
        }
        System.out.println(charMap.getOrDefault(targetChar, 0));
    }
}
