package cn.com.nightfield.string;

import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 * （注：字符串末尾不以空格为结尾）
 * 输入描述：
 *
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：
 *
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&&tqId=21224&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/2
 **/
public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String lastWorld = input.substring(input.lastIndexOf(" ") + 1);
            System.out.println(lastWorld.length());
        }
    }
}
