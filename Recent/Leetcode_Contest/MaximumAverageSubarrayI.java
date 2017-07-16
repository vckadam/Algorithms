/*
643. Maximum Average Subarray I My SubmissionsBack to Contest
User Accepted: 1400
User Tried: 1535
Total Accepted: 1434
Total Submissions: 3781
Difficulty: Easy
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
*/

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        double ret = -Double.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i >= k) sum -= nums[i-k];
            sum += nums[i];
            if(i >= k-1) {
               double currAvg = (double)sum / k;
                if(currAvg > ret) {
                    ret = currAvg;
                }
            }
        }
        return ret;
    }
}