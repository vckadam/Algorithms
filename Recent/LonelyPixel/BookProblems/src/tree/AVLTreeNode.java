package tree;

public class AVLTreeNode {
	int val, height;
	AVLTreeNode left, right;
	public AVLTreeNode(int val) {
		this.val = val;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
}
