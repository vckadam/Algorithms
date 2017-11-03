package doublyList;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseDLLTest {

	private ReverseDLL reverseDLL;
	
	@Before
	public void setUp() {
		this.reverseDLL = new ReverseDLL();
	}
	
	@After
	public void tearDown() {
		this.reverseDLL = null;
	}
	
	@Test
	public void testReverse_BasicScenario() {
		int[] array = {1,2,3,4,5};
		Node head = this.reverseDLL.createList(array);
		Node reverseHead = this.reverseDLL.reverse(head);
		int[] actual = convertListToArray(reverseHead);
		int[] expected = {5,4,3,2,1};
		Assert.assertArrayEquals(expected, actual);
	}

	public int[] convertListToArray(Node head) {
		List<Integer> ret = new ArrayList<Integer>();
		while(head != null) {
			ret.add(head.val);
			head = head.next;
		}
		return ret.stream().mapToInt(i->i).toArray();
	}
}
