/*
654. Maximum Binary Tree My SubmissionsBack to Contest
User Accepted: 263
User Tried: 273
Total Accepted: 264
Total Submissions: 289
Difficulty: Medium
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return helper(nums,0,nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int left, int right) {
        if(left > right) return null;
        int div = getMaxInd(nums,left,right);
        TreeNode root = new TreeNode(nums[div]);
        root.left = helper(nums, left, div-1);
        root.right = helper(nums, div+1, right);
        return root;
    }
    
    public int getMaxInd(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int maxInd = left;
        for(int i = left; i <= right; i++)  {
            if(nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }
        }
        return maxInd;
    }
}