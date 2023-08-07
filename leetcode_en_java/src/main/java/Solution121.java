import java.util.ArrayList;
import java.util.List;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int currLow = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // introducing pruning
            if (currLow <= prices[i]) continue;

            int high = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i] && prices[j] > high) {
                    high = prices[j];
                }
            }
            profit = Math.max(profit, high - prices[i]);
            currLow = prices[i];
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution121.maxProfit(prices));
    }

}
