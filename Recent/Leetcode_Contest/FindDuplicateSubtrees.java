/*652. Find Duplicate Subtrees My SubmissionsBack to Contest
User Accepted: 296
User Tried: 753
Total Accepted: 301
Total Submissions: 2544
Difficulty: Medium
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1: 
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if(root == null) return ret;
        Set<TreeNode> set = new HashSet<TreeNode>();
        Map<Integer,List<TreeNode>> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(hm.containsKey(temp.val))  {
                for(TreeNode node : hm.get(temp.val)) {
                    if(isSame(temp,node)) {
                        boolean status = false;
                        for(TreeNode tempNode : set) {
                            if(isSame(temp,tempNode)) {
                                status = true;
                            }
                        }
                        if(!status) {
                            ret.add(node);
                            set.add(node);
                        }
                    }
                }
                hm.get(temp.val).add(temp);
            }
            else hm.put(temp.val, new ArrayList<TreeNode>(Arrays.asList(temp)));
            if(temp.left != null) q.offer(temp.left);
            if(temp.right != null) q.offer(temp.right);
        }
        return ret;
    }
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }
}
