/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

//Think in terms of => What is the maximum number of simultaneously active meetings at any point?
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((i1 , i2) -> (i1.start-i2.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }
}
