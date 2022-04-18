package cn.com.nightfield.problems;

import java.util.Scanner;

/**
 *
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 *
 * 一、密码长度:
 *
 * 5 分: 小于等于4 个字符
 *
 * 10 分: 5 到7 字符
 *
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 *
 * 0 分: 没有字母
 *
 * 10 分: 全都是小（大）写字母
 *
 * 20 分: 大小写混合字母
 *
 * 三、数字:
 *
 * 0 分: 没有数字
 *
 * 10 分: 1 个数字
 *
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 *
 * 0 分: 没有符号
 *
 * 10 分: 1 个符号
 *
 * 25 分: 大于1 个符号
 *
 * 五、奖励:
 *
 * 2 分: 字母和数字
 *
 * 3 分: 字母、数字和符号
 *
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 *
 * >= 90: 非常安全
 *
 * >= 80: 安全（Secure）
 *
 * >= 70: 非常强
 *
 * >= 60: 强（Strong）
 *
 * >= 50: 一般（Average）
 *
 * >= 25: 弱（Weak）
 *
 * >= 0:  非常弱
 *
 *
 * 对应输出为：
 *
 * VERY_SECURE
 *
 * SECURE
 *
 * VERY_STRONG
 *
 * STRONG
 *
 * AVERAGE
 *
 * WEAK
 *
 * VERY_WEAK
 *
 *
 * 请根据输入的密码字符串，进行安全评定。
 *
 * 注：
 *
 * 字母：a-z, A-Z
 *
 * 数字：0-9
 *
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 *
 * !"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
 *
 * :;<=>?@             (ASCII码：0x3A~0x40)
 *
 * [\]^_`              (ASCII码：0x5B~0x60)
 *
 * {|}~                (ASCII码：0x7B~0x7E)
 *
 *
 *
 * 提示:
 * 1 <= 字符串的长度<= 300
 * 输入描述：
 *
 * 本题含有多组输入样例。
 * 每组样例输入一个string的密码
 * 输出描述：
 *
 * 每组样例输出密码等级
 *
 * https://www.nowcoder.com/practice/52d382c2a7164767bca2064c1c9d5361?tpId=37&&tqId=21310&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/8
 **/
public class StrengthOfPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String pwd = sc.nextLine();
            int numCount = 0, lowerCaseCount = 0, upperCaseCount = 0, signCount = 0;
            for (char c : pwd.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    lowerCaseCount++;
                }
                else if ('A' <= c && c <= 'Z') {
                    upperCaseCount++;
                }
                else if ('0' <= c && c <= '9') {
                    numCount++;
                }
                else if (('!' <= c && c <= '/') || (':' <= c && c <= '@') || ('[' <= c && c <= '`') || ('{' <= c && c <= '~')) {
                    signCount++;
                }
                else {
                    // ignore
                }
            }

            int lengthScore = pwd.length() <= 4 ? 5 : pwd.length() <= 7 ? 10 : 25;
            int letterScore = (lowerCaseCount == 0 && upperCaseCount == 0) ? 0 : (lowerCaseCount != 0 && upperCaseCount != 0) ? 20 : 10;
            int numScore = numCount == 0 ? 0 : numCount == 1 ? 10 : 20;
            int signScore = signCount == 0 ? 0 : signCount == 1 ? 10 : 25;
            int bounsScore = (numCount > 0 && lowerCaseCount > 0 && upperCaseCount > 0 && signCount > 0) ? 5
                    : (numCount > 0 && signCount > 0 && (lowerCaseCount > 0 || upperCaseCount > 0)) ? 3
                    : (numCount > 0 && (lowerCaseCount > 0 || upperCaseCount > 0)) ? 2
                    : 0;
            int finalScore = lengthScore + letterScore + numScore + signScore + bounsScore;
            if (finalScore >= 90) {
                System.out.println("VERY_SECURE");
            }
            else if (finalScore >= 80) {
                System.out.println("SECURE");
            }
            else if (finalScore >= 70) {
                System.out.println("VERY_STRONG");
            }
            else if (finalScore >= 60) {
                System.out.println("STRONG");
            }
            else if (finalScore >= 50) {
                System.out.println("AVERAGE");
            }
            else if (finalScore >= 25) {
                System.out.println("WEAK");
            }
            else {
                System.out.println("VERY_WEAK");
            }
        }
    }
}
