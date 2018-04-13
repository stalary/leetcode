package dp;

/**
 * dp.BestTimeToBuyAndSellStockWithCooldown309
 * 买卖股票的最好时机309
 * 当卖出(sell)股票时需要休息(cooldown)一天才可以买入(buy)股票
 *
 * @author lirongqian
 * @since 2018/04/09
 */
public class BestTimeToBuyAndSellStockWithCooldown309 {

    public static void main(String[] args) {

    }

    /**
     * A further observation is that and rest[i] <= sell[i] is also true therefore
     *
     * rest[i] = sell[i-1]
     * Substitute this in to buy[i] we now have 2 functions instead of 3:
     *
     * buy[i] = max(sell[i-2]-price, buy[i-1])
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 买入利润需要首先设置最小值，防止亏损时的计算错误
        int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy;
        for (int price : prices) {
            // 上一次购买的最大利润
            prevBuy = buy;
            // 比较本次买入和上上次买入的最大利润
            buy = Math.max(prevSell - price, prevBuy);
            // 上一次出售的最大利润
            prevSell = sell;
            // 比较本次卖出和上一次卖出的最大利润
            sell = Math.max(prevBuy + price, prevSell);
        }
        return sell;
    }
}