package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/4/25
 *
 * https://leetcode-cn.com/problems/basic-calculator/
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 **/
public class BasicCalculator {
    public int solution(String s) {
        return calculate(s, 0, s.length());
    }

    // left cursor inclusive, right cursor exclusive
    private int calculate(String s, int start, int end) {
        int firstNumber = 0, secondNumber = 0;
        Integer operator = null;
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    // case like "(1 + 1)"
                    if (operator == null) {
                        // find first number
                        int brace = 1;
                        for (int j = i + 1; j < end; j++) {
                            if (s.charAt(j) == '(') {
                                brace++;
                            }
                            else if (s.charAt(j) == ')') {
                                brace--;
                                // should always go through here
                                if (brace == 0) {
                                    firstNumber = calculate(s, i + 1, j);
                                    i = j;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        // find second number
                        int brace = 1;
                        for (int j = i + 1; j < end; j++) {
                            if (s.charAt(j) == '(') {
                                brace++;
                            }
                            else if (s.charAt(j) == ')') {
                                brace--;
                                // should always go through here
                                if (brace == 0) {
                                    secondNumber = calculate(s, i + 1, j);
                                    i = j;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case ' ':
                    // do nothing
                    break;
                case '-':
                    // operator chain
                    if (operator != null) {
                        firstNumber = operator > 0 ? firstNumber + secondNumber : firstNumber - secondNumber;
                        secondNumber = 0;
                    }
                    operator = -1;
                    break;
                case '+':
                    // operator chain
                    if (operator != null) {
                        firstNumber = operator > 0 ? firstNumber + secondNumber : firstNumber - secondNumber;
                        secondNumber = 0;
                    }
                    operator = 1;
                    break;
                default:
                    if (operator == null) {
                        firstNumber = firstNumber * 10 + (c - '0');
                    }
                    else {
                        secondNumber = secondNumber * 10 + (c - '0');;
                    }
            }
        }

        return operator == null ? firstNumber : (operator > 0 ? firstNumber + secondNumber : firstNumber - secondNumber);
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.solution("(1+(4+5+2)-3)+(6+8)"));
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        System.out.println(i == j);
        Integer k = 100;
        System.out.println(i == k);
    }
}
