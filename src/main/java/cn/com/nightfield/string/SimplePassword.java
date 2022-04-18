package cn.com.nightfield.string;

import java.util.Scanner;

/**
 * 描述
 *
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 *
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 *
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 *
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，不就是 y 了嘛，简单吧。记住，Z 往后移是 a 哦。
 *
 * 数据范围： 输入的字符串长度满足
 *
 * 本题有多组样例输入
 * 输入描述：
 *
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * 输出描述：
 *
 * 输出渊子真正的密文
 *
 * https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&&tqId=21244&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/29
 **/
public class SimplePassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            StringBuilder builder = new StringBuilder();
            for (char c : input.toCharArray()) {
                builder.append(getMapping(c));
            }
            System.out.println(builder);
        }
    }

    private static char getMapping(char input) {
        if ('0' <= input && '9' >= input) {// not change
            return input;
        }
        if ('A' <= input && 'Z' >= input) {
            if (input == 'Z') {
                return 'a';
            }
            return (char)('b' - 'A' + input);
        }
        if ('a' <= input && 'z' >= input) {
            return getLowerCaseMapping(input);
        }
        return input;
    }

    private static char getLowerCaseMapping(char input) {
        if ('a' <= input && 'c' >= input) {
            return '2';
        }
        if ('d' <= input && 'f' >= input) {
            return '3';
        }
        if ('g' <= input && 'i' >= input) {
            return '4';
        }
        if ('j' <= input && 'l' >= input) {
            return '5';
        }
        if ('m' <= input && 'o' >= input) {
            return '6';
        }
        if ('p' <= input && 's' >= input) {
            return '7';
        }
        if ('t' <= input && 'v' >= input) {
            return '8';
        }
        if ('w' <= input && 'z' >= input) {
            return '9';
        }
        return input;
    }
}
