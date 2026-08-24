class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String str : wordDict) {
                int len = str.length();
                if (i + len <= n) {
                    String sub = s.substring(i, i + len);
                    if (str.equals(sub) && dp[i + len]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}