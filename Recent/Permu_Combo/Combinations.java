/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(k <= 0 || k > n || n <= 0) return ret;
        List<Integer> curr = new ArrayList<Integer>();
        helper(n,k,1,curr,ret);
        return ret;
    }
    public void helper(int n, int k, int start, List<Integer> curr, List<List<Integer>> ret) {
        if(curr.size() == k) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = start; i <= n; i++) {
            curr.add(i);
            helper(n, k, i+1, curr, ret);
            curr.remove(curr.size()-1);
        }
    }
}