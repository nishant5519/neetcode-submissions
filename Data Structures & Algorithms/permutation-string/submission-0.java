class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            // Add current character to window
            window[s2.charAt(right) - 'a']++;

            // If window becomes larger than s1, remove from left
            if (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare only when window size equals s1 length
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(need, window)) {
                    return true;
                }
            }
        }

        return false;
    }
}
