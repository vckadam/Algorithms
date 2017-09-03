/*
671. Second Minimum Node In a Binary Tree

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
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
class Solution {
    int secondMin = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        helper(root);
        return secondMin == Integer.MAX_VALUE ? -1 : secondMin;
    }
    
    public void helper(TreeNode root) {
        if(root.left == null && root.right == null) 
            return;
        if(root.left.val == root.val)
            helper(root.left);
        else 
            secondMin = Math.min(secondMin, root.left.val);
        if(root.right.val == root.val)
            helper(root.right);
        else 
            secondMin = Math.min(secondMin, root.right.val);      
        
    }
}