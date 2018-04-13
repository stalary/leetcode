package dp;

/**
 * dp.BestTimeToBuyAndSellStockII122
 *
 * 给一个数组股票，每次卖出买入，求出最大利润
 * 与121的区别是，每次买入后立马卖出
 * @author lirongqian
 * @since 2018/03/26
 */
public class BestTimeToBuyAndSellStockII122 {

    public static void main(String[] args) {
        int[] prices = new int[] {
                2, 3, 5, 1, 7
        };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}