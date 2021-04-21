package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/company/mock-interview/0/
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 **/
public class PlusOne {
    public int[] solution(int[] digits) {
        int i = digits.length - 1, promote = 1;
        while (i >= 0 && promote != 0) {
            int currentNum = digits[i] + promote;
            digits[i] = currentNum % 10;
            promote = currentNum / 10;
            i--;
        }
        if (promote != 0) {
            int[] result = new int[digits.length + 1];
            for (i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            result[0] = promote;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {9};
        plusOne.solution(digits);
    }
}
