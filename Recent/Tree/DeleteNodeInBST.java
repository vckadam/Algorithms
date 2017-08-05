/*
450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode node = null, suc = null, ret = root, prev = null, nodePar = null, sucPar = null;
        while(root != null) {
            if(key < root.val) {
                sucPar = prev;
                suc = root;
            }
            else {
                if(key == root.val) {
                    node = root;
                    nodePar = prev;
                } 
            }
            prev = root;
            root = (key < root.val) ? root.left : root.right;
        }
        //System.out.println(nodePar.val);
        if(node == null) return ret; // Not found
        if(node.left == null && node.right == null) { // No child
            if(nodePar != null) {
                if(nodePar.left != null && nodePar.left.val == key) nodePar.left = null;
                if(nodePar.right != null && nodePar.right.val == key) nodePar.right = null;
                return ret;
            } else {
                return null;
            }
        }
        if(node.left == null || node.right == null) { // One child
            TreeNode temp;
            if(node.left != null) {
                node.val = node.left.val;
                node.right = node.left.right;  // assign right first because it's empty
                node.left = node.left.left;
            } else {
                node.val = node.right.val;
                node.left = node.right.left;
                node.right = node.right.right;
            }
            return ret;
        }
        node.val = suc.val;
        if(suc.right != null) {    // two childrens, successor's right is not null.
            suc.val = suc.right.val;
            suc.left = suc.right.left;
            suc.right = suc.right.right;
        } else {
            if(sucPar.left != null && sucPar.left.val == suc.val) sucPar.left = null;
            if(sucPar.right != null && sucPar.right.val == suc.val) sucPar.right = null;
        }
        return ret;
    }
}