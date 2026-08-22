class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        int one = 1;  // dp[n]
        int two = 0;  // dp[n+1]

        for (int i = n - 1; i >= 0; i--) {

            int curr = 0;

            if (s.charAt(i) != '0') {
                curr = one;
            }

            if (i + 1 < n &&
                (s.charAt(i) == '1' ||
                 (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {

                curr += two;
            }

            two = one;
            one = curr;
        }

        return one;
    }
}