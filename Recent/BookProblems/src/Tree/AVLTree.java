package tree;

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
			return new AVLTreeNode(val);
		}
		if(val == root.val) {
			root.count++;
			return root;
		}
		else if(val > root.val) {
			root.count++;
			root.right = insertHelper(root.right, val);
		} else {
			root.left = insertHelper(root.left, val);
		}
		root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
		int diff = getBalance(root.left,root.right);
		if(diff > 1 &&  getHeight(root.left.left) > getHeight(root.left.right)) {
			root = rotateRight(root);
		} else if(diff > 1 && getHeight(root.left.right) > getHeight(root.left.left)) {
			root.left = rotateLeft(root.left);
			root = rotateRight(root);
		} else if(diff < -1 && getHeight(root.right.right) > getHeight(root.right.left)) {
			root = rotateLeft(root);
		} else if(diff < -1 && getHeight(root.right.left) > getHeight(root.right.right)) {
			root.right = rotateRight(root.right);
			root = rotateLeft(root);
		}
		return root;
	}
	
	public AVLTreeNode rotateLeft(AVLTreeNode root) {
		AVLTreeNode temp = root.right;
		root.count -= getCount(root.right);
		root.right = temp.left;  // changes root.right, so change count before and after
		root.count += getCount(root.right);
		temp.left = root;
		root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
		root = temp;
		root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
		return root;
	}
	
	public AVLTreeNode rotateRight(AVLTreeNode root) {
		AVLTreeNode temp = root.left;
		root.left = temp.right;
		root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
		temp.count -= getCount(temp.right);
		temp.right = root; // when right changes, need to update count (only for dupliate)
		temp.count += getCount(temp.right);
		root = temp;
		root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
		return root;
	}
	
	
	public int getHeight(AVLTreeNode root) {
		return root != null ? root.height : 0;
	}
	
	public int getCount(AVLTreeNode root) {
		return root == null ? 0 : root.count;
	}
	
	public int getBalance(AVLTreeNode root1, AVLTreeNode root2) {
		return getHeight(root1)-getHeight(root2);
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
	
	public int searchThanVal(int val) {
		return searchHelper(root, val);
	}
	
	public int searchHelper(AVLTreeNode root, int val) {
		if(root == null) return 0;
		if(root.val == val) return root.count;
		if(val < root.val) {
			return root.count + searchHelper(root.left,val);
		} else {
			return searchHelper(root.right,val);
		}
	}
}
