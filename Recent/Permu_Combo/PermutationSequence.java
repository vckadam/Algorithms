/*
60. Permutation Sequence
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution {
    public String getPermutation(int n, int k) {
        if(k <= 0 || k > factorial(n)) return "";
        List<String> ret = new ArrayList<String>();
        boolean[] visited = new boolean[n];
        helper(n, k, ret, "",visited);
        return ret.get(ret.size()-1);  
    }
    
    public void helper(int n, int k, List<String> ret, String str, boolean[] visited) {
        if(ret.size() == k) return;
        if(str.length() == n) {
            ret.add(str);
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i-1]) {
                visited[i-1] = true;
                helper(n,k,ret,str+i,visited);
                visited[i-1] = false;
            }
        }
    }
    public int factorial(int n) {
        int ret = 1;
        for(int i = n; i >= 1; i--) ret *= i;
        return ret;
    }
}