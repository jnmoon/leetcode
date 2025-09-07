package two_pointers;

import java.util.*;

/**
 * LeetCode 2592. Maximize Greatness of an Array
 * https://leetcode.com/problems/maximize-greatness-of-an-array/
 *
 * Approach:
 * 1. Sort the array.
 * 2. Use two pointers i, j to greedily match nums[j] > nums[i]. 
 * 3. Count maximum valid pairs.
 *
 * Time: O(n log n)
 * Space: O(1)
 */
public class LC2592_MaximizeGreatnessOfAnArray {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = 0, result = 0;
        while (i < n && j < n) {
            if (nums[j] > nums[i]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }
}
