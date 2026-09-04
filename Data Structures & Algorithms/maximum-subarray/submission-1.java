class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {

        currentSum = Math.max(
            nums[i],                 // start fresh
            currentSum + nums[i]     // continue
        );

        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
    }
}
