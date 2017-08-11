/*
90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) 
            return ret;
        Arrays.sort(nums); // avoids to sort each list later
        Set<List<Integer>> set = new HashSet<>(); // removes duplicates
        ret.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            int currSize = ret.size();
            for(int j = 0; j < currSize; j++) {
                List<Integer> currList = new ArrayList<>(ret.get(j));
                currList.add(nums[i]);
                if(!set.contains(currList)) {
                    ret.add(currList);
                    set.add(currList);
                }
            }
        }
        return ret;
    }
}