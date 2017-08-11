/*
216. Combination Sum III
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n <= 0 || k < 0 || k > n) 
            return ret;
        List<Integer> curr = new ArrayList<>();
        helper(ret,k,n,1,curr,0);
        return ret;
    }
    
    public void helper(List<List<Integer>> ret, int k, int n, int start,List<Integer> curr, int sum) {
        if(sum >= n || curr.size() == k) {
            if(sum == n && curr.size() == k) {
                ret.add(new ArrayList<Integer>(curr));
            }
            return;
        }
        for(int i = start; i < 10; i++) {
            curr.add(i);
            helper(ret, k, n, i+1, curr, sum+i);
            curr.remove(curr.size()-1);
        }
    }
}
