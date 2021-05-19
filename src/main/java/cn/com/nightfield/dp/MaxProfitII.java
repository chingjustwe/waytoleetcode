package cn.com.nightfield.dp;

/**
 * @author: zhochi
 * @create: 2021/4/23
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 **/
public class MaxProfitII {
    public int solution(int[] prices) {
        int result = 0, pre = prices[0], current;
        for (int i = 1; i < prices.length; i++) {
            current = prices[i];
            if (current > pre) {
                result += current - pre;
            }
            pre = current;
        }

        return result;
    }
}
