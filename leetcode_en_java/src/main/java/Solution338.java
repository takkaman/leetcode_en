import java.util.Arrays;

public class Solution338 {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        if (n >= 1) {
            ans[1] = 1;
        }

        for (int i = 1; i < ans.length; i++) {
            if (i % 2 == 1) {
                // odd num, bit number equals previous even number bits + 1
                ans[i] = ans[i - 1] + 1;
            } else {
                // even number, bit number : - previous odd number right consecutive 1s + new 1
                int c = 0;
                int j = i - 1;
                while (j % 2 == 1) {
                    j = j / 2;
                    c++;
                }
                ans[i] = ans[i - 1] - c + 1;
            }
        }

        return ans;

    }

    public int[] countBits1(int n) {
        // good solution from web
        int[] ans = new int[n+1];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i>>1] + (i&1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution338 solution338 = new Solution338();
        System.out.println(Arrays.toString(solution338.countBits1(0)));
    }

}
