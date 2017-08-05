package tree;

public class CountSmallerOnRight {
	private class Node {
		int val, leftCount, height;
		Node left, right;
		public Node(int val) {
			this.val = val;
			this.height = 1;
			this.leftCount = 1;
			this.left = null;
			this.right = null;
		}
	}
	private class Tree {
		/*
		 *   5,4,3,2,1
		 *       2 1 0
		 *  
		 */
		Node root;
		public Tree() {
			root = null;
		}
		public Node insert(Node root, int val) {
			if(root == null) {
				return new Node(val);
			} 
			if(val == root.val) {
				root.leftCount++;
				return root;
			}
			if(val < root.val) {
				root.leftCount++;
				root.left = insert(root.left, val);
				
			} else {
				root.right = insert(root.right, val);
			}
			int leftH , rightH;
			root.height = Math.max((leftH = getHeight(root.left)),(rightH = getHeight(root.right)))+1;
			int bal = leftH - rightH;
			if(bal > 1) {
				int leftLH, leftRH;
				if((leftLH = getHeight(root.left.left)) > (leftRH = getHeight(root.left.right))) {
					root = rotateRight(root);
				} else if(leftLH < leftRH) {
					root.left = rotateLeft(root.left);
					root = rotateRight(root);
				}
			}
			else if(bal < -1) {
				int rightLH, rightRH;
				if((rightRH = getHeight(root.right.right)) > (rightLH = getHeight(root.right.left))) {
					root = rotateLeft(root);
				} else if(rightRH < rightLH) {
					root.right = rotateRight(root.right);
					root = rotateLeft(root);
				}
			}
			return root;
		}
		
		public Node rotateLeft(Node root) {
			Node newNode = root.right;
			root.right = newNode.left;
			newNode.left = root;
			root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
			newNode.height = Math.max(getHeight(newNode.left), getHeight(newNode.right))+1;
			newNode.leftCount += getCount(newNode.left);
			return newNode;
		}
		
		public Node rotateRight(Node root) {
			Node newNode = root.left;
			root.left = newNode.right;
			newNode.right = root;
			root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
			newNode.height = Math.max(getHeight(newNode.left), getHeight(newNode.right))+1;
			root.leftCount -= getCount(newNode);
			return newNode;
		}
		
		public int getHeight(Node root) {
			return root == null ? 0 : root.height;
		}
		
		public int getCount(Node root) {
			return root == null ? 0 : root.leftCount;
		}
		
		public int search(Node root, int val) {
			if(root == null || root.val == val) return 0;
			if(val < root.val) return search(root.left,val);
			else return root.leftCount + search(root.right,val);
		}		
	}
	public int[] getSmallEleOnRight(int[] array) {
		if(array == null || array.length == 0) 
			throw new IllegalArgumentException("Illegal Argumnet Input: "+array);
		Tree tree = new Tree();
		int[] ret = new int[array.length];
		for(int i = array.length-1; i >= 0; i--) {
			ret[i] = tree.search(tree.root, array[i]);
			tree.root = tree.insert(tree.root, array[i]);
		}
		return ret;
	}
}
