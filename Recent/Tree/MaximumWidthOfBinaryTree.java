/*
662. Maximum Width of Binary Tree

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        List<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        int width = 1;
        while(true) {
            List<TreeNode> next = new ArrayList<TreeNode>();
            for(int i = 0; i < curr.size(); i++) {
                if(curr.get(i) == null) {
                    next.add(null); next.add(null);
                } else {
                    next.add(curr.get(i).left);
                    next.add(curr.get(i).right);
                }
            }
            next = trimList(next);
            if(next == null)
                break;
            curr = next;
            width = Math.max(width, curr.size());
        }
        return width;
    }
    
    public List<TreeNode> trimList(List<TreeNode> list) {
        int left = 0, right = list.size()-1;
        while(left < list.size() && list.get(left) == null) left++;
        while(right >= 0 && list.get(right) == null) right--;
        return (left > right) ? null : list.subList(left,right+1);
    }
}