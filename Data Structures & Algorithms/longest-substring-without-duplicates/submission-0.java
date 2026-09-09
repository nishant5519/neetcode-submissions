class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character , Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }
}
