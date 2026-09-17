class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            if (pile > right)
                right = pile;
        }
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0;

            // calculate hours required if banana eaten at mid banana/hr speed
            for (int pile : piles) {
                hours += pile / mid;

                // If some bananas remain as remainder, Koko needs one additional hour
                if (pile % mid != 0) {
                    hours++;
                }
            }
            if (hours <= h) {
                // mid works, but try to find a smaller speed
                result = mid;
                right = mid - 1;
            } else {
                // mid is too slow
                left = mid + 1;
            }
        }
        return result;
    }
}
