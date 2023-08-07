import java.util.ArrayList;
import java.util.List;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowestPrice = Integer.MAX_VALUE;

        // always compare current price and lowest price to calculate profit
        // O(n) complexity, not O(n^2)
        // performs like double pointers, one is current value (fast pointer), one stops at lowest position (slow pointer)
        for (int price : prices) {
            // update lowest price
            if (price < lowestPrice) {
                lowestPrice = price;
            }

            int currProfit = price - lowestPrice;
            if (currProfit > profit) {
                profit = currProfit;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] prices = {1, 11, 4, 2, 7};
        System.out.println(solution121.maxProfit(prices));
    }

}
