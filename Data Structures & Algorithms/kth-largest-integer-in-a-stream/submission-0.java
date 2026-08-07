class KthLargest {

    private PriorityQueue<Integer> minheap;
    private int kthMax;
    
    public KthLargest(int k, int[] nums) {
         kthMax = k;
        minheap = new PriorityQueue<>();
        for(int num : nums){
           minheap.offer(num);
           if(minheap.size() > k)
              minheap.poll();
        }
    }
    
    public int add(int val) {
       minheap.offer(val);
        if (minheap.size() > kthMax) {
            minheap.poll();
        }
        
        return minheap.peek();  
    }
}
