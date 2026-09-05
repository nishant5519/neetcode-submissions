class Solution {
    public boolean canJump(int[] nums) {
        // inuition: keep track of the farthest index I can reach so far
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            // I've moved beyond the reachable boundary
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
