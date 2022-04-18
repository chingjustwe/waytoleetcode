package cn.com.nightfield.string;

import java.util.Scanner;
import java.util.*;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 输入描述：
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&&tqId=21228&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/11/30
 **/
public class HexToDec {
    private static final Map<Character, Integer> charMap = new HashMap();
    public static void main(String[] args) {
        // init map
        char tempChar = 'A';
        int tempInt = 10;
        while (tempChar <= 'F') {
            charMap.put(tempChar++, tempInt++);
        }
        tempChar = '0';
        tempInt = 0;
        while (tempChar <= '9') {
            charMap.put(tempChar++, tempInt++);
        }


        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String hex = in.nextLine();
            String result = solution(hex);
            System.out.println(result);
        }
    }

    public static String solution(String input) {
        // boundary check
        if (!input.startsWith("0x") || input.length() <= 2) {
            return "";
        }

        int length = input.length(), i = length, base = 1;
        int result = 0;
        while (--i >= 2) {
            char currentChar = input.charAt(i);
            result += charMap.get(currentChar) * base;
            base *= 16;
        }
        return Integer.toString(result);
    }
}
