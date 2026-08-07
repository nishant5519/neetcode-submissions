class Solution {
    
    private List<List<Integer>> result = new  ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0 , nums , new ArrayList<>());
        return result;
    }

    private void generateSubsets(int index , int[] nums , List<Integer> current){

        if(index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generateSubsets(index+1 , nums , current);
        current.remove(current.size()-1);
        generateSubsets(index+1 , nums , current);

    }
}
