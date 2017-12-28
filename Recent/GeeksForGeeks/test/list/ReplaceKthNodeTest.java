package list;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReplaceKthNodeTest {

	private ReplaceKthNode replaceKthNode;
	
	@Before
	public void setUp() {
		this.replaceKthNode = new ReplaceKthNode();
	}
	
	@After
	public void tearDown() {
		this.replaceKthNode = null;
	}
	
	@Test
	public void testReplace() {
		int[] array = {1,2,3,4,5};
		//Node reverseHead = this.replaceKthNode.replace(head, 2);
	}

}
