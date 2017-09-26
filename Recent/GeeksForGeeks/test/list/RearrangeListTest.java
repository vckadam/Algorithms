package list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RearrangeListTest {

	private RearrangeList rearrangeList;
	@Before
	public void setUp() throws Exception {
		this.rearrangeList = new RearrangeList();
	}

	@Test
	public void testRearrange_BasicScenario() {
		int[] list = {1,2,3,4,5,6,7};
		Node head = createList(list);
		Node actualHead = this.rearrangeList.rearrange(head);
		List<Integer> actual = createList(actualHead);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,3,2,5,4,7,6));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRearrange_BasicScenario_2() {
		int[] list = {9,6,8,3,7};
		Node head = createList(list);
		Node actualHead = this.rearrangeList.rearrange(head);
		List<Integer> actual = createList(actualHead);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(6,9,3,8,7));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRearrange_ValidArrangement() {
		int[] list = {6,9,2,5,1,4};
		Node head = createList(list);
		Node actualHead = this.rearrangeList.rearrange(head);
		List<Integer> actual = createList(actualHead);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(6,9,2,5,1,4));
		assertEquals(expected, actual);
	}

	public List<Integer> createList(Node head) {
		if(head == null)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		return list;
	}
	public Node createList(int[] array) {
		if(array.length == 0)
			return null;
		Node head = new Node(array[0]);
		Node temp = head;
		for(int i = 1; i < array.length; i++) {
			temp.next = new Node(array[i]);
			temp = temp.next;
		}
		return head;
	}
}
