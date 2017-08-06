/*
655. Print Binary Tree My SubmissionsBack to Contest
User Accepted: 24
User Tried: 32
Total Accepted: 24
Total Submissions: 40
Difficulty: Medium
Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ret = new ArrayList<>();
        if(root == null) return ret;
        int[] dim = getDimension(root); 
        //System.out.println(Arrays.toString(dim));
        for(int i = 0; i < dim[0]; i++) {
            ret.add(new ArrayList<String>());
            for(int j = 0; j < dim[1]; j++) {
                ret.get(i).add("");
            }
        }
        helper(root,0,dim[1]-1,ret,0);
        return ret;
    }
    
    public void helper(TreeNode root, int left, int right, List<List<String>> ret, int row) {
        if(root == null) return;
        int pos = left + (right - left) / 2;
        ret.get(row).set(pos, ""+root.val);
        helper(root.left,left,pos-1,ret,row+1);
        helper(root.right, pos+1, right, ret, row+1);
    }
    
    public int[] getDimension(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = getDimension(root.left);
        int[] right = getDimension(root.right);
        int[] ret = new int[2];
        ret[0] = Math.max(left[0],right[0])+1;
        ret[1] = 2*Math.max(left[1],right[1])+1;
        return ret;
    }
}