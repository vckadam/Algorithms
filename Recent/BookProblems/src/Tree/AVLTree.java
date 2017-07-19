package Tree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {
	
	AVLTreeNode root;
	
	public AVLTree() {
		this.root = null;
	}
	
	public void insert(int val) {
		this.root = insertHelper(this.root, val);
	}
	
	public AVLTreeNode insertHelper(AVLTreeNode root, int val) {
		if(root == null) {
			AVLTreeNode temp = new AVLTreeNode(val);
			return temp;
		}
		if(val >= root.val) {
			root.right = insertHelper(root.right, val);
		} else {
			root.left = insertHelper(root.left, val);
		}
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		int diff = Math.abs(getHeight(root.left)-getHeight(root.right));
		if(diff > 1) {
			int countLeft = getHeight(root.left);
			int countRight = getHeight(root.right);
			if(countLeft > countRight) {
				int countChildLeft = getHeight(root.left.left);
				int countChildRight = getHeight(root.left.right);
				if(countChildLeft > countChildRight) {
					root = rotateRight(root);
				} else {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			} else {
				int countChildLeft = getHeight(root.right.left);
				int countChildRight = getHeight(root.right.right);
				if(countChildRight > countChildLeft) {
					root = rotateLeft(root);
				} else{
					root.right = rotateRight(root.right);
					root = rotateLeft(root);
				}
			}
		}
		return root;
	}
	
	public AVLTreeNode rotateLeft(AVLTreeNode root) {
		AVLTreeNode temp = root.right;
		root.right = temp.left;
		root.height = (temp.left == null) ? 0 : temp.left.height+1;
		temp.left = root;
		root = temp;
		root.height = (root.left == null ? 0 : root.left.height) + (root.right == null ? 0 : root.right.height)+1;
		return root;
	}
	
	public AVLTreeNode rotateRight(AVLTreeNode root) {
		AVLTreeNode temp = root.left;
		root.left = temp.right;
		root.height = (temp.right == null) ? 0 : temp.right.height+1;
		temp.right = root;
		root = temp;
		root.height = (root.left == null ? 0 : root.left.height) + (root.right == null ? 0 : root.right.height)+1;
		return root;
	}
	
	public int getDifference(AVLTreeNode root1, AVLTreeNode root2) {
		int num1 = root1 == null ? 0 : root1.height;
		int num2 = root2 == null ? 0 : root2.height;
		return Math.abs(num2-num1);
	}
	
	public int getHeight(AVLTreeNode root) {
		return root != null ? root.height : -1;
	}
	
	public List<Integer> inOrder(AVLTreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		inOrderHelper(root, ret);
		return ret;
	}
	
	public void inOrderHelper(AVLTreeNode root, List<Integer> list) {
		if(root == null) return;
		inOrderHelper(root.left, list);
		list.add(root.val);
		inOrderHelper(root.right, list);
	}
}
