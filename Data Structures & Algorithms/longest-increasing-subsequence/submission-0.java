class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
        return solve(nums , 0 , -1 , dp);
    }

    //dfs(i, prev) = Starting from index i, what is the maximum length of an increasing subsequence I can build, given that the previously selected element is at index prev?
    private int solve(int[] nums , int index , int prevIndex , int[][] dp){
        if(index >= nums.length)
            return 0;

        if(dp[index][prevIndex+1]!= -1)
            return dp[index][prevIndex+1];

        int take = 0;
        //pick
        if(prevIndex== -1 || nums[index] > nums[prevIndex]){
            take = 1+solve(nums , index+1 , index , dp);
        }

        //not pick
        int notTake = solve(nums , index+1 , prevIndex , dp);

        return dp[index][prevIndex+1] = Math.max(take , notTake);
    }

}