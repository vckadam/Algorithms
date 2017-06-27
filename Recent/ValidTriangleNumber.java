/* 
611. Valid Triangle Number

Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].

*/
// Optimized 
public class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length <= 2) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int k = nums.length-1; k >= 2; k--) {
            int left = 0, right = k - 1;
            while(left < right) {
                if(nums[left]+nums[right] > nums[k]) {
                    count += (right - left);
                    right--;
                } 
                else left++;
            }
        }
        return count;
    }
}

// Another 
public class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length <= 2) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int k = 2; k < nums.length; k++) {
            for(int i = 0; i < k-1; i++) {
                for(int j = i+1; j < k; j++) {
                    if(nums[i] + nums[j] > nums[k]) {
                        count += (k - j);
                        break;
                    }
                }
            }
        }
        return count;
    }
}