package tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SpecificLevelOrderTest {

	private SpecificLevelOrder specificLevelOrder;
	@Before
	public void setUp() throws Exception {
		this.specificLevelOrder = new SpecificLevelOrder();
	}

	@Test
	public void testGetSpecificOrder() {
		Integer[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		TreeNode root = buildTree(array);
		List<Integer> ret = this.specificLevelOrder.getSpecificOrder(root);
		assertEquals(Arrays.asList(1,2,3,4,7,5,6, 8, 15, 9, 14, 10, 13, 11, 12),ret);
	}
	
	@Test
	public void testGetSpecificOrder_SingleNode() {
		Integer[] array = {1};
		TreeNode root = buildTree(array);
		List<Integer> ret = this.specificLevelOrder.getSpecificOrder(root);
		assertEquals(Arrays.asList(1),ret);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetSpecificOrder_EmptyTree() {
		TreeNode root = null;
		List<Integer> ret = this.specificLevelOrder.getSpecificOrder(root);
		assertEquals(Arrays.asList(1),ret);
	}
	
	private TreeNode buildTree(Integer[] array) {
		return buildTree(array,0);
	}
	
	private TreeNode buildTree(Integer[] array, int i) {
		if(i >= array.length || array[i] == null)
			return null;
		TreeNode root = new TreeNode(array[i]);
		root.left = buildTree(array,i*2+1);
		root.right = buildTree(array,i*2+2);
		return root;
	}

}
