package cn.com.nightfield.problems;

/**
 * @author: zhochi
 * @create: 2021/4/18
 *
 * https://leetcode-cn.com/problems/lemonade-change
 *
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 **/
public class LemonadeChange {
    public boolean solution(int[] bills) {
        int fiveRemaining = 0, tenRemaining = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    fiveRemaining++;
                    break;
                case 10:
                    if (fiveRemaining <= 0) {
                        return false;
                    }
                    fiveRemaining--;
                    tenRemaining++;
                    break;
                case 20:
                    if (tenRemaining > 0) {
                        if (fiveRemaining <= 0) {
                            return false;
                        }
                        tenRemaining--;
                        fiveRemaining--;
                    }
                    else if (fiveRemaining < 3) {
                        return false;
                    }
                    else {
                        fiveRemaining -= 3;
                    }
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] bills = {5,5,5,10,20};
        lemonadeChange.solution(bills);
    }
}
