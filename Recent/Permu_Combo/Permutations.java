/*
46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


*/

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums.length == 0) return ret;
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<Integer>();
        helper(nums,visited,curr,ret);
        return ret;
    }
    public void helper(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> ret) {
        if(curr.size() == nums.length) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                helper(nums, visited, curr, ret);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}