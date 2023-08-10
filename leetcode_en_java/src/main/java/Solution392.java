public class Solution392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        if ("".equals(s)) return true;

        for (i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution392 solution338 = new Solution392();
        String s;
        String t;
        s = "axc";
        t = "ahbgdc";
        System.out.println(solution338.isSubsequence(s, t));
    }

}
