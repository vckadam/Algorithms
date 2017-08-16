package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpecificLevelOrder {
	public List<Integer> getSpecificOrder(TreeNode root) {
		if(root == null)
			throw new IllegalArgumentException("Illegal Argument");
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(root.val);
		if(root.left == null && root.right == null)
			return ret;
		Queue<TreeNode> queueLeft = new LinkedList<TreeNode>();
		Queue<TreeNode> queueRight = new LinkedList<TreeNode>();
		queueLeft.offer(root.left);
		queueRight.offer(root.right);
		while(!queueLeft.isEmpty()) {
			TreeNode leftSide = queueLeft.poll();
			TreeNode rightSide = queueRight.poll();
			ret.add(leftSide.val);
			ret.add(rightSide.val);
			if(leftSide != null && leftSide.right != null) {
				queueLeft.offer(leftSide.left);
				queueLeft.offer(leftSide.right);
			}
			if(rightSide.left != null && rightSide.right != null) {
				queueRight.offer(rightSide.right);
				queueRight.offer(rightSide.left);
			}
		}
		return ret;
	}
}
