public class Solution509 {

    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;

        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res[n];
    }

    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        System.out.println(solution509.fib(4));
    }

}
