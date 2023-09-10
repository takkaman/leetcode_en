public class Solution121_DoubleCheck {

    /*
        You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        Example 2:

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.


        Constraints:

        1 <= prices.length <= 105
        0 <= prices[i] <= 104
     */
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
        Solution121_DoubleCheck solution = new Solution121_DoubleCheck();
        int[] prices = {1, 11, 4, 2, 7};
        System.out.println(solution.maxProfit(prices));
    }

}
