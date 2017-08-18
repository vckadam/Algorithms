/*
145. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(true) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            if(s.isEmpty()) break;
            if(s.peek().right == null) {
                TreeNode temp = s.pop(); ret.add(temp.val);
                while(!s.isEmpty() && s.peek().right == temp) {
                    temp = s.pop(); ret.add(temp.val);
                }
            }
            else root = s.peek().right;
        }
        return ret;
    }
   
}