package array;

import java.util.*;

/**
 * LeetCode 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Approach:
 * 1. Sort the array
 * 2. Iterate nums[i] while skipping duplicates
 * 3. Use two pointers (left, right) to find pairs that sum to -nums[i]
 * 4. Skip duplicate values after finding a triplet
 *
 * Time: O(n^2)
 * Space: O(n^2) (including output)
 */
public class LC0015_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    int lv = nums[left], rv = nums[right];
                    while (left < right && lv == nums[left]) left++;
                    while (left < right && rv == nums[right]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }
}
