class Solution {
    
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        
        return fibonacci(n , dp);
    }
    private int fibonacci(int n , int[] dp){
        if(n <= 1)
            return dp[n];

        if(dp[n]!=-1)
            return dp[n];
        
        return dp[n] = fibonacci(n-1 , dp) + fibonacci(n-2 , dp);
    }
}
