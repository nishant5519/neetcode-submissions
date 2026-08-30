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

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
    
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        int prevEnd = -1;

        for (int i = 0; i < intervals.size(); i++) {
            int currStart = intervals.get(i).start;
            if (prevEnd > currStart)
                return false;
            prevEnd = intervals.get(i).end;
        }
        return true;
    }
}
