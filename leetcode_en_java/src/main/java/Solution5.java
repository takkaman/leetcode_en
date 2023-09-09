public class Solution5 {

    /*
        Given a string s, return the longest
        palindromic substring in s.

        Example 1:

        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.
        Example 2:

        Input: s = "cbbd"
        Output: "bb"


        Constraints:

        1 <= s.length <= 1000
        s consist of only digits and English letters.
     */

    /*
        dynamic programming algorithm
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] input = s.toCharArray();

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        int maxLength = -1;
        String res = "";

        // cannot start from (0,0) as (i+1,j-1) calculated later than (i,j)
        // should start from (s.length, s.length)
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) {
                    isPalindrome[i][j] = true;
                } else if (j - i == 1) {
                    isPalindrome[i][j] = input[i] == input[j];
                } else {
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && input[i] == input[j];
                }

                if (isPalindrome[i][j] && j - i >= maxLength) {
                    res = s.substring(i, j + 1);
                    maxLength = j - i;
                }
            }
        }

        return res;
    }

    /*
        扩展回文串中心算法
        以i作为中心，或者以i，i+1作为中心，向两边遍历
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] input = s.toCharArray();

        int maxLength = -1;
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (i - j >= 0 && i + j < s.length()) {
                if (input[i - j] != input[i + j]) break;

                if (maxLength <= 2 * j + 1) {
                    res = s.substring(i - j, i + j + 1);
                    maxLength = 2 * j + 1;
                }

                j++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {

            int j = 0;
            while (i - j >= 0 && i + 1 + j < s.length()) {
                if (input[i - j] != input[i + 1 + j]) break;
                if (maxLength <= 2 * j + 2) {
                    res = s.substring(i - j, i + j + 2);
                    maxLength = 2 * j + 2;
                }

                j++;
            }
        }

        return res;
    }

    /*
        Manacher algorithm
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] input = s.toCharArray();

        int maxLength = -1;
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (i - j >= 0 && i + j < s.length()) {
                if (input[i - j] != input[i + j]) break;

                if (maxLength <= 2 * j + 1) {
                    res = s.substring(i - j, i + j + 1);
                    maxLength = 2 * j + 1;
                }

                j++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {

            int j = 0;
            while (i - j >= 0 && i + 1 + j < s.length()) {
                if (input[i - j] != input[i + 1 + j]) break;
                if (maxLength <= 2 * j + 2) {
                    res = s.substring(i - j, i + j + 2);
                    maxLength = 2 * j + 2;
                }

                j++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome2("ababa"));
    }

}
