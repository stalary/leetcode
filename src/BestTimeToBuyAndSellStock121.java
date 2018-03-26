/**
 * BestTimeToBuyAndSellStock121
 *
 * 购买股票的最好时机
 * @author lirongqian
 * @since 2018/03/26
 */
public class BestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock121 b = new BestTimeToBuyAndSellStock121();
        int[] prices = new int[]{
                7, 1, 5, 3, 6, 4
        };
        System.out.println(b.maxProfit(prices));
    }

    /**
     * 使用暴力枚举时，会超时，所以只能使用一次循环O(n)的方法
     * 每次都判断是否是比最小值小的值，如果是，则更新最小值，否则计算盈利是否大于盈利。
     * 动态规划的思想
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}