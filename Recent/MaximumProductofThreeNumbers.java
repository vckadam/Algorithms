/* 
628. Maximum Product of Three Numbers

Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

*/

public class Solution {
    public int maximumProduct(int[] nums) {
        int max1, max2, min1, min2, ret = Integer.MIN_VALUE;
        max1 = (nums[1] >= nums[0])? nums[1] : nums[0];
        max2 = (nums[1] >= nums[0])? nums[0] : nums[1];
        min1 = (nums[1] <= nums[0])? nums[1] : nums[0];
        min2 = (nums[1] <= nums[0])? nums[0] : nums[1];
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] >= 0) {
                ret = Math.max(ret, Math.max(nums[i]*max1*max2, nums[i]*min1*min2));
            }  else {
                ret = Math.max(ret, nums[i]*min1*max1);
            }
            if(nums[i] >= max1) {
                max2 = max1;
                max1 = nums[i];
            } else if(nums[i] >= max2) {
                max2 = nums[i];
            }
            if(nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i] <= min2) {
                min2 = nums[i];
            }
        }
        return ret;
    }
}