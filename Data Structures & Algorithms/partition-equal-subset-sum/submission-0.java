class Solution {
    public boolean canPartition(int[] nums) {
       
        int sum = 0;
        for(int num : nums){
            sum = sum + num;
        }

        if(sum%2 != 0)
            return false;
        
        int[][] dp = new int[nums.length+1][sum/2 + 1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        
        int n = nums.length;

        return subsetSum(0 , sum/2 , nums , dp);
    }

    private boolean subsetSum(int index , int target , int[] num , int[][] memo){

        if(target == 0)
            return true;
        
        if(index == num.length)
            return false;
        
        if(memo[index][target]!= -1){
            //don't return true here , because memo can store 0 and 1 both
            return memo[index][target] == 1;
        }

        boolean take = false;
        //pick
        if(target >= num[index])
            take = subsetSum(index+1 , target-num[index] , num , memo);

        //not pick
        boolean notTake = subsetSum(index+1 , target , num , memo);

        boolean result = take || notTake;
        memo[index][target] = result == true ? 1 : 0;
        return result;

    }
}