package cn.com.nightfield.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: zhochi
 * @create: 2021/4/21
 *
 * 描述
 *
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 *
 * 数据范围：字符串长度满足
 * 输入描述：
 *
 * 输入一行以空格来分隔的句子
 * 输出描述：
 *
 * 输出句子的逆序
 *
 * https://www.nowcoder.com/practice/81544a4989df4109b33c2d65037c5836?tpId=37&&tqId=38366&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 **/
public class ReverseWords2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            Deque<String> wordStack = new LinkedList<>();
            StringBuilder builder = new StringBuilder();
            for (char c : input.toCharArray()) {
                if (('a' <= c && 'z' >= c) || ('A' <= c && 'Z' >= c))  {
                    builder.append(c);
                } else {
                    wordStack.push(builder.toString());
                    builder.setLength(0);
                }
            }
            wordStack.push(builder.toString());
            System.out.print(String.join(" ", wordStack));
        }
    }
}
