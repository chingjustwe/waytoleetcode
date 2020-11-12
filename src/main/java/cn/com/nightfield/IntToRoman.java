package cn.com.nightfield;

/**
 * @author: zhochi
 * @create: 2020/11/9
 *
 * https://leetcode-cn.com/problems/integer-to-roman/submissions/
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 思路：
 * 构造一个数组，包含了每个单位的信息。根据题目描述，总共有13个单位：1000，900，500，400，100，90...5，4，1
 * 过程就是：将目标数字不断地去减构造出来的单位数组，被减一次，就append一次对应的字符。
 **/
public class IntToRoman {
    public String solution(int num) {
        if (num > 3999 || num < 1) {
            throw new RuntimeException("invalid input.");
        }

        RomanNumber[] rnArr = new RomanNumber[13];
        rnArr[0] = new RomanNumber(1000, "M");
        rnArr[1] = new RomanNumber(900, "CM");
        rnArr[2] = new RomanNumber(500, "D");
        rnArr[3] = new RomanNumber(400, "CD");
        rnArr[4] = new RomanNumber(100, "C");
        rnArr[5] = new RomanNumber(90, "XC");
        rnArr[6] = new RomanNumber(50, "L");
        rnArr[7] = new RomanNumber(40, "XL");
        rnArr[8] = new RomanNumber(10, "X");
        rnArr[9] = new RomanNumber(9, "IX");
        rnArr[10] = new RomanNumber(5, "V");
        rnArr[11] = new RomanNumber(4, "IV");
        rnArr[12] = new RomanNumber(1, "I");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rnArr.length; i++) {
            RomanNumber rn = rnArr[i];
            while (num >= rn.value) {
                result.append(rn.character);
                num -= rn.value;
            }
        }
        return result.toString();
    }

    static class RomanNumber {
        int value;
        String character;
        RomanNumber (int value, String character) {
            this.value = value;
            this.character = character;
        }
    }

    public static void main(String[] args) {
        IntToRoman itr = new IntToRoman();
        System.out.println("3: " + itr.solution(3));
        System.out.println("4: " + itr.solution(4));
        System.out.println("9: " + itr.solution(9));
        System.out.println("58: " + itr.solution(58));
        System.out.println("1994: " + itr.solution(1994));
    }
}
