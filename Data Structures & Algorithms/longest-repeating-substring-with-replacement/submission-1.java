class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxFreq = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(c));

            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}