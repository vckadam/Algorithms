/*

581. Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

*/

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) return 0;
        int start = -1, end = nums.length, max = nums[0], min = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length-i-1]);
            if(max > nums[i]) end = i;
            if(min < nums[nums.length-i-1]) start = nums.length-i-1;
        }
        return (start == -1 && end == nums.length) ? 0 : end - start + 1;
    }
}