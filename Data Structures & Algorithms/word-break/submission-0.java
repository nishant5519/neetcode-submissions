class Solution {
    //Can I reach the end of the string by repeatedly choosing valid dictionary words?
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return solve(s , wordDict , 0 , dp);
    }

    //solve(index) - Is it possible to successfully segment the string starting from index ?
    private boolean solve(String s, List<String> wordDict, int index , int[] dp) {

    if (index == s.length())
        return true;
    
     if(dp[index]!= -1)
            return dp[index] == 1;

    for (String str : wordDict) {
        int len = str.length();

        if (index + len <= s.length()) {
            String sub = s.substring(index, index + len);
            if (sub.equals(str) &&
                solve(s, wordDict, index + len , dp)) {
                dp[index] = 1;
                return true;
            }
        }
    }
    dp[index] = 0;
    return false;
}
}