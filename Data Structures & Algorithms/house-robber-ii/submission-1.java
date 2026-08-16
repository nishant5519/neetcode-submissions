class Solution {
    int[] memo1;
    int[] memo2;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        memo1 = new int[n];
        memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        int ans1 = dfs(nums, 0 , n-2 , memo1);
        int ans2 = dfs(nums , 1 , n-1 , memo2);
        System.out.println(ans1);
        System.out.println(ans2);
        return Math.max(ans1 , ans2);
    }

    private int dfs(int[] nums, int start , int end , int[] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }

        int steal = nums[start] + dfs(nums, start + 2 , end , dp);
        int notSteal = dfs(nums, start + 1 , end , dp);
        dp[start] = Math.max(steal , notSteal);
        return dp[start];
    }
}
