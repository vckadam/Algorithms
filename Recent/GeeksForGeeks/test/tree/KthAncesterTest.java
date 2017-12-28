package tree;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KthAncesterTest {

	private KthAncester kthAncester;
	
	@Before
	public void setUp() {
		this.kthAncester = new KthAncester();
	}
	
	@After
	public void tearDown() {
		this.kthAncester = null;
	}
	
	@Test
	public void testGetKthAncester() {
		Integer[] array = {1,2,3,4,5,null,null,null,null,6,7};
		TreeNode root = buildTree(array);
		assertEquals(2,this.kthAncester.getKthAncester(root, 7, 2));
	}
	
	public TreeNode buildTree(Integer[] array) {
		if(array == null || array.length == 0 || array[0] == null) return null;
		Map<Integer,TreeNode> hm = new HashMap<Integer,TreeNode>();
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null) 
				hm.put(i, new TreeNode(array[i]));
		}
		for(int i = 0; i < array.length; i++) {
			TreeNode curr = hm.get(i);
			if(curr == null) continue;
			int left = i * 2 + 1;
			int right = i * 2 + 2;
			if(left < array.length && array[left] != null) curr.left = hm.get(left);
			if(right < array.length && array[right] != null) curr.right = hm.get(right);
		}
		//System.out.println(hm.toString());
		return hm.get(0);
	}

}
