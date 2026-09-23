class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqMap = new List[nums.length + 1];

        for (int i = 0; i < freqMap.length; i++) {
            freqMap[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freqMap[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int freq = nums.length; freq >= 1 && index < k; freq--) {
            if (freqMap[freq] != null) {
                for (int number : freqMap[freq]) {
                    result[index++] = number;

                    if (index == k)
                        break;
                }
            }
        }

        return result;
    }
}