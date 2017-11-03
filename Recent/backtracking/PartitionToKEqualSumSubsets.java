/*
698. Partition to K Equal Sum Subsets

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.

*/
class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % k != 0)
            return false;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return helper(nums, k, 0, 0, sum/k, visited);
    }

    public boolean helper(int[] nums, int k, int start, int currSum, int target, boolean[] visited) {
        if(k == 1)
            return true;
        if(currSum == target)
            return helper(nums, k-1, 0, 0, target, visited);
        for(int i = start; i < nums.length; i++) {
            if(currSum + nums[i] > target)
                break;
            if(!visited[i]) {
                visited[i] = true;
                if(helper(nums, k, i+1, currSum+nums[i], target, visited))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
