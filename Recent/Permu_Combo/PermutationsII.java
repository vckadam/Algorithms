/*
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) 
            return ret;
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<Integer>();
        Set<List<Integer>> set = new HashSet<>(); // removes duplicates
        helper(ret, curr, nums, visited, set);
        return ret;
    }
    
    public void helper(List<List<Integer>> ret, List<Integer> curr, int[] nums, boolean[] visited, Set<List<Integer>> set) {
        if(curr.size() == nums.length) {
            if(!set.contains(curr)) {
                List<Integer> currList = new ArrayList<Integer>(curr);
                set.add(currList);
                ret.add(currList);
            }
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                helper(ret,curr,nums,visited,set);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}