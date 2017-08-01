/*
154. Find Minimum in Rotated Sorted Array II

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length-1,mid;
        while(left <= right) {
            if(left == right) return nums[left];
            mid = left + (right - left)/2;
            if(nums[left] < nums[mid]) {
                if(nums[left] < nums[right]) return nums[left];
                else left = mid + 1;
            }
            else if(nums[left] > nums[mid]){
                if(nums[mid] < nums[mid-1]) return nums[mid];
                else right = mid - 1;
            }
            else {
                if(nums[left] < nums[right]) return nums[left];
                else left++;
            }
        }
        return -1;
    }
}