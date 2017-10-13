package list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RemoveZeroSumSequenceTest {

	private RemoveZeroSumSequence removeZeroSumSequence;
	
	@Before
	public void setUp() {
		this.removeZeroSumSequence = new RemoveZeroSumSequence();
	}
	
	@Test
	public void testGetUpdatedList_BasicScenario() {
		int[] list = {6,-6,8,4,-12,9,8,-8};
		Node head = createLinkedList(list);
		Node actualHead = this.removeZeroSumSequence.getUpdatedList(head);
		List<Integer> actualList = listToArray(actualHead);
		List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(9));
		assertEquals(expectedList, actualList);
	}
	
	@Test
	public void testGetUpdatedList_LastTwoRemains() {
		int[] list = {4, 6, -10, 8, 9, 10, -19, 10, -18, 20, 25 };
		Node head = createLinkedList(list);
		Node actualHead = this.removeZeroSumSequence.getUpdatedList(head);
		List<Integer> actualList = listToArray(actualHead);
		List<Integer> expectedList = new ArrayList<Integer>(Arrays.asList(20, 25));
		assertEquals(expectedList, actualList);
	}
	
	public List<Integer> listToArray(Node head) {
		List<Integer> ret = new ArrayList<Integer>();
		while(head != null) {
			ret.add(head.val);
			head = head.next;
		}
		return ret;
	}

	public Node createLinkedList(int[] list) {
		Node root = new Node(0);
		Node temp = root;
		for(int n : list) {
			temp.next = new Node(n);
			temp = temp.next;
		}
		return root.next;
	}
}
