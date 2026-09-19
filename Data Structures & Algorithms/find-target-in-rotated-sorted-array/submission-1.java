class Solution {
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid])
                return mid;

            // left array is sorted
            if (arr[start] <= arr[mid]) {
                // target <= arr[mid] is not required because = is already checked above in if block
                if (target < arr[mid] && target >= arr[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            // right array is sorted
            else {
                if (target > arr[mid] && target <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
