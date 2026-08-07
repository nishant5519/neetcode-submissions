public class Solution {
    /*

    Intuition
We want all subsets, but the array may contain duplicates.
If we blindly generate all subsets, we will produce repeated ones.
So we must avoid picking the same value in the same decision level more than once.

Key idea:

At each index i, we make two choices:
Include nums[i]
Exclude nums[i]
But when excluding, if the next number is the same (nums[i] == nums[i+1]), then skipping it now and skipping it later produce the same subset.
So after exploring the "exclude" branch, we skip over all duplicate values to avoid generating duplicate subsets.

We also sort the array first, so duplicates become consecutive and easy to skip.
    */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, subset, nums);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(i + 1, subset, nums);
    }
}