/*
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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
    public boolean isValidBST(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        return helper(root,prev);
    }
    public boolean helper(TreeNode root, TreeNode[] prev) {
        if(root == null) return true;
        boolean left = helper(root.left,prev);
        if(!left) return false;
        if(prev[0] != null && prev[0].val >= root.val) return false;
        prev[0] = root;
        return helper(root.right, prev);
    }
}