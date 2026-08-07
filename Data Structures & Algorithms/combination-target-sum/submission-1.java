class Solution {
    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int index = 0;
        calculateCombinationSum(index , candidates , target , new ArrayList<>());
        return lists;
        
    }

     void calculateCombinationSum(int index , int[] candidates, int target ,List<Integer> list){

        if(target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        if(target < 0)
            return;

        if(index == candidates.length)
            return;
        
        
        int sum = candidates[index];
        list.add(sum);
        calculateCombinationSum(index , candidates , target-sum  , list);


        list.remove(list.size()-1);
        calculateCombinationSum(index+1 , candidates , target , list);

     }
}
