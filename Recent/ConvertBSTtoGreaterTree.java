/*
538. Convert BST to Greater Tree
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode root) {
        if(root == null) return;
        helper(root.right);
        root.val += sum;
        sum = root.val;
        helper(root.left);
    }
}