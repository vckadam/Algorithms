/*
530. Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    Integer prev = null, diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return diff;
    }
    public void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(prev == null) prev = root.val;
        else {
            diff = Math.min(diff, Math.abs(root.val-prev));
            prev = root.val;
        }
        helper(root.right);
    }
}