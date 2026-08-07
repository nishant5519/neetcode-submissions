class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num); // min heap stores lowest element at the root
        //Keep the minheap size to k , keep on deleting the items if size goes beyond k
            if(minHeap.size() > k)
                minHeap.poll(); // remove first n-k lowest elements
        }
        
        //return the top most element
        return minHeap.peek();
    }
}
