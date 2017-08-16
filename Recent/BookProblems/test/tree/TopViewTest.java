package tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TopViewTest {

	private TopView topView;
	@Before
	public void setUp() throws Exception {
		this.topView = new TopView();
	}

	@Test
	public void testGetTopView() {
		Integer[] array = {20,8,22,5,3,null,25,null,null,10,14};
		TreeNode root = buildTree(array);
		List<Integer> ret = this.topView.getTopView(root);
		assertEquals(Arrays.asList(5,8,20,22,25),ret);
	}
	
	@Test
	public void testGetBottomView_OverLapping() {
		Integer[] array = {20,8,null,5,3,null,null,null,null,10,14};
		TreeNode root = buildTree(array);
		List<Integer> ret = this.topView.getTopView(root);
		assertEquals(Arrays.asList(5,8,20,14),ret);
	}
	
	@Test
	public void testGetBottomView_LeftSkew() {
		Integer[] array = {20,8,null,3,null,null};
		TreeNode root = buildTree(array);
		List<Integer> ret = this.topView.getTopView(root);
		assertEquals(Arrays.asList(3,8,20),ret);
	}
	
	@Test
	public void testGetBottomView_RightSkew() {
		Integer[] array = {20,null,25,null,null,null,30};
		TreeNode root = buildTree(array);
		List<Integer> ret = this.topView.getTopView(root);
		assertEquals(Arrays.asList(20,25,30),ret);
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
