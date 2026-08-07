class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) ->Integer.compare(a, b));
        maxHeap = new PriorityQueue<>((a,b) ->Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        //Keeping maxHeap size larger than minHeap
        if(maxHeap.size() - minHeap.size() > 1)
            minHeap.offer(maxHeap.poll());
        
        //Since we have choosen to keep maxHeap larger , so at no point minheap can be larger than maxHeap
        if(maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());

    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (minHeap.size() < maxHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            return (double) minHeap.peek();
        }
    }
}
