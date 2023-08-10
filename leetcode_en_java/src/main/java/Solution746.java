public class Solution746 {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        Solution746 solution746 = new Solution746();
        int[] cost = {10, 15, 20};
        System.out.println(solution746.minCostClimbingStairs(cost));
    }

}
