/*
663. Equal Tree Partition

Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.

Example 1:
Input:     
    5
   / \
  10 10
    /  \
   2   3

Output: True
Explanation: 
    5
   / 
  10
      
Sum: 15

   10
  /  \
 2    3

Sum: 15
Example 2:
Input:     
    1
   / \
  2  10
    /  \
   2   20

Output: False
Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
Note:
The range of tree node value is in the range of [-100000, 100000].
1 <= n <= 10000
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
    public boolean checkEqualTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) 
            return false;
        int sum = getSum(root);
        return helper(root,sum) == null;     
    }
    
    public Integer helper(TreeNode root, int sum) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        Integer left = helper(root.left,sum);
        Integer right = helper(root.right,sum);
        if(left == null || right == null)
            return null;
        if((root.left != null && left == sum - left) || (root.right != null && right == sum - right))
                return null;
        return root.val+left+right;
    }
    
    public int getSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            sum += temp.val;
            if(temp.left != null) 
                q.offer(temp.left);
            if(temp.right != null) 
                q.offer(temp.right);
        }
        return sum;
    }
}