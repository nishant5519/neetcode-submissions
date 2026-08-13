class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp , -1);
        return Math.min(recursion(n-1 , cost) , recursion(n-2,cost));
    }

    private int recursion(int index , int[] cost){

        if(index == 0 || index == 1)
            return cost[index];
        
        if(dp[index]!=-1)
            return dp[index];

        return dp[index] = cost[index] + Math.min(recursion(index-1 ,cost) , recursion(index-2 , cost));
    }
}
