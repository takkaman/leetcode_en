public class Solution70 {

    public int climbStairs(int n) {

        if (n == 1) return 1;

        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;

        for (int i = 2; i < n; i++) {
            // step n = step n-1 + step n-2
            steps[i] = steps[i - 1] + steps[i - 2];
        }


        return steps[n - 1];
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(45));
    }

}
