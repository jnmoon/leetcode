package array;

/**
 * LeetCode 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Constraints:
 * 1. 2 <= nums.length <= 1e5
 * 2. -30 <= nums[i] <= 30
 * 3. The product of any prefix/suffix fits within a 32-bit integer
 *
 * Approach:
 * 1. Prefix pass: move from left to right, storing the product of all previous elements in result[i].
 * 2. Suffix pass: move from right to left, multiplying result[i] by the product of all elements after it.
 * This combines left and right products to get the final result without using division.
 *
 * Time: O(n)
 * Space: O(n)
 */
public class LC0238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
