package tree;

public class AVLTreeNode {
	int val, height, count;
	AVLTreeNode left, right;
	public AVLTreeNode(int val) {
		this.val = val;
		this.count = 1;
		this.height = 1;
		this.left = null;
		this.right = null;
	}
}
