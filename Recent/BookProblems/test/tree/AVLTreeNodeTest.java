package tree;

import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tree.AVLTree;

public class AVLTreeNodeTest {
	
	AVLTree tree;
	
	@Before
	public void beforeMethod() {
		this.tree = new AVLTree();
	}
	
	@After
	public void afterMethod() {
		this.tree = null;
	}
	
	@Test
	public void testSearchThanVal_BasicScenario() {
		int[] treeNode = {1,2,3,6,15,-2,-5,-8};
		tree= buildTree(treeNode);
		assertEquals(1,this.tree.searchHelper(tree.root, 7));
	}
	
	@Test
	public void testSearchThanVal_ExistInTree() {
		int[] treeNode = {1,2,3,6,15,-2,-5,-8};
		tree= buildTree(treeNode);
		assertEquals(5,this.tree.searchHelper(tree.root, 1));
	}
	
	@Test
	public void testSearchThanVal_LeastNumber() {
		int[] treeNode = {1,2,3,6,15,-2,-5,-8};
		tree= buildTree(treeNode);
		assertEquals(8,this.tree.searchHelper(tree.root, -100));
	}
	
	@Test
	public void testSearchThanVal_LargestNumber() {
		int[] treeNode = {1,2,3,6,15,-2,-5,-8};
		tree= buildTree(treeNode);
		assertEquals(0,this.tree.searchHelper(tree.root, 100));
	}
	
	@Test
	public void testSearchThanVal_Duplicate() {
		int[] treeNode = {1,2,3,3,6,15,-2,-5,-8};
		tree= buildTree(treeNode);
		assertEquals(4,this.tree.searchHelper(tree.root, 3));
	}
	
	private AVLTree buildTree(int[] treeNodes) {
		AVLTree tree = new AVLTree();
		for(int node : treeNodes) {
			tree.insert(node);
		}
		return tree;
	}
	

	@Test
	public void createTreeTest() {
		this.tree.insert(1);
		this.tree.insert(2);
		//assertEquals(1, this.tree.root.height);
		assertEquals(2, this.tree.root.count);
		this.tree.insert(3);
		assertEquals(2, this.tree.root.val);
		assertEquals(2, this.tree.root.count);
		//assertEquals(2, this.tree.root.left.height);
		this.tree.insert(6);
		assertEquals(3, this.tree.root.right.val);
		this.tree.insert(15);
		assertEquals(6, this.tree.root.right.val);
		assertEquals(3, this.tree.root.right.left.val);
		this.tree.insert(-2);
		assertEquals(1, this.tree.root.left.val);
		this.tree.insert(-5);
		assertEquals(-2, this.tree.root.left.val);
		this.tree.insert(-8);
		assertEquals(-2, this.tree.root.left.val);
		assertEquals(-5, this.tree.root.left.left.val);
		assertEquals(-8, this.tree.root.left.left.left.val);
	}
	
}
