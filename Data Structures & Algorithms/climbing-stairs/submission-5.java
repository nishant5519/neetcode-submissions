class Solution {
    private int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibonacci(n);
    }
    private int fibonacci(int n){
        if(n <= 2)
            return n;

        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}
