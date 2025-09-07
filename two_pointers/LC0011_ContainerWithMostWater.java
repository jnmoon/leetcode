package two_pointers;

/**
 * LeetCode 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Approach:
 * - Start with two pointers at both ends of the array
 * - Calculate the amount of water
 * - Move the pointer pointing to the shorter line inward
 * - Continue until the pointers meet
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class LC0011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, result = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            result = Math.max(result, (right - left) * h);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}