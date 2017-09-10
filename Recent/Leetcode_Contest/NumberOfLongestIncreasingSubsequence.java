/*
673. Number of Longest Increasing Subsequence

Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.

*/

class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] max = new int[nums.length];
        Arrays.fill(max,1);
        int[] count = new int[nums.length];
        Arrays.fill(count,1);
        count[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(max[j]+1 > max[i]) {
                        max[i] = max[j]+1;
                        count[i] = 0;
                        count[i] += count[j];
                    } else if(max[j]+1 == max[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(max));
        //System.out.println(Arrays.toString(count));
        return getNumMaxLength(max,count);
    }
    
    public int getNumMaxLength(int[] max, int[] count) {
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int maxMax = 0, maxCount = 0;
        for(int i = 0; i < max.length; i++) {
            if(!hm.containsKey(max[i])) 
                hm.put(max[i],count[i]);
            else 
                hm.put(max[i], hm.get(max[i])+count[i]);
            if(max[i] >= maxMax) {
                maxMax = max[i];
                maxCount = hm.get(max[i]);
            }
        }
        return maxCount;
    }
}