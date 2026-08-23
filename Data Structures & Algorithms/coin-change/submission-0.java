class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo , -1);
        int ans = dfs(coins , amount , memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int[] coins, int amount , int[] dp) {
        
        if(amount == 0)
            return 0;
        
        if(amount < 0)
            return Integer.MAX_VALUE;

        if(dp[amount]!=-1)
            return dp[amount];

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < coins.length ; i++){
            
            int currCoin = dfs(coins ,  amount-coins[i] , dp);
            if(currCoin != Integer.MAX_VALUE)
                min = Math.min( min , currCoin + 1);
        }

        return dp[amount] = min;
    }
}