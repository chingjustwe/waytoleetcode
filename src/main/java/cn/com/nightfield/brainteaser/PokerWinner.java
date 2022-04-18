package cn.com.nightfield.brainteaser;

import java.util.Scanner;

/**
 * 描述
 *
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
 * 基本规则：
 * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
 * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 *
 * （4）输入的两手牌不会出现相等的情况。
 *
 * 数据范围：字符串长度：
 *
 *
 *
 * 输入描述：
 *
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如 4 4 4 4-joker JOKER。
 * 输出描述：
 *
 * 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
 *
 * https://www.nowcoder.com/practice/d290db02bacc4c40965ac31d16b1c3eb?tpId=37&&tqId=21311&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @author: zhochi
 * @create: 2021/12/1
 **/
public class PokerWinner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] poker = input.split("-");
            if (poker.length != 2) {
                System.out.println("ERROR");
                return;
            }

            int result = compare(parse(poker[0]), parse(poker[1]));
            System.out.println(result == 1 ? poker[0] : result == -1 ? poker[1] : "ERROR");
        }
    }

    /**
     * compare two poker cards
     * @param poker1
     * @param poker2
     * @return 1 if first poker is larger; -1 if second poker is larger; 0 if not comparable
     */
    private static int compare(Poker poker1, Poker poker2) {
        PokerType p1 = poker1.type, p2 = poker2.type;
        if (p1 == PokerType.JOKER) return 1;
        if (p2 == PokerType.JOKER) return -1;
        if (p1 == PokerType.BOOM) return 1;
        if (p2 == PokerType.BOOM) return -1;
        if (p1 != p2) return 0; // not comparable
        return poker1.getValue() > poker2.getValue() ? 1 : -1;// type is the same
    }

    private static Poker parse(String rawCards) {
        String[] cardArr = rawCards.split("\\s+");
        switch (cardArr.length) {
            case 1: return new Poker(getPokerValue(cardArr[0]), PokerType.SINGLE);
            case 2:
                if (cardArr[0].equals(cardArr[1])) {
                    return new Poker(getPokerValue(cardArr[0]), PokerType.PAIR);
                }
                else {
                    return new Poker(getPokerValue(cardArr[0]), PokerType.JOKER);
                }
            case 3: return new Poker(getPokerValue(cardArr[0]), PokerType.THREE);
            case 4: return new Poker(getPokerValue(cardArr[0]), PokerType.BOOM);
            case 5: return new Poker(getPokerValue(cardArr[0]), PokerType.STRAIGHT);
            default:
                // should not happen
                throw new IllegalArgumentException("input is not valid " + rawCards);
        }
    }

    private static int getPokerValue(String value) {
        char firstChar = value.charAt(0);
        if (value.length() > 1) {
            switch (firstChar) {
                case 'J': return 17; // Joker
                case 'j': return 16; // joker
                default: return 10; // 10
            }
        }

        switch (firstChar) {
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14;
            case '2': return 15;
            default:
                return firstChar + (1 - '1');
        }
    }

    public enum PokerType {
        SINGLE, PAIR, THREE, BOOM, JOKER, STRAIGHT
    }
    public static class Poker {
        /**
         * SINGLE: value of the card
         * PAIR: value of one of the card
         * THREE: value of one of the card
         * BOOM: value of one of the card
         * JOKER: value of "joker"
         * STRAIGHT: value of the first card
         */
        private int value;
        private PokerType type;
        public Poker(int value, PokerType type) {
            this.value = value;
            this.type = type;
        }
        public int getValue() {
            return value;
        }
    }
}
