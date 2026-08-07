class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int s : stones) {
            maxHeap.offer(s); //add , n*logn 
        }

        // loop executes n times => n*logn
        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // largest stone , logn
            int x = maxHeap.poll(); // second largest stone , logn

            if (y != x) {
                maxHeap.offer(y - x); //logn
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();    
    }
}
