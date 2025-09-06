package sliding_window;

/**
 * LeetCode 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach: Sliding Window
 * - Use a boolean array to track seen characters.
 * - Move the right pointer to expand the window.
 * - Move the left pointer to shrink the window when a duplicate is found.
 * 
 * Time: O(n)
 * Space: O(1)
 */
class LC0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[128];
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            while (seen[rc]) {
                char lc = s.charAt(left++);
                seen[lc] = false;
            }
            seen[rc] = true;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}