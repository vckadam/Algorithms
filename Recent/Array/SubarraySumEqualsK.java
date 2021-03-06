/*  
560. Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*/

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int ret = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hm.containsKey(sum - k)) ret += hm.get(sum - k);
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return ret;
    }
}